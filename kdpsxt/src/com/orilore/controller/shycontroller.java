package com.orilore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orilore.bizs.IShyBiz;
import com.orilore.dto.Shydto;

import com.orilore.model.Shy;


@Controller
public class shycontroller {
@Resource
public IShyBiz shybiz;
@RequestMapping(value="/addshy")
public String addshy(HttpServletRequest request){
	shybiz.addShy(request);
	return "redirect:/addshy.jsp";
	
}
	@RequestMapping(value="/selectshy")
	public @ResponseBody Shydto selectshy(@RequestParam(value="xm") String xm,@RequestParam(value="page") int page){
		
		Map map=new HashMap();
		if(xm!=null&&!xm.equals("")){
			xm="%"+xm+"%";
		}
		map.put("xm", xm);
		List<Shy> shys=shybiz.findshybyxm(page,xm);
		int pagecount=shybiz.findcount(map);
		Shydto shydto=new Shydto();
		shydto.setPagecount(pagecount);
		shydto.setShys(shys);
		
		return shydto;
		
		
	} 
	@RequestMapping(value="/updateshy")
	public String updateshy(@RequestParam(value="id") int id,HttpServletRequest request){
		Shy shy=shybiz.getShy(id);
		request.setAttribute("shy", shy);
		return "selectshycz.jsp";
	}
	@RequestMapping(value="/updateshycz")
	public String updateshycz(HttpServletRequest request){
	    int id=Integer.parseInt(request.getParameter("id"));	
		Shy shy=shybiz.getShy(id);
		String xm=request.getParameter("xm");
		String dh=request.getParameter("dh");
		String szxx=request.getParameter("szxx");
		String zt=request.getParameter("zt");
		shy.setDh(dh);
		shy.setSzxx(szxx);
		shy.setXm(xm);
		shy.setZt(Integer.parseInt(zt));
		shybiz.modifyShy(shy);
		return "redirect:/selectshy.jsp";
	}
	@RequestMapping(value="/glshy")
	public @ResponseBody Shy glshy(HttpServletRequest request){
		List<Shy> shys=shybiz.findbyzt(request);
		Shy shy=shys.get(0);
		return shy;
	}
}
