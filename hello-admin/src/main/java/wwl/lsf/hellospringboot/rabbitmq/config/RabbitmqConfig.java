/*
package wwl.lsf.hellospringboot.rabbitmq.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.springframework.context.annotation.Bean;

public class RabbitmqConfig {

  private final static String EXCHANGE_NAME = "topic_exchange_test";

//  @Bean("myChannel")
//  public Channel get() throws IOException, TimeoutException {
//    //定义连接工厂
//    ConnectionFactory factory = new ConnectionFactory();
//    //设置服务地址
//    factory.setHost("server02");
//    //端口
//    factory.setPort(5672);
//    //设置账号信息，用户名、密码、vhost
//    factory.setVirtualHost("/");
//    factory.setUsername("guest");
//    factory.setPassword("guest");
//    // 通过工程获取连接
//    Connection connection = factory.newConnection();
//    Channel channel = connection.createChannel();
//    // 声明exchange，指定类型为topic
//    channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);
//
//    //一个通道开启一次不是每次发消息都需要开启
//    channel.confirmSelect() ;
//    return channel;
//  }
}
*/
