package com.mk.bean;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

public class User {

	private Integer id;
	@NotEmpty(message="{NotEmpty.username}")
	@Length(min=6,message="用户名长度不能小于6位")
	private String usernamne;
	@Pattern(regexp="w(4,30)",message="{Pattern.realname}")
	private String realname;
	@NotEmpty(message="密码不能为空")
	@Pattern(regexp="S{6,30}",message="非空白字符6-30位")
	private String password;
	@DecimalMin(value="1000.00",message="金额必须是大于1000")
	@DecimalMax(value="100000.00",message="金额必须小于100000")
	@NumberFormat(pattern="#,##")
	private Float money;
	@NotEmpty(message="账户允许为空")
	private String account;
	@Past(message="日期必须是一个过去的日期")
	private Date createTime;
	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsernamne() {
		return usernamne;
	}

	public void setUsernamne(String usernamne) {
		this.usernamne = usernamne;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}
}
