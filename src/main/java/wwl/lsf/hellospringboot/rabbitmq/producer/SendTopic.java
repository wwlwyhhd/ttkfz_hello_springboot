package wwl.lsf.hellospringboot.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import wwl.lsf.hellospringboot.util.RabbitMQConnectionUtil;

public class SendTopic {

  private final static String EXCHANGE_NAME = "topic_exchange_test";

  public static void main(String[] argv) throws Exception {
    // 获取到连接以及mq通道
    Connection connection = RabbitMQConnectionUtil.getConnection();
    // 从连接中创建通道，这是完成大部分API的地方。
    Channel channel = connection.createChannel();

    // 声明exchange，指定类型为topic
    channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);
    // 消息内容
    String message = "quick.orange.rabbit";
    channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    // 消息内容
    message = "lazy.orange.elephant";
    channel.basicPublish(EXCHANGE_NAME, "lazy.orange.elephant", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    // 消息内容
    message = "quick.orange.fox";
    // 发送消息，并且指定routing key 为：insert ,代表新增商品
    channel.basicPublish(EXCHANGE_NAME, "quick.orange.fox", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    // 消息内容
    message = "lazy.pink.rabbit";
    channel.basicPublish(EXCHANGE_NAME, "lazy.pink.rabbit", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    // 消息内容
    message = "quick.brown.fox";
    channel.basicPublish(EXCHANGE_NAME, "quick.brown.fox", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    // 消息内容
    message = "quick.orange.male.rabbit";
    channel.basicPublish(EXCHANGE_NAME, "quick.orange.male.rabbit", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    // 消息内容
    message = "orange";
    channel.basicPublish(EXCHANGE_NAME, "orange", null, message.getBytes());
    System.out.println(" [订阅模型-Topic：] Sent '" + message + "'");

    //关闭通道和连接
    channel.close();
    connection.close();
  }
}