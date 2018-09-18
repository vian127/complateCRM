package com.pop136.customerservice.vo.user;

/**
 * Created by XH on 2018-8-16.
 */
public class UserVo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String userid;
    private String username;
    private String passwd;
    private String frameworkname;
    private Integer frameworkid;
    private Integer fatherid;
    private String typeid;
    private String roleid;
    private String roletype;
    private Integer positionid;
    private String positionname;

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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getFrameworkname() {
        return frameworkname;
    }

    public void setFrameworkname(String frameworkname) {
        this.frameworkname = frameworkname;
    }

    public Integer getFrameworkid() {
        return frameworkid;
    }

    public void setFrameworkid(Integer frameworkid) {
        this.frameworkid = frameworkid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
}
