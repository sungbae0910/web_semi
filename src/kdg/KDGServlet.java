package kdg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.review.controller.RvDao;
import com.user.review.controller.RvVo;

@WebServlet("*.ff")
public class KDGServlet extends HttpServlet {
	String url = "index.jsp?middle=./kdg";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//roomView(req,resp);
		action(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action(req, resp);
			
	}
	
	public void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String temp = req.getRequestURI();
		int pos = temp.lastIndexOf("/");
		String tempUrl = temp.substring(pos);
		switch(tempUrl) {
		case "/hotel.ff":
			hotel(req,resp);
			break;
		case "/motel.ff":
			motel(req,resp);		
			break;
		case "/penshion.ff":
			penshion(req,resp);
			break;
		case "/guesthouse.ff":
			guesthouse(req,resp);
			break;
		case "/roomView.ff":
			roomView(req,resp);
			break;
		case "/gooSelect.ff":
			gooSelect(req,resp);
			break;
		case "/fillter.ff":
			fillter(req,resp);
			break;
/*		case "/insert.ff":
			insert(req,resp);*/
		}
	}
	public void hotel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 2;
		}
		//���댁�����
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		//���몄����
				String sort="";
				if(req.getParameter("sort_f")!=null) {
					sort = req.getParameter("sort_f");
				}else {
					sort ="asc";
				}
				//吏��� ����
				String place="";
				if(req.getParameter("place_f")!=null) {
					place = req.getParameter("place_f");
				}else {
					place ="구전체호텔";
				}
				RoomsDao dao = new RoomsDao();
				List<RoomsListVo> list =dao.select(aType,p_f);
				req.setAttribute("list_f", list);
				req.setAttribute("p_f", p_f);
				req.setAttribute("sort_f", sort);
				req.setAttribute("place_f", place);
		String path = url + "/hrooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
	}
	public void motel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 1;
		}
		//���댁�����
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		//���몄����
		String sort="";
		if(req.getParameter("sort_f")!=null) {
			sort = req.getParameter("sort_f");
		}else {
			sort ="asc";
		}
		//吏��� ����
		String place="";
		if(req.getParameter("place_f")!=null) {
			place = req.getParameter("place_f");
		}else {
			place ="구전체모텔";
		}
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list =dao.select(aType,p_f);
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		req.setAttribute("sort_f", sort);
		req.setAttribute("place_f", place);
		String path = url + "/mrooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);	
	}
	public void penshion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 3;
		}
		//���댁�����
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		//���몄����
				String sort="";
				if(req.getParameter("sort_f")!=null) {
					sort = req.getParameter("sort_f");
				}else {
					sort ="asc";
				}
				//吏��� ����
				String place="";
				if(req.getParameter("place_f")!=null) {
					place = req.getParameter("place_f");
				}else {
					place ="구전체펜션";
				}
				RoomsDao dao = new RoomsDao();
				List<RoomsListVo> list =dao.select(aType,p_f);
				req.setAttribute("list_f", list);
				req.setAttribute("p_f", p_f);
				req.setAttribute("sort_f", sort);
				req.setAttribute("place_f", place);
		String path = url + "/prooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	public void guesthouse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int aType=0;
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}else {
			aType = 4;
		}
		//���댁�����
		int nowPage_f = 1;
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		//���몄����
				String sort="";
				if(req.getParameter("sort_f")!=null) {
					sort = req.getParameter("sort_f");
				}else {
					sort ="asc";
				}
				//吏��� ����
				String place="";
				if(req.getParameter("place_f")!=null) {
					place = req.getParameter("place_f");
				}else {
					place ="구전체게하";
				}
				RoomsDao dao = new RoomsDao();
				List<RoomsListVo> list =dao.select(aType,p_f);
				req.setAttribute("list_f", list);
				req.setAttribute("p_f", p_f);
				req.setAttribute("sort_f", sort);
				req.setAttribute("place_f", place);
		String path = url + "/grooms.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	public void roomView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		Enumeration e = req.getParameterNames();
		while ( e.hasMoreElements() ){
			String name = (String) e.nextElement();
			String[] values = req.getParameterValues(name);		
			for (String value : values) {
				System.out.println("name=" + name + ",value=" + value);
			}   
		}
		
		int rCode=Integer.parseInt(req.getParameter("rCode"));
		String checkIn="";
		String checkOut="";
		
		if(rCode!=0) {
			rCode = Integer.parseInt(req.getParameter("rCode"));
		}
		if(req.getParameter("checkIn")!=null) {
			checkIn = req.getParameter("checkIn");
		}
		if(req.getParameter("checkOut")!=null) {
			checkOut = req.getParameter("checkOut");
		}
		RvDao dao = new RvDao();
		RoomsDao2 dao2 = new RoomsDao2();
		List<RvVo> list = dao.rvSelect(rCode);
		int rvCnt = dao.rvCnt(rCode);
		int reply = dao.replyCnt(rCode);
		List<RoomsVo> vo = dao2.view(rCode);

		req.setAttribute("list", list);
		req.setAttribute("rvCnt", rvCnt);
		req.setAttribute("vo", vo);
		req.setAttribute("rCode", rCode);
		req.setAttribute("checkIn", checkIn);
		req.setAttribute("checkOut", checkOut);
		req.setAttribute("reply", reply);
		
		String path = url + "/rooms_view.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	//援� ������
	public void gooSelect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String place ="";
		int aType=0;
		int nowPage_f = 1;
		String target ="";
		String sort ="";	//媛�寃� ���� 萸�濡���嫄곕��
		int bedtype=5;
		SelectorVo vo = new SelectorVo();//泥댄�щ��� �ы���� �댁�� 由ы���ㅽ�몄�� �댁���� 湲곗〈媛� �����댁�寃�
		
		if(req.getParameter("bedtype")!=null) {
			bedtype = Integer.parseInt(req.getParameter("bedtype"));
		}

		String checkIn =""; //泥댄�ъ�� ��媛�
		String checkOut ="";//泥댄�ъ������媛�
		if(req.getParameter("target")!=null) {
			target = req.getParameter("target");
		}
		if(req.getParameter("nowPage_f")!=null) {
			nowPage_f = Integer.parseInt(req.getParameter("nowPage_f"));
		}
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
		}
		if(req.getParameter("place_f")!=null) {
				place = req.getParameter("place_f");				
			
		}
		if(req.getParameter("checkIn")!=null) {
			checkIn = req.getParameter("checkIn");
		}
		if(req.getParameter("checkOut")!=null) {
			checkOut = req.getParameter("checkOut");
		}
		if(req.getParameter("sort_f")!=null) {
			sort = req.getParameter("sort_f");
		}
		/* -----------泥댄�щ���------------------------------------------------------------------------------*/
		if(req.getParameter("pt")!=null) {
			if(req.getParameter("pt").equals("on")) {
				vo.setPt(req.getParameter("pt"));
			}	
		}
		if(req.getParameter("swim")!=null) {
			if(req.getParameter("swim").equals("on")) {
				vo.setSwim(req.getParameter("swim"));
			}	
		}
		if(req.getParameter("rest")!=null) {
			if(req.getParameter("rest").equals("on")) {
				vo.setRest(req.getParameter("rest"));
			}	
		}
		if(req.getParameter("cafe")!=null) {
			if(req.getParameter("cafe").equals("on")) {
				vo.setRest(req.getParameter("cafe"));
			}	
		}
		if(req.getParameter("bar")!=null) {
			if(req.getParameter("bar").equals("on")) {
				vo.setBar(req.getParameter("bar"));
			}	
		}
		if(req.getParameter("tv")!=null) {
			if(req.getParameter("tv").equals("on")) {
				vo.setTv(req.getParameter("tv"));
			}	
		}
		if(req.getParameter("wifi")!=null) {
			if(req.getParameter("wifi").equals("on")) {
				vo.setWifi(req.getParameter("wifi"));
			}	
		}
		if(req.getParameter("shower")!=null) {
			if(req.getParameter("shower").equals("on")) {
				vo.setShower(req.getParameter("shower"));
			}	
		}
		if(req.getParameter("spa")!=null) {
			if(req.getParameter("spa").equals("on")) {
				vo.setSpa(req.getParameter("spa"));
			}	
		}
		if(req.getParameter("tub")!=null) {
			if(req.getParameter("tub").equals("on")) {
				vo.setTub(req.getParameter("tub"));
			}	
		}
		if(req.getParameter("iron")!=null) {
			if(req.getParameter("iron").equals("on")) {
				vo.setIron(req.getParameter("iron"));
			}	
		}
		if(req.getParameter("computer")!=null) {
			if(req.getParameter("computer").equals("on")) {
				vo.setComputer(req.getParameter("computer"));
			}	
		}
		if(req.getParameter("refr")!=null) {
			if(req.getParameter("refr").equals("on")) {
				vo.setRefr(req.getParameter("refr"));
			}	
		}
		if(req.getParameter("aircon")!=null) {
			if(req.getParameter("aircon").equals("on")) {
				vo.setAircon(req.getParameter("aircon"));
			}	
		}
		if(req.getParameter("socket")!=null) {
			if(req.getParameter("socket").equals("on")) {
				vo.setSocket(req.getParameter("socket"));
			}	
		}
		if(req.getParameter("pet")!=null) {
			if(req.getParameter("pet").equals("on")) {
				vo.setPet(req.getParameter("pet"));
			}	
		}
		if(req.getParameter("smoke")!=null) {
			if(req.getParameter("smoke").equals("on")) {
				vo.setSmoke(req.getParameter("smoke"));
			}	
		}
		if(req.getParameter("noSmoke")!=null) {
			if(req.getParameter("noSmoke").equals("on")) {
				vo.setNoSmoke(req.getParameter("noSmoke"));
			}	
		}
		if(req.getParameter("parking")!=null) {
			if(req.getParameter("parking").equals("on")) {
				vo.setParking(req.getParameter("parking"));
			}	
		}
		if(req.getParameter("breakfast")!=null) {
			if(req.getParameter("breakfast").equals("on")) {
				vo.setBreakfast(req.getParameter("breakfast"));
			}	
		}
		if(req.getParameter("washer")!=null) {
			if(req.getParameter("washer").equals("on")) {
				vo.setWasher(req.getParameter("washer"));
			}	
		}
		if(req.getParameter("lounge")!=null) {
			if(req.getParameter("lounge").equals("on")) {
				vo.setLounge(req.getParameter("lounge"));
			}	
		}
		if(req.getParameter("kitchen")!=null) {
			if(req.getParameter("kitchen").equals("on")) {
				vo.setKitchen(req.getParameter("kitchen"));
			}	
		}
		if(req.getParameter("dryer")!=null) {
			if(req.getParameter("dryer").equals("on")) {
				vo.setDryer(req.getParameter("dryer"));
			}	
		}
		if(req.getParameter("talsu")!=null) {
			if(req.getParameter("talsu").equals("on")) {
				vo.setTalsu(req.getParameter("talsu"));
			}	
		}
		
		
		page p_f = new page();
		p_f.setNowPage(nowPage_f);
		
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list = dao.selectGoo(aType, p_f,place);
		
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		req.setAttribute("place_f", place);
		req.setAttribute("sort_f", sort);
		req.setAttribute("checkIn_f", checkIn);
		req.setAttribute("checkOut_f", checkOut);
		req.setAttribute("bedtype", bedtype);
		req.setAttribute("vo_f", vo);
		
		String path = url + target;
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
		
		
	}

	
	
	public void fillter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String place ="";	//�몄�μ�� 吏��� ��������?
		int aType = 0;		//��������
		int nowPage =1;	//���댁�
		String target ="";	//蹂대�� ���댁�
		String sort ="";	//媛�寃� ���� 萸�濡���嫄곕��
		//�쇰���� 踰��쇱�� 留��� null濡� �ㅼ�댁�⑤�ㅻ㈃ 珥�湲곌��� 5濡���嫄곕��
		int kind = 5;		//�명�� ����?
		int maxPeople =1;	//理����몄��?
		int bedtype =5;		//踰��� ����?
		String checkIn =""; //泥댄�ъ�� ��媛�
		String checkOut ="";//泥댄�ъ������媛�
		if(req.getParameter("checkIn")!=null) {
			checkIn = req.getParameter("checkIn");
		}
		if(req.getParameter("checkOut")!=null) {
			checkOut = req.getParameter("checkOut");
		}
	
		List<String> fillter = new ArrayList<String>();//泥댄�ъ�ы���� 泥댄�щ���� 媛��� ���댁�ㅻ㈃ sql臾몄�� 留��ㅼ�� 諛곗�댁���댁�� dao�� ����
		List<String> pagingSql = new ArrayList<String>();
		SelectorVo2 svo = new SelectorVo2();// 泥댄�ъ�ы�� �댁�몄�� 媛��ㅼ�� ���� ������留� �댁�� dao�� ���ы��寃�
		SelectorVo vo = new SelectorVo();//泥댄�щ��� �ы���� �댁�� 由ы���ㅽ�몄�� �댁���� 湲곗〈媛� �����댁�寃�
		
		if(req.getParameter("place_f")!=null) {
			place = req.getParameter("place_f");
			
			svo.setPlace(place);
		}
		if(req.getParameter("aType")!=null) {
			aType = Integer.parseInt(req.getParameter("aType"));
			svo.setaType(aType);
		}
		if(req.getParameter("nowPage_f")!=null) {
			nowPage = Integer.parseInt(req.getParameter("nowPage_f"));
			svo.setNowPage(nowPage);
		}
		if(req.getParameter("target")!=null) {
			target = req.getParameter("target");
			svo.setTarget(target);
		}
		if(req.getParameter("sort_f")!=null) {
			sort = req.getParameter("sort_f");
			svo.setSort(sort);
		}
		if(req.getParameter("kind")!=null) {
			kind = Integer.parseInt(req.getParameter("kind"));
			svo.setKind(kind);
		}
		if(req.getParameter("maxPeople")!=null) {
			maxPeople = Integer.parseInt(req.getParameter("maxPeople"));
			svo.setMaxPeople(maxPeople);
		}
		if(req.getParameter("bedtype")!=null) {
			bedtype = Integer.parseInt(req.getParameter("bedtype"));
			svo.setBedtype(bedtype);
		}
		
		//-----------泥댄�ъ�ы���� on�대�쇰㈃ sql臾몄�� 留��ㅼ�� fillter�� paginSql�� �댁��寃�-------------------------------------------------------
		
		if(req.getParameter("pt")!=null) {
			if(req.getParameter("pt").equals("on")) {
				fillter.add(" and S.pt = ? ");
				pagingSql.add(" and S.pt =? ");
				vo.setPt(req.getParameter("pt"));
			}	
		}
		if(req.getParameter("swim")!=null) {
			if(req.getParameter("swim").equals("on")) {
				fillter.add(" and S.swim = ? ");
				pagingSql.add(" and S.swim =? ");
				vo.setSwim(req.getParameter("swim"));
			}	
		}
		if(req.getParameter("rest")!=null) {
			if(req.getParameter("rest").equals("on")) {
				fillter.add(" and S.rest = ? ");
				pagingSql.add(" and S.rest =? ");
				vo.setRest(req.getParameter("rest"));
			}	
		}
		if(req.getParameter("cafe")!=null) {
			if(req.getParameter("cafe").equals("on")) {
				fillter.add(" and S.cafe = ? ");
				pagingSql.add(" and S.cafe =? ");
				vo.setCafe(req.getParameter("cafe"));
			}	
		}
		if(req.getParameter("bar")!=null) {
			if(req.getParameter("bar").equals("on")) {
				fillter.add(" and S.bar = ? ");
				pagingSql.add(" and S.bar =? ");
				vo.setBar(req.getParameter("bar"));
			}	
		}
		if(req.getParameter("tv")!=null) {
			if(req.getParameter("tv").equals("on")) {
				fillter.add(" and R.tv = ? ");
				pagingSql.add(" and R.tv =? ");
				vo.setTv(req.getParameter("tv"));
			}	
		}
		if(req.getParameter("wifi")!=null) {
			if(req.getParameter("wifi").equals("on")) {
				fillter.add(" and R.wifi = ? ");
				pagingSql.add(" and R.wifi =? ");
				vo.setWifi(req.getParameter("wifi"));
			}	
		}
		if(req.getParameter("spa")!=null) {
			if(req.getParameter("spa").equals("on")) {
				fillter.add(" and R.spa = ? ");
				pagingSql.add(" and R.spa =? ");
				vo.setSpa(req.getParameter("spa"));
			}	
		}
		if(req.getParameter("tub")!=null) {
			if(req.getParameter("tub").equals("on")) {
				fillter.add(" and R.tub = ? ");
				pagingSql.add(" and R.tub =? ");
				vo.setTub(req.getParameter("tub"));
			}	
		}
		if(req.getParameter("iron")!=null) {
			if(req.getParameter("iron").equals("on")) {
				fillter.add(" and R.iron = ? ");
				pagingSql.add(" and R.iron =? ");
				vo.setIron(req.getParameter("iron"));
			}	
		}
		if(req.getParameter("computer")!=null) {
			if(req.getParameter("computer").equals("on")) {
				fillter.add(" and R.computer = ? ");
				pagingSql.add(" and R.computer =? ");
				vo.setComputer(req.getParameter("computer"));
			}	
		}
		if(req.getParameter("refr")!=null) {
			if(req.getParameter("refr").equals("on")) {
				fillter.add(" and R.refr = ? ");
				pagingSql.add(" and R.refr =? ");
				vo.setRefr(req.getParameter("refr"));
			}	
		}
		if(req.getParameter("aircon")!=null) {
			if(req.getParameter("aircon").equals("on")) {
				fillter.add(" and R.aircon = ? ");
				pagingSql.add(" and R.aircon =? ");
				vo.setAircon(req.getParameter("aircon"));
			}	
		}
		if(req.getParameter("socket")!=null) {
			if(req.getParameter("socket").equals("on")) {
				fillter.add(" and R.socket = ? ");
				pagingSql.add(" and R.socket =? ");
				vo.setSocket(req.getParameter("socket"));
			}	
		}
		if(req.getParameter("pet")!=null) {
			if(req.getParameter("pet").equals("on")) {
				fillter.add(" and S.pet = ? ");
				pagingSql.add(" and S.pet =? ");
				vo.setPet(req.getParameter("pet"));
			}	
		}
		if(req.getParameter("smoke")!=null) {
			if(req.getParameter("smoke").equals("on")) {
				fillter.add(" and S.smoke = ? ");
				pagingSql.add(" and S.smoke =? ");
				vo.setSmoke(req.getParameter("smoke"));
			}	
		}
		if(req.getParameter("noSmoke")!=null) {
			if(req.getParameter("noSmoke").equals("on")) {
				fillter.add(" and S.noSmoke = ? ");
				pagingSql.add(" and S.noSmoke =? ");
				vo.setNoSmoke(req.getParameter("noSmoke"));
			}	
		}
		if(req.getParameter("parking")!=null) {
			if(req.getParameter("parking").equals("on")) {
				fillter.add(" and S.parking = ? ");
				pagingSql.add(" and S.parking =? ");
				vo.setParking(req.getParameter("parking"));
			}	
		}
		if(req.getParameter("breakfast")!=null) {
			if(req.getParameter("breakfast").equals("on")) {
				fillter.add(" and S.breakfast = ? ");
				pagingSql.add(" and S.breakfast =? ");
				vo.setBreakfast(req.getParameter("breakfast"));
			}	
		}
		if(req.getParameter("washer")!=null) {
			if(req.getParameter("washer").equals("on")) {
				fillter.add(" and S.washer = ? ");
				pagingSql.add(" and S.wqsher =? ");
				vo.setWasher(req.getParameter("washer"));
			}	
		}
		if(req.getParameter("lounge")!=null) {
			if(req.getParameter("lounge").equals("on")) {
				fillter.add(" and S.lounge = ? ");
				pagingSql.add(" and S.lounge =? ");
				vo.setLounge(req.getParameter("lounge"));
			}	
		}
		if(req.getParameter("kitchen")!=null) {
			if(req.getParameter("kitchen").equals("on")) {
				fillter.add(" and S.kitchen = ? ");
				pagingSql.add(" and S.kitchen =? ");
				vo.setKitchen(req.getParameter("kitchen"));
			}	
		}
		if(req.getParameter("dryer")!=null) {
			if(req.getParameter("dryer").equals("on")) {
				fillter.add(" and S.dryer = ?");
				pagingSql.add(" and S.dryer =?");
				vo.setDryer(req.getParameter("dryer"));
			}	
		}
		if(req.getParameter("talsu")!=null) {
			if(req.getParameter("talsu").equals("on")) {
				fillter.add(" and S.talsu = ? ");
				pagingSql.add(" and S.talsu =? ");
				vo.setTalsu(req.getParameter("talsu"));
			}	
		}

		page p_f = new page();
		p_f.setNowPage(nowPage);
	
		RoomsDao dao = new RoomsDao();
		List<RoomsListVo> list = dao.selector(svo,p_f,fillter,pagingSql);
		
		req.setAttribute("list_f", list);
		req.setAttribute("p_f", p_f);
		req.setAttribute("place_f", place);
		req.setAttribute("sort_f", sort);
		req.setAttribute("checkIn_f", checkIn);
		req.setAttribute("checkOut_f", checkOut);
		req.setAttribute("kind", kind);
		req.setAttribute("maxPeople", maxPeople);
		req.setAttribute("bedtype", bedtype);
		req.setAttribute("vo_f", vo);
		
		String path = url + target;
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	
/*	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		FileUpload upload = new FileUpload(req,resp);
		if(upload.uploadFormCheck()) {
			InsertRoomsVo vo = upload.roomsUploading();
			
			RoomsDao dao = new RoomsDao();
			Map<String,String> map =dao.roomsInsert(vo);
			req.setAttribute("map_f", map);
			System.out.println("-----------");
			
			
		}else {
			System.out.println("err");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		String path ="rooms_insert_result.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}*/
}

























































