package com.biz;

import com.entity.Position;
import com.entity.PositionType;
import com.factory.PositionFactory;

/**
 * PositionBiz
 * com.biz
 *
 * @author xiaoyy
 * 职位的业务处理类
 * @Date 2017-07-19 下午3:37
 * The word 'impossible' is not in my dictionary.
 */
public class PositionBiz {

    public void positionBiz(){
        Position atsPosition = PositionFactory.createPosition(PositionType.ATS);
        System.out.println(atsPosition.getCity());
        System.out.println(atsPosition.getTitle());

        Position moseekerPosition = PositionFactory.createPosition(PositionType.MOSEEKER);
        System.out.println(moseekerPosition.getCity());
        System.out.println(moseekerPosition.getTitle());
    }

}
