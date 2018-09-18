package com.pop136.customerservice.constant;

public class ContactConstant {


  /**
   * 联系人 职务
   */
  public enum CONTACT_DUTY{
    TYPE_0("tag00011","tagval0000000267", 0) ,//老板
    TYPE_1("tag00011","tagval0000000268", 1),//设计总监
    TYPE_2("tag00011","tagval0000000269", 2),//财务
    TYPE_3("tag00011","tagval0000000270", 3),//设计师
    TYPE_4("tag00011","tagval0000000271", 4),//备用联系人
    TYPE_5("tag00011","tagval0000000272", 5),//其他
    TYPE_6("tag00011","tagval0000000273", 6);//离职设计师

    public static String getValIdByType(Integer type){

      CONTACT_DUTY[] types = CONTACT_DUTY.values();

      for(CONTACT_DUTY customercd1 :types){

        if(customercd1.getType().equals(type)){

          return customercd1.getTagvalId();
        }
      }
      return null;
    }

    private CONTACT_DUTY(String tagId, String tagvalId, Integer type) {
      this.tagId = tagId;
      this.tagvalId = tagvalId;
      this.type = type;
    }

    private String tagId;
    private String tagvalId ;
    private Integer type ;

    public String getTagId() {
      return tagId;
    }

    public void setTagId(String tagId) {
      this.tagId = tagId;
    }

    public String getTagvalId() {
      return tagvalId;
    }

    public void setTagvalId(String tagvalId) {
      this.tagvalId = tagvalId;
    }

    public Integer getType() {
      return type;
    }

    public void setType(Integer type) {
      this.type = type;
    }
  }

  /**
   * 联系人 状态
   */
  public enum CONTACT_STATUS{
    TYPE_0("tag00012","tagval0000000274", 0) ,//重要
    TYPE_1("tag00012","tagval0000000275", 1),//普通
    TYPE_2("tag00012","tagval0000000276", 2),//不重要
    TYPE_3("tag00012","tagval0000000277", 3),//在职
    TYPE_4("tag00012","tagval0000000278", 4),//离职设计师
    TYPE_5("tag00012","tagval0000000279", 5),//退休
    TYPE_6("tag00012","tagval0000000280", 6),//其他
    TYPE_7("tag00012","tagval0000000281", -2);//无

    public static String getValIdByType(Integer type){

      CONTACT_STATUS[] types = CONTACT_STATUS.values();

      for(CONTACT_STATUS status :types){

        if(status.getType().equals(type)){

          return status.getTagvalId();
        }
      }
      return null;
    }

    private CONTACT_STATUS(String tagId, String tagvalId, Integer type) {
      this.tagId = tagId;
      this.tagvalId = tagvalId;
      this.type = type;
    }

    private String tagId;
    private String tagvalId ;
    private Integer type ;

    public String getTagId() {
      return tagId;
    }

    public void setTagId(String tagId) {
      this.tagId = tagId;
    }

    public String getTagvalId() {
      return tagvalId;
    }

    public void setTagvalId(String tagvalId) {
      this.tagvalId = tagvalId;
    }

    public Integer getType() {
      return type;
    }

    public void setType(Integer type) {
      this.type = type;
    }
  }


  /**
   * 联系人 角色
   */
  public enum CONTACT_ROLE{
    TYPE_1("tag00018","tagval0000000307", 1) ,//决策人
    TYPE_2("tag00018","tagval0000000308", 2),//使用人
    TYPE_3("tag00018","tagval0000000309", 3);//其他

    public static String getValIdByType(Integer type){

      CONTACT_ROLE[] types = CONTACT_ROLE.values();

      for(CONTACT_ROLE status :types){

        if(status.getType().equals(type)){

          return status.getTagvalId();
        }
      }
      return null;
    }

    private CONTACT_ROLE(String tagId, String tagvalId, Integer type) {
      this.tagId = tagId;
      this.tagvalId = tagvalId;
      this.type = type;
    }

    private String tagId;
    private String tagvalId ;
    private Integer type ;

    public String getTagId() {
      return tagId;
    }

    public void setTagId(String tagId) {
      this.tagId = tagId;
    }

    public String getTagvalId() {
      return tagvalId;
    }

    public void setTagvalId(String tagvalId) {
      this.tagvalId = tagvalId;
    }

    public Integer getType() {
      return type;
    }

    public void setType(Integer type) {
      this.type = type;
    }
  }




  /**
   * 联系人 来源
   */
  public enum CONTACT_SOURCE{
    TYPE_0("其他",0) ,
    TYPE_1("下载包",1),
    TYPE_2("开启订货会",2),
    TYPE_3("开启私人订制",3),
    TYPE_4("开启下载包",4),
    TYPE_5("子账号",5),
    TYPE_6("无",-3);

    private CONTACT_SOURCE(String key, Integer type) {
      this.key = key;
      this.type = type;
    }
    private String key ;
    private Integer type ;
    public String getKey() {
      return key;
    }
    public Integer getType() {
      return type;
    }
  }


  /**
   * 回访 级别
   */
  public enum FeedBack_CUSTOMERCD2{
    TYPE_0("Ⅰ",0) ,
    TYPE_1("Ⅱ",1),
    TYPE_2("Ⅲ",2),
    TYPE_3("Ⅳ",3),
    TYPE_4("无",-2);


