package cn.dgkj.mq;

/*import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration*/
public class ActiveMQConfig {
/*
    @Value("${spring.activemq.broker-url}")
    private String ActiveMQ_URL;

    @Value("${spring.activemq.user}")
    private String ActiveMQ_USER;

    @Value("${spring.activemq.password}")
    private String ActiveMQ_PASSWORD;

    public ActiveMQConfig() {
        System.out.println(1);
    }

    *//**
     * 创建 ActiveMQ 连接工厂
     *
     * @return
     *//*
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(ActiveMQ_URL);
        connectionFactory.setUserName(ActiveMQ_USER);
        connectionFactory.setPassword(ActiveMQ_PASSWORD);
        return connectionFactory;
    }


    @Bean
    public JmsTemplate jmsQueueTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }


    @Bean
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory) {

        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置连接数
        factory.setConcurrency("3-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        return factory;

    }*/

}
