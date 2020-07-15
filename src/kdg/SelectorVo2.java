package kdg;

public class SelectorVo2 {
	String place ="";	//호옥시 지역 선택했니?
	int aType = 0;		//숙소타입
	int nowPage =1;		//페이징
	String target ="";	//보낼 페이지
	String sort ="";	//가격 정렬 뭘로할거니
	//라디오 버튼이 만약 null로 들어온다면 초기값을 5로할거다
	int kind = 5;		//호텔 타입?
	int maxPeople =0;	//최대인원?
	int bedtype =5;		//베드 타입?
	
	public SelectorVo2() {}
	public SelectorVo2(String place , int aType , int nowPage, String sort , int kind,int maxPeople,int bedtype) { 
		this.place = place;
		this.aType = aType;
		this.nowPage = nowPage;
		this.sort = sort;
		this.kind = kind;
		this.maxPeople = maxPeople;
		this.bedtype = bedtype;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getaType() {
		return aType;
	}
	public void setaType(int aType) {
		this.aType = aType;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getBedtype() {
		return bedtype;
	}
	public void setBedtype(int bedtype) {
		this.bedtype = bedtype;
	}
	
}
	