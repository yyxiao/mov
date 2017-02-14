package test.activeMq;

import org.apache.activemq.broker.Connection;

/**
 * TestConsumer
 * activeMq
 *
 * 客户端消费者测试
 * @author xiaoyy
 * @Date 2017-01-11 下午3:09
 * The word 'impossible' is not in my dictionary.
 */
public class TestConsumer {
    public static void main(String[] args) throws Exception{
        Consumer consumer = new Consumer();
        consumer.init();
        TestConsumer testConsumer = new TestConsumer();
        // Thread1
        Thread thread1 = new Thread(testConsumer.new ConsumerMq(consumer));
        thread1.join();
        // Thread2
        Thread thread2 = new Thread(testConsumer.new ConsumerMq(consumer));
        thread2.join();
        // Thread3
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        // Thread4
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
