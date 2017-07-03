package com.orilore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String createmd5str(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException{
MessageDigest md5=MessageDigest.getInstance("MD5");
		
		BASE64Encoder base64en = new BASE64Encoder();
	 
      String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
      return newstr;
		
	}
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		
		String str = createmd5str("admin");
		
		
		
		System.out.println(str);
		
		
		
	} 
}
