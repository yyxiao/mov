package com.entity;

import java.io.Serializable;

/**
 * UserInfo
 * <p>
 * com.entity
 *
 * @author xiaoyy
 *         2016-12-16 下午2:51
 *         The word 'impossible' is not in my dictionary.
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private transient String pwd;

    public UserInfo(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
