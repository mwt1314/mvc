package cn.dgkj.test;

import cn.dgkj.mq.rabbitmq.RabbitMQProducer;
import cn.dgkj.mq.rabbitmq.TopicProducer;
import cn.dgkj.mq.rabbitmq.fanout.MsgSenderFanout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mawt
 * @description
 * @date 2019/11/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitMQProducer helloSender;

    @Autowired
    private TopicProducer msgSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            helloSender.send(i);
            Thread.sleep(300);
        }
    }

    @Test
    public void send2() throws Exception {
        msgSender.send2();
    }

    @Autowired
    private MsgSenderFanout msgSenderr;

    @Test
    public void send1() throws Exception {
        msgSenderr.send();
    }

}
