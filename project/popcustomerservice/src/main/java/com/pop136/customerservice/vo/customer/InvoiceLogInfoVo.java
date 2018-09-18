package com.pop136.customerservice.vo.customer;

import java.io.Serializable;

/**
 *发票 表
 */
public class InvoiceLogInfoVo implements Serializable {

  private String invoiceNum;//发票号

  private String address;//邮寄地址

  private String status;//状态

  private String type;//类型

  private String property;//属性

  private String expressNum;//快递单号

  private String expressCompany;//快递公司

  private String crateTime;//创建时间

  private String contactName;//联系人

  private String contactWay;//联系方式

  public String getInvoiceNum() {
    return invoiceNum;
  }

  public void setInvoiceNum(String invoiceNum) {
    this.invoiceNum = invoiceNum;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public String getExpressNum() {
    return expressNum;
  }

  public void setExpressNum(String expressNum) {
    this.expressNum = expressNum;
  }

  public String getExpressCompany() {
    return expressCompany;
  }

  public void setExpressCompany(String expressCompany) {
    this.expressCompany = expressCompany;
  }

  public String getCrateTime() {
    return crateTime;
  }

  public void setCrateTime(String crateTime) {
    this.crateTime = crateTime;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getContactWay() {
    return contactWay;
  }

  public void setContactWay(String contactWay) {
    this.contactWay = contactWay;
  }
}
