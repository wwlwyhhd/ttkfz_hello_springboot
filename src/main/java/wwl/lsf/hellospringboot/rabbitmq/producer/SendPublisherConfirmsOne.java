package wwl.lsf.hellospringboot.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import wwl.lsf.hellospringboot.util.RabbitMQConnectionUtil;

public class SendPublisherConfirmsOne {

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
    // 消息内容
    String message = "quick.orange.rabbit";
    channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");
    try {
      channel.waitForConfirmsOrDie(5000);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      //时间到了还不能确认 要写逻辑
      e.printStackTrace();
    }
    System.out.println("消息确认发布了");
     //关闭通道和连接
    channel.close();
    connection.close();
  }
}