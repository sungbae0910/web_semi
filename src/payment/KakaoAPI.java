package payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("*.kk")
public class KakaoAPI  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8"); // 응답 인코딩 설정(한글깨짐 방지)
		System.out.println("여긴 들어와?");
		
		String email = req.getParameter("email"); // 로그인 아이디
		String roomName = req.getParameter("roomName");
		String price = req.getParameter("price");
		
		System.out.println("email : " + email);
		System.out.println("roomName : " + roomName);
		System.out.println("price : " + price);
		
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST"); // POST 방식으로 요청
		conn.setRequestProperty("Authorization", "KakaoAK d2552e77546358d3e85bcf31fa9199ad"); 
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); 
		conn.setDoInput(true); 
		conn.setDoOutput(true); 
		
		Map<String, String> params = new HashMap<>();
		params.put("cid", "TC0ONETIME");
		params.put("partner_order_id", "jhta1907"); // 가맹점 ID
		params.put("partner_user_id", email); // 유저 ID
		params.put("item_name", roomName); // 상품이름
		params.put("quantity", "1"); // 상품 수량
		params.put("total_amount", price); // 상품 총 가격
		params.put("tax_free_amount", price); // 비과세 금액
/*		params.put("approval_url", "http://localhost:8888/semiProject/kakao/approval.jsp");
		params.put("cancel_url", "http://localhost:8888/semiProject/kakao/cancel.jsp");
		params.put("fail_url", "http://localhost:8888/semiProject/kakao/fail.jsp");*/
		params.put("approval_url", "http://192.168.0.27:8888/semiProject/kakao/approval.jsp");
		params.put("cancel_url", "http://192.168.0.27:8888/semiProject/kakao/cancel.jsp");
		params.put("fail_url", "http://192.168.0.27:8888/semiProject/kakao/fail.jsp");
		
		// param값 생성
		String string_params = new String();
		for(Map.Entry<String, String> elem : params.entrySet()) {
			string_params += (elem.getKey() + "=" + elem.getValue() + "&");
		}
		
		System.out.println("string_params : " + string_params );
		// 연결된 url에 파라미터 전달
		OutputStream out = conn.getOutputStream();
        out.write(string_params.getBytes("utf-8"));
        out.flush();
        out.close(); // POST 호출
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		System.out.println("in : " + in);
		String successUrl = null; // 준비 성공 시 연결할 url
		
		
        try { // 응답받은 json 파싱작업
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(in);
			
			successUrl = (String)obj.get("next_redirect_pc_url");
			System.out.println("successUrl : " + successUrl);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			in.close(); // 응답 스트림 닫기
		}
		
		PrintWriter out1 = resp.getWriter(); // ajax 데이터 반환시 사용
		out1.print(successUrl);
		out1.flush();
	}
	
}
