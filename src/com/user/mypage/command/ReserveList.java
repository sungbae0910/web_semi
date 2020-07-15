package com.user.mypage.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.contoroller.MpDao;
import com.user.mypage.contoroller.ReListVo;

public class ReserveList implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String eMail = req.getParameter("eMail");
		MpDao dao = new MpDao();
		List<ReListVo> list = dao.reList(eMail);
		
		req.setAttribute("list", list);
	}
}
