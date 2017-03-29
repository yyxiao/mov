package enums;

import org.junit.Test;

/**
 * SimpleEnumDemo
 * <p>
 * Java中Enum的简单用法
 *
 * @author xiaoyy
 * @Date 2017-01-11 上午10:01
 * The word 'impossible' is not in my dictionary.
 */
public class SimpleEnumDemo {

    /**
     * 简单遍历enum，并打印
     * @author Xender
     * @Date 17/1/11 上午10:58
     * The word 'impossible' is not in my dictionary.
     */
    @Test
    public void easyEnum(){
        for (EnumTest name : EnumTest.values()) {
            System.out.println(name + ":" + name.getContext());
        }
    }



    /**
     * 定义枚举对象
     *
     * @author Xender
     * @Date 17/1/11 上午10:47
     * The word 'impossible' is not in my dictionary.
     */
    enum EnumTest {
        XANDER("The given name of me"),
        XIAO("The family name of me");
        private String context;

        private String getContext() {
            return this.context;
        }

        private EnumTest(String context) {
            this.context = context;
        }
    }


}
