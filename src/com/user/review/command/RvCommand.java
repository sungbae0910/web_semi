package com.user.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RvCommand {

	void execute(HttpServletRequest req, HttpServletResponse res);
}
