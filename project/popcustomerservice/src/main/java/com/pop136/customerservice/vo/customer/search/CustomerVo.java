package com.pop136.customerservice.vo.customer.search;

import java.io.Serializable;

/**
 *客户详情 表
 */
public class CustomerVo implements Serializable {

  private String id;//id

  private String accountName;//用户名

  private String companyName;//公司名

  private String returnDate;//回访天数

  private String feebackDate;//回访天数

  private String loginDate;//登陆天数

  private String activityDate;//活动天数

  private String receiveId;//领用人id

  private String receiveName;//领用人

  private String receiveDate;//领用时间

  private String expireDate;//到期时间

  private String receiveStatus;//领用状态

  public String getFeebackDate() {
    return feebackDate;
  }

  public void setFeebackDate(String feebackDate) {
    this.feebackDate = feebackDate;
  }

  public String getReceiveStatus() {
    return receiveStatus;
  }

  public void setReceiveStatus(String receiveStatus) {
    this.receiveStatus = receiveStatus;
  }

  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  public String getReceiveId() {
    return receiveId;
  }

  public void setReceiveId(String receiveId) {
    this.receiveId = receiveId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }

  public String getLoginDate() {
    return loginDate;
  }

  public void setLoginDate(String loginDate) {
    this.loginDate = loginDate;
  }

  public String getActivityDate() {
    return activityDate;
  }

  public void setActivityDate(String activityDate) {

    this.activityDate = activityDate;
  }

  public String getReceiveName() {
    return receiveName;
  }

  public void setReceiveName(String receiveName) {
    this.receiveName = receiveName;
  }

  public String getReceiveDate() {
    return receiveDate;
  }

  public void setReceiveDate(String receiveDate) {
    this.receiveDate = receiveDate;
  }
}
