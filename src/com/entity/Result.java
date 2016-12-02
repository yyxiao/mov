package com.entity;

/**
 * Result
 * com.entity
 *
 * @author xiaoyy
 * @description
 * @create 2016-11-25 上午11:40
 * The word 'impossible' is not in my dictionary.
 */
public class Result {
    private String name;

    private String contents;

    private String url;

    private String other_name;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setContents(String contents){
        this.contents = contents;
    }
    public String getContents(){
        return this.contents;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }
}