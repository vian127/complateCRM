package com.pop136.customerservice.vo.customer.param;

import java.io.Serializable;
import java.util.List;

public class ContactoAllParamVo implements Serializable {

  private String id;//联系人id

  private ContactParamVo contactParam;

  private String impressionId;//印象id

  private List<ContactServeProductParam> productParams;

  private List<TagParamVo> tags;

  private String userRoleId;//操作人

  private String userRoleName;//操作人

  public String getUserRoleName() {
    return userRoleName;
  }

  public void setUserRoleName(String userRoleName) {
    this.userRoleName = userRoleName;
  }

  public String getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(String userRoleId) {
    this.userRoleId = userRoleId;
  }

  public List<TagParamVo> getTags() {
    return tags;
  }

  public void setTags(List<TagParamVo> tags) {
    this.tags = tags;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ContactParamVo getContactParam() {
    return contactParam;
  }

  public void setContactParam(ContactParamVo contactParam) {
    this.contactParam = contactParam;
  }

  public String getImpressionId() {
    return impressionId;
  }

  public void setImpressionId(String impressionId) {
    this.impressionId = impressionId;
  }

  public List<ContactServeProductParam> getProductParams() {
    return productParams;
  }

  public void setProductParams(List<ContactServeProductParam> productParams) {
    this.productParams = productParams;
  }
}
