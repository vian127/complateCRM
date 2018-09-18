package com.pop136.customerservice.vo.customer.search;

import com.pop136.customerservice.vo.common.Page;

import java.util.List;

/**
 *客户详情 表
 */
public class ContactSearchVo extends Page {

  private String id;//id

  private String ownerId;//领用人id

  private String  ownerIds;//所有人id

  private String customerId;//联系人id

  private String customerName;//联系人名称

  private String mobile;//移动电话

  private String contactName;//所属客户

  private String name;//姓名

  private String telephone;//电话号码

  private String qq;//qq

  private String email;//邮箱

  private String weChat;//微信

  private String main;//主要

  private String startContactTime;//开始联络时间

  private String endContactTime;//结束联络时间

  private String role;//角色

  private String status;//用户状态

  private String duty;//职务

  private List<String> roles;//角色

  private String sex;//客户 性别 标签

  private List<String> sexs;

  private String phones;//电话号

  private List<String> phoneList;

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public String getOwnerIds() {
    return ownerIds;
  }

  public void setOwnerIds(String ownerIds) {
    this.ownerIds = ownerIds;
  }

  public String getPhones() {
    return phones;
  }

  public void setPhones(String phones) {
    this.phones = phones;
  }

  public List<String> getPhoneList() {
    return phoneList;
  }

  public void setPhoneList(List<String> phoneList) {
    this.phoneList = phoneList;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public List<String> getSexs() {
    return sexs;
  }

  public void setSexs(List<String> sexs) {
    this.sexs = sexs;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDuty() {
    return duty;
  }

  public void setDuty(String duty) {
    this.duty = duty;
  }

  public String getStartContactTime() {
    return startContactTime;
  }

  public void setStartContactTime(String startContactTime) {
    this.startContactTime = startContactTime;
  }

  public String getEndContactTime() {
    return endContactTime;
  }

  public void setEndContactTime(String endContactTime) {
    this.endContactTime = endContactTime;
  }

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
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

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWeChat() {
    return weChat;
  }

  public void setWeChat(String weChat) {
    this.weChat = weChat;
  }
}