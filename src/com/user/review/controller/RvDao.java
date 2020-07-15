package com.user.review.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bean.DBConn;


public class RvDao {
	Connection conn;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public RvDao() {
		conn = DBConn.getConn();
	}
	
	public void rvWrite(int rCode, String eMail, String rContent, int star, String title) {
		PreparedStatement pstmt = null;
		ResultSet set = null;
		int cnt = 0;
		int sum = 0;
		double re = 0;
		String query = "insert into review values(seq_review_rno.nextval,?, ?, ?, sysdate,(select nvl(max(rGroup)+1,1)from review),0,0,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCode);
			pstmt.setString(2, eMail);
			pstmt.setString(3, rContent);
			pstmt.setInt(4, star);
			pstmt.setString(5, title);
			re = pstmt.executeUpdate();
			
			starCh(rCode);
			/*query="select count(stars) cnt, sum(stars) sum from review where rIndent=0";
			pstmt = conn.prepareStatement(query);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				cnt = set.getInt("cnt");
				sum = set.getInt("sum");
			}

			re = sum/(double)cnt;
			System.out.println(re);
			query = "update rooms set stars=? where rCode = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, re);
			pstmt.setInt(2, rCode);
			pstmt.executeUpdate();*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
	public List<RvVo> rvSelect(int rCode) {
		List<RvVo> list = new ArrayList<RvVo>();
		int reply=0;
		RvVo vo = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from review where rCode=? order by rGroup desc, rStep asc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCode);
			set = pstmt.executeQuery();
			
			while(set.next()) {
				vo = new RvVo();
				vo.setrNo(set.getInt("rno"));
				vo.setrCode(set.getInt("rcode"));
				vo.seteMail(set.getString("eMail"));
				vo.setrContent(set.getString("rcontent"));
				vo.setrDate(sdf.format(set.getDate("rdate")));
				vo.setrGroup(set.getInt("rgroup"));
				vo.setrStep(set.getInt("rstep"));
				vo.setrIndent(set.getInt("rindent"));
				vo.setStars(set.getInt("stars"));
				vo.setTitle(set.getString("rtitle"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		
		return list;
	}
	
	public RvVo rvMoView(int rNo) {
		RvVo vo = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from review where rNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				vo = new RvVo();
				vo.setrNo(set.getInt("rNo"));
				vo.setrCode(set.getInt("rCode"));
				vo.seteMail(set.getString("eMail"));
				vo.setrContent(set.getString("rContent"));
				vo.setrDate(sdf.format(set.getDate("rDate")));
				vo.setrGroup(set.getInt("rgroup"));
				vo.setrStep(set.getInt("rStep"));
				vo.setrIndent(set.getInt("rIndent"));
				vo.setStars(set.getInt("stars"));
				vo.setTitle(set.getString("rtitle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return vo;
	}
	
	public void rvModify(String content, int stars, String title, int rNo, int rCode) {
		PreparedStatement pstmt = null;
		String query = "update review set rcontent=?, rdate=sysdate, stars=?, rTitle=? where rno=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setInt(2, stars);
			pstmt.setString(3, title);
			pstmt.setInt(4, rNo);
			pstmt.executeUpdate();
			
			starCh(rCode);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
	public void rvReply(int rCode, String eMail, String title, String content, int rGroup, int rStep, int rIndent) {
		PreparedStatement pstmt = null;
		String query = "insert into review values(seq_review_rno.nextval, ?, ?, ?, sysdate, ?, ?, ?, 0, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCode);
			pstmt.setString(2, eMail);
			pstmt.setString(3, content);
			pstmt.setInt(4, rGroup);
			pstmt.setInt(5, rStep+1);
			pstmt.setInt(6, rIndent+1);
			pstmt.setString(7, title);
			
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
	public void rvDelete(int rNo, int rGroup, int flag, int rCode) {
		PreparedStatement pstmt = null;
		String query = "";
		
		try { 
			if(flag==0) {
				query = "delete from review where rGroup=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rGroup);
			}else {
				query = "delete from review where rNo=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, rNo);
			}
			pstmt.executeUpdate();
			
			starCh(rCode);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
/*	public void replyShape(int rGroup, int rStep) {
		PreparedStatement pstmt = null;
		String query = "update review set rStep = rStep + 1 where rGroup =? and rStep > ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rGroup);
			pstmt.setInt(2, rStep);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	// ���� ���� ����� ���ؼ� rooms ���̺� stars�÷��� �ٲ��ֱ� ���� �޼ҵ� 
	public void starCh(int rCode) {
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "";
		int cnt = 0;
		int sum = 0;
		double re = 0;
		try {
			query="select count(stars) cnt, sum(stars) sum from review where rIndent=0";
			pstmt = conn.prepareStatement(query);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				cnt = set.getInt("cnt");
				sum = set.getInt("sum");
			}

			re = sum/(double)cnt;
			query = "update rooms set stars=? where rCode = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, re);
			pstmt.setInt(2, rCode);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
		if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
		
	}
	
	public int replyCnt(int rCode) {
		int reply = 0;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select count(*) cnt from review where rcode=? and rindent=1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCode);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				reply = set.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return reply;
	}
	
	public int rvCnt(int rCode) {
		int rvCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select count(*) cnt from review where rCode=? and rIndent=0";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCode);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				rvCnt = set.getInt("cnt");
			}
			System.out.println("왜안나오니:"+set);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return rvCnt;
	}
}
