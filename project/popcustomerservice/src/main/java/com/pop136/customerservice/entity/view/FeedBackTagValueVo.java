package com.pop136.customerservice.entity.view;

import java.io.Serializable;
import java.util.List;

/**
 * 标签 mapping
 */
public class FeedBackTagValueVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String tagid;

    private String code;

    private String value;

    private String tagname;

    private String tagcate;

    private String tagattribute;

    private String description;

    private String module;

    private String selected;

    private Integer nlevel;

    private List<FeedBackTagValueVo> children;

    private String haschild;

    private Integer sortnum;

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

    public Integer getNlevel() {
        return nlevel;
    }

    public void setNlevel(Integer nlevel) {
        this.nlevel = nlevel;
    }

    public List<FeedBackTagValueVo> getChildren() {
        return children;
    }

    public void setChildren(List<FeedBackTagValueVo> children) {
        this.children = children;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getHaschild() {
        return haschild;
    }

    public void setHaschild(String haschild) {
        this.haschild = haschild;
    }
}