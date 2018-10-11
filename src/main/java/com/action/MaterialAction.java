package com.action;

import com.entity.Material;
import com.service.MaterialService;
import com.service.impl.MaterialServiceImpl;

import java.util.List;

/**
 * MaterialAction
 * com.action
 *
 * @author xiaoyy
 * @Date 2017-07-13 上午9:39
 * The word 'impossible' is not in my dictionary.
 */
public class MaterialAction {

    public static void main(String[] args) {
        MaterialService materialService = new MaterialServiceImpl();
        List<Material> materialList = materialService.findByName("火腿肠");
        System.out.println(materialList);
    }
}
