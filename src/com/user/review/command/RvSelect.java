package com.user.review.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;
import com.user.review.controller.RvVo;

public class RvSelect implements RvCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int rCode = Integer.parseInt(req.getParameter("rCo"));
		RvDao dao = new RvDao();
		List<RvVo> list = dao.rvSelect(rCode);
		int reply = dao.replyCnt(rCode);
		int rvCnt = dao.rvCnt(rCode);
		
		req.setAttribute("rCode_a", rCode);
		req.setAttribute("list", list);
		req.setAttribute("rvCnt", rvCnt);
		req.setAttribute("reply", reply);
	}
	
}
