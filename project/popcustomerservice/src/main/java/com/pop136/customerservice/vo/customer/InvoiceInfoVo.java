package com.pop136.customerservice.vo.customer;

import java.io.Serializable;

/**
 *发票 表
 */
public class InvoiceInfoVo implements Serializable{

  private String status;//是否需要发票

  private String type;//类型

  private String title;//抬头

  private String content;//内容

  private String address;//邮寄地址

  private String contactName;//联系人

  private String contactWay;//联系方式

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
