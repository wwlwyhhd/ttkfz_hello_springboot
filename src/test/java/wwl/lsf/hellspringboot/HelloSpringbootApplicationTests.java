package wwl.lsf.hellspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringbootApplicationTests {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Test
  public void testSend() {
    Message message = new Message("我要红包_i want money".getBytes(), null);
    rabbitTemplate.convertAndSend("ttkfz_first_quence","我要红包_i want money");
  }
}
