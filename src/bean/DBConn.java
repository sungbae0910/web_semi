package bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	public static Connection getConn() {
		return getConn("web", "web");
	}
	
	public static Connection getConn(String id, String pwd) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.27:1521:xe";
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = id;
		String dbPwd = pwd;
		Connection conn = null;
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, dbUser, dbPwd);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		DBConn.getConn();
	}
	
}
