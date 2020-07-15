package com.user.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.contoroller.MpDao;

public class MpSecession implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String eMail = req.getParameter("eMail");
		
		MpDao dao = new MpDao();
		dao.mpSecession(eMail);
	}

}
