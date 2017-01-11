package activeMq;

import org.apache.activemq.broker.Connection;

/**
 * TestConsumer
 * activeMq
 *
 * @author xiaoyy
 * @TODO
 * @Date 2017-01-11 下午3:09
 * The word 'impossible' is not in my dictionary.
 */
public class TestConsumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.init();
        TestConsumer testConsumer = new TestConsumer();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
    }

    private class ConsumerMq implements Runnable {
        Consumer consumer;

        public ConsumerMq(Consumer consumer) {
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consumer.getMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
