package com.user.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MpCommand {
	
	void execute(HttpServletRequest req, HttpServletResponse res);
}
