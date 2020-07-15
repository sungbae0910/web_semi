package com.login.controller;

import java.util.Date;

public class LoginVo {
	int mNo;
	int mAdmin;
	String email;
	Date birth;
	String pwd;
	String phone;
	String nName;
	boolean flag = false;
	
	public LoginVo() {}
	public LoginVo(String email, Date birth, String pwd, String phone, String nName) {
		this.email = email;
		this.birth = birth;
		this.pwd = pwd;
		this.phone = phone;
		this.nName = nName;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public int getmAdmin() {
		return mAdmin;
	}
	public void setmAdmin(int mAdmin) {
		this.mAdmin = mAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
