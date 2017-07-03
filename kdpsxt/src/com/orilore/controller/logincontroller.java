package com.orilore.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orilore.bizs.IGlyBiz;

import com.orilore.model.Gly;
import com.orilore.util.MD5Util;

@Controller
public class logincontroller {
@Resource
public IGlyBiz glybiz;
@RequestMapping(value="/login")
public String loginsuccess(@RequestParam(value="yhm") String yhm,@RequestParam(value="yhmm") String yhmm,HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException{
	Map map=new HashMap();
	
	map.put("yhm", yhm);
	map.put("mm", yhmm);
	Gly gly=glybiz.getGlylogin(map);
	boolean flag=false;
	
	if(gly==null){
		flag=true;
		return "redirect:/login.jsp?flag="+flag;
		
	}else{
		HttpSession session=request.getSession();
		session.setAttribute("username", yhm);
		return "main.jsp";
	}
	
}
@RequestMapping(value="/outlogin")
public String outlogin(HttpServletRequest request){
	HttpSession session=request.getSession();
	session.invalidate();
	
	return "redirect:/login.jsp";
}
}
