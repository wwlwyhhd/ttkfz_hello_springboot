package wwl.lsf.hellospringboot.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

  @RabbitListener(bindings = @QueueBinding(
      value = @Queue(value = "topic_exchange_queue_1", durable = "true"),
      exchange = @Exchange(
          value = "topic_exchange_test",
          ignoreDeclarationExceptions = "true",
          type = ExchangeTypes.TOPIC
      ),
      key = {"#.#"}))
  public void listen(String msg) {
    System.out.println("接收到消息：" + msg);
  }

}
