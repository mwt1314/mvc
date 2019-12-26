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
@RabbitListener(queues = "q_topic_message")
public class TopicConsumer1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
