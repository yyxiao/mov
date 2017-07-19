package com.entity;

import java.util.ArrayList;

/**
 * MoseekerPosition
 * com.entity
 *
 * @author xiaoyy
 * 仟寻职位
 * @Date 2017-07-19 下午2:41
 * The word 'impossible' is not in my dictionary.
 */
public class MoseekerPosition extends Position {

    public MoseekerPosition(){
        this.setTitle("Moseeker positon");
        this.setCity(new ArrayList<String>(){{this.add("上海");}});
    }
}
