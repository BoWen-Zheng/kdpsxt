package com.orilore.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orilore.bizs.IYhBiz;
import com.orilore.model.Yh;

@Controller
public class zccontroller {
	@Resource
	public IYhBiz yhbiz;
	@RequestMapping(value="/zc")
	public @ResponseBody boolean zc(HttpServletRequest request) throws UnsupportedEncodingException{
		String yhm=request.getParameter("yhm");
		String mm=request.getParameter("mm");
		String sjh=request.getParameter("sjh");
		String wdxx=request.getParameter("wdxx");
		String wddz=request.getParameter("wddz");
		yhm=new String(yhm.getBytes("ISO8859-1"),"UTF-8");
		wdxx=new String(wdxx.getBytes("ISO8859-1"),"UTF-8");
		wddz=new String(wddz.getBytes("ISO8859-1"),"UTF-8");
		Yh yh=new Yh();
		yh.setMm(mm);
		yh.setWddh(sjh);
		yh.setWddz(wddz);
		yh.setYhm(yhm);
		yh.setXx(wdxx);
		boolean flag=yhbiz.addYh(yh);
		return flag;
	}
	@RequestMapping(value="/dl")
	public @ResponseBody Yh dl(HttpServletRequest request) throws UnsupportedEncodingException{
		String yhm=request.getParameter("yhm");
		String mm=request.getParameter("mm");
		yhm=new String(yhm.getBytes("ISO8859-1"),"UTF-8");
		mm=new String(mm.getBytes("ISO8859-1"),"UTF-8");
		Map map=new HashMap();
		map.put("yhm", yhm);
		map.put("mm", mm);
		Yh yh=yhbiz.finddl(map);
		return yh;
	}
}
