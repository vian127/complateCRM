package com.pop136.customerservice.entity;

import java.io.Serializable;

import javax.persistence.Transient;

public class BasePage implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String error_code;
    private String error_msg;
    private String code;
    private String message;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
	
    
}
