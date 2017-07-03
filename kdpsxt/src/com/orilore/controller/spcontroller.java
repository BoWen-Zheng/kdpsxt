package com.orilore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orilore.bizs.ISjBiz;
import com.orilore.bizs.ISpBiz;
import com.orilore.dto.Spdto;
import com.orilore.model.Sj;
import com.orilore.model.Sp;

@Controller
public class spcontroller {
@Resource
public ISpBiz spbiz;
@Resource
public ISjBiz sjbiz;
@RequestMapping(value="/selectlxtosp")
public String selectlxtosp(HttpServletRequest request){
	List<Sj> sjs=sjbiz.findSj();
	request.setAttribute("sjs", sjs);
	return "addsp.jsp";
}
@RequestMapping(value="/addsp")
public String addsj(HttpServletRequest request){
	boolean flag=false;
	try {
		flag=true;
		spbiz.addSp(request);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "redirect:/addsp.jsp?flag="+flag;
	
}
@RequestMapping(value="/selectonesp")
public String selectonesp(@RequestParam(value="id")int id,HttpServletRequest request){
	Sp sp=spbiz.getSp(id);
	request.setAttribute("sp", sp);
	return "selectspcz.jsp";
}
@RequestMapping(value="/selectcp")
public String selectcp(HttpServletRequest request){
	request.setAttribute("sjs", sjbiz.findSj());
	
	return "selectcp.jsp";
}

@RequestMapping(value="/selectsp")	
	
	public @ResponseBody Spdto selectsp(HttpServletRequest request,int page){
	
	
	int pagecount=spbiz.findcount(request);
	List<Sp> sps=spbiz.findbymap(request,page);
	Spdto spdto=new Spdto();
	spdto.setPagecount(pagecount);
	spdto.setSps(sps);
	spdto.setPage(page);
	return spdto;
}
	
	
}

