package batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import bean.DBConn;

public class Batch {
	Connection conn;
	
	// DB 연결
	Batch() {
		conn = DBConn.getConn();
	}
	
	// 메인메서드 정의
	public static void main(String[] args) {
		Batch ssb = new Batch();
		int i = 0;

		while (true) {
			i++;
			try {
				Thread.sleep(60000); // 최초 실행시간을 기점으로 60초 단위로 시간을 찍는다.

				// 포맷을 지정해서 날짜 구하기
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss EEE", Locale.ENGLISH);
				Date currentTime = new Date();
				String dTime = formatter.format(currentTime);

				System.out.println(dTime);
				System.out.println(dTime.indexOf(" 00:00"));

				/********************************************************
				 * 일배치를 실행시킬 시간 (월요일 ~ 일요일 11:59) *
				 *********************************************************/
				if (dTime.indexOf(" 15:25") != -1) {
					System.out.println("배치 시간입니다 땅땅땅~ (지난 방문지insert 후, 예약현황에서 제거");
					ssb.callBatch("Delete");
				}

				/********************************************************
				 * 일배치를 실행 및 초기화할 시간 (일요일 11:59) *
				 *********************************************************/
				/*if (dTime.indexOf(" 23:59") != -1 && dTime.indexOf(" Sun") != -1) {
					System.out.println("Step-1. www.kiniwini.com Connect Resquest. : 명령어.");
					ssb.callBatch("명령어");

					System.out.println("Step-1. www.kiniwini.com Connect Resquest. : 명령어.");
					ssb.callBatch("명령어");
				}*/

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 배치 함수 정의
	public void callBatch(String CMD_COMMON) {
		// 속성 정의
		PreparedStatement ps = null;
		String sql = "";
		
		if(!CMD_COMMON.equals("Delete")) return; // 삭제 명령일때만 실행
		
		try {
			sql = "delete from reserve "
				+ " where to_char(checkIn, 'mmdd') <= to_char(sysdate, 'mmdd') ";
			ps = conn.prepareStatement(sql);

			int cnt = ps.executeUpdate();
			if(cnt > 0) { // 정상 입력되면 커밋
				System.out.println("완료!");
				conn.commit();
			} else {
				System.out.println("실패!");
				conn.rollback();
			}
		} catch (Exception ex) {
			System.err.println("Exception 발생!");
			ex.printStackTrace();
		}
	}
}
