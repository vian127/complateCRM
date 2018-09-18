package com.pop136.customerservice.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Transient;

public class VerifyCellPhoneVo implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Transient
	private Integer id;
	@NotNull(message = "verify.cell.phone.not.null")
	private String phone;// 手机号码

	private String verifyCode;// 验证码
	private String imgCode;// 图片验证码

	private Integer isVerify;// 验证状态 0:未验证 1:已验证

	private String verifyTime;// 验证时间

	private String sendTime;// 发送时间
	@NotNull(message = "verify.cell.phone.type.not.null")
	private Integer type;// 获取验证码类型 0:注册 1：忘记密码/2：登录

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public Integer getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(Integer isVerify) {
		this.isVerify = isVerify;
	}

	public String getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(String verifyTime) {
		this.verifyTime = verifyTime;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
	    this.type = type;
	  }
}