package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;

public class RvInsert implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rCode = Integer.parseInt(req.getParameter("rCode"));
		String title = req.getParameter("title");
		String eMail = req.getParameter("eMail");
		String rContent = req.getParameter("content");
		int star = Integer.parseInt(req.getParameter("star"));
		
		RvDao dao = new RvDao();
		
		dao.rvWrite(rCode, eMail, rContent, star, title);
		
	}
}
