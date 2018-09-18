package com.pop136.customerservice.vo.customer.param;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class ContactParamVo implements Serializable {

  private String id;//id

  private String userRoleId;//操作人

  private String userRoleName;//操作人名

  @NotNull
  private String name;//姓名

  @NotNull
  private String role;//角色

  @NotNull
  private String duty;//职务

  @NotNull
  private String statusId;//状态

  private String telephone;//电话

  private String mobile;//移动电话

  private String qq;//qq号

  private String weChat;//微信号

  private String isWeChat;

  private String extensionPhone;//分机号

  private String email;//邮箱

  private String main;//是否 主要

  @NotNull
  private String customerId;//客户id

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

  public String getIsWeChat() {
    return isWeChat;
  }

  public void setIsWeChat(String isWeChat) {
    this.isWeChat = isWeChat;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getDuty() {
    return duty;
  }

  public void setDuty(String duty) {
    this.duty = duty;
  }

  public String getStatusId() {
    return statusId;
  }

  public void setStatusId(String statusId) {
    this.statusId = statusId;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getWeChat() {
    return weChat;
  }

  public void setWeChat(String weChat) {
    this.weChat = weChat;
  }

  public String getExtensionPhone() {
    return extensionPhone;
  }

  public void setExtensionPhone(String extensionPhone) {
    this.extensionPhone = extensionPhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
