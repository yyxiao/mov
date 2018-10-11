package com.action;

import com.biz.PositionBiz;

/**
 * PositionApp——参照“大飞哥”工厂设计模式归纳
 * com.action
 *
 * 简单工厂用于隔离对象的创建过程和对象本身业务处理过程，
 * 使得对象业务处理过程不需要考虑对象的创建，
 * 以及对象的创建也不需要关心对象的业务处理。
 *
 * 一般情况下，简单工厂通过一个传递进来的参数，根据这个参数创建不同的对象。
 *
 * 缺点：工厂类的职责比较重，如果添加产品时，必须要改动代码。
 * 优点：在处理对象业务过程时，不需要关心对象是怎么创建的。
 * 当需要一个对象时，只需要传递一个参数，就能得到需要的对象
 *
 * @author xiaoyy
 * @Date 2017-07-19 下午5:21
 * The word 'impossible' is not in my dictionary.
 */
public class PositionApp {

    public static void main(String[] args) {
        PositionBiz positionBiz = new PositionBiz();
        positionBiz.positionBiz();
    }
}
