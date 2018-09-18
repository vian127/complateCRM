package com.pop136.customerservice.constant;


public class CustomerConstant {
  /**
   * 客户来源 webSource
   */
  public enum CUSTOMER_SOURCE {

    CLOTHING("tag00001", "tagval0000000001", 1),//服装
    BAGS("tag00001", "tagval0000000002", 2),//箱包
    SHOE("tag00001", "tagval0000000003", 3),//鞋子
    JEWELRY("tag00001", "tagval0000000004", 4),//首饰
    TEXTILES("tag00001", "tagval0000000005", 5),//家纺
    CLOTHING_E("tag00001", "tagval0000000006", 6),//英文服装
    FABRIC("tag00001", "tagval0000000007", 7);//面料

    public static String getKeyByType(Integer type) {

      CUSTOMER_SOURCE[] types = CUSTOMER_SOURCE.values();

      for (CUSTOMER_SOURCE customercd1 : types) {

        if (customercd1.getType().equals(type)) {

          return customercd1.getTagvalId();
        }
      }
      return null;
    }

    private CUSTOMER_SOURCE(String tagId, String tagvalId, Integer type) {
      this.tagId = tagId;
      this.tagvalId = tagvalId;
      this.type = type;
    }

    private String tagId;
    private String tagvalId;
    private Integer type;

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
  public enum CUSTOMER_APM_PRODUCTS{
    TYPE_1("APM男装",1) ,
    TYPE_2("APM女装",2),
    TYPE_6("APM童装",3);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CustomerConstant.CUSTOMER_APM_PRODUCTS.TYPE_1.getKey();
      }
      CustomerConstant.CUSTOMER_APM_PRODUCTS[] Types = CustomerConstant.CUSTOMER_APM_PRODUCTS.values();
      for(CustomerConstant.CUSTOMER_APM_PRODUCTS Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CustomerConstant.CUSTOMER_APM_PRODUCTS.TYPE_1.getKey();
    }

    private CUSTOMER_APM_PRODUCTS(String key, Integer type) {
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
   * 用户 发票类型(crm 系统)
   */
  public enum CUSTOMER_CRM_INVOICE{
    TYPE_1("信息服务费",0) ,
    TYPE_2("网络咨询费",1),
    TYPE_3("服务费",2),
    TYPE_4("无",-1);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CustomerConstant.CUSTOMER_CRM_INVOICE.TYPE_4.getKey();
      }
      CustomerConstant.CUSTOMER_CRM_INVOICE[] Types = CustomerConstant.CUSTOMER_CRM_INVOICE.values();
      for(CustomerConstant.CUSTOMER_CRM_INVOICE Type:Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CustomerConstant.CUSTOMER_CRM_INVOICE.TYPE_4.getKey();
    }

    private CUSTOMER_CRM_INVOICE(String key, Integer type) {
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
   * 客户 服务阶段
   */
  public enum CUSTOMER_SERVICE_STAGE{

    TYPE_1("tag00013","tagval0000000282",1),//新客期
    TYPE_2("tag00013","tagval0000000283",2),//服务期
    TYPE_3("tag00013","tagval0000000284",3);//流转期

    public static String getValIdByType(Integer type){

      CUSTOMER_SERVICE_STAGE[] types = CUSTOMER_SERVICE_STAGE.values();

      for(CUSTOMER_SERVICE_STAGE customercd1 :types){

        if(customercd1.getType().equals(type)){

          return customercd1.getTagvalId();
        }
      }
      return null;
    }

    private CUSTOMER_SERVICE_STAGE(String tagId, String tagvalId, Integer type) {
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

}