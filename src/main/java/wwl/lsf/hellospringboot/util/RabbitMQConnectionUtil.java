package wwl.lsf.hellospringboot.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConnectionUtil {
  /**
   * 建立与RabbitMQ的连接
   * @return
   * @throws Exception
   */
  public static Connection getConnection() throws Exception {
    //定义连接工厂
    ConnectionFactory factory = new ConnectionFactory();
    //设置服务地址
    factory.setHost("server02");
    //端口
    factory.setPort(5672);
    //设置账号信息，用户名、密码、vhost
    factory.setVirtualHost("/");
    factory.setUsername("guest");
    factory.setPassword("guest");
    // 通过工程获取连接
    Connection connection = factory.newConnection();
    return connection;
  }

  public static void main(String[] args) {
    Integer i1 = 2000;
    Integer i2 = null;
//    System.out.println(i1.intValue()==i2.intValue());
    System.out.println(i2.equals(i1));
  }
}
