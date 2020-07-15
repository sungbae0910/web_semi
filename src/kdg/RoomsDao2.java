package kdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DBConn;

public class RoomsDao2 {
	Connection conn;
	public RoomsDao2() {
		conn = DBConn.getConn();
	}
 public List<RoomsVo> view(int rCode) {
 	 List<RoomsVo> list = new ArrayList<RoomsVo>();
	 RoomsVo vo = null;
	 try {
		 String sql = " select rs.rCode , rs.rName,rs.rPlace, rs.ginfo,rs.aType,rs.OriFile,rs.SysFile,rs.stars,rs.checkIn,rs.checkOut,rs.address,rs.kind,rs.pet,rs.smoke,rs.noSmoke,rs.Parking, " 
		            + " rs.breakfast,rs.pt,rs.swim,rs.rest,rs.cafe,rs.bar,rs.washer,rs.lounge,rs.kitchen,rs.dryer,rs.talsu, rs.ceo, r.roomCode,r.roomName,r.rCode,r.rMaxPeople,r.price,r.tv,r.wifi,r.shower, " 
				    + " r.aircon,r.spa,r.tub,r.computer,r.iron,r.refr ,r.socket,r.bed,p.oriFile pori,p.sysfile psys "
		            + " from Rooms rs , Room r , room_photo p "
				    + " where rs.rCode = r.rCode and r.ROOMCODE = p.ROOMCODE(+) and rs.rCode = ? ";
		 
	 PreparedStatement ps =conn.prepareStatement(sql);
	 ps.setInt(1, rCode);
	 ResultSet rs = ps.executeQuery();
	 while(rs.next()) {
	  vo = new RoomsVo();
	  vo.setrCode(rs.getInt("rCode"));
	  vo.setrName(rs.getString("rName"));
	  vo.setrPlace(rs.getString("rPlace"));
	  vo.setgInfo(rs.getString("gInfo"));
	  vo.setaType(rs.getString("aType"));
	  vo.setOriFile(rs.getString("OriFile"));
	  vo.setSysFile(rs.getString("SysFile"));
	  vo.setStars(rs.getInt("stars"));
	  vo.setCheckin(rs.getTimestamp("checkin"));
	  vo.setCheckout(rs.getTimestamp("checkout"));
	  vo.setAddress(rs.getString("address"));
	  vo.setKind(rs.getInt("kind"));
	  vo.setPet(rs.getInt("pet"));
	  vo.setSmoke(rs.getInt("smoke"));
	  vo.setNoSmoke(rs.getInt("nosmoke"));
	  vo.setParking(rs.getInt("parking"));
	  vo.setBreakfast(rs.getInt("breakfast"));
	  vo.setPt(rs.getInt("pt"));
	  vo.setSwim(rs.getInt("swim"));
	  vo.setRest(rs.getInt("rest"));
	  vo.setCafe(rs.getInt("cafe"));
	  vo.setBar(rs.getInt("bar"));
	  vo.setWasher(rs.getInt("washer"));
	  vo.setLounge(rs.getInt("lounge"));
	  vo.setKitchen(rs.getInt("kitchen"));
	  vo.setDryer(rs.getInt("dryer"));
	  vo.setTalsu(rs.getInt("talsu"));
      vo.setPori(rs.getString("pori"));
      vo.setPori(rs.getString("psys"));
      vo.setPrice(rs.getInt("price"));
      vo.setRoomCode(rs.getInt("roomCode"));
      vo.setRoomName(rs.getString("roomName"));
      vo.setWifi(rs.getInt("wifi"));
      vo.setBed(rs.getInt("bed"));
      vo.setTub(rs.getInt("tub"));
      vo.setTv(rs.getInt("tv"));
      vo.setSpa(rs.getInt("spa"));
      vo.setComputer(rs.getInt("computer"));
      vo.setCeo(rs.getString("ceo"));
      list.add(vo);
      
	 }
	} catch (Exception e) {

		e.printStackTrace();
	}finally {
		return list;
	}
 }
   
	
}
