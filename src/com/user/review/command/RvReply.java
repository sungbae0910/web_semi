package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;

public class RvReply implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rCode = Integer.parseInt(req.getParameter("rCode"));
		String eMail = req.getParameter("eMail");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int rGroup = Integer.parseInt(req.getParameter("rGroup"));
		int rStep = Integer.parseInt(req.getParameter("rStep"));
		int rIndent = Integer.parseInt(req.getParameter("rIndent"));
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(eMail);
		RvDao dao = new RvDao();
		dao.rvReply(rCode, eMail, title, content, rGroup, rStep, rIndent);
	}

}
