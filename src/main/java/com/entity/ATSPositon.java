package com.entity;

import java.util.ArrayList;

/**
 * ATSPositon
 * com.entity
 *
 * @author xiaoyy
 * 第三方平台的职位
 * @Date 2017-07-19 下午2:49
 * The word 'impossible' is not in my dictionary.
 */
public class ATSPositon extends Position {
    private int atsStatus;

    public ATSPositon(){
        this.setTitle("ATS position");
        this.setCity(new ArrayList<String>(){{this.add("全国");}});
        this.setAtsStatus(1);
    }

    /**
     * Getter for property 'atsStatus'.
     *
     * @return Value for property 'atsStatus'.
     */
    public int getAtsStatus() {
        return atsStatus;
    }

    /**
     * Setter for property 'atsStatus'.
     *
     * @param atsStatus Value to set for property 'atsStatus'.
     */
    public void setAtsStatus(int atsStatus) {
        this.atsStatus = atsStatus;
    }
}
