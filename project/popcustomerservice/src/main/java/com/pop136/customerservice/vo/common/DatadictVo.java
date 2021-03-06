package com.pop136.customerservice.vo.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典表vo
 */
public class DatadictVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String stype;//类型

    private String name;

    private Integer code;

    private String description;

    private Integer sortnum;

    private Integer canmodify;

    private Integer fatherid;

    private String createtime;

    private String lastupdatetime;

    private Integer deleteflag;

    private String updateroleid;

    private Integer isdefault;

    private Integer targetunit;

    private Integer targetmodel;

    private String grpcode;

    private String orgcode;

    private String loccode;

    private String basevalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getCanmodify() {
        return canmodify;
    }

    public void setCanmodify(Integer canmodify) {
        this.canmodify = canmodify;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }


    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(String lastupdatetime) {
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

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    public Integer getTargetunit() {
        return targetunit;
    }

    public void setTargetunit(Integer targetunit) {
        this.targetunit = targetunit;
    }

    public Integer getTargetmodel() {
        return targetmodel;
    }

    public void setTargetmodel(Integer targetmodel) {
        this.targetmodel = targetmodel;
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

    public String getBasevalue() {
        return basevalue;
    }

    public void setBasevalue(String basevalue) {
        this.basevalue = basevalue;
    }
}