package com.factory;

import com.entity.ATSPositon;
import com.entity.MoseekerPosition;
import com.entity.Position;
import com.entity.PositionType;

/**
 * PositionFactory
 * com.factory
 *
 * @author xiaoyy
 *         创建职位的简单工厂
 * @Date 2017-07-19 下午3:12
 * The word 'impossible' is not in my dictionary.
 */
public class PositionFactory {

    public static Position createPosition(PositionType positionType) {
        Position position = null;
        switch (positionType) {
            case ATS:
                position = new ATSPositon();
                break;
            case MOSEEKER:
                position = new MoseekerPosition();
                break;
            default:

        }
        return position;
    }
}
