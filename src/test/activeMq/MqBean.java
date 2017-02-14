package test.activeMq;

import java.io.Serializable;

/**
 * MqBean
 * activeMq
 *
 * MQBean
 * @author xiaoyy
 * @Date 2017-01-16 上午11:16
 * The word 'impossible' is not in my dictionary.
 */
public class MqBean implements Serializable {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
