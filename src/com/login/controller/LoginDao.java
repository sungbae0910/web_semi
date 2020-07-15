package com.login.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import bean.DBConn;


public class LoginDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int cnt;
	
	public LoginDao() {
		conn = DBConn.getConn();
	}
	
	public LoginVo login(String email, String pwd) {
		LoginVo vo = new LoginVo();
		try {
			sql = "select email, nName from membership where email=? and pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setEmail(rs.getString("email"));
				vo.setnName(rs.getString("nName"));
				vo.setFlag(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return vo;			
		}
	}
	
	public String emailCheck(String email_c) {
		String email = null;
		try {
			sql = "select email from membership where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email_c);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				email = rs.getString("email");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return email;
		}
	}
	
	public String nNameCheck(String nName_c) {
		String nName = null;
		try {
			sql = "select nName from membership where nName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nName_c);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				nName = rs.getString("nName");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return nName;			
		}
	}
	public boolean membership(LoginVo vo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag = false;
		try {
			sql = "insert into membership(mNo, email, pwd, phone, nName, birth) values(seq_membership_mNo.nextval, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getEmail());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getnName());
			ps.setString(5, sdf.format(vo.getBirth()));
			cnt = ps.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
				flag = true;
			}else {
				conn.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
	}
	
	public boolean pwReset(String email, String pwd) {
		boolean flag = false;
		try {
			sql = "update membership set pwd=? where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, email);
			cnt = ps.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
				flag = true;
			}else {
				conn.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;			
		}
	}
	
}