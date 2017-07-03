package com.orilore.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.orilore.bizs.ISjBiz;
import com.orilore.bizs.ISpBiz;
import com.orilore.bizs.IYhBiz;
import com.orilore.bizs.IYh_sjBiz;
import com.orilore.dto.Showspdto;
import com.orilore.dto.Sjdto;
import com.orilore.dto.Yhpjdto;
import com.orilore.model.Sj;
import com.orilore.model.Sp;
import com.orilore.model.Yh;
import com.orilore.model.Yh_sj;
import com.orilore.util.config;

@Controller
public class sjcontroller {
	@Resource
	public ISjBiz sjbiz;
	@Resource
	public ISpBiz spbiz;
	@Resource
	public IYh_sjBiz yhsjbiz;
	@Resource
	public IYhBiz yhbiz;
	@RequestMapping(value="/addsj")
	public String addsj(HttpServletRequest request){
		boolean flag=true;
		
		try {
			sjbiz.addSj(request);
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		
		
		return "redirect:/addsj.jsp?flag="+flag;
	}
	@RequestMapping(value="/selectsj")
	public @ResponseBody Sjdto selectsj(int page){
		return sjbiz.showview(page);
		
	}
	@RequestMapping(value="/updatesj")
	public String updatesj(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		request.setAttribute("sj", sjbiz.getSj(id));
		return "selectsjcz.jsp";
	}
	@RequestMapping(value="/updatesjcz")
	public String updatesjcz(HttpServletRequest request){
		boolean flag=true;
		
		int id=Integer.parseInt(request.getParameter("id"));
		MultipartRequest mrequest=(MultipartRequest)request;
		MultipartFile file=mrequest.getFile("sjtp");
		Sj sj=sjbiz.getSj(id);
		if(file!=null){
		String path=request.getSession().getServletContext().getRealPath("/");
		String filename=System.currentTimeMillis()+file.getOriginalFilename();
		String pathfilename=path+"upload/"+filename;
		File newfile=new File(pathfilename);
		String httpname=config.url+filename;
		try {
			file.transferTo(newfile);
		} catch (Exception e) {
			flag=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sj.setTp(httpname);
		}
		String sjmc=request.getParameter("sjmc");
		String sjdz=request.getParameter("sjdz");
		String sjdh=request.getParameter("sjdh");
		String pssj=request.getParameter("pssj");
		String psfs=request.getParameter("psfs");
		String qsjg=request.getParameter("qsjg");
		String rjjg=request.getParameter("rjjg");
		String xq=request.getParameter("xq");
		
		sj.setPsfs(Integer.parseInt(psfs));
		sj.setPssj(pssj);
		sj.setQsjg(Double.parseDouble(qsjg));
		sj.setRjjg(Double.parseDouble(rjjg));
		sj.setSjdh(sjdh);
		sj.setSjdz(sjdz);
		sj.setSjmc(sjmc);

		sj.setXq(xq);
		
		sjbiz.modifySj(sj);
		return "redirect:/selectsj.jsp?flag="+flag;
	}
	@RequestMapping(value="/sj")
	public @ResponseBody List<Sj> sj(){
		List<Sj> sjs=sjbiz.findSj();
		
		return sjs;
		
	}
	@RequestMapping(value="/sjxq")
	public @ResponseBody Showspdto sjxq(@RequestParam(value="id") int id){
		Sj sj=sjbiz.getSj(id);
		List<Sp> sps=spbiz.findbysj(id);
		Map spmap=new HashMap();
		Showspdto dto=new Showspdto();
		List<Yh_sj> yhsjs=yhsjbiz.findbysj(id);
		List list=new ArrayList();
		for (Yh_sj yhsj : yhsjs) {
			String pj=yhsj.getPj();
			int yhid=yhsj.getYhid();
			Yh yh=yhbiz.getYh(yhid);
			Yhpjdto yhpj=new Yhpjdto();
			yhpj.setPj(pj);
			yhpj.setYh(yh);
			list.add(yhpj);
		}
		dto.setYhpj(list);
		dto.setSj(sj);
		dto.setSps(sps);
		return dto;
	}
	@RequestMapping(value="/addpj")
	public @ResponseBody boolean addpj(@RequestParam(value="pj") String pj,@RequestParam(value="sjid") int sjid,@RequestParam(value="yhid") int yhid) throws UnsupportedEncodingException{
		Yh_sj yh_sj=new Yh_sj();
		pj=new String(pj.getBytes("ISO8859-1"),"UTF-8");
		yh_sj.setPj(pj);
		yh_sj.setJsid(sjid);
		yh_sj.setYhid(yhid);
		boolean flag=yhsjbiz.addYh_sj(yh_sj);
		return flag;
	}
}
