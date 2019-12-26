package cn.dgkj.mq.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mawt
 * @description
 * @date 2019/11/29
 */
@Component
public class TopicProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        /**
         *
         * @param exchange 交换机名称
         * @param routingKey 路由键
         * @param msg 消息
         */
        this.rabbitTemplate.convertAndSend("mybootexchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("mybootexchange", "topic.messages", context);
    }

}
