package com.service;

import com.entity.Boohee;
import com.entity.Result;
import com.util.Constants;
import com.util.DBHelper;
import com.util.StringHelper;
import org.apache.log4j.Logger;
import com.google.gson.Gson;

import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//生成Execl所用类
import  java.io.File;
import  jxl.Workbook;
import  jxl.write.Label;
import  jxl.write.WritableSheet;
import  jxl.write.WritableWorkbook;

/**
 * BooheeService
 * com.service
 *
 * @author xiaoyy
 * @description
 * @create 2016-11-25 上午10:07
 * The word 'impossible' is not in my dictionary.
 */
public class BooheeService {
    static DBHelper db = null;
    static ResultSet rs = null;

    private Logger logger = Logger.getLogger(BooheeService.class);

    /**
     * 获取食品数据list，并进行gson转换对象处理
     * @return
     */
    public static List<Result> booheeList(){
        List<Boohee> booheeList = new ArrayList<>();
        List<Result> resultList = new ArrayList<>();
        String sql = "select * from boohee";
        db = new DBHelper(sql);
        try {
            rs = db.pst.executeQuery();
            if (!StringHelper.isEmptyObject(rs)){
                while (rs.next()){
                    Boohee boohee = new Boohee();
                    boohee.setTaskid(rs.getString(1));
                    boohee.setUrl(rs.getString(2));
                    if (rs.getBlob(3) instanceof Blob){
                        Gson gson = new Gson();
                        Result result = gson.fromJson(rs.getString(3), Result.class);
                        boohee.setResult(result);
                        resultList.add(result);
                    }
                    booheeList.add(boohee);
                }
            }
        }catch (Exception e){
            System.out.print("查询数据出错" + e);
        }
        return resultList;
    }


    /**
     * 生成处理Execl
     * @param resultList
     */
    public static void CreateExcel(List<Result> resultList){
        try {
            WritableWorkbook book = Workbook.createWorkbook(new File("text.xls"));
            WritableSheet sheet = book.createSheet("乌拉拉" , 0);
            for (int i = 0; i<resultList.size(); i++){
                Label label  =   new  Label( 0 ,  i ,  resultList.get(i).getName() );
                String contents = resultList.get(i).getContents();
                String[] contentArr = contents.split(" ");
                System.out.println(contentArr);
                sheet.addCell(label);
            }
            //  写入数据并关闭文件
            book.write();
            book.close();
        }catch (Exception e){
            System.out.println("生成Excel出错" + e);
        }

    }


    public static void main(String[] args) {
        List<Result> booheeList = booheeList();
        System.out.println(booheeList);
        CreateExcel(booheeList);
    }

}
