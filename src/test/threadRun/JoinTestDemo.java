package threadRun;

/**
 * JoinTestDemo
 * threadRun
 *
 * 多线程demo
 * @author xiaoyy
 * @Date 2017-01-19 下午2:15
 * The word 'impossible' is not in my dictionary.
 */
public class JoinTestDemo {

    public static void main(String[] args) {
        //main线程启动，但并没有马上结束，因为调用了t.join()，所以要等t结束了，此线程才能向下执行。
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        CustomThread1 thread1 = new CustomThread1();
        CustomThread thread = new CustomThread(thread1);
        try {
            thread1.start();
            Thread.sleep(2000);
            thread.start();
//            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(threadName + " end.");
    }

}

class CustomThread extends Thread {
    CustomThread1 thread1;

    public CustomThread(CustomThread1 thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            thread1.join();
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + " .run");
        }
    }
}

class CustomThread1 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + " .run");
        }
        System.out.println(threadName + " end.");
    }
}
