package com.pop136.customerservice.vo.customer;

import java.io.Serializable;

/**
 *商拍 vo
 */
public class ShangpainfoVo implements Serializable {

  private String acountName;//账号

  private String phone;//电话

  private String area;//地区

  private String brand;//品牌

  private String status;//审核状态

  private String sex;//性别

  private String updateTime;//更新时间

  private String remark;//备注


  public String getAcountName() {
    return acountName;
  }

  public void setAcountName(String acountName) {
    this.acountName = acountName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
