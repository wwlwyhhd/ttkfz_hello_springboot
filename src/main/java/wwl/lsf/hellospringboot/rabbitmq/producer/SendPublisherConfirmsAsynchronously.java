package wwl.lsf.hellospringboot.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.Connection;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import wwl.lsf.hellospringboot.util.RabbitMQConnectionUtil;

public class SendPublisherConfirmsAsynchronously {

  private final static String EXCHANGE_NAME = "topic_exchange_test";

  public static void main(String[] argv) throws Exception {
    // 获取到连接以及mq通道
    Connection connection = RabbitMQConnectionUtil.getConnection();
    // 从连接中创建通道，这是完成大部分API的地方。
    Channel channel = connection.createChannel();

    // 声明exchange，指定类型为topic
    channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);

    //一个通道开启一次不是每次发消息都需要开启
    channel.confirmSelect();
    ConcurrentNavigableMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();

    ConfirmCallback cleanOutstandingConfirms = (sequenceNumber, multiple) -> {
      // 服务器收到了,确认逻辑
      if (multiple) {
        ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(
            sequenceNumber, true
        );
        confirmed.clear();
      } else {
        outstandingConfirms.remove(sequenceNumber);
      }
      System.out.println("服务器收到了,确认逻辑"+multiple);
    };
    channel.addConfirmListener(cleanOutstandingConfirms, (sequenceNumber, multiple) -> {
      // 服务器内部异常,应该重新发送一下,这个例子就是记录,然后清除了map,
      //如何重新发布? 官网建议如下
      //重新发布nack-ed消息？
      //从相应的回调中重新发布一个nack-ed消息可能很诱人，
      // 但是应该避免这种情况，因为确认回调是在不应执行通道的I / O线程中分派的。
      // 更好的解决方案是将消息放入由发布线程轮询的内存队列中。
      // 诸如ConcurrentLinkedQueue之类的类将是在确认回调和发布线程之间传输消息的理想选择
      String body = outstandingConfirms.get(sequenceNumber);
      //记录了一下错误的日志
      System.out.println("记录了一下错误的日志");
      System.err.format(
          "Message with body %s has been nack-ed. Sequence number: %d, multiple: %b%n",
          body, sequenceNumber, multiple
      );
      cleanOutstandingConfirms.handle(sequenceNumber, multiple);
    });
    //发送消息
    for (int i = 0; i < 55; i++) {
      // 消息内容
      String message = "quick.orange.rabbit"+i;
      outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
      channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());
      //能保证每次只确认一条
      Thread.sleep(20);
    }
    //关闭通道和连接
    Thread.sleep(30000);
    channel.close();
    connection.close();
  }
}