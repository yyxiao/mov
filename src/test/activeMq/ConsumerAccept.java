package test.activeMq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ConsumerAccept
 * activeMq
 *
 * 消费者接收
 * @author xiaoyy
 * @Date 2017-01-16 上午11:24
 * The word 'impossible' is not in my dictionary.
 */
public class ConsumerAccept {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq默认用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMq默认用户名
    private static final String BROKEN_URL = "tcp://192.168.1.244:61616";

    public ConsumerAccept() {
    }

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            //这个最好还是有事务
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue("test-queue2");
            consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        MqBean bean = (MqBean) ((ObjectMessage)message).getObject();
                        System.out.println(bean);
                        if (null != message) {
                            System.out.println("收到消息" + bean.getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
//            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
