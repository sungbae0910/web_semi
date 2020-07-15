package bean;

public class Page_m {
	int totListSize;//검색된 결과의 전체 건수
	int totPage;//만들어지 페이지수
	int listSize=10;//한페이지에 보이는 갯수, 갯수를 지정하지 않으면 가변적으로 볼수 있는 갯수를 만들수 있다
	int blockSize=5;//보여지는 블럭 페이지 갯수
	int nowPage=1;//현재 페이지에서 보이는 페이지. url로 page정보가 없을 때 1이 나옴
	int startNo;//
	int endNo;
	int startPage;//시작블럭(페이지 갯수)
	int endPage;//blockSize의 마지막 블럭(페이지 갯수)
	String findStr ="";//url로 page정보가 없을 때 검색어는 없음.
	
	public Page_m(){}
	
	public Page_m(int tot, int now) {
		this.totListSize = tot;
		this.nowPage = now;
		pageCompute();
	}
	
	
	public void pageCompute() {
		totPage = (int)Math.ceil(totListSize/(double)listSize);//전체 건수 나누기 한페이지 건수를 실수로 받아 ceil(절상)함.
		endNo = nowPage * listSize;//마지막 페이지를 구하기
		startNo = endNo-listSize+1;//첫페이지 구하기
		
		if(endNo>totListSize) endNo = totListSize;//마지막 건수가 최종건수보다 크면 마지막건수만 표시되게함
		
		endPage=(int)Math.ceil(nowPage/(double)blockSize) * blockSize;//블럭에 들어가는 페이지 갯수구하는 방법
		startPage= endPage-blockSize+1;//첫블럭 보이기
		
		if(endPage>totPage) endPage = totPage;//마지막 블럭이 최종블럭보다 클때 마지막 블럭만 보에게 함.
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotListSize() {
		return totListSize;
	}

	public void setTotListSize(int totListSize) {
		this.totListSize = totListSize;
	}

	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public String getFindStr() {
		return findStr;
	}
	public void setFindStr(String findStr) {
		this.findStr = findStr;
	}
	
}