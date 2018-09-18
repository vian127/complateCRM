package com.pop136.customerservice.vo.marketing.search;

import com.pop136.customerservice.vo.common.Page;
import com.pop136.customerservice.vo.marketing.param.MsgParamVo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 模版 param
 */
public class MsgSendSearchVo extends Page{

  private String id;//id

  private String batchId;//批次id

  private String phoneNumber;//电话号码

  private String templateId;//模版号

  private String createrId;//创建人id

  private String status;//状态

  private String createTime;//创建时间

  private String typeId;//类型id

  private String remark;//备注

  private String sendTime;//发送时间


  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public String getCreaterId() {
    return createrId;
  }

  public void setCreaterId(String createrId) {
    this.createrId = createrId;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getSendTime() {
    return sendTime;
  }

  public void setSendTime(String sendTime) {
    this.sendTime = sendTime;
  }
}
