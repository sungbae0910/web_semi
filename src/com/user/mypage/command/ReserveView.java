package com.user.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.contoroller.MpDao;
import com.user.mypage.contoroller.ResVo;

public class ReserveView implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String rCode = req.getParameter("rCode");
		
		MpDao dao = new MpDao();
		ResVo vo = dao.resView(rCode);
		
		req.setAttribute("resView", vo);
	}

}
