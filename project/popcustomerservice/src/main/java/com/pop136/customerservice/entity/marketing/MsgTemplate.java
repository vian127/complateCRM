package com.pop136.customerservice.entity.marketing;

import java.io.Serializable;
import java.util.Date;

public class MsgTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String name;//名称

    private String sign;//签名

    private String content;

    private String ownerroleid;

    private Integer typeid;

    private String typename;

    private Integer statusid;

    private String statusname;

    private String createtime;

    private String lastupdatetime;

    private Integer deleteflag;

    private Integer annexflag;

    private String updateroleid;

    private String creatorroleid;

    private String creater;

    private String updater;

    private Integer flag;

    private String subject;

    private String grpcode;

    private String orgcode;

    private String loccode;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwnerroleid() {
        return ownerroleid;
    }

    public void setOwnerroleid(String ownerroleid) {
        this.ownerroleid = ownerroleid;
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

    public Integer getAnnexflag() {
        return annexflag;
    }

    public void setAnnexflag(Integer annexflag) {
        this.annexflag = annexflag;
    }

    public String getUpdateroleid() {
        return updateroleid;
    }

    public void setUpdateroleid(String updateroleid) {
        this.updateroleid = updateroleid;
    }

    public String getCreatorroleid() {
        return creatorroleid;
    }

    public void setCreatorroleid(String creatorroleid) {
        this.creatorroleid = creatorroleid;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
}