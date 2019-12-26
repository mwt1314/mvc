package cn.dgkj.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author mawt
 * @description '
 * @date 2019/11/29
 */
/*@Component
@RabbitListener(queues = "q_hello")*/
public class RabbitMQConsumer {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}
