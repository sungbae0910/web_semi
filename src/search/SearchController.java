package search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.se")
public class SearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Search_doGet");
		doAction_Get(req, resp);
	}
	
	protected void doAction_Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8"); // 응답 인코딩 설정(한글깨짐 방지)
		SearchDao dao = new SearchDao();
		PrintWriter out = resp.getWriter();
		
		String data = ""; // 반환해줄 데이터

		// 요청받은 url 확인
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		System.out.println(tempUrl);
		
		String findStr = req.getParameter("findStr");
		System.out.println("findStr : " + findStr);
		
		String rCode = req.getParameter("rCode");
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");
		System.out.println("rCode : " + rCode);
		System.out.println("checkIn : " + checkIn);
		System.out.println("checkOut : " + checkOut);
		
		if(tempUrl.equals("/search.se")) {
			data = dao.search(findStr);
		}
		if(tempUrl.equals("/rsSearch.se")) {
			data = dao.rsSearch(rCode, checkIn, checkOut);
		}
		switch(tempUrl) {
		case "/search.se":
			data = dao.search(findStr);
			break;
		case "/rsSearch.se":
			data = dao.rsSearch(rCode, checkIn, checkOut);
			break;
		case "/ntSearch.se":
			data = dao.ntSearch();
			break;
		}

		System.out.println("data : " + data);
		try {
			dao.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(data);
		out.flush();
	}
}
