package com.entity;

import java.util.List;

/**
 * Position
 * com.entity
 *
 * @author xiaoyy
 * 职位信息
 * @Date 2017-07-19 下午2:38
 * The word 'impossible' is not in my dictionary.
 */
public abstract class Position {
    private int id;
    private String title;
    private List<String> city;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for property 'title'.
     *
     * @return Value for property 'title'.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for property 'title'.
     *
     * @param title Value to set for property 'title'.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for property 'city'.
     *
     * @return Value for property 'city'.
     */
    public List<String> getCity() {
        return city;
    }

    /**
     * Setter for property 'city'.
     *
     * @param city Value to set for property 'city'.
     */
    public void setCity(List<String> city) {
        this.city = city;
    }
}
