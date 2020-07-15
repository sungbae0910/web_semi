package com.user.mypage.contoroller;

import java.util.Date;

public class MpVo {
	int mNo;
	String eMail;
	String pwd;
	String phone;
	String nName;
	Date birth;
	String uName;
	int mAdmin;
	
	public MpVo() {}
	public MpVo(int mNo, String eMail, String pwd, String phone, String nName, Date birth, String uName, int mAdmin) {
		this.mNo=mNo;
		this.eMail=eMail;
		this.pwd=pwd;
		this.phone=phone;
		this.nName=nName;
		this.birth=birth;
		this.uName=uName;
		this.mAdmin=mAdmin;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getmAdmin() {
		return mAdmin;
	}

	public void setmAdmin(int mAdmin) {
		this.mAdmin = mAdmin;
	}

	
}
