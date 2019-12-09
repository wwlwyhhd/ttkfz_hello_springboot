/*
package wwl.lsf.hellospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class HelloSpringbootApplicationTests {

  @Autowired
  private AmqpTemplate amqpTemplate;

  @Test
  public void testSend() throws InterruptedException {
    String msg = "hello, Spring boot amqp";
    this.amqpTemplate.convertAndSend("topic_exchange_test", "quick.orange.rabbit", msg);
    // 等待10秒后再结束
    Thread.sleep(10000);
  }
}
*/
