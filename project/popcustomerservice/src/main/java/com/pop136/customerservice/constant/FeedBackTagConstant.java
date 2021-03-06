package com.pop136.customerservice.constant;

public class FeedBackTagConstant {

  /**
   * 客户 标签
   */
  /**
   * 联系人 职务
   */
  public enum CUSTOMER_TYPE{
    TYPE_0("feedbtag00001") ,//基础项
    TYPE_1("feedbtag00002"),//发票项
    TYPE_2("feedbtag00003"),//赠品项
    TYPE_3("feedbtag00004"),//登陆使用项
    TYPE_4("feedbtag00005"),//网站服务项
    TYPE_5("feedbtag00008");//推荐项


    private CUSTOMER_TYPE(String tagId) {
      this.tagId = tagId;

    }

    private String tagId;

    public String getTagId() {
      return tagId;
    }

    public void setTagId(String tagId) {
      this.tagId = tagId;
    }
  }


  /**
   * 客户联系人 标签
   */
  public enum CONTACT_TYPE{
    TYPE_0("feedbtag00006") ,//联络类型
    TYPE_1("feedbtag00007") ,//联络结果
    TYPE_2("feedbtag00009") ;//服务方式

    private CONTACT_TYPE(String key) {
      this.key = key;
    }
    private String key ;
    public String getKey() {
      return key;
    }
  }


}
