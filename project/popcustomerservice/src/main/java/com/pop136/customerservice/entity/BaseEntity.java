package com.pop136.customerservice.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 基础信息
 *
 */
public class BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	@Override    
    public boolean equals(Object o) {    
        if (this == o) return true;    
        if (o == null || getClass() != o.getClass()) return false;    
    
        BaseEntity ent_tity = (BaseEntity) o;    
    
        if (id != null ? !id.equals(ent_tity.id) : ent_tity.id != null) return false;    
    
        return true;    
    }    
    
    @Override    
    public int hashCode() {    
        return id != null ? id.hashCode() : 0;    
    } 	
    
}
