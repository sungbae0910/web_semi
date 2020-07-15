package com.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.controller.LoginDao;
import com.login.controller.LoginVo;

public class Login{
	
	public boolean login(HttpServletRequest req, HttpServletResponse resp) {
		LoginDao dao = new LoginDao();

		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		LoginVo vo = dao.login(email, pwd);
		
		req.getSession().setAttribute("email", vo.getEmail());
		req.getSession().setAttribute("nName", vo.getnName());
		boolean flag = vo.isFlag();
		return flag;
	}
	
}
