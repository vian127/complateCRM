package com.pop136.customerservice.vo.common;

import com.pop136.customerservice.entity.view.FeedBackTagValueVo;
import com.pop136.customerservice.entity.view.TagValueVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XH on 2018-7-25.
 */
public class FeedBackTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String value;
    private String tagcate;
    private String taggroup;
    private String tagattribute;
    private String tagseries;
    private String tagclassification;
    private String tagsection;

    public String getTagseries() {
        return tagseries;
    }

    public void setTagseries(String tagseries) {
        this.tagseries = tagseries;
    }

    public String getTagclassification() {
        return tagclassification;
    }

    public void setTagclassification(String tagclassification) {
        this.tagclassification = tagclassification;
    }

    public String getTagsection() {
        return tagsection;
    }

    public void setTagsection(String tagsection) {
        this.tagsection = tagsection;
    }

    private String isnecessary;
    private Integer sortnum;
    private Integer nlevel;
    private List<FeedBackTagValueVo> children;

    public List<FeedBackTagValueVo> getChildren() {
        return children;
    }

    public void setChildren(List<FeedBackTagValueVo> children) {
        this.children = children;
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

    public String getTagcate() {
        return tagcate;
    }

    public void setTagcate(String tagcate) {
        this.tagcate = tagcate;
    }

    public String getTaggroup() {
        return taggroup;
    }

    public void setTaggroup(String taggroup) {
        this.taggroup = taggroup;
    }

    public String getTagattribute() {
        return tagattribute;
    }

    public void setTagattribute(String tagattribute) {
        this.tagattribute = tagattribute;
    }

    public String getIsnecessary() {
        return isnecessary;
    }

    public void setIsnecessary(String isnecessary) {
        this.isnecessary = isnecessary;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getNlevel() {
        return nlevel;
    }

    public void setNlevel(Integer nlevel) {
        this.nlevel = nlevel;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
