package com.pop136.customerservice.entity.customer;

import java.io.Serializable;
import java.util.Date;

/**
 * 协助客户表
 */
public class CustomerOwner implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String ownerroleid;

    private String customerid;

    private Integer msgtype;

    private String objectid;

    private Integer source;

    private String fathergroupid;

    private String msggroupid;

    private String userroleid;

    private Date begindate;

    private Date enddate;

    private Integer dateflag;

    private String enduserroleid;

    private Integer status;

    private Date createtime;

    private Date lastupdatetime;

    private Integer deleteflag;

    private String updateroleid;

    private String grpcode;

    private String orgcode;

    private String loccode;

    private String assistid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerroleid() {
        return ownerroleid;
    }

    public void setOwnerroleid(String ownerroleid) {
        this.ownerroleid = ownerroleid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public Integer getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getFathergroupid() {
        return fathergroupid;
    }

    public void setFathergroupid(String fathergroupid) {
        this.fathergroupid = fathergroupid;
    }

    public String getMsggroupid() {
        return msggroupid;
    }

    public void setMsggroupid(String msggroupid) {
        this.msggroupid = msggroupid;
    }

    public String getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(String userroleid) {
        this.userroleid = userroleid;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getDateflag() {
        return dateflag;
    }

    public void setDateflag(Integer dateflag) {
        this.dateflag = dateflag;
    }

    public String getEnduserroleid() {
        return enduserroleid;
    }

    public void setEnduserroleid(String enduserroleid) {
        this.enduserroleid = enduserroleid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getUpdateroleid() {
        return updateroleid;
    }

    public void setUpdateroleid(String updateroleid) {
        this.updateroleid = updateroleid;
    }

    public String getGrpcode() {
        return grpcode;
    }

    public void setGrpcode(String grpcode) {
        this.grpcode = grpcode;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getLoccode() {
        return loccode;
    }

    public void setLoccode(String loccode) {
        this.loccode = loccode;
    }

    public String getAssistid() {
        return assistid;
    }

    public void setAssistid(String assistid) {
        this.assistid = assistid;
    }
}