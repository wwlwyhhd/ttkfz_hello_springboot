package wwl.lsf.hellspringboot.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

  @RabbitListener(queues = "ttkfz_first_quence")
  public void showMessage(String message) {
    System.out.println("接收到的消息是 = " + message);
  }

}
