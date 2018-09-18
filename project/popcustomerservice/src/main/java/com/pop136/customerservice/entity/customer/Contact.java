package com.pop136.customerservice.entity.customer;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户 联系人表
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private Integer sex;

    private String customerid;

    private String position;

    private String department;

    private Integer statusid;

    private String telephone;

    private String fax;

    private String email;

    private String mobile;

    private String selfemail;

    private Integer marriage;

    private String birthday;

    private String customfield1;

    private String customfield2;

    private String customfield3;

    private String customfield4;

    private String customfield5;

    private Integer customdict1;

    private Integer customdict2;

    private Integer customdict3;

    private String creatorid;

    private String createtime;

    private String lastmenderid;

    private String lastupdatetime;

    private Integer deleteflag;

    private String unit;

    private String homephone;

    private String iismain;

    private String updateroleid;

    private String msn;

    private String qq;

    private Integer oneye;

    private String response;

    private String callname;

    private Integer srelation;

    private Integer customdict4;

    private Integer customdict5;

    private Integer annexflag;

    private String pingying;

    private Integer cardtypeid;

    private Integer educationtypeid;

    private Integer incometypeid;

    private String grpcode;

    private String orgcode;

    private String loccode;

    private String mergecontactid;

    private String customerfatherid;

    private String contactfatherid;

    private String relatecontactid1;

    private String relatecontactid2;

    private String relatecontactid3;

    private String relatecontactid4;

    private String relatecontactid5;

    private String leadid;

    private String leadname;

    private String partenerid;

    private String partenername;

    private String competitorid;

    private String competitorname;

    private String extensionphone;

    private String phoneid;

    private String customerName;

    private String iswechat;


    public String getIswechat() {
        return iswechat;
    }

    public void setIswechat(String iswechat) {
        this.iswechat = iswechat;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSelfemail() {
        return selfemail;
    }

    public void setSelfemail(String selfemail) {
        this.selfemail = selfemail;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setLastupdatetime(String lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getCustomfield1() {
        return customfield1;
    }

    public void setCustomfield1(String customfield1) {
        this.customfield1 = customfield1;
    }

    public String getCustomfield2() {
        return customfield2;
    }

    public void setCustomfield2(String customfield2) {
        this.customfield2 = customfield2;
    }

    public String getCustomfield3() {
        return customfield3;
    }

    public void setCustomfield3(String customfield3) {
        this.customfield3 = customfield3;
    }

    public String getCustomfield4() {
        return customfield4;
    }

    public void setCustomfield4(String customfield4) {
        this.customfield4 = customfield4;
    }

    public String getCustomfield5() {
        return customfield5;
    }

    public void setCustomfield5(String customfield5) {
        this.customfield5 = customfield5;
    }

    public Integer getCustomdict1() {
        return customdict1;
    }

    public void setCustomdict1(Integer customdict1) {
        this.customdict1 = customdict1;
    }

    public Integer getCustomdict2() {
        return customdict2;
    }

    public void setCustomdict2(Integer customdict2) {
        this.customdict2 = customdict2;
    }

    public Integer getCustomdict3() {
        return customdict3;
    }

    public void setCustomdict3(Integer customdict3) {
        this.customdict3 = customdict3;
    }


    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getLastmenderid() {
        return lastmenderid;
    }

    public void setLastmenderid(String lastmenderid) {
        this.lastmenderid = lastmenderid;
    }

    public String getLastupdatetime() {
        return lastupdatetime;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }


    public String getIismain() {
        return iismain;
    }

    public void setIismain(String iismain) {
        this.iismain = iismain;
    }

    public String getUpdateroleid() {
        return updateroleid;
    }

    public void setUpdateroleid(String updateroleid) {
        this.updateroleid = updateroleid;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getOneye() {
        return oneye;
    }

    public void setOneye(Integer oneye) {
        this.oneye = oneye;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCallname() {
        return callname;
    }

    public void setCallname(String callname) {
        this.callname = callname;
    }

    public Integer getSrelation() {
        return srelation;
    }

    public void setSrelation(Integer srelation) {
        this.srelation = srelation;
    }

    public Integer getCustomdict4() {
        return customdict4;
    }

    public void setCustomdict4(Integer customdict4) {
        this.customdict4 = customdict4;
    }

    public Integer getCustomdict5() {
        return customdict5;
    }

    public void setCustomdict5(Integer customdict5) {
        this.customdict5 = customdict5;
    }

    public Integer getAnnexflag() {
        return annexflag;
    }

    public void setAnnexflag(Integer annexflag) {
        this.annexflag = annexflag;
    }

    public String getPingying() {
        return pingying;
    }

    public void setPingying(String pingying) {
        this.pingying = pingying;
    }

    public Integer getCardtypeid() {
        return cardtypeid;
    }

    public void setCardtypeid(Integer cardtypeid) {
        this.cardtypeid = cardtypeid;
    }

    public Integer getEducationtypeid() {
        return educationtypeid;
    }

    public void setEducationtypeid(Integer educationtypeid) {
        this.educationtypeid = educationtypeid;
    }

    public Integer getIncometypeid() {
        return incometypeid;
    }

    public void setIncometypeid(Integer incometypeid) {
        this.incometypeid = incometypeid;
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

    public String getMergecontactid() {
        return mergecontactid;
    }

    public void setMergecontactid(String mergecontactid) {
        this.mergecontactid = mergecontactid;
    }

    public String getCustomerfatherid() {
        return customerfatherid;
    }

    public void setCustomerfatherid(String customerfatherid) {
        this.customerfatherid = customerfatherid;
    }

    public String getContactfatherid() {
        return contactfatherid;
    }

    public void setContactfatherid(String contactfatherid) {
        this.contactfatherid = contactfatherid;
    }

    public String getRelatecontactid1() {
        return relatecontactid1;
    }

    public void setRelatecontactid1(String relatecontactid1) {
        this.relatecontactid1 = relatecontactid1;
    }

    public String getRelatecontactid2() {
        return relatecontactid2;
    }

    public void setRelatecontactid2(String relatecontactid2) {
        this.relatecontactid2 = relatecontactid2;
    }

    public String getRelatecontactid3() {
        return relatecontactid3;
    }

    public void setRelatecontactid3(String relatecontactid3) {
        this.relatecontactid3 = relatecontactid3;
    }

    public String getRelatecontactid4() {
        return relatecontactid4;
    }

    public void setRelatecontactid4(String relatecontactid4) {
        this.relatecontactid4 = relatecontactid4;
    }

    public String getRelatecontactid5() {
        return relatecontactid5;
    }

    public void setRelatecontactid5(String relatecontactid5) {
        this.relatecontactid5 = relatecontactid5;
    }

    public String getLeadid() {
        return leadid;
    }

    public void setLeadid(String leadid) {
        this.leadid = leadid;
    }

    public String getLeadname() {
        return leadname;
    }

    public void setLeadname(String leadname) {
        this.leadname = leadname;
    }

    public String getPartenerid() {
        return partenerid;
    }

    public void setPartenerid(String partenerid) {
        this.partenerid = partenerid;
    }

    public String getPartenername() {
        return partenername;
    }

    public void setPartenername(String partenername) {
        this.partenername = partenername;
    }

    public String getCompetitorid() {
        return competitorid;
    }

    public void setCompetitorid(String competitorid) {
        this.competitorid = competitorid;
    }

    public String getCompetitorname() {
        return competitorname;
    }

    public void setCompetitorname(String competitorname) {
        this.competitorname = competitorname;
    }

    public String getExtensionphone() {
        return extensionphone;
    }

    public void setExtensionphone(String extensionphone) {
        this.extensionphone = extensionphone;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }
}