    public static String getKeyByType(Integer type){
      if(type==null){
        return FeedBack_CUSTOMERCD2.TYPE_0.getKey();
      }
      FeedBack_CUSTOMERCD2[] Types = FeedBack_CUSTOMERCD2.values();
      for(FeedBack_CUSTOMERCD2 Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return FeedBack_CUSTOMERCD2.TYPE_0.getKey();
    }

    private FeedBack_CUSTOMERCD2(String key, Integer type) {
      this.key = key;
      this.type = type;
    }
    private String key ;
    private Integer type ;
    public String getKey() {
      return key;
    }
    public Integer getType() {
      return type;
    }
  }


  /**
   * 用户 微信状态判断
   */
  public enum CONTACT_ISWECHAT{
    TYPE_1("是",1),
    TYPE_2("否",0),
    TYPE_3("无",-2);


    public static String getKeyByType(Integer type){
      if(type==null){
        return CONTACT_ISWECHAT.TYPE_3.getKey();
      }
      CONTACT_ISWECHAT[] Types = CONTACT_ISWECHAT.values();
      for(CONTACT_ISWECHAT Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CONTACT_ISWECHAT.TYPE_3.getKey();
    }

    private CONTACT_ISWECHAT(String key, Integer type) {
      this.key = key;
      this.type = type;
    }
    private String key ;
    private Integer type ;
    public String getKey() {
      return key;
    }
    public Integer getType() {
      return type;
    }
  }


  /**
   * 联系人 多产品
   */
  public enum CONTACT_PRODUCTS{
    TYPE_0("不需要",0) ,
    TYPE_1("免费试用",1),
    TYPE_2("了解",2),
    TYPE_3("高意向",3);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CONTACT_PRODUCTS.TYPE_0.getKey();
      }
      CONTACT_PRODUCTS[] Types = CONTACT_PRODUCTS.values();
      for(CONTACT_PRODUCTS Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CONTACT_PRODUCTS.TYPE_0.getKey();
    }

    private CONTACT_PRODUCTS(String key, Integer type) {
      this.key = key;
      this.type = type;
    }
    private String key ;
    private Integer type ;
    public String getKey() {
      return key;
    }
    public Integer getType() {
      return type;
    }
  }


  /**
   * 联系人 客服印象
   */
  public enum CONTACT_IMPRESSION{
    TYPE_1("tag00019","tagval0000000310", 1) ,//Ⅰ很好沟通
    TYPE_2("tag00019","tagval0000000311", 2),//Ⅱ一般
    TYPE_3("tag00019","tagval0000000311", 3);//Ⅲ拒绝沟通

    public static String getValIdByType(Integer type){

      CONTACT_IMPRESSION[] types = CONTACT_IMPRESSION.values();

      for(CONTACT_IMPRESSION status :types){

        if(status.getType().equals(type)){

          return status.getTagvalId();
        }
      }
      return null;
    }

    private CONTACT_IMPRESSION(String tagId, String tagvalId, Integer type) {
      this.tagId = tagId;
      this.tagvalId = tagvalId;
      this.type = type;
    }

    private String tagId;
    private String tagvalId ;
    private Integer type ;

    public String getTagId() {
      return tagId;
    }

    public void setTagId(String tagId) {
      this.tagId = tagId;
    }

    public String getTagvalId() {
      return tagvalId;
    }

    public void setTagvalId(String tagvalId) {
      this.tagvalId = tagvalId;
    }

    public Integer getType() {
      return type;
    }

    public void setType(Integer type) {
      this.type = type;
    }
  }


  /**
   * 联系人 多产品
   */
  public enum CONTACT_SERVER_PRODUCTS{
    TYPE_1("APM",1) ,
    TYPE_2("书籍",2),
    TYPE_3("总裁班",3),
    TYPE_4("云图",4),
    TYPE_5("韩国行",5),
    TYPE_6("展会",6);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CONTACT_SERVER_PRODUCTS.TYPE_1.getKey();
      }
      CONTACT_SERVER_PRODUCTS[] Types = CONTACT_SERVER_PRODUCTS.values();
      for(CONTACT_SERVER_PRODUCTS Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CONTACT_SERVER_PRODUCTS.TYPE_1.getKey();
    }

    private CONTACT_SERVER_PRODUCTS(String key, Integer type) {
      this.key = key;
      this.type = type;
    }
    private String key ;
    private Integer type ;
    public String getKey() {
      return key;
    }
    public Integer getType() {
      return type;
    }
  }

  /**
   * 联系人 多产品 意向
   */
  public enum CONTACT_SERVER_PRODUCTS_CHECK{
    TYPE_1("不需要",0) ,
    TYPE_2("免费试用",1),
    TYPE_3("了解",2),
    TYPE_4("高意向",3);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CONTACT_SERVER_PRODUCTS_CHECK.TYPE_1.getKey();
      }
      CONTACT_SERVER_PRODUCTS_CHECK[] Types = CONTACT_SERVER_PRODUCTS_CHECK.values();
      for(CONTACT_SERVER_PRODUCTS_CHECK Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CONTACT_SERVER_PRODUCTS_CHECK.TYPE_1.getKey();
    }

    private CONTACT_SERVER_PRODUCTS_CHECK(String key, Integer type) {
      this.key = key;
      this.type = type;
    }
    private String key ;
    private Integer type ;
    public String getKey() {
      return key;
    }
    public Integer getType() {
      return type;
    }
  }





}
