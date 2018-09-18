package com.pop136.customerservice.entity.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户权限表
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userid;

    private Integer frameworkid;

    private Integer positionid;

    private Integer roletype;

    private Date begindate;

    private Date enddate;

    private Integer nodenum;

    private Date createtime;

    private Date lastupdatetime;

    private Integer deleteflag;

    private String updateroleid;

    private String usegrpcode;

    private String useorgcode;

    private String useloccode;

    private String grpcode;

    private String orgcode;

    private String loccode;

    private Integer typeid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getFrameworkid() {
        return frameworkid;
    }

    public void setFrameworkid(Integer frameworkid) {
        this.frameworkid = frameworkid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
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

    public Integer getNodenum() {
        return nodenum;
    }

    public void setNodenum(Integer nodenum) {
        this.nodenum = nodenum;
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

    public String getUsegrpcode() {
        return usegrpcode;
    }

    public void setUsegrpcode(String usegrpcode) {
        this.usegrpcode = usegrpcode;
    }

    public String getUseorgcode() {
        return useorgcode;
    }

    public void setUseorgcode(String useorgcode) {
        this.useorgcode = useorgcode;
    }

    public String getUseloccode() {
        return useloccode;
    }

    public void setUseloccode(String useloccode) {
        this.useloccode = useloccode;
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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}