package com.action;


import java.util.List;
import java.util.stream.Stream;

/**
 * ExeclAction
 * com.action
 *
 * @author xiaoyy
 * 处理转存excel
 * 2016-11-25 上午9:59
 * The word 'impossible' is not in my dictionary.
 */
public class ExcelAction {

    public static void main(String[] args) {
//        BooheeService booheeService = new BooheeService();
//        List<Result> booheeList = booheeService.booheeList();
//        System.out.println(booheeList);
//        booheeService.CreateExcel(booheeList);

//        MD5 md5 = new MD5();
//        System.out.println(md5.decrypt("dGR1BHV+eHUCNnNtBGAKZnEHd2dwEQU3c0N3TAdN", "jcms2008"));


        Stream.iterate(2, item -> item + 1).limit(10).forEach(System.out::println);
    }

}
