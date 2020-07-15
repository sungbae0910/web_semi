package kdg;

import java.io.File;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.DBConn;

public class RoomsDao {
	String upload = "C:\\source\\web_semi\\WebContent\\upload";
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	Connection conn;
	public RoomsDao() {
		conn = bean.DBConn.getConn();
	}
	//처음상태 일때 데이터만들기
	public List<RoomsListVo> select(int aType,page p_f) {
		List<RoomsListVo> list = new ArrayList<RoomsListVo>();
		String sql = "";
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totList = 0;
		
		try {
			sql = " select count(rcode) cnt"
				+ " from rooms"
				+ " where atype=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aType);
			rs = ps.executeQuery();
			if(rs.next()) {
				totList = rs.getInt("cnt");
			}
			p_f.setTotListSize(totList);
			p_f.pageCompute();
			
			ps.close();
			rs.close();
			
			
			sql	=" select * from ( "
				+" 	select rownum rn , A.* from ("
				+" select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price"
				+"	from rooms S join room R "
				+"	on S.rCode = R.rCode "
				+"	where S.atype =? "
				+"	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
				+"  order by S.rCode ) A"
				+" ) where rn between ? and ?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, aType);
			ps.setInt(2, p_f.getStartNo());
			ps.setInt(3, p_f.getEndNo());
			rs = ps.executeQuery();
			while(rs.next()) {
				RoomsListVo vo = new RoomsListVo();
				vo.setrCode(rs.getInt("a"));
				vo.setrName(rs.getString("b"));
				vo.setgInfo(rs.getString("c"));
				vo.setSysFile(rs.getString("d"));
				vo.setStars(rs.getInt("e"));
				vo.setAddress(rs.getString("f"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return list;
		}
	}
	//구 선택시 대이터 만들기
	public List<RoomsListVo> selectGoo(int aType,page p_f,String place) {
		List<RoomsListVo> list = new ArrayList<RoomsListVo>();
		String sql = "";
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totList = 0;
		String[] p = place.split(",");
		
		try {
			sql = " select count(rcode) cnt"
				+ " from rooms"
				+ " where atype=? ";
				if(p.length>1) {
					if(p.length==3) {
						sql += " and (rplace=? or rplace=? or rplace=?) ";
					}else if(p.length==4) {
						sql += " and (rplace=? or rplace=? or rplace=? or rplace=?) ";							
					}
				}
			ps = conn.prepareStatement(sql);
			if(p.length>1) {
				if(p.length==3) {
					ps.setInt(1, aType);
					ps.setString(2, p[0]);
					ps.setString(3, p[1]);
					ps.setString(4, p[2]);
				}else if(p.length==4) {	
					ps.setInt(1, aType);
					ps.setString(2, p[0]);
					ps.setString(3, p[1]);
					ps.setString(4, p[2]);
					ps.setString(5, p[3]);
				}
			}else {
				ps.setInt(1, aType);
				
			}
			rs = ps.executeQuery();
			if(rs.next()) {
				totList = rs.getInt("cnt");
			}
			
			ps.close();
			rs.close();
			
			p_f.setTotListSize(totList);
			p_f.pageCompute();
			
			
			sql	=" select * from ( "
				+" 	select rownum rn , A.* from ("
				+" select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price"
				+"	from rooms S join room R "
				+"	on S.rCode = R.rCode "
				+"	where S.atype =? ";
				
				if(p.length>1) {
					if(p.length==3) {
						sql += " and (S.rplace=? or S.rplace=? or S.rplace=?) ";
					}else if(p.length==4) {
						sql += " and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?) ";							
					}
				}
				
			sql+="	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address "
				+"  order by price ) A"
				+" ) where rn between ? and ?";
			
			ps =conn.prepareStatement(sql);
			
			
			if(p.length>1) {
				if(p.length==3) {
					
					ps.setInt(1, aType);
					ps.setString(2, p[0]);
					ps.setString(3, p[1]);
					ps.setString(4, p[2]);
					ps.setInt(5, p_f.getStartNo());
					ps.setInt(6, p_f.getEndNo());
				}else if(p.length==4) {
							
					ps.setInt(1, aType);
					ps.setString(2, p[0]);
					ps.setString(3, p[1]);
					ps.setString(4, p[2]);
					ps.setString(5, p[3]);
					ps.setInt(6, p_f.getStartNo());
					ps.setInt(7, p_f.getEndNo());
				}
			}else {
				ps.setInt(1, aType);
				ps.setInt(2, p_f.getStartNo());
				ps.setInt(3, p_f.getEndNo());
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				RoomsListVo vo = new RoomsListVo();
				vo.setrCode(rs.getInt("a"));
				vo.setrName(rs.getString("b"));
				vo.setgInfo(rs.getString("c"));
				vo.setSysFile(rs.getString("d"));
				vo.setStars(rs.getInt("e"));
				vo.setAddress(rs.getString("f"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return list;
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//필터링 적용
	public List<RoomsListVo> selector(SelectorVo2 svo,page p_f,List<String> fillter,List<String> pasingSql){
		String[] p =svo.getPlace().split(",");	
		List<RoomsListVo> list = new ArrayList<RoomsListVo>();
		String sql = " select count(S.rcode) cnt "
					+" from rooms S join room R "
					+" on S.rCode = R.rCode "
					+" where S.atype=? ";
					if(p.length>1) {
						if(p.length==3) {
							sql += " and (S.rplace=? or S.rplace=? or S.rplace=?) ";
						}else if(p.length==4) {
							sql += " and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?) ";							
						}
					}
					
		String sql2 =" select * from ( "
					+" 		select rownum rn , A.* from ( "
					+" 			select S.rCode a, S.rName b, S.gInfo c, S.sysFile d, S.stars e, S.address f, min(R.price) price "
					+"			from rooms S join room R "
					+"			on S.rCode = R.rCode "
					+"			where S.atype =? ";
					if(p.length>1) {
						if(p.length==3) {
							sql2 += " and (S.rplace=? or S.rplace=? or S.rplace=?) ";
						}else if(p.length==4) {
							sql2 += " and (S.rplace=? or S.rplace=? or S.rplace=? or S.rplace=?) ";						
						}
					}
		List<Integer> pagelist = new ArrayList<Integer>();//나중에 ps에 setInt를 할때 몇개의 정보가 있는지 확인을위해 list.size()를 사용할것임
		List<Integer> mainlist = new ArrayList<Integer>();//나중에 ps에 setInt를 할때 몇개의 정보가 있는지 확인을위해 list.size()를 사용할것임
		PreparedStatement ps =null;
		ResultSet rs =null;
		int totList = 0;
		
		
		//최대인원 조건추가
		
		sql += " and R.rmaxPeople >= ?";
		sql2 += " and R.rmaxPeople >= ?";
		pagelist.add(svo.getMaxPeople());
		mainlist.add(svo.getMaxPeople());
		if(svo.kind!=5) {//kind가 5가 아니라면
			sql += " and S.kind = ? ";
			sql2+= " and S.kind = ? ";
			pagelist.add(svo.kind);
			mainlist.add(svo.kind);
			if(svo.bedtype!=5) {//bedtype이 5가 아니라면
				sql +=" and R.bed =? ";
				sql2 +=" and R.bed =? ";
				pagelist.add(svo.bedtype);
				mainlist.add(svo.bedtype);
				if(pagelist.size()>0) {//페이징sql에 값이 담겨있다면
					for(int i=0;i<pasingSql.size();i++) {//페이지sql 사이즈만금 돌아라~
						sql += pasingSql.get(i);
						pagelist.add(1);
					}
				}else {//페이징sql에 값이 담겨있다면
					
				}
				
				if(fillter.size()>0) {//필터에 값이 담겨있다면
					for(int i=0;i<fillter.size();i++) {//필터의 사이즈만큼 돌아라~~~~~~~~~~
						sql2 += fillter.get(i);
						mainlist.add(1);
					}
				}else {//필터에 값이 담겨있다면
					
				}
				
			}else {//bedtype 이 5 라면
				
			}
		}else {//kind가 5 라면
			if(svo.bedtype!=5) {//bedtype이 5가 아니라면
				sql +=" and R.bed =? ";
				sql2 +=" and R.bed =? ";
				pagelist.add(svo.bedtype);
				mainlist.add(svo.bedtype);
				
				if(pasingSql.size()>0) {//페이징sql에 값이 담겨있다면
					for(int i=0;i<pasingSql.size();i++) {//페이지sql 사이즈만금 돌아라~
						sql += pasingSql.get(i);
						pagelist.add(1);
					}
				}else {//페이징sql에 값이 담겨있다면
					
				}
				
				if(fillter.size()>0) {//필터에 값이 담겨있다면
					for(int i=0;i<fillter.size();i++) {//필터의 사이즈만큼 돌아라~~~~~~~~~~
						sql2 += fillter.get(i);
						mainlist.add(1);
					}
				}else {//필터에 값이 담겨있다면
					
				}
				
			}else {//bedtype 이 5 라면
				if(pasingSql.size()>0) {//페이징sql에 값이 담겨있다면
					for(int i=0;i<pasingSql.size();i++) {//페이지sql 사이즈만금 돌아라~
						sql += pasingSql.get(i);
						pagelist.add(1);
					}
				}else {//페이징sql에 값이 없다면
					
				}
				
				if(fillter.size()>0) {//필터에 값이 담겨있다면
					for(int i=0;i<fillter.size();i++) {//필터의 사이즈만큼 돌아라~~~~~~~~~~
						sql2 += fillter.get(i);
						mainlist.add(1);
					}
				}else {//필터에 값이 없다면
					
				}
			}
		}
		sql2 +=" 	group by S.rCode, S.rName, S.gInfo, S.sysFile, S.stars, S.address ";
			 
			 if(svo.getSort().equals("asc")) {
				 sql2+= " order by price ";
			 }else if(svo.getSort().equals("dsc")) {
				 sql2+= " order by price desc ";
			 }
		sql2 +=" ) A  ) where rn between ? and ?";
		
		try {
			
			
			if(p.length>1) { //지역 선택됫니?
				
				if(p.length==4) {
					//페이징 sql 열기---------------------------------
					ps = conn.prepareStatement(sql);
					ps.setInt(1,svo.getaType());
					ps.setString(2, p[0]);
					ps.setString(3, p[1]);
					ps.setString(4, p[2]);
					ps.setString(5, p[3]);
					if(pagelist.size()>0) {//페이징을 위한 sql을 담은 list 에 값이 존재한다면
						for(int i=0;i<pagelist.size();i++) {
							ps.setInt(5+i+1, pagelist.get(i));
						}
					}
					rs = ps.executeQuery();
					if(rs.next()) {
						totList = rs.getInt("cnt");
						}
						p_f.setTotListSize(totList);
						p_f.pageCompute();
						
						
						//메인 sql열기-------------------------------------
						ps = conn.prepareStatement(sql2);
						ps.setInt(1, svo.getaType());
						ps.setString(2, p[0]);
						ps.setString(3, p[1]);
						ps.setString(4, p[2]);
						ps.setString(5, p[3]);
						if(mainlist.size()>0) {
							for(int i=0;i<mainlist.size();i++) {
								ps.setInt(5+i+1, mainlist.get(i));
							}
						}
						ps.setInt(5 + mainlist.size()+1, p_f.getStartNo());
						ps.setInt(5 + mainlist.size()+2, p_f.getEndNo());
						rs = ps.executeQuery();
						while(rs.next()) {
							RoomsListVo vo = new RoomsListVo();
							vo.setrCode(rs.getInt("a"));
							vo.setrName(rs.getString("b"));
							vo.setgInfo(rs.getString("c"));
							vo.setSysFile(rs.getString("d"));
							vo.setStars(rs.getInt("e"));
							vo.setAddress(rs.getString("f"));
							vo.setPrice(rs.getInt("price"));
							list.add(vo);
						}
						ps.close();
						rs.close();
				}else if(p.length==3) {
					ps = conn.prepareStatement(sql);
					ps.setInt(1,svo.getaType());
					ps.setString(2, p[0]);
					ps.setString(3, p[1]);
					ps.setString(4, p[2]);
					if(pagelist.size()>0) {//페이징을 위한 sql을 담은 list 에 값이 존재한다면
						for(int i=0;i<pagelist.size();i++) {
							ps.setInt(4+i+1, pagelist.get(i));
						}
					}
					rs = ps.executeQuery();
					if(rs.next()) {
						totList = rs.getInt("cnt");
					}
						p_f.setTotListSize(totList);
						p_f.pageCompute();
						
						
						//메인 sql열기-------------------------------------
						ps = conn.prepareStatement(sql2);
						ps.setInt(1, svo.getaType());
						ps.setString(2, p[0]);
						ps.setString(3, p[1]);
						ps.setString(4, p[2]);
						if(mainlist.size()>0) {
							for(int i=0;i<mainlist.size();i++) {
								ps.setInt(4+i+1, mainlist.get(i));
							}
						}
						ps.setInt(4 + mainlist.size()+1, p_f.getStartNo());
						ps.setInt(4 + mainlist.size()+2, p_f.getEndNo());
						rs = ps.executeQuery();
						while(rs.next()) {
							RoomsListVo vo = new RoomsListVo();
							vo.setrCode(rs.getInt("a"));
							vo.setrName(rs.getString("b"));
							vo.setgInfo(rs.getString("c"));
							vo.setSysFile(rs.getString("d"));
							vo.setStars(rs.getInt("e"));
							vo.setAddress(rs.getString("f"));
							vo.setPrice(rs.getInt("price"));
							list.add(vo);
						}
						ps.close();
						rs.close();
				}
			}else {//지역 선택 안됬니?
				//페이징 sql 열기---------------------------------
				ps = conn.prepareStatement(sql);
				ps.setInt(1,svo.getaType());
				if(pagelist.size()>0) {//페이징을 위한 sql을 담은 list 에 값이 존재한다면
					for(int i=0;i<pagelist.size();i++) {
						ps.setInt(1+i+1, pagelist.get(i));
					}
				}
				rs = ps.executeQuery();
				if(rs.next()) {
					totList = rs.getInt("cnt");
				}
				p_f.setTotListSize(totList);
				p_f.pageCompute();
				
				
				//메인 sql열기-------------------------------------
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, svo.getaType());
				if(mainlist.size()>0) {
					for(int i=0;i<mainlist.size();i++) {
						ps.setInt(1+i+1, mainlist.get(i));
					}
				}
				ps.setInt(1 + mainlist.size()+1, p_f.getStartNo());
				ps.setInt(1 + mainlist.size()+2, p_f.getEndNo());
				rs = ps.executeQuery();
				while(rs.next()) {
					RoomsListVo vo = new RoomsListVo();
					vo.setrCode(rs.getInt("a"));
					vo.setrName(rs.getString("b"));
					vo.setgInfo(rs.getString("c"));
					vo.setSysFile(rs.getString("d"));
					vo.setStars(rs.getInt("e"));
					vo.setAddress(rs.getString("f"));
					vo.setPrice(rs.getInt("price"));
					list.add(vo);
				}
				ps.close();
				rs.close();
			}
		}catch(Exception e) {
			
		}finally {
			return list;
		}
	}
	
	
	
	
	//건물입력
	public Map<String,String> roomsInsert(InsertRoomsVo vo) {
		Map<String,String> map = new HashMap<String, String>();
		String rCode="";
		String msg ="건물 등록이 완료 되었습니다 객실 등록을 해주세요";
		Timestamp tt1 = new Timestamp(vo.getCheckin().getTime());
		Timestamp tt2 = new Timestamp(vo.getCheckout().getTime());
		try {
			String sql  =" insert into rooms(rCode,rName,rPlace,gInfo,aType,oriFile,sysFile,stars,checkIn,checkOut,address,kind,"
						+" pet,smoke,noSmoke,parking,breakfast,pt,swim,rest,cafe,bar,washer,lounge,kitchen,dryer,talsu,ceo)"
						+" values(rooms_rcode_seq.nextval,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?) ";
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getrName());//
			ps.setString(2, vo.getrPlace());//
			ps.setString(3, vo.getgInfo());//
			ps.setString(4, Integer.toString(vo.getaType()));//
			ps.setString(5, vo.getOriFile());//
			ps.setString(6, vo.getSysFile());//
			ps.setInt(7, vo.getStars());//
			ps.setTimestamp(8, tt1);//
			ps.setTimestamp(9, tt2);//
			ps.setString(10, vo.getAddress());//
			ps.setInt(11, vo.getKind());//
			ps.setInt(12, vo.getPet());//
			ps.setInt(13, vo.getSmoke());//
			ps.setInt(14, vo.getNoSmoke());//
			ps.setInt(15, vo.getParking());//
			ps.setInt(16, vo.getBreakfast());//
			ps.setInt(17, vo.getPt());//
			ps.setInt(18, vo.getSwim());//
			ps.setInt(19, vo.getRest());//
			ps.setInt(20, vo.getCafe());//
			ps.setInt(21, vo.getBar());//
			ps.setInt(22, vo.getWasher());//
			ps.setInt(23, vo.getLounge());//
			ps.setInt(24, vo.getKitchen());//
			ps.setInt(25, vo.getDryer());//
			ps.setInt(26, vo.getTalsu());//
			ps.setString(27, vo.getCeo());//
			int cnt = ps.executeUpdate();
			System.out.println(cnt);
			if(cnt>0) {
				
				
						conn.commit();
					}else {
						conn.rollback();
					}
				
			
			sql = " select rCode from rooms where ceo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCeo());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				rCode = Integer.toString(rs.getInt("rCode"));
				map.put("rCode", rCode);
			}
			ps.close();
			rs.close();
		}catch(Exception e) {
			conn.rollback();
			msg = e.toString();
			e.printStackTrace();
			File delFile = new File(upload + vo.getSysFile());
			if(delFile.exists()) {
				delFile.delete();
			}
		}finally {
			try {
				conn.commit();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			map.put("msg", msg);
			return map;
			
		}
	}
	//방입력
	public String roomInsert() {
		String msg ="";
		return msg;
	}
	
	
	
	
	
	
}


















































