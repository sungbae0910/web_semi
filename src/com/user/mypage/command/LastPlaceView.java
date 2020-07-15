package com.user.mypage.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.mypage.contoroller.LogVo;
import com.user.mypage.contoroller.MpDao;

public class LastPlaceView implements MpCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String eMail = req.getParameter("eMail");
		MpDao dao = new MpDao();
		List<LogVo> list = dao.lastPlaceView(eMail);
		
		
		req.setAttribute("list", list);
	}

}
