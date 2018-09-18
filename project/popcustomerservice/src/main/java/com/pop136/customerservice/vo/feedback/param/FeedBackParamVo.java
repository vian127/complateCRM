package com.pop136.customerservice.vo.feedback.param;

import com.pop136.customerservice.vo.customer.param.ContactServeProductParam;
import com.pop136.customerservice.vo.customer.param.TagParamVo;

import java.io.Serializable;
import java.util.List;

public class FeedBackParamVo implements Serializable {

  private String id;//id

  private String customerId;//客户id

  private String contactId;// 联系人id

  private String mobile;//手机号码

  private List<TagParamVo> customerTags;//客户标签

  private List<TagParamVo> contactTags;// 联络人

  private String serviceWay;//服务方式

  private String userRoleId;//客服id

  private String userRoleName;//客服名称

  private List<ContactServeProductParam> productParams;//多产品

  private String remark;//备注

  private String attention;//关注备注

  public String getServiceWay() {
    return serviceWay;
  }

  public void setServiceWay(String serviceWay) {
    this.serviceWay = serviceWay;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getAttention() {
    return attention;
  }

  public void setAttention(String attention) {
    this.attention = attention;
  }

  public String getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(String userRoleId) {
    this.userRoleId = userRoleId;
  }

  public String getUserRoleName() {
    return userRoleName;
  }

  public void setUserRoleName(String userRoleName) {
    this.userRoleName = userRoleName;
  }

  public List<ContactServeProductParam> getProductParams() {
    return productParams;
  }

  public void setProductParams(List<ContactServeProductParam> productParams) {
    this.productParams = productParams;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getContactId() {
    return contactId;
  }

  public void setContactId(String contactId) {
    this.contactId = contactId;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public List<TagParamVo> getCustomerTags() {
    return customerTags;
  }

  public void setCustomerTags(List<TagParamVo> customerTags) {
    this.customerTags = customerTags;
  }

  public List<TagParamVo> getContactTags() {
    return contactTags;
  }

  public void setContactTags(List<TagParamVo> contactTags) {
    this.contactTags = contactTags;
  }
}
