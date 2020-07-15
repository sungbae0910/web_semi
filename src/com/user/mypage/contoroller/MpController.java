package com.user.mypage.contoroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.mypage.command.LastPlaceView;
import com.user.mypage.command.MpCommand;
import com.user.mypage.command.MpSecession;
import com.user.mypage.command.MpUpdate;
import com.user.mypage.command.MpView;
import com.user.mypage.command.ReserveList;
import com.user.mypage.command.ReserveView;

@WebServlet("*.mp")
public class MpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMp(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMp(request, response);
	}
	
	private void actionMp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String url = "index.jsp?middle=./user/u_subtitle.jsp?inc2=";
		String viewPage = null;
		MpCommand command = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/mpview.mp")) {
			command = new MpView();
			command.execute(req, res);
			viewPage = url+"mypage.jsp";
		}else if(com.equals("/mpUp.mp")){
			command = new MpView();
			command.execute(req, res);
			viewPage = url+"mpUpdate.jsp";
		}else if(com.equals("/mpUpdate.mp")) {
			command = new MpUpdate();
			command.execute(req, res);
			viewPage = "mpview.mp";
		}else if(com.equals("/reserveList.mp")) {
			command = new ReserveList();
			command.execute(req, res);
			viewPage =  url+"reserveList.jsp";
		}else if(com.equals("/resView.mp")) {
			command = new ReserveView();
			command.execute(req, res);
			viewPage = url+"resView.jsp";
		}else if(com.equals("/lastPlace.mp")) {
			command = new LastPlaceView();
			command.execute(req, res);
			viewPage = url+"lastPlace.jsp";
		}else if(com.equals("/mpSecession.mp")) {
			HttpSession session = req.getSession();
			command = new MpSecession();
			command.execute(req, res);
			session.invalidate();
			viewPage = "index.jsp";
		}
		RequestDispatcher dis = req.getRequestDispatcher(viewPage);
		dis.forward(req, res);
	}

}
