package com.service.impl;

import com.entity.Material;
import com.service.MaterialService;
import com.util.DBHelper;
import com.util.StringHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * MaterialServiceImpl
 * com.service.impl
 *
 * @author xiaoyy
 * @Date 2017-07-13 上午9:21
 * The word 'impossible' is not in my dictionary.
 */
public class MaterialServiceImpl implements MaterialService{
    @Override
    public List<Material> findByName(String name) {
//        List<String> param= new ArrayList<>();
//        param.add(name);
        String param[]= new String[1];
        param[0] = name;
        List<Material> materialList = new ArrayList<>();
        String sql = "select * from material where material_name = '?'";
        DBHelper db = new DBHelper(sql, param);
        try {
            ResultSet rs = db.pst.executeQuery();
            if (!StringHelper.isEmptyObject(rs)) {
                while (rs.next()) {
                    Material material = new Material();
                    material.setId(rs.getInt(1));
                    material.setMaterialName(rs.getString(2));
                    material.setParentId(rs.getString(3));
                    material.setCalorie(rs.getFloat(4));
                    materialList.add(material);
                }
            }
        } catch (Exception e) {
            System.out.print("查询数据出错" + e);
        }
        return materialList;
    }

    @Override
    public void findById(int id) {

    }

    @Override
    public void update(Material material) {

    }
}
