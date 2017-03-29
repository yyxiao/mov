/**
 * SplitDemo
 * test
 *
 * @author xiaoyy
 * split方法测试Demo
 * @Date 2017-03-28 上午11:02
 * The word 'impossible' is not in my dictionary.
 */
public class SplitDemo {


    public static void main(String[] args) {
        String str1 = "1,,,,";
        String str2 = "1,,,,2";
        splitTest1(str1, str2);

        splitTest2(str1, str2);

    }


    /**
     * 常见使用split场景
     * @author Xander
     * @Date 2017/3/28 上午11:23
     * The word 'impossible' is not in my dictionary.
     */
    private static void splitTest1(String str1, String str2){
        String[] arrayStr1 = str1.split(",");
        String[] arrayStr2 = str2.split(",");
        // 输出数组长度
        System.out.println("splitTest1 arrayStr1 length=" + arrayStr1.length);
        System.out.println("splitTest1 arrayStr2 length=" + arrayStr2.length);
    }


    /**
     * 将limit设置正数或非正
     * @author Xander
     * @Date 2017/3/28 上午11:29
     * The word 'impossible' is not in my dictionary.
     */
    private static void splitTest2(String str1, String str2){
        String[] arrayStr1 = str1.split(",", 4);
        String[] arrayStr2 = str1.split(",", 6);
        String[] arrayStr3 = str1.split(",", -1);
        String[] otherArrayStr1 = str2.split(",", 5);
        String[] otherArrayStr2 = str2.split(",", 6);
        String[] otherArrayStr3 = str2.split(",", -1);
        // 输出数组长度
        System.out.println("splitTest2 arrayStr1 length=" + arrayStr1.length);
        System.out.println("splitTest2 arrayStr2 length=" + arrayStr2.length);
        System.out.println("splitTest2 arrayStr3 length=" + arrayStr3.length);
        System.out.println("splitTest2 otherArrayStr1 length=" + otherArrayStr1.length);
        System.out.println("splitTest2 otherArrayStr2 length=" + otherArrayStr2.length);
        System.out.println("splitTest2 otherArrayStr3 length=" + otherArrayStr3.length);
    }
}
