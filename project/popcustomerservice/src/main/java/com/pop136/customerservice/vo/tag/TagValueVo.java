package com.pop136.customerservice.vo.tag;

import java.io.Serializable;

public class TagValueVo implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;//客户标签id

  private String tagId;//标签id

  private String customerId;//客户id

  private String contactId;//联系人id

  private String tagName;//名称

  private String code;

  private String value;//值

  private String module;//模型

  private String fromCode;//标签层级

  public String getContactId() {
    return contactId;
  }

  public void setContactId(String contactId) {
    this.contactId = contactId;
  }

  public String getFromCode() {
    return fromCode;
  }

  public void setFromCode(String fromCode) {
    this.fromCode = fromCode;
  }

  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getModule() {
    return module;
  }

  public void setModule(String module) {
    this.module = module;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
}