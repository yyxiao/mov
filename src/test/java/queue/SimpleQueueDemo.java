package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SimpleQueueDemo
 * <p>
 * com.test.queue
 * This demo come from http://www.runoob.com/java/data-queue.html.
 * @author xiaoyy
 *         2016-12-16 上午10:45
 *         The word 'impossible' is not in my dictionary.
 */
public class SimpleQueueDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // add elements
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String q : queue) {
            System.out.println("原始queue输出：" + q);
        }
        // return and remove first element from queue.
        System.out.println("poll=" + queue.poll());
        // remove element from queue.
        queue.remove();
        queue.remove();
        queue.remove();
        for (String q : queue) {
            System.out.println("poll/remove元素后：" + q);
        }
        System.out.println("element=" + queue.element());
        for (String q : queue) {
            System.out.println("element元素后：" + q);
        }
        queue.remove();
        // peek与element的区别：if queue is empty, peek return null, but element throws NoSuchElementException
        System.out.println("peek=" + queue.peek());
        for (String q : queue) {
            System.out.println("peek元素后：" + q);
        }

        // test while circulation queue.
        Queue<String> queue1 = new LinkedList();
        queue1.offer("Hello");
        queue1.offer("World!");
        queue1.offer("你好！");
        System.out.println(queue1.size());
        String str;
        while((str=queue1.poll())!=null){
            System.out.println(str);
        }
        System.out.println();
        System.out.println(queue1.size());
    }
}
