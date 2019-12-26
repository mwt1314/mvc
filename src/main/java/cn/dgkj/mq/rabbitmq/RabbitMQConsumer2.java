package cn.dgkj.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author mawt
 * @description
 * @date 2019/11/29
 */
@Component
@ConditionalOnProperty(name = "spring.rabbitmq.enable", havingValue = "true")
@RabbitListener(queues = "q_hello")
public class RabbitMQConsumer2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }

}
