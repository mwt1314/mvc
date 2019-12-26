package cn.dgkj.mq;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;*/


public class ActiveMQUtil {

   /* @Autowired
    private JmsTemplate jmsQueueTemplate;

    *//**
     * 发送原始消息 Message
     *//*
    public void send() {
        jmsQueueTemplate.send("queue1", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("我是原始消息");
            }
        });
        //
        jmsQueueTemplate.convertAndSend("queue1", "我是自动转换的消息");
    }

    @JmsListener(destination = "queue1")
    public void receive(String msg){
        System.out.println("监听到的消息内容为: " + msg);
    }*/

}
