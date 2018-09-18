package com.pop136.customerservice.constant;

public class CustomerTagConstant {

  /**
   * 客户 标签 企业类型
   */
  public enum CUSTOMER_COMPANY_TYPE{
    TYPE_0("男装",581089) ,
    TYPE_1("女装",581090),
    TYPE_2("童装",581091),
    TYPE_3("男女装",581092),
    TYPE_4("男装 童装",581093),
    TYPE_5("女装 童装",581096),
    TYPE_6("男女童装",581097),
    TYPE_7("中性",581098),
    TYPE_8("情侣",581099),
    TYPE_9("男",582219),
    TYPE_10("女",582220),
    TYPE_11("童/婴",582221),
    TYPE_12("综合",582222),
    TYPE_13("男装",582223),
    TYPE_14("女装",582224),
    TYPE_15("男包",582225),
    TYPE_16("女包",582226),
    TYPE_17("运动旅行",582232),
    TYPE_18("男",582233),
    TYPE_19("女",582234),
    TYPE_20("童",582235),
    TYPE_21("运动",582236),
    TYPE_22("全性别",582237),
    TYPE_23("男+女",582276),
    TYPE_24("面料",583373),
    TYPE_25("图案",583374),
    TYPE_26("摄影",583375),
    TYPE_27("配饰 ",583376);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CUSTOMER_COMPANY_TYPE.TYPE_6.getKey();
      }
      CUSTOMER_COMPANY_TYPE[] Types = CUSTOMER_COMPANY_TYPE.values();
      for(CUSTOMER_COMPANY_TYPE Type : Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CUSTOMER_COMPANY_TYPE.TYPE_6.getKey();
    }

    private CUSTOMER_COMPANY_TYPE(String key, Integer type) {
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
   * 客户 标签 sex (性别)
   */
  public enum CUSTOMER_SEX{
    TYPE_0("男装",582140) ,
    TYPE_1("女装",582141),
    TYPE_2("童装",582144),
    TYPE_3("男女装",582145),
    TYPE_4("男装 童装",582214),
    TYPE_5("女装 童装",582215),
    TYPE_6("男女童装",582216),
    TYPE_7("中性",582217),
    TYPE_8("情侣",582218),
    TYPE_9("男",582219),
    TYPE_10("女",582220),
    TYPE_11("童/婴",582221),
    TYPE_12("综合",582222),
    TYPE_13("男装",582223),
    TYPE_14("女装",582224),
    TYPE_15("男包",582225),
    TYPE_16("女包",582226),
    TYPE_17("运动旅行",582232),
    TYPE_18("男",582233),
    TYPE_19("女",582234),
    TYPE_20("童",582235),
    TYPE_21("运动",582236),
    TYPE_22("全性别",582237),
    TYPE_23("男+女",582276),
    TYPE_24("面料",583373),
    TYPE_25("图案",583374),
    TYPE_26("摄影",583375),
    TYPE_27("配饰 ",583376);

    public static String getKeyByType(Integer type){
      if(type==null){
        return CUSTOMER_SEX.TYPE_6.getKey();
      }
      CUSTOMER_SEX[] Types = CUSTOMER_SEX.values();
      for(CUSTOMER_SEX Type : Types){
        if(Type.getType().equals(type)){
          return Type.getKey();
        }
      }
      return CUSTOMER_SEX.TYPE_6.getKey();
    }

    private CUSTOMER_SEX(String key, Integer type) {
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
