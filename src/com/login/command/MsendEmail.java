package com.login.command;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.PasswdUserDatabase;

public class MsendEmail{
	
	public String send(String toE) {
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
        
        //email전송
        try {
        	MimeMessage msg = new MimeMessage(session);
        	msg.setFrom(new InternetAddress(email));
        	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        	msg.setSubject("야!여기어때 회원가입 인증번호입니다.", "utf-8"); //메일 제목
        	msg.setText("인증번호 : " + num, "utf-8"); //메일 내용
        	//msg.setHeader("content-Type", "text/html"); 이메일 헤더
        	Transport.send(msg);
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return num;
	}
}
