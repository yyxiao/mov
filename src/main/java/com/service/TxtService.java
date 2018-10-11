package com.service;

import com.entity.AaaLoginFtpLog;
import com.util.DBHelper;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * TxtService
 * com.service
 *
 * @author xiaoyy
 * @Date 2017-11-28 上午9:40
 * The word 'impossible' is not in my dictionary.
 */
public class TxtService {
    private Logger logger = Logger.getLogger(TxtService.class);

    DBHelper db = null;

    public boolean saveTxt(List<AaaLoginFtpLog> list) {
        Boolean bl = true;
        String sql = "insert into AAA_LOGIN_FTP_LOG ( AAA_LOGIN_FTP_LOG_ID, CHARGE_TPYE, ACCESS_TYPE, BELONG_NET, VISIT_NET, TICKET_SOURCE, INITIAL_SOURCE, ACCOUNT, ACCESS_DESC, ACCESS_ADD, ACCESS_SIGN, SESSION_ID, APP_IP, CALLING_NO, MAC_NUM, CALLED_NO, START_TIME, END_TIME, CALL_TIME, IN_DISCHARGE, OUT_DISCHARGE, ALL_DISCHARGE, COUNTRY, AAA_FTPNAME) values ";
        // 填写sql语句
        for(int i = 0; i < list.size(); i++) {
            sql += "( '"+list.get(i).getAaaLoginFtpLogId()+"', '"+list.get(i).getChargeTpye()+"'," +
                    " '"+list.get(i).getAccessType()+"', '"+list.get(i).getBelongNet()+"', '"+list.get(i).getVisitNet()+"', " +
                    "'"+list.get(i).getTicketSource()+"', '"+list.get(i).getInitialSource()+"', '"+list.get(i).getAccount()+"', " +
                    "'"+list.get(i).getAccessDesc()+"', '"+list.get(i).getAccessAdd()+"', '"+list.get(i).getAccessSign()+"', " +
                    "'"+list.get(i).getSessionId()+"', '"+list.get(i).getAppIp()+"', '"+list.get(i).getCallingNo()+"', " +
                    "'"+list.get(i).getMacNum()+"', '"+list.get(i).getCalledNo()+"', '"+list.get(i).getStartTime()+"', " +
                    "'"+list.get(i).getEndTime()+"', '"+list.get(i).getCallTime()+"', '"+list.get(i).getInDischarge()+"', " +
                    "'"+list.get(i).getOutDischarge()+"', '"+list.get(i).getAllDischarge()+"', '"+list.get(i).getCountry()+"', " +
                    "'"+list.get(i).getAaaFtpname()+"'),";
        }
        sql = sql.substring(0,sql.length()-1);
        db = new DBHelper(sql);
        try {
            int ret = db.pst.executeUpdate();
            //处理结果
            if(ret>=0){
                // 添加成功
                logger.info("记录成功！" + ret);
            }else{
                bl = false;
                logger.info("记录失败！");
            }
            db.close();
        } catch (Exception e) {
            bl = false;
            logger.info("添加配置失败！" + e);
        }
        return bl;
    }
}
