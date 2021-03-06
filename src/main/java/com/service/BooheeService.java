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
import java.util.Arrays;
import java.util.List;

//生成Excel所用类
import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * BooheeService
 * com.service
 *
 * @author xiaoyy
 * @description java生成demo execl数据
 * @create 2016-11-25 上午10:07
 * The word 'impossible' is not in my dictionary.
 */
public class BooheeService {
    static DBHelper db = null;
    static ResultSet rs = null;

    public Logger logger = Logger.getLogger(BooheeService.class);

    /**
     * 获取食品数据list，并进行gson转换对象处理
     *
     * @return resultList 获取结果List
     */
    public List<Result> booheeList() {
        List<Boohee> booheeList = new ArrayList<>();
        List<Result> resultList = new ArrayList<>();
        String sql = "select * from boohee";
        db = new DBHelper(sql);
        try {
            rs = db.pst.executeQuery();
            if (!StringHelper.isEmptyObject(rs)) {
                while (rs.next()) {
                    Boohee boohee = new Boohee();
                    boohee.setTaskid(rs.getString(1));
                    boohee.setUrl(rs.getString(2));
                    if (rs.getBlob(3) instanceof Blob) {
                        Gson gson = new Gson();
//                        System.out.println(rs.getString(3));
                        Result result = gson.fromJson(rs.getString(3), Result.class);
                        boohee.setResult(result);
                        resultList.add(result);
                    }
                    booheeList.add(boohee);
                }
            }
        } catch (Exception e) {
            System.out.print("查询数据出错" + e);
        }
        return resultList;
    }


    /**
     * 生成处理Excel
     *
     * @param resultList 查询结果列表
     */
    public void CreateExcel(List<Result> resultList) {
        try {
            WritableWorkbook book = Workbook.createWorkbook(new File("薄荷网excel.xls"));
            WritableSheet sheet = book.createSheet("薄荷数据", 0);
            // 插入表头
            for (int i = 0; i < Constants.title_row_all.length; i++) {
                Label label = new Label(i, 0, Constants.title_row_all[i]);
                sheet.addCell(label);
            }

            // 插入数据
            for (int i = 0; i < resultList.size(); i++) {
                // name add
                Label label = new Label(0, i + 1, resultList.get(i).getName());
                sheet.addCell(label);
                // type add
                Label labelType = new Label(1, i + 1, resultList.get(i).getType());
                sheet.addCell(labelType);
                // other_name add
                Label label2 = new Label(2, i + 1, resultList.get(i).getOther_name());
                if (StringHelper.isEmptyObject(resultList.get(i).getOther_name())) {
                    label2 = new Label(2, i + 1, "一");
                }
                sheet.addCell(label2);
                String contents = resultList.get(i).getContents();
                String[] contentArr = contents.split(" ");
                // 判断title是否存在
                for (int j = 0; j < Constants.title_row.length; j++) {
                    if (Arrays.asList(contentArr).contains(Constants.title_row[j])) {
                        for (int k = 0; k < contentArr.length; k++) {
                            if (contentArr[k].equals(Constants.title_row[j])) {
                                Label label1 = new Label(j + 3, i + 1, contentArr[k + 1]);
                                sheet.addCell(label1);
                            }
                        }
                    } else {
//                        Label label1 = new Label(j + 1, i + 1, "——");
                        Label label1 = new Label(j + 3, i + 1, "一");
                        sheet.addCell(label1);
                    }
                }
                // otherNames
                String otherName = resultList.get(i).getOther_name();
                String[] otherNames = otherName.split("、");
                for (int l = 0; l < otherNames.length; l++) {
                    Label labelOtherName = new Label(l + Constants.title_row_all.length, i + 1, otherNames[l]);
                    sheet.addCell(labelOtherName);
                }
            }
            //  写入数据并关闭文件
            book.write();
            book.close();
        } catch (Exception e) {
            logger.error("生成Excel出错" + e);
        }

    }

}
