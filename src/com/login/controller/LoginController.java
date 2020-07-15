package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.command.Login;
import com.login.command.MsendEmail;
import com.login.command.PwEncrypt;
import com.login.command.PwSendEmail;

@WebServlet("*.lg")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		all(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		all(req, resp);
	}
	
	private void all(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String path = null;		
		boolean flag = false;
		LoginDao dao = new LoginDao();
		PrintWriter out = resp.getWriter(); //ajax페이지로 값 보낼 때.
		
		String url = req.getRequestURI();
		int pos = url.lastIndexOf("/");
		String tempUrl = url.substring(pos);
		
		switch(tempUrl) {
		case "/login.lg" : //로그인
			String email = req.getParameter("email");
			PwEncrypt encrypt = new PwEncrypt();
			String pwd = encrypt.encrypt(req.getParameter("pwd"));
			LoginVo vo = dao.login(email, pwd);
			
			if(vo.isFlag()) {//로그인 성공하면 세션에 저장.
				req.getSession().setAttribute("email", vo.getEmail());
				req.getSession().setAttribute("nName", vo.getnName());
			}
			out.print(vo.isFlag());
			out.flush();
			return;
		case "/emailCk.lg" : //가입된 이메일인지 확인
			String email_c = req.getParameter("email");
			email = dao.emailCheck(email_c);
			out.print(email);
			out.flush();
			return;
		case "/emailS.lg" : //회원가입 email전송
			String toEmail = req.getParameter("email");
			MsendEmail mse = new MsendEmail();
			String num = mse.send(toEmail);
			out.print(num);
			out.flush();
			return;
		case "/nNameCk.lg" : //닉네임 중복체크
			String nName_c = req.getParameter("nName");
			String nName = dao.nNameCheck(nName_c);
			out.print(nName);
			out.flush();
			return;
		case "/member.lg" : //회원가입
			vo = new LoginVo();
			//비밀번호 암호화
			encrypt = new PwEncrypt();
			String pwd_c = req.getParameter("pwd_c");
			pwd = encrypt.encrypt(pwd_c);
			try {
				vo.setEmail(req.getParameter("email_c"));
				vo.setBirth(sdf.parse(req.getParameter("birth_c")));
				vo.setPwd(pwd);
				vo.setPhone(req.getParameter("phone_c"));
				vo.setnName(req.getParameter("nName_c"));				
			} catch (ParseException e) { e.printStackTrace();}
			flag =  dao.membership(vo);
			req.getSession().setAttribute("email", vo.getEmail());
			req.getSession().setAttribute("nName", vo.getnName());
			if(flag) {
					path = "../index.jsp";
					break;
			}else {
				out.print(flag);
				out.flush();
				return;
			}
		case "/pwResetMail.lg" : //비밀번호 재설정 메일
			toEmail = req.getParameter("email");
			PwSendEmail pwMail = new PwSendEmail();
			flag = pwMail.send(toEmail);
			out.print(flag);
			out.flush();
			return;
		case "/pwReset.lg" : //비밀번호 재설정
			encrypt = new PwEncrypt();
			pwd = encrypt.encrypt(req.getParameter("pwd"));
			email = req.getParameter("email");
			flag = dao.pwReset(email, pwd);
			out.print(flag);
			out.flush();
			return;
		case "/naver.lg" : //네이버 로그인 DB확인(회원정보가 있는지)
			email_c = req.getParameter("email");
			nName_c = req.getParameter("nName");
			email = dao.emailCheck(email_c);
			if(email != null) {
				req.getSession().setAttribute("email", email_c);
				req.getSession().setAttribute("nName", nName_c);
			}
			out.print(email);
			out.flush();
			return;
		}
		resp.sendRedirect(path);
	}
}
