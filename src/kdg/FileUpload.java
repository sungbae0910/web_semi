package kdg;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.*;

public class FileUpload {
	String tempDir = "C:/temp2/";
	
	int maxSize = 1024*1024*50;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
	
	public FileUpload(HttpServletRequest req,HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	public boolean uploadFormCheck() {
		boolean flag = ServletFileUpload.isMultipartContent(req);
		return flag;
	}
	public InsertRoomsVo roomsUploading(){//건물정보 업로드
		InsertRoomsVo vo = new InsertRoomsVo();//건물정보
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(tempDir));
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize);
		
		try {
			List<FileItem> list = sf.parseRequest(req);
			for(FileItem fi:list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				if(fi.isFormField()) {
					switch(k) {
					case "ceo":
						vo.setCeo(v);
						System.out.println("ceo:"+vo.getCeo());
						break;
					case "rName":
						vo.setrName(v);
						System.out.println("rName:"+vo.getrName());
						break;
					case "adress":
						vo.setAddress(v);
						System.out.println("adress:"+vo.getAddress());
						break;
					case "rPlace":
						vo.setrPlace(v);
						System.out.println("rPlace:"+vo.getrPlace());
						break;
					case "stars":
						vo.setStars(Integer.parseInt(v));
						System.out.println("stars:"+vo.getStars());
						break;
					case "gInfo":
						vo.setgInfo(v);
						System.out.println("ginfo:"+vo.getgInfo());
						break;
					case "aType":
						vo.setaType(Integer.parseInt(v));
						System.out.println("aType:"+vo.getaType());
						break;
					case "kind":
						vo.setKind(Integer.parseInt(v));
						System.out.println("kind:"+vo.getKind());
						break;
					case "checkIn":
						vo.setCheckin(sdf.parse("2020-04-01 "+v));
						System.out.println("checkin:"+vo.getCheckin());
						break;
					case "checkOut":
						vo.setCheckout(sdf.parse("2020-04-01 "+v));
						System.out.println("checkOut:"+vo.getCheckout());
						break;
					
					case "pet":
						
							vo.setPet(Integer.parseInt(v));
						
						System.out.println("pet:"+vo.getPet());
						break;
					case "smoke":
						
							vo.setSmoke(Integer.parseInt(v));
						
						System.out.println("smoke:"+vo.getSmoke());
						break;
					case "noSmoke":
						
							vo.setNoSmoke(Integer.parseInt(v));
						
						System.out.println("nsmoke:"+vo.getNoSmoke());
						break;
					case "parking":
						
							vo.setParking(Integer.parseInt(v));
						
						System.out.println("parking:"+vo.getParking());
						break;
					case "breakfast":
						
							vo.setBreakfast(Integer.parseInt(v));
						
						System.out.println("brakfa:"+vo.getBreakfast());
						break;
						
					case "pt":
						
							vo.setPt(Integer.parseInt(v));
						
						System.out.println("pt:"+vo.getPt());
						break;
					case "swim":
						
							vo.setSwim(Integer.parseInt(v));
						
						System.out.println("swim:"+vo.getSwim());
						break;
					case "rest":
						
							vo.setRest(Integer.parseInt(v));
						
						System.out.println("rest:"+vo.getRest());
						break;
					case "cafe":
						
							vo.setCafe(Integer.parseInt(v));
						
						System.out.println("cafe:"+vo.getCafe());
						break;
					case "bar":
						
							vo.setBar(Integer.parseInt(v));
						
						System.out.println("bar:"+vo.getBar());
						break;
					case "washer":
						
							vo.setWasher(Integer.parseInt(v));
						System.out.println("washer:" + vo.getWasher());
						break;
					case "lounge":
						
							vo.setLounge(Integer.parseInt(v));
						System.out.println("lounge:" +vo.getLounge());
						break;
					case "kitchen":
						
							vo.setKitchen(Integer.parseInt(v));
						System.out.println("kitcen:" + vo.getKitchen());
						break;
					case "dryer":
						
							vo.setDryer(Integer.parseInt(v));
						System.out.println("dryer:" + vo.getDryer());
						break;
					case "talsu":
						
							vo.setTalsu(Integer.parseInt(v));
						System.out.println("talsu:" + vo.getTalsu());
						break;
					}
				}else {
					if(fi.getSize()>0) {
						String f = fi.getName();
						String sysfile = new Date().getTime()+"-"+f;
						vo.setOriFile(f);
						System.out.println("ori:" +vo.getOriFile());
						vo.setSysFile(sysfile);
						System.out.println("sys:"+vo.getSysFile());
						
						File file = new File("C:\\source\\web_semi\\WebContent\\upload\\" + sysfile);
						fi.write(file);
						
						fi.delete();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return vo;
			
		}
	}
	public InsertRoomVo roomUploading() {
		InsertRoomVo vo = new InsertRoomVo();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(tempDir));
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize);
		
		try {
			List<FileItem> list = sf.parseRequest(req);
			for(FileItem fi:list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				
				if(fi.isFormField()) {
					switch(k) {
					case "rCode":
						vo.setrCode(Integer.parseInt(v));
						break;
					case "roomName":
						vo.setRoomName(v);
						break;
					case "rMaxPeople":
						vo.setrMaxPeople(Integer.parseInt(v));
						break;
					case "price":
						vo.setPrice(Integer.parseInt(v));
						break;
						
					case "tv":
						if(v.equals("on")) {
							vo.setTv(1);
						}else {
							vo.setTv(0);
						}
						break;
					case "wifi":
						if(v.equals("on")) {
							vo.setWifi(1);
						}else {
							vo.setWifi(0);
						}
						break;
					case "shower":
						if(v.equals("on")) {
							vo.setShower(1);
						}else {
							vo.setShower(0);
						}
						break;
					case "aircon":
						if(v.equals("on")) {
							vo.setAircon(1);
						}else {
							vo.setAircon(0);
						}
						break;
					case "spa":
						if(v.equals("on")) {
							vo.setSpa(1);
						}else {
							vo.setSpa(0);
						}
						break;
					case "tub":
						if(v.equals("on")) {
							vo.setTub(1);
						}else {
							vo.setTub(0);
						}
						break;
					case "computer":
						if(v.equals("on")) {
							vo.setComputer(1);
						}else {
							vo.setComputer(0);
						}
						break;
					case "iron":
						if(v.equals("on")) {
							vo.setIron(1);
						}else {
							vo.setIron(0);
						}
						break;
					case "refr":
						if(v.equals("on")) {
							vo.setRefr(1);
						}else {
							vo.setRefr(0);
						}
						break;
					case "socket":
						if(v.equals("on")) {
							vo.setSocket(1);
						}else {
							vo.setSocket(0);
						}
						break;
					case "bed":
						vo.setBed(Integer.parseInt(v));
						break;
					
					}
				}else {
					if(fi.getSize()>0) {
						String f = fi.getName();
						String sysfile = new Date().getTime()+"-"+f;
						vo.setOriFile(f);
						vo.setSysFile(sysfile);
						
						File file = new File("C:\\source\\web_semi\\WebContent\\upload\\" + sysfile);
						fi.write(file);
						
						fi.delete();
					}
				}
			}
		}catch(Exception e) {
			
		}finally {
			return vo;
			
		}
	}
	
	
}





































