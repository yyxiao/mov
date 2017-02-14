package test.activeMq;

import org.apache.activemq.store.kahadb.disk.index.ListNode;

import javax.xml.soap.Node;

/**
 * TestMq
 * activeMq
 *
 * 测试Message queue
 * @author xiaoyy
 * @Date 2017-01-11 下午2:56
 * The word 'impossible' is not in my dictionary.
 */
public class TestMq {
    public static void main(String[] args) {
        Producter producter = new Producter();
        producter.init();
        TestMq testMq = new TestMq();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 2
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 3
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 4
        new Thread(testMq.new ProductorMq(producter)).start();
        //Thread 5
        new Thread(testMq.new ProductorMq(producter)).start();
    }

    private class ProductorMq implements Runnable {
        Producter producter;

        public ProductorMq(Producter producter) {
            this.producter = producter;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    producter.sendMessage("Jaycekon-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
