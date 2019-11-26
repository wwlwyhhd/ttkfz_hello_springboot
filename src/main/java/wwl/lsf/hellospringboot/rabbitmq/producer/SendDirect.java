package wwl.lsf.hellospringboot.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import wwl.lsf.hellospringboot.util.RabbitMQConnectionUtil;

public class SendDirect {

  private final static String EXCHANGE_NAME = "direct_exchange_test";

  public static void main(String[] argv) throws Exception {
    // 获取到连接以及mq通道
    Connection connection = RabbitMQConnectionUtil.getConnection();
    // 从连接中创建通道，这是完成大部分API的地方。
    Channel channel = connection.createChannel();

    // 声明exchange，指定类型为fanout
    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
    // 消息内容
    String message = "商品新增了， id = 1001";
    // 发送消息，并且指定routing key 为：insert ,代表新增商品
    channel.basicPublish(EXCHANGE_NAME, "insert", null, message.getBytes());
    System.out.println(" [商品服务：] Sent '" + message + "'");

    // 消息内容
    message = "商品修改了， id = 1002";
    // 发送消息，并且指定routing key 为：insert ,代表新增商品
    channel.basicPublish(EXCHANGE_NAME, "update", null, message.getBytes());
    System.out.println(" [商品服务：] Sent '" + message + "'");

    // 消息内容
    message = "商品删除了， id = 1003";
    // 发送消息，并且指定routing key 为：insert ,代表新增商品
    channel.basicPublish(EXCHANGE_NAME, "delete", null, message.getBytes());
    System.out.println(" [商品服务：] Sent '" + message + "'");

    //关闭通道和连接
    channel.close();
    connection.close();
  }
}