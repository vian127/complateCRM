package com.pop136.customerservice.entity.view;

import java.io.Serializable;

/**
 * 标签 mapping
 */
public class FeedBackTagValueMappingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String tagid;

    private String fromtagvalid;

    private String fromcode;

    private String fromvalue;

    private String totagvalid;

    private String tocode;

    private String tovalue;

    private String sortnum;

    private String module;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String getFromtagvalid() {
        return fromtagvalid;
    }

    public void setFromtagvalid(String fromtagvalid) {
        this.fromtagvalid = fromtagvalid;
    }

    public String getFromcode() {
        return fromcode;
    }

    public void setFromcode(String fromcode) {
        this.fromcode = fromcode;
    }

    public String getFromvalue() {
        return fromvalue;
    }

    public void setFromvalue(String fromvalue) {
        this.fromvalue = fromvalue;
    }

    public String getTotagvalid() {
        return totagvalid;
    }

    public void setTotagvalid(String totagvalid) {
        this.totagvalid = totagvalid;
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

    public String getSortnum() {
        return sortnum;
    }

    public void setSortnum(String sortnum) {
        this.sortnum = sortnum;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}