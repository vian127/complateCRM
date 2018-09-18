/**
 * SmsServiceUTFSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public interface SmsServiceUTFSoap_PortType extends java.rmi.Remote {

    /**
     * 获取余额：username用户名;password密码
     */
    public int getBalance(String username, String password) throws java.rmi.RemoteException;

    /**
     * 接收短信返回字符串：username用户名;password密码
     */
    public String recvSms(String username, String password) throws java.rmi.RemoteException;

    /**
     * 接收短信返回XML：username用户名;password密码
     */
    public RecvSmsExResponseRecvSmsExResult recvSmsEx(String username, String password) throws java.rmi.RemoteException;

    /**
     * 快速发送短信：username用户名;password密码;mobile手机号码,每次提交1000个以逗号,隔开;smscontent发送内容
     */
    public int sendSMS(String username, String password, String mobile, String smscontent) throws java.rmi.RemoteException;

    /**
     * 定时发送短信：username用户名;password密码;mobile手机号码,每次提交1000个以逗号,隔开;smscontent发送内容;sendtime发送时间,默认空时立即发送
     */
    public int sendSmsTime(String username, String password, String mobile, String smscontent, String sendtime) throws java.rmi.RemoteException;

    /**
     * 扩展发送短信：username用户名;password密码;mobile手机号码,每次提交1000个以逗号,隔开;smsID唯一编号对应mobile;smscontent发送内容;sa扩展号码1-4位
     */
    public int sendSmsEXTRequest(String username, String password, String mobile, String smsID, String smscontent, String sa) throws java.rmi.RemoteException;

    /**
     * 相同内容群发短信：username用户名;password密码;mobile手机号码,每次提交1000个以逗号,隔开;smsID唯一编号对应mobile;smscontent发送内容;sendtime发送时间,默认空时立即发送;sa扩展号码1-4位
     */
    public int sendSmsRe(String username, String password, String mobile, String smsID, String smscontent, String sendtime, String sa) throws java.rmi.RemoteException;

    /**
     * 个性化内容群发短信：username用户名;password密码;mobile手机号码,每次提交1000个以逗号,隔开;smsID唯一编号对应mobile以逗号,隔开;smscontent发送内容对应mobile数量以&&隔开;sendtime发送时间,默认空时立即发送;sa扩展号码1-4位
     */
    public int sendSmsReEx(String username, String password, String mobile, String smsID, String smscontent, String sendtime, String sa) throws java.rmi.RemoteException;
}
