package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVo_m {
	int nno;
	String title;
	String rDate;
	String memo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String pattern = "{'nno' : '%s', 'title' : '%s', 'rDate' : '%s', 'memo' : '%s'}";

	public MemberVo_m() {}
	public MemberVo_m(int nno, String title, String memo) {
		this.nno = nno;
		this.title = title;
		this.memo = memo;
	}
	public MemberVo_m(String title, String memo) {
		this.title = title;
		this.memo = memo;
	}
	public MemberVo_m(int nno, String title, String d, String memo) {
		this.nno = nno;
		this.title = title;
		this.rDate = d;
		this.memo = memo;
	}
	
	/*public String toString() {
		//String d = sdf.format(rDate);
		String str = String.format("%10s\t%15s\t%15s\t%4d\n", nno, title, d, memo);
		return str;
	}*/
	
	public String toJSON() {
		String d = sdf.format(rDate);
		String json = String.format(pattern, nno, title, d, memo);
		json = json.replaceAll("\'", "\"");
		return json;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}