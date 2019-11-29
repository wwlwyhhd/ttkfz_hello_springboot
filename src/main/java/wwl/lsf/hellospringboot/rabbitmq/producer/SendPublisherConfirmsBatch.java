package wwl.lsf.hellospringboot.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import wwl.lsf.hellospringboot.util.RabbitMQConnectionUtil;

public class SendPublisherConfirmsBatch {

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
    int batchSize = 10;
    int outstandingMessageCount = 0;
    for (int i = 0; i < 55; i++) {
      // 消息内容
      String message = "quick.orange.rabbit" + i;
      channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());
      outstandingMessageCount++;
      if (outstandingMessageCount == batchSize) {
        try {
          channel.waitForConfirmsOrDie(5000);
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (TimeoutException e) {
          //处理异常,缺点不知道具体是哪个消息导致批量的失败
        }
        outstandingMessageCount = 0;
      System.out.println(" [批量订阅模型-Topic：] Sent '" + message + "'");
      }
    }
    if (outstandingMessageCount > 0) {
      try {
        channel.waitForConfirmsOrDie(5000);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (TimeoutException e) {
        //处理异常,缺点不知道具体是哪个消息导致批量的失败
      }
      System.out.println(" [最后批量订阅模型-Topic：] Sent ");

    }
    //关闭通道和连接
    channel.close();
    connection.close();
  }
}