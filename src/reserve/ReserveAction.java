package reserve;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReserveAction {
	ReserveDao dao;
	
	ReserveAction() {
		dao = new ReserveDao();
	}
	
	void connClose() {
		try {
			dao.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 예약 추가
	String rsInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		boolean flag = false;
		
		// reserve.jsp에서 파라미터값 받아오기
		// 많은 데이터를 받아와야함..ㅎ
		String rCode = req.getParameter("rCode"); // 숙소 코드
		String roomCode = req.getParameter("roomCode"); // 객실 코드
		String email = req.getParameter("email"); // 로그인 아이디
		String rName = req.getParameter("rName");
		String roomName = req.getParameter("roomName");
		String price = req.getParameter("price");
		
		String rsName = req.getParameter("reserve_name_k"); // 예약자 이름
		String rPhone = req.getParameter("reserve_Phone_k"); // 예약자 번호
		String payment = req.getParameter("paySelect_k"); // 지불방식
		// 체크인, 체크아웃 날짜
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");
		// 체크아웃 날짜 - 체크인 날짜
		String period = req.getParameter("period");
		// 결제 가격
		//int price = 1;
		
		System.out.println("rCode : " + rCode);
		System.out.println("roomCode : " + roomCode);
		System.out.println("email : " + email);
		System.out.println("rName : " + rName);
		System.out.println("roomName : " + roomName);
		System.out.println("rsName : " + rsName);
		System.out.println("rPhone : " + rPhone);
		System.out.println("payment : " + payment);
		System.out.println("checkIn : " + checkIn);
		System.out.println("checkOut : " + checkOut);
		System.out.println("period : " + period);
		System.out.println("price : " + price);
		
		// 파타미터 값 vo에 저장
		ReserveVo vo = new ReserveVo();
		vo.setrCode(rCode);
		vo.setRoomCode(roomCode);
		vo.setEmail(email);
		vo.setrName(rName);
		vo.setRoomName(roomName);
		vo.setRsName(rsName);
		vo.setrPhone(rPhone);
		vo.setPayment(payment);
		vo.setCheckIn(checkIn);
		vo.setCheckOut(checkOut);
		vo.diffDay(); // 기간 계산
		vo.setPrice(price);
		
		// 데이터베이스에 insert
		flag = dao.insert(vo);
		if(flag) { // insert 성공!
			msg = "정상 예약되었습니다.";
		} else { // insert 실패!
			msg = "예약 중 오류가 발생했습니다.\n고객센터에 문의해주세요.";
		}
		return msg;
	}
	// 예약 삭제
	String rsDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		boolean flag = false;
		// reserve_modify.jsp에서 파라미터값 받아오기
		// 예약번호, 숙소번호, 객실번호, 로그인 아이디 가져오면 됨!!
		String rNo = req.getParameter("rNo");
//		String rCode = req.getParameter("rCode"); // 숙소 코드
//		String roomCode = req.getParameter("roomCode"); // 객실 코드
		String email = req.getParameter("email"); // 로그인 아이디
	
		System.out.println("rNo : " + rNo);
//		System.out.println("rCode : " + rCode);
//		System.out.println("roomCode : " + roomCode);
		System.out.println("email : " + email);
		
		// 데이터베이스에서 delete
		flag = dao.delete(rNo, email);
		if(flag) { // insert 성공!
			msg = "정상 취소되었습니다.";
		} else { // insert 실패!
			msg = "취소 중 오류가 발생했습니다.\n고객센터에 문의해주세요.";
		}
		return msg;
	}
	// 예약 내역 상세보기
	ReserveVo rsSelect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReserveVo vo = null;
		
		String rNo = req.getParameter("rNo");
		
		System.out.println("rNo : " + rNo);
		
		// DB에서 select
		vo = dao.view(rNo);
		
		return vo;
	}
	// 숙소 및 객실 내역 보기
	ReserveVo roomSelect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReserveVo vo = null;
		
		String rCode = req.getParameter("rCode"); // 숙소 코드
		String roomCode = req.getParameter("roomCode"); // 객실 코드
		String checkIn = req.getParameter("checkIn_w");
		String checkOut = req.getParameter("checkOut_w");
		HttpSession httpSession = req.getSession(true);
		String userID = httpSession.getAttribute("email") + "";
		
		System.out.println("userID : " + userID);
		System.out.println("rCode : " + rCode);
		System.out.println("roomCode : " + roomCode);
		System.out.println("checkIn : " + checkIn);
		System.out.println("checkOut : " + checkOut);
		// DB에서 select
		vo = dao.roomView(rCode, roomCode, checkIn, checkOut);
		String phone = dao.searchPhone(userID);
		
		vo.setPhone(phone); // 폰 번호 저장
		vo.diffDay(); // 기간 계산
		
		return vo;
	}
}
