package com.pop136.customerservice.entity.view;

import java.io.Serializable;

/**
 * 标签 mapping
 */
public class FeedBackTagMappingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String fromtagid;

    private String fromtagname;

    private String fromtagvalid;

    private String fromcode;

    private String fromtagvalue;

    private String totagid;

    private String totagname;

    private String totagvalid;

    private String tocode;

    private String totagvalue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromtagid() {
        return fromtagid;
    }

    public void setFromtagid(String fromtagid) {
        this.fromtagid = fromtagid;
    }

    public String getFromtagname() {
        return fromtagname;
    }

    public void setFromtagname(String fromtagname) {
        this.fromtagname = fromtagname;
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

    public String getFromtagvalue() {
        return fromtagvalue;
    }

    public void setFromtagvalue(String fromtagvalue) {
        this.fromtagvalue = fromtagvalue;
    }

    public String getTotagid() {
        return totagid;
    }

    public void setTotagid(String totagid) {
        this.totagid = totagid;
    }

    public String getTotagname() {
        return totagname;
    }

    public void setTotagname(String totagname) {
        this.totagname = totagname;
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

    public String getTotagvalue() {
        return totagvalue;
    }

    public void setTotagvalue(String totagvalue) {
        this.totagvalue = totagvalue;
    }
}