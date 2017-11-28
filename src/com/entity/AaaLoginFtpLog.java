package com.entity;

/**
 * AAALoginFtpLog
 * com.entity
 *
 * @author xiaoyy
 * @TODO
 * @Date 2017-11-28 上午10:19
 * The word 'impossible' is not in my dictionary.
 */

import java.math.BigDecimal;

public class AaaLoginFtpLog {
    private String aaaLoginFtpLogId;

    private String chargeTpye;

    private String accessType;

    private String belongNet;

    private String visitNet;

    private String ticketSource;

    private String initialSource;

    private String account;

    private String accessDesc;

    private String accessAdd;

    private String accessSign;

    private String sessionId;

    private String appIp;

    private String callingNo;

    private String macNum;

    private String calledNo;

    private String startTime;

    private String endTime;

    private BigDecimal callTime;

    private String inDischarge;

    private String outDischarge;

    private String allDischarge;

    private String country;

    private String aaaFtpname;

    public String getAaaFtpname() {
        return aaaFtpname;
    }

    public AaaLoginFtpLog setAaaFtpname(String aaaFtpname) {
        this.aaaFtpname = aaaFtpname;
        return this;
    }

    public String getAaaLoginFtpLogId() {
        return aaaLoginFtpLogId;
    }

    public void setAaaLoginFtpLogId(String aaaLoginFtpLogId) {
        this.aaaLoginFtpLogId = aaaLoginFtpLogId == null ? null : aaaLoginFtpLogId.trim();
    }

    public String getChargeTpye() {
        return chargeTpye;
    }

    public void setChargeTpye(String chargeTpye) {
        this.chargeTpye = chargeTpye == null ? null : chargeTpye.trim();
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType == null ? null : accessType.trim();
    }

    public String getBelongNet() {
        return belongNet;
    }

    public void setBelongNet(String belongNet) {
        this.belongNet = belongNet == null ? null : belongNet.trim();
    }

    public String getVisitNet() {
        return visitNet;
    }

    public void setVisitNet(String visitNet) {
        this.visitNet = visitNet == null ? null : visitNet.trim();
    }

    public String getTicketSource() {
        return ticketSource;
    }

    public void setTicketSource(String ticketSource) {
        this.ticketSource = ticketSource == null ? null : ticketSource.trim();
    }

    public String getInitialSource() {
        return initialSource;
    }

    public void setInitialSource(String initialSource) {
        this.initialSource = initialSource == null ? null : initialSource.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getAccessDesc() {
        return accessDesc;
    }

    public void setAccessDesc(String accessDesc) {
        this.accessDesc = accessDesc == null ? null : accessDesc.trim();
    }

    public String getAccessAdd() {
        return accessAdd;
    }

    public void setAccessAdd(String accessAdd) {
        this.accessAdd = accessAdd == null ? null : accessAdd.trim();
    }

    public String getAccessSign() {
        return accessSign;
    }

    public void setAccessSign(String accessSign) {
        this.accessSign = accessSign == null ? null : accessSign.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public String getAppIp() {
        return appIp;
    }

    public void setAppIp(String appIp) {
        this.appIp = appIp == null ? null : appIp.trim();
    }

    public String getCallingNo() {
        return callingNo;
    }

    public void setCallingNo(String callingNo) {
        this.callingNo = callingNo == null ? null : callingNo.trim();
    }

    public String getMacNum() {
        return macNum;
    }

    public void setMacNum(String macNum) {
        this.macNum = macNum == null ? null : macNum.trim();
    }

    public String getCalledNo() {
        return calledNo;
    }

    public void setCalledNo(String calledNo) {
        this.calledNo = calledNo == null ? null : calledNo.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public BigDecimal getCallTime() {
        return callTime;
    }

    public void setCallTime(BigDecimal callTime) {
        this.callTime = callTime;
    }

    public String getInDischarge() {
        return inDischarge;
    }

    public void setInDischarge(String inDischarge) {
        this.inDischarge = inDischarge == null ? null : inDischarge.trim();
    }

    public String getOutDischarge() {
        return outDischarge;
    }

    public void setOutDischarge(String outDischarge) {
        this.outDischarge = outDischarge == null ? null : outDischarge.trim();
    }

    public String getAllDischarge() {
        return allDischarge;
    }

    public void setAllDischarge(String allDischarge) {
        this.allDischarge = allDischarge == null ? null : allDischarge.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
}
