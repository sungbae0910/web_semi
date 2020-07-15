package reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.DBConn;


public class ReserveDao {
	Connection conn;
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	
	public ReserveDao() {
		conn = DBConn.getConn();
	}
	
	void connClose() {
		try {
			ps.close();
			if(rs != null) {
				rs.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 디비에 데이터 추가
	protected boolean insert(ReserveVo vo) {
		boolean result = false;
		
		try {			
			sql = "insert into reserve(rNo, rsName, rPhone, rCode, roomCode, rdate, period, payment, price, email, checkin, checkout, rName, roomName) "
				+ " values(SEQ_RESERVE_RNO.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, to_date(?, 'mm.dd dy hh24:mi'), to_date(?, 'mm.dd dy hh24:mi'), ?, ?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRsName());
			ps.setString(2, vo.getrPhone());
			ps.setInt(3, vo.getrCode());
			ps.setInt(4, vo.getRoomCode());
			ps.setInt(5, vo.getPeriod());
			ps.setString(6, vo.getPayment());
			ps.setInt(7, vo.getPrice());
			ps.setString(8, vo.getEmail());
			ps.setString(9, vo.getCheckIn());
			ps.setString(10, vo.getCheckOut());
			ps.setString(11, vo.getrName());
			ps.setString(12, vo.getRoomName());
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) { // insert 성공
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("insert중 오류 발생");
			e.printStackTrace();
		} finally {
			connClose();
		}
		return result;
	}
	// 디비에 데이터 삭제
	protected boolean delete(String rNo, String email) {
		boolean result = false;
		
		try {
			sql = "delete from reserve "
				+ " where rNo = ? and email = ? ";// and roomCode = ? and rCode = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rNo);
			ps.setString(2, email);
			/*ps.setInt(3, roomCode);
			ps.setString(4, email);*/
			
			int cnt = ps.executeUpdate();
			if(cnt > 0) { // delete 성공
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("delete 중 오류 발생");
			e.printStackTrace();
		} finally {
			connClose();
		}
		return result;
	}
	// 디비에서 선택한 숙소의 선택한 객실 정보 가져오기
	protected ReserveVo roomView(String rCode, String roomCode, String checkIn, String checkOut) {
		ReserveVo vo = null;
		
		try {
			sql = "select a.rName c, to_char(a.checkin, 'HH24:MI') d, to_char(a.checkout, 'HH24:MI') e, b.roomName f, b.price g, a.rCode h, b.roomCode i"
				+ " from rooms a join room b "
				+ " on a.rCode = b.rCode "
				+ " where a.rCode = ? and b.roomCode = ?"; // a.rCode 없어도됨
			ps = conn.prepareStatement(sql);
			ps.setString(1, rCode);
			ps.setString(2, roomCode);
			
			rs = ps.executeQuery();
			if(rs.next()) { // select 결과
				vo = new ReserveVo();
				vo.setrCode(rCode);
				vo.setRoomCode(roomCode);
				vo.setrName(rs.getString("c"));
				vo.setCheckIn(checkIn + " " + rs.getString("d"));
				vo.setCheckOut(checkOut + " " + rs.getString("e"));
				vo.setRoomName(rs.getString("f"));
				vo.setPrice(rs.getInt("g"));
			}
		} catch (SQLException e) {
			System.out.println("숙소 정보 select 중 오류 발생");
			e.printStackTrace();
		} finally {
			connClose();
		}
		return vo;
	}
	// 디비에서 로그인 중인 유저의 예약 정보 한개 가져오기
	protected ReserveVo view(String rNo) {
		ReserveVo vo = null;
		
		try {
			sql = "select rName a, roomName b, period c, to_char(checkin, 'mm.dd dy hh24:mi') d, to_char(checkout, 'mm.dd dy hh24:mi') e, rNo f, rsName g, rPhone h, price i "
				+ " from reserve "
				+ " where rNo = ?";
/*			sql = "select rName a, period c, to_char(checkin, 'mm.dd dy hh24:mi') d, to_char(checkout, 'mm.dd dy hh24:mi') e, rNo f, rPhone h, price i "
					+ " from reserve "
					+ " where rNo = ?";*/
			ps = conn.prepareStatement(sql);
			ps.setString(1, rNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new ReserveVo();
				vo.setrName(rs.getString("a"));
				vo.setRoomName(rs.getString("b"));
				vo.setPeriod(rs.getInt("c"));
				vo.setCheckIn(rs.getString("d"));
				vo.setCheckOut(rs.getString("e"));
				vo.setrNo(rs.getInt("f"));
				vo.setRsName(rs.getString("g"));
				vo.setrPhone(rs.getString("h"));
				vo.setPrice(rs.getInt("i"));
			}
		} catch (SQLException e) {
			System.out.println("예약 정보 select 중 오류 발생");
			e.printStackTrace();
		} finally {
			connClose();
		}
		return vo;
	}
	
	protected String searchPhone(String email) {
		String phone = "";
		
		try {
			sql = "select phone from membership where email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				phone = rs.getString("phone");
			}
		} catch (SQLException e) {
			System.out.println("휴대폰 번호 가져오는 중 오류 발생");
			e.printStackTrace();
		} finally {
			connClose();
		}
		
		return phone;
	}
}
