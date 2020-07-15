package com.login.command;

import java.security.MessageDigest;

public class PwEncrypt {
	public String encrypt(String pw) {
		String pwEn = "";
			try {
				
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(pw.getBytes());
				byte byteDate[] = md.digest();
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<byteDate.length; i++) {
					sb.append(Integer.toString((byteDate[i]&0xff) + 0x100, 16).substring(1));
				}
				pwEn = sb.toString();
			}catch(Exception e) {
				e.printStackTrace();
				pwEn = null;
			}
		return pwEn;
	}
}
