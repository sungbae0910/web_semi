package kdg;

import java.util.Date;
import java.util.List;


public class RoomsVo {
	int rCode;//����肄���
	String rName;//�����대�
	String rPlace;//援ъ�대�
	String gInfo;//��媛�
	String aType;//��������
	String OriFile;//�ъ� �대�
	String SysFile;//�ъ� 媛��몄�ㅺ린
	
	int stars;//蹂���
	Date checkin;//泥댄�ъ�몄��媛�
	Date checkout;//泥댄�ъ������媛�
	String address;//���몄＜怨�
	int kind;//�깃�,醫�瑜�
	
	int pet;//��臾쇰��諛�
	int smoke;//媛��ㅻ�� �≪��
	int noSmoke;//湲���
	int parking;//二쇱감
	int breakfast;//議곗��
	
	int pt;//�쇳�몃����
	int swim;//������
	int rest;//���ㅽ����
	int cafe;//移댄��
	int bar;//諛�
	
	int washer;//�명��湲�
	int lounge;//�쇱�댁�
	int kitchen;//二쇰갑
	int dryer;//嫄댁“湲�
	int talsu;//����湲�
	int price;
	int roomCode;
	int wifi;
	int bed;
	int tub;
	int tv;
	int spa;
	int computer;
	
	
	String roomName;
	
	String pori;
	String psys;
	String ceo;
	

	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
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
	public String getaType() {
		return aType;
	}
	public void setaType(String aType) {
		this.aType = aType;
	}
	public String getOriFile() {
		return OriFile;
	}
	public void setOriFile(String oriFile) {
		OriFile = oriFile;
	}
	public String getSysFile() {
		return SysFile;
	}
	public void setSysFile(String sysFile) {
		SysFile = sysFile;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getPet() {
		return pet;
	}
	public void setPet(int pet) {
		this.pet = pet;
	}
	public int getSmoke() {
		return smoke;
	}
	public void setSmoke(int smoke) {
		this.smoke = smoke;
	}
	public int getNoSmoke() {
		return noSmoke;
	}
	public void setNoSmoke(int noSmoke) {
		this.noSmoke = noSmoke;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public int getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public int getSwim() {
		return swim;
	}
	public void setSwim(int swim) {
		this.swim = swim;
	}
	public int getRest() {
		return rest;
	}
	public void setRest(int rest) {
		this.rest = rest;
	}
	public int getCafe() {
		return cafe;
	}
	public void setCafe(int cafe) {
		this.cafe = cafe;
	}
	public int getBar() {
		return bar;
	}
	public void setBar(int bar) {
		this.bar = bar;
	}
	public int getWasher() {
		return washer;
	}
	public void setWasher(int washer) {
		this.washer = washer;
	}
	public int getLounge() {
		return lounge;
	}
	public void setLounge(int lounge) {
		this.lounge = lounge;
	}
	public int getKitchen() {
		return kitchen;
	}
	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}
	public int getDryer() {
		return dryer;
	}
	public void setDryer(int dryer) {
		this.dryer = dryer;
	}
	public int getTalsu() {
		return talsu;
	}
	public void setTalsu(int talsu) {
		this.talsu = talsu;
	}
	public String getPori() {
		return pori;
	}
	public void setPori(String pori) {
		this.pori = pori;
	}
	public String getPsys() {
		return psys;
	}
	public void setPsys(String psys) {
		this.psys = psys;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	
	public int getTub() {
		return tub;
	}
	public void setTub(int tub) {
		this.tub = tub;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getSpa() {
		return spa;
	}
	public void setSpa(int spa) {
		this.spa = spa;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	
    

	
}
