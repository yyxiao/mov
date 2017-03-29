package activeMq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Consumer
 * activeMq
 * <p>
 * 消费者
 *
 * @author xiaoyy
 * @Date 2017-01-11 下午2:35
 * The word 'impossible' is not in my dictionary.
 */
public class Consumer {
    //ActiveMq默认用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq默认用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMq默认用户名
//    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String BROKEN_URL = "tcp://192.168.1.244:61616";

    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();
    AtomicInteger count = new AtomicInteger();

    public void init() {
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String disname) {
        try {
            Queue queue = session.createQueue(disname);
            //消息消费者
            MessageConsumer consumer = null;

            if (threadLocal.get() != null) {
                consumer = threadLocal.get();
            } else {
                consumer = session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            while (true) {
                Thread.sleep(1000);
                TextMessage msg = (TextMessage) consumer.receive();
                if (msg != null) {
                    msg.acknowledge();
                    System.out.println(Thread.currentThread().getName() + ": Consumer:消费者，正在消费Msg" + msg.getText() + "--->" + count.getAndIncrement());
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
