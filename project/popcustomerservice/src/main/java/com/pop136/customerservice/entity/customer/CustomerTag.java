package com.pop136.customerservice.entity.customer;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户标签表
 */
public class CustomerTag implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private Integer typeid;

    private String typename;

    private Integer tagid;

    private String tagname;

    private Integer statusid;

    private String statusname;

    private String customerid;

    private String customername;

    private String ownerroleid;

    private Date createtime;

    private Date lastupdatetime;

    private String createroleid;

    private String updateroleid;

    private Integer deleteflag;

    private String grpcode;

    private String orgcode;

    private String loccode;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getOwnerroleid() {
        return ownerroleid;
    }

    public void setOwnerroleid(String ownerroleid) {
        this.ownerroleid = ownerroleid;
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

    public String getCreateroleid() {
        return createroleid;
    }

    public void setCreateroleid(String createroleid) {
        this.createroleid = createroleid;
    }

    public String getUpdateroleid() {
        return updateroleid;
    }

    public void setUpdateroleid(String updateroleid) {
        this.updateroleid = updateroleid;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}