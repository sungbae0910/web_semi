package com.user.mypage.contoroller;

public class ReListVo {
	int rNo;
	int rCode;
	String rName;
	String rPlace;
	String gInfo;
	String oriFile;
	String sysFile;
	String address;
	int price;
	
	public ReListVo(){};
	public ReListVo(int rNo, int rCode, String rName, String rPlace, String gInfo, String oriFile, String sysFile, String address, int price){
		this.rNo = rNo;
		this.rCode=rCode;
		this.rName=rName;
		this.rPlace=rPlace;
		this.gInfo=gInfo;
		this.oriFile=oriFile;
		this.sysFile=sysFile;
		this.address=address;
		this.price=price;
	}
	
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
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

	public String getgInfo() {
		return gInfo;
	}

	public void setgInfo(String gInfo) {
		this.gInfo = gInfo;
	}

	public String getOriFile() {
		return oriFile;
	}

	public void setOriFile(String oriFile) {
		this.oriFile = oriFile;
	}

	public String getSysFile() {
		return sysFile;
	}

	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

