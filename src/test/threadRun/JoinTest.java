package test.threadRun;

/**
 * JoinTest
 * threadRun
 * <p>
 * 测试 Thread.join()方法
 *
 * @author xiaoyy
 * @Date 2017-01-19 下午1:45
 * The word 'impossible' is not in my dictionary.
 */
public class JoinTest implements Runnable {

    private static int a = 0;

    public void run() {
        for (int i = 0; i < 5; i++) {
            a = a + 1;
        }
    }

    public static void main(String[] args) throws Exception {
//        Runnable r = new JoinTest();
//        Thread t = new Thread(r);
//        t.start();
//        t.join(); // 加入join()使线程在此之前执行完毕
//        //注意循环体内一定要有实际执行语句，否则编译器或JVM可能优化掉你的这段代码，视这段代码为无效。
////        for (int i = 0; i <1; i++) {
////            System.out.println(i);
////        }
//        System.out.println("test" + a);

        Thread t = new Thread(new RunnableImpl());
        t.start();
        try {
            t.join(1000);
            System.out.println("joinFinish");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class RunnableImpl implements Runnable {

    public void run() {
        try {
            System.out.println("Begin sleep");
            Thread.sleep(2000);
            System.out.println("End sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}