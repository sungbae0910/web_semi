package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;

public class RvModify implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		int stars = Integer.parseInt(req.getParameter("star"));
		int rCode = Integer.parseInt(req.getParameter("rCo"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		System.out.println(rNo);
		System.out.println(stars);
		System.out.println(content);
		RvDao dao = new RvDao();
		dao.rvModify(content, stars, title, rNo, rCode);
	}
}
