package reserve;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("*.rs")
public class ReserveController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doAction_Get(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doAction_Post(req, resp);
	}
	
	
	protected void doAction_Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "./index.jsp?middle=";
		String subPath = "";
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8"); // 응답 인코딩 설정(한글깨짐 방지)
		ReserveVo vo = new ReserveVo(); // DB select
		PrintWriter out = resp.getWriter();
		
		// 요청받은 url 확인
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		System.out.println(tempUrl);
		
		ReserveAction ra = new ReserveAction();
/*		Map<String, String[]> param = req.getParameterMap();
		System.out.println(param.get("reserve_name_k")[0]);*/
		switch(tempUrl) {
		case "/rsView.rs":
			// 예약 현황 테이블에서 데이터 가져오기
			subPath = "./user/u_subtitle.jsp&inc2=../reserve/reserve_modify.jsp";
			vo = ra.rsSelect(req, resp);
			break;
		case "/rsRoom.rs":
			// 예약 시, 룸 정보 가져오기
			subPath = "./reserve/reserve.jsp";
			vo = ra.roomSelect(req, resp);
			break;
		}
		
		req.setAttribute("vo", vo);
		ra.connClose();
		
//		resp.sendRedirect("./index.jsp?middle=./user/u_subtitle.jsp&inc2=../reserve/reserve_modify.jsp");
		RequestDispatcher dis = req.getRequestDispatcher(path + subPath);
		dis.forward(req, resp);
		
		/*String json = vo.toJSON();
		System.out.println(json);*/
		// 데이터 반환
		/*out.print(json);
		out.flush();*/
	}
	
	protected void doAction_Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8"); // 응답 인코딩 설정(한글깨짐 방지)
		PrintWriter out = resp.getWriter(); // ajax 데이터 반환시 사용
		String msg = null; // 예약 or 예약 취소할 때, 성공 or 실패 메세지 반환
		
		// 요청받은 url 확인
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		System.out.println(tempUrl);
		
		ReserveAction ra = new ReserveAction();
/*		Map<String, String[]> param = req.getParameterMap();
		System.out.println(param.get("reserve_name_k")[0]);*/
		switch(tempUrl) {
		case "/rsInsert.rs":
			// 예약 현황 테이블에 데이터 추가
			msg = ra.rsInsert(req, resp);
			break;
		case "/rsDelete.rs":
			// 예약 현황 테이블에서 데이터 제거
			msg = ra.rsDelete(req, resp);
			break;
		}
		
		ra.connClose();
		
		// 데이터 반환
		out.print(msg);
		out.flush();
	}
}
