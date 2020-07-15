package com.login.command;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PwSendEmail {
	public boolean send(String toE) {
		boolean flag = false; //이메일 전송 성공 유무
		String email = "websemi@naver.com"; //발신자 이메일
		String pwd = "jhta1907^^"; //발신자 비밀번호
		String host = "smtp.naver.com"; //네이버SMTP (구글 : smtp.gmail.com)
		String toEmail = toE; //수신자 이메일
		int port = 465; //서버와 통신하는 포트 (구글 : 465)
		
		//랜덤 인증번호 생성
		StringBuffer temp = new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++){
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
            	temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 1-10
                temp.append((rnd.nextInt(10)) + 1);
                break;
            }
        }
        String num = temp.toString();
        
        //SMTP서버 정보설정
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
        		return new PasswordAuthentication(email, pwd);
        	}
        });
        
        //이메일로 보낼내용
        StringBuffer sb = new StringBuffer();
        sb.append("<HTML><HEAD><meta charset=\"UTF-8\">\n");
        sb.append("<title>비밀번호 재설정 </title>\n");
        sb.append("<style>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("<div\n");
        sb.append("<img src=\"\" /><!-- 로고이미지넣기 -->\n");
        sb.append("<h1>비밀번호 재설정 안내 메일</h1><br/>\n");
        sb.append("<div style='color:#f45858;font-size:20px;font-weight:bold;'>안녕하세요</div><br/>\n");
        sb.append("<div style='font-size:18px;'>\n" + 
        		"		야!여기어때 회원의 본인 확인을 위해 발송된 메일입니다.<br/>" + 
        		"		  비밀번호 재설정을 하시려면 아래의 버튼을 클릭해주세요.	\n" + 
        		"	</div>\n");
        sb.append("<div style='width:272px;background-color:#f45858;margin:25px 0 25px 0;padding:20px 0 20px 0;border-radius:10px;'>\n");
        sb.append("<a href='http://192.168.0.27:8888/semiProject/login/pw_reset.jsp?e=" + toEmail + "\'");
        sb.append(" style='padding-left:70px; text-decoration:none;color:#fff;font-size:18px;font-weight:bold;'>비밀번호 재설정</a></div>\n");
        sb.append("<div style='font-size:18px;'>\n" + 
        		"		회원님의 요청 없이 해당 메일이 수신되었다면,<br/>\n" + 
        		"		 고객센터를 통해 연락부탁 드립니다.\n" + 
        		"	</div><br/>\n");
        sb.append("<div style='width:500px;background-color:#F0F0F0;font-size:13px;padding:20px 0 20px 10px;'>\n" + 
        		"		본 메일은 발신 전용 메일이므로 회신을 통한 문의는 처리되지 않습니다.<br/>\n" + 
        		"	        문의사항은  고객센터 1234-5678<br/>\n" + 
        		"	    (주)중앙HTA<br/>\n" + 
        		"	        주소:서울특별시 종로구 율곡로10길 105 디아망 401호(봉익동 10-1 디아망 401호)\n" + 
        		"	</div>\n");
        sb.append("</div>\n");
        sb.append("<script>\n");
        sb.append("console.log(request.getParameter(\"u\"));\n");
        sb.append("</script>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
      
        
        //email전송
        try {
        	MimeMessage msg = new MimeMessage(session);
        	msg.setFrom(new InternetAddress(email));
        	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        	msg.setSubject("야!여기어때 비밀번호 재설정 메일입니다.", "utf-8"); //메일 제목
        	msg.setContent(sb.toString(),"text/html; charset=utf-8");
        	Transport.send(msg);
        	flag = true;
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return flag;
	}	
}
