package com.service;

import com.entity.Material;

import java.util.List;

/**
 * MaterialService
 * com.service
 *
 * @author xiaoyy
 * 测试原料详情接口类
 * @Date 2017-07-13 上午9:15
 * The word 'impossible' is not in my dictionary.
 */
public interface MaterialService {

    List<Material> findByName(String name);

    void findById(int id);

    void update(Material material);
}
