package com.user.mypage.contoroller;

import java.util.Date;

public class ResVo {
	int rNo;
	String rName;
	String rPhone;
	int rCode;
	Date rDate;
	int period;
	String payment;
	int price;
	
	public ResVo() {};
	public ResVo(int rNo, String rName, String rPhone, int rCode, Date rDate, int period, String payment, int price) {
		this.rNo=rNo;
		this.rName=rName;
		this.rPhone=rPhone;
		this.rCode=rCode;
		this.rDate=rDate;
		this.period=period;
		this.payment=payment;
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
	public String getrPhone() {
		return rPhone;
	}
	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
