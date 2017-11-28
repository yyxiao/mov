package com.action;

import com.entity.AaaLoginFtpLog;
import com.service.TxtService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * ReadTxtController
 * com.action
 *
 * @author xiaoyy
 * @Date 2017-11-28 上午9:13
 * The word 'impossible' is not in my dictionary.
 */
public class ReadTxtController {
    private static TxtService txtService = new TxtService();

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/xiaoyy/Downloads/11.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        List<AaaLoginFtpLog> aaaLoginFtpLogList = new ArrayList<>();
        try {
            String line = "";
            String[] arrs = null;
            String uuid = "";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date = df.format(new Date());
            while ((line = br.readLine()) != null) {
                arrs = line.split("@@");
                if (arrs.length == 22) {
                    AaaLoginFtpLog aaaLoginFtpLog = new AaaLoginFtpLog();
                    uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    aaaLoginFtpLog.setAaaLoginFtpLogId(uuid);
                    aaaLoginFtpLog.setChargeTpye(arrs[0]);
                    aaaLoginFtpLog.setAccessType(arrs[1]);
                    aaaLoginFtpLog.setBelongNet(arrs[2]);
                    aaaLoginFtpLog.setVisitNet(arrs[3]);
                    aaaLoginFtpLog.setTicketSource(arrs[4]);
                    aaaLoginFtpLog.setInitialSource(arrs[5]);
                    aaaLoginFtpLog.setAccount(arrs[6]);
                    aaaLoginFtpLog.setAccessDesc(arrs[7]);
                    aaaLoginFtpLog.setAccessAdd(arrs[8]);
                    aaaLoginFtpLog.setAccessSign(arrs[9]);
                    aaaLoginFtpLog.setSessionId(arrs[10]);
                    aaaLoginFtpLog.setAppIp(arrs[11]);
                    aaaLoginFtpLog.setCallingNo(arrs[12]);
                    aaaLoginFtpLog.setMacNum(arrs[13]);
                    aaaLoginFtpLog.setCalledNo(arrs[14]);
                    aaaLoginFtpLog.setStartTime(arrs[15]);
                    aaaLoginFtpLog.setEndTime(arrs[16]);
                    BigDecimal bd=new BigDecimal(arrs[17]);
                    aaaLoginFtpLog.setCallTime(bd);
                    aaaLoginFtpLog.setInDischarge(arrs[18]);
                    aaaLoginFtpLog.setOutDischarge(arrs[19]);
                    aaaLoginFtpLog.setAllDischarge(arrs[20]);
                    aaaLoginFtpLog.setCountry(arrs[21]);
                    aaaLoginFtpLog.setAaaFtpname(date);
                    aaaLoginFtpLogList.add(aaaLoginFtpLog);
                }
            }
            txtService.saveTxt(aaaLoginFtpLogList);
        } catch (Exception e) {
        } finally {
            br.close();
            isr.close();
            fis.close();
        }


    }
}
