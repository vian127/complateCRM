package com.pop136.customerservice.vo.marketing.param;

import java.io.Serializable;

/**
 * 模版 param
 */
public class MsgTemplateParamVo implements Serializable{

  private String id;//id

  private String name;//模版名称

  private String sign;//模版签名

  private String content;//N内容

  private String variable;//变量

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

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getVariable() {
    return variable;
  }

  public void setVariable(String variable) {
    this.variable = variable;
  }
}
