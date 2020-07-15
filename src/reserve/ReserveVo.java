package reserve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReserveVo {
	SimpleDateFormat sdf = new SimpleDateFormat("MM.dd E hh:mm");
	int rNo; // 예약 번호
	String rsName; // 예약자 이름
	String rPhone; // 예약자 번호
	int rCode; // 숙소 코드
	int roomCode; // 객실 코드
	String rName; // 숙소 이름
	String roomName; // 객실 이름
	int period; // 숙박 기간
	String payment; // 결제 수단(1:신용카드, 2:페이)
	int price; // 결제 가격
	String email; // 유저 아이디
	String checkIn; // 체크인 시간
	String checkOut; // 체크아웃 시간
	String phone; // 휴대폰 번호
	
	String toJSON() {
		String json = "";
		String temp = "{"
					+ "\"rName\":" + rName
					+ ",\"roomName\":" + roomName
					+ ",\"price\":" + price
					+ ",\"checkIn\":" + checkIn
					+ ",\"checkOut\":" + checkOut
					+ "}";
		json = "[" + temp + "]";
		return json;
	}
	
	void diffDay() {
		double diffDay = 0;
		if(checkIn != null && checkOut != null) {
			try {
				Date startDate = sdf.parse(checkIn);
				Date endDate = sdf.parse(checkOut);
				
				long diff = endDate.getTime() - startDate.getTime();
				System.out.println("diff : " + diff);
				diffDay = Math.ceil(diff / (double)(24*60*60*1000));		
				System.out.println("diffDay : " + diffDay);
				this.period = (int) diffDay;
				// 지내는 기간에 따라 가격 변동
				this.price *= this.period;
			} catch (ParseException e) {
				System.out.println("기간 계산 시 오류 발생");
				e.printStackTrace();
			}
		}
	}
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = Integer.parseInt(rNo);
	}
	public String getRsName() {
		return rsName;
	}
	public void setRsName(String rsName) {
		this.rsName = rsName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = Integer.parseInt(roomCode);
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
	public void setrCode(String rCode) {
		this.rCode = Integer.parseInt(rCode);
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public void setPeriod(String period) {
		this.period = Integer.parseInt(period);
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
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = sdf.format(checkIn);
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = sdf.format(checkOut);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
