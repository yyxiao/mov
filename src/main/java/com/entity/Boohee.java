package com.entity;

/**
 * Boohee
 * com.entity
 *
 * @author xiaoyy
 * @description boohee实体类
 * @create 2016-11-25 上午10:11
 * The word 'impossible' is not in my dictionary.
 */
public class Boohee {

    private String taskid;

    private String url;

    private Result result;


    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTaskid() {

        return taskid;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
