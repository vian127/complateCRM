package com.pop136.customerservice.vo.customer;

import java.io.Serializable;

/**
 *协助状态
 */
public class AssistInfoVo implements Serializable {

  private String customerId;//客户id

  private String handlerName;//操作者

  private String assistantName;//协助人

  private String assistantName2;//第二协助人

  private String startTime;

  private String endTime;


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getHandlerName() {
    return handlerName;
  }

  public void setHandlerName(String handlerName) {
    this.handlerName = handlerName;
  }

  public String getAssistantName() {
    return assistantName;
  }

  public void setAssistantName(String assistantName) {
    this.assistantName = assistantName;
  }

  public String getAssistantName2() {
    return assistantName2;
  }

  public void setAssistantName2(String assistantName2) {
    this.assistantName2 = assistantName2;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
}