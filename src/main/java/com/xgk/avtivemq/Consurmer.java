package com.xgk.avtivemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consurmer {
    public static void main(String[] args) throws JMSException {
        // 获取mq连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
        // 创建连接
        Connection createConnection = connectionFactory.createConnection();
        // 启动连接
        createConnection.start();
        // 创建会话工厂
        Session session = createConnection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 创建队列
        Destination destination = session.createQueue("activemq");
        MessageConsumer createConsumer = session.createConsumer(destination);
        while (true) {
            //监听消息
            TextMessage textMessage = (TextMessage) createConsumer.receive();
            if (textMessage != null) {
                String text = textMessage.getText();
                System.out.println("消费者 获取到消息:  text:" + text);
            } else {
                break;
            }
        }

        System.out.println("消费者消费消息完毕!!!");
    }
}
