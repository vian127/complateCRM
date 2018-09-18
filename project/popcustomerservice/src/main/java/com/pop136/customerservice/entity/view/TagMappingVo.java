package com.pop136.customerservice.entity.view;

import java.io.Serializable;
import java.util.List;

/**
 * 标签 mapping
 */
public class TagMappingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tagid;

    private String tagname;

    private String tagcate;

    private String tagattribute;

    private String id;

    private String code;

    private String value;

    private String description;

    private String module;

    private String lang;

    private Integer nlevel;

    private String children;

    private Integer sortnum;

    private String totagid;

    private String tocode;

    private String tovalue;

    private String todescription;

    private Integer tosortnum;

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getTagcate() {
        return tagcate;
    }

    public void setTagcate(String tagcate) {
        this.tagcate = tagcate;
    }

    public String getTagattribute() {
        return tagattribute;
    }

    public void setTagattribute(String tagattribute) {
        this.tagattribute = tagattribute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getNlevel() {
        return nlevel;
    }

    public void setNlevel(Integer nlevel) {
        this.nlevel = nlevel;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public String getTotagid() {
        return totagid;
    }

    public void setTotagid(String totagid) {
        this.totagid = totagid;
    }

    public String getTocode() {
        return tocode;
    }

    public void setTocode(String tocode) {
        this.tocode = tocode;
    }

    public String getTovalue() {
        return tovalue;
    }

    public void setTovalue(String tovalue) {
        this.tovalue = tovalue;
    }

    public Integer getTosortnum() {
        return tosortnum;
    }

    public void setTosortnum(Integer tosortnum) {
        this.tosortnum = tosortnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTodescription() {
        return todescription;
    }

    public void setTodescription(String todescription) {
        this.todescription = todescription;
    }
}