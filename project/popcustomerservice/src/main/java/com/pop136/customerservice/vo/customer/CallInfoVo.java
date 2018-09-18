package com.pop136.customerservice.vo.customer;

import java.io.Serializable;

/**
 *电话 表
 */
public class CallInfoVo implements Serializable {

  private String staffName;//员工

  private String time;//时间

  private String name;//用户

  private String remark;//备注

  private String type;//名单等级

  private String result;//结果

  private String record;//录音

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getRecord() {
    return record;
  }

  public void setRecord(String record) {
    this.record = record;
  }
}