package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;

public class RvDelete implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rNo = Integer.parseInt(req.getParameter("rno"));
		int flag = Integer.parseInt(req.getParameter("indent"));
		int rGroup = Integer.parseInt(req.getParameter("rGro"));
		int rCode = Integer.parseInt(req.getParameter("rCode"));
		
		RvDao dao = new RvDao();
		dao.rvDelete(rNo, rGroup, flag, rCode);
	}

}
