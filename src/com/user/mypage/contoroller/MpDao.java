package com.user.mypage.contoroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DBConn;

import java.sql.PreparedStatement;

public class MpDao {
	Connection conn;
	public MpDao() {
		conn = DBConn.getConn();
	}
	
	public MpVo mpView(String email) {
		PreparedStatement pstmt = null;
		ResultSet set = null;
		MpVo vo = null;
		String query = "select * from membership where email=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				vo = new MpVo();
				vo.setmNo(set.getInt("mno"));
				vo.seteMail(set.getString("email"));
				vo.setPwd(set.getString("pwd"));
				vo.setPhone(set.getString("phone"));
				vo.setnName(set.getString("nname"));
				vo.setBirth(set.getDate("birth"));
				vo.setmAdmin(set.getInt("madmin"));
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
	
	public List<ReListVo> reList(String eMail) {
		String query = "select b.rno, a.rcode, a.rname, a.rplace, a.ginfo, a.orifile, a.sysfile, a.address, b.price from rooms a join reserve b on a.rcode=b.rcode where b.email=?";
		PreparedStatement pstmt = null;
		ResultSet set = null;
		ReListVo vo = null;
		List<ReListVo> list = new ArrayList<ReListVo>();
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, eMail);
			set=pstmt.executeQuery();
			
			while(set.next()){
				vo = new ReListVo();
				vo.setrNo(set.getInt("rno"));
				vo.setrCode(set.getInt("rcode"));
				vo.setrName(set.getString("rname"));
				vo.setrPlace(set.getString("rplace"));
				vo.setgInfo(set.getString("ginfo"));
				vo.setOriFile(set.getString("orifile"));
				vo.setSysFile(set.getString("sysfile"));
				vo.setAddress(set.getString("address"));
				vo.setPrice(set.getInt("price"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return list;
	}
	
	
	public ResVo resView(String rCode) {
		PreparedStatement pstmt = null;
		ResultSet set = null;
		ResVo vo = null;
		String query = "select * from reserve where rCode=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rCode);
			set=pstmt.executeQuery();
			
			if(set.next()) {
				vo = new ResVo();
				vo.setrNo(set.getInt("rno"));
				vo.setrName(set.getString("rname"));
				vo.setrPhone(set.getString("rphone"));
				vo.setrCode(set.getInt("rcode"));
				vo.setrDate(set.getDate("rDate"));
				vo.setPeriod(set.getInt("period"));
				vo.setPayment(set.getString("payment"));
				vo.setPrice(set.getInt("price"));
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
	
	public List<LogVo> lastPlaceView(String eMail){
		List<LogVo> list = new ArrayList<LogVo>();
		LogVo vo = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select a.logno, a.rcode, a.email, a.logDate,  a.price, b.rName, b.rPlace, b.sysFile from a_log a join rooms b on a.rCode=b.rCode where eMail=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eMail);
			set = pstmt.executeQuery();
			
			while(set.next()) {
				vo = new LogVo();
				vo.setLogNo(set.getInt("logno"));
				vo.setrCode(set.getInt("rcode"));
				vo.seteMail(set.getString("email"));
				vo.setLogDate(set.getDate("logDate"));
				vo.setrName(set.getString("rName"));
				vo.setrPlace(set.getString("rPlace"));
				vo.setSysFile(set.getString("sysFile"));
				vo.setPrice(set.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try { set.close();} catch (Exception e2) {e2.printStackTrace();}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
		return list;
	}
	
	public void mpUpdate(String nName, String phone, String eMail) {
		PreparedStatement pstmt = null;
		String query= "update membership set nName=?, phone=? where eMail=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nName);
			pstmt.setString(2, phone);
			pstmt.setString(3, eMail);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
	public void mpSecession(String eMail) {
		PreparedStatement pstmt = null;
		String query = "delete from membership where email=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eMail);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try { conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
}
