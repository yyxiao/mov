package com.action;

import com.entity.Result;
import com.service.BooheeService;

import java.util.List;

/**
 * ExeclAction
 * com.action
 *
 * @author xiaoyy
 * @description 处理转存excel
 * @create 2016-11-25 上午9:59
 * The word 'impossible' is not in my dictionary.
 */
public class ExcelAction {

    public static void main(String[] args) {
        BooheeService booheeService = new BooheeService();
        List<Result> booheeList = booheeService.booheeList();
        System.out.println(booheeList);
        booheeService.CreateExcel(booheeList);
    }

}
