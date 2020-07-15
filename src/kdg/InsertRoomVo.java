package kdg;

public class InsertRoomVo {
	int rCode;//숙소 코드
	String roomName;//방이름
	int rMaxPeople;//수용 가능인원
	int price;//가격
	
	int tv;//TV
	int wifi;//WIFI
	int shower;//샤워실
	int aircon;//에어컨
	int spa;//스파
	int tub;//욕조
	int computer;//컴퓨터
	int iron;//다리미
	int refr;//냉장고
	int socket;//개인콘센트
	
	int bed;//베드타입
	
	String OriFile;//방사진
	String SysFile;
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getrMaxPeople() {
		return rMaxPeople;
	}
	public void setrMaxPeople(int rMaxPeople) {
		this.rMaxPeople = rMaxPeople;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getShower() {
		return shower;
	}
	public void setShower(int shower) {
		this.shower = shower;
	}
	public int getAircon() {
		return aircon;
	}
	public void setAircon(int aircon) {
		this.aircon = aircon;
	}
	public int getSpa() {
		return spa;
	}
	public void setSpa(int spa) {
		this.spa = spa;
	}
	public int getTub() {
		return tub;
	}
	public void setTub(int tub) {
		this.tub = tub;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getIron() {
		return iron;
	}
	public void setIron(int iron) {
		this.iron = iron;
	}
	public int getRefr() {
		return refr;
	}
	public void setRefr(int refr) {
		this.refr = refr;
	}
	public int getSocket() {
		return socket;
	}
	public void setSocket(int socket) {
		this.socket = socket;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
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
	
	
	
}
