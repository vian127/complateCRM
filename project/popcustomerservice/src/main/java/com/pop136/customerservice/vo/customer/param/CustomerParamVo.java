package com.pop136.customerservice.vo.customer.param;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class CustomerParamVo implements Serializable {

  @NotNull
  private String id;//id

  private String userRoleId;//用户id 操作者

  private String userRoleName;//用户名

  private String companyName;//公司名

  private String bank;//品牌

  private Integer province;//省份

  private Integer city;//城市

  private Integer district;//区

  private String address;//详细地址

  private String email;//邮箱

  private String phone;//电话


  private String enterpriseType;//企业类型

  private String businessType;//行业类型

  private String tradeType;//贸易类型

  private String sex;//性别

  private String design;//市场风格

  private String product;//单品

  private String style;//款式

  private String season;//季节

  private String technology;//工艺

  private String texture;//材质

  private List<TagParamVo> tags;

  private String attentionRemark;//客户 关注备注

  private String tagIds;//

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

  public String getAttentionRemark() {
    return attentionRemark;
  }

  public void setAttentionRemark(String attentionRemark) {
    this.attentionRemark = attentionRemark;
  }

  public List<TagParamVo> getTags() {
    return tags;
  }

  public void setTags(List<TagParamVo> tags) {
    this.tags = tags;
  }

  public String getTagIds() {
    return tagIds;
  }

  public void setTagIds(String tagIds) {
    this.tagIds = tagIds;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public Integer getProvince() {
    return province;
  }

  public void setProvince(Integer province) {
    this.province = province;
  }

  public Integer getCity() {
    return city;
  }

  public void setCity(Integer city) {
    this.city = city;
  }

  public Integer getDistrict() {
    return district;
  }

  public void setDistrict(Integer district) {
    this.district = district;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEnterpriseType() {
    return enterpriseType;
  }

  public void setEnterpriseType(String enterpriseType) {
    this.enterpriseType = enterpriseType;
  }

  public String getBusinessType() {
    return businessType;
  }

  public void setBusinessType(String businessType) {
    this.businessType = businessType;
  }

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getDesign() {
    return design;
  }

  public void setDesign(String design) {
    this.design = design;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public String getTechnology() {
    return technology;
  }

  public void setTechnology(String technology) {
    this.technology = technology;
  }

  public String getTexture() {
    return texture;
  }

  public void setTexture(String texture) {
    this.texture = texture;
  }
}