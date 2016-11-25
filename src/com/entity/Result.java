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

}