package com.user.mypage.contoroller;

import java.util.Date;

public class LogVo {
	int logNo;
	int rCode;
	String eMail;
	Date logDate;
	String rName;
	String rPlace;
	String sysFile;
	int price;
	
	public LogVo() {};
	public LogVo(int logNo, int rCode, String eMail, Date logDate, String rName, String rPlace, String sysFile, int price) {
		this.logNo=logNo;
		this.rCode=rCode;
		this.eMail=eMail;
		this.logDate=logDate;
		this.rName=rName;
		this.rPlace=rPlace;
		this.sysFile=sysFile;
		this.price=price;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrPlace() {
		return rPlace;
	}
	public void setrPlace(String rPlace) {
		this.rPlace = rPlace;
	}
	public String getSysFile() {
		return sysFile;
	}
	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getLogNo() {
		return logNo;
	}
	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	
}
