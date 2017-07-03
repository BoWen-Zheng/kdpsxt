package com.orilore.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.lf5.viewer.configure.MRUFileManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.orilore.bizs.IYhBiz;
import com.orilore.dto.Yhdto;
import com.orilore.model.Yh;
import com.orilore.util.config;

@Controller
public class yhcontroller {
@Resource
public IYhBiz yhbiz;
@RequestMapping(value="/selectyh")
public @ResponseBody Yhdto selectyh(@RequestParam(value="yhm") String yhm,@RequestParam(value="page") int page){
	
	Map map=new HashMap();
	if(yhm!=null&&!yhm.equals("")){
		yhm="%"+yhm+"%";
	}
	map.put("yhm", yhm);
	List<Yh> yhs=yhbiz.findYhbyyhm(page,yhm);
	int pagecount=yhbiz.findcount(map);
	Yhdto yhdto=new Yhdto();
	yhdto.setYhs(yhs);
	yhdto.setPagecount(pagecount);
	
	return yhdto;
}
@RequestMapping(value="/uploadtx")
public @ResponseBody boolean uploadtx(HttpServletRequest request){
	boolean flag=false;

	
		String url=request.getParameter("imgdata");
		String id=request.getParameter("id");
		Yh yh=new Yh();
		yh=yhbiz.getYh(Integer.parseInt(id));
		yh.setTx(url);
		flag=yhbiz.modifyYh(yh);
		
	System.out.println(flag);
	
	return flag;
}
@RequestMapping(value="/UploadFile")
public  @ResponseBody 	String  Upload(HttpServletRequest  request) throws IllegalStateException, IOException{

	 MultipartRequest  mtr = (MultipartRequest)request;
	 
	 MultipartFile  mf = mtr.getFile("file");

	 String realpath = request.getSession().getServletContext().getRealPath("/");
	 
	 
	 String uname = System.currentTimeMillis()+mf.getOriginalFilename();
	 
	 
	 String storepath = realpath+"upload/"+uname;
	 
	 
	 File file = new File(storepath);
	 
	 
	 mf.transferTo(file);
		 
	 String url = "http://192.168.43.167:8080/kdpsxt/upload/"+uname;
		 
	 

	 return url;
}
@RequestMapping(value="/selecttx")
public @ResponseBody Yh selecttx(@RequestParam(value="id") int id){
	Yh yh=yhbiz.getYh(id);
	
	return yh;
	
}
@RequestMapping(value="/grsz")
public @ResponseBody boolean grsz(@RequestParam(value="id") int id,@RequestParam(value="yhm") String yhm,@RequestParam(value="sjh") String sjh,@RequestParam(value="xx") String xx,@RequestParam(value="dz") String dz) throws UnsupportedEncodingException{
	Yh yh=yhbiz.getYh(id);
	yhm=new String(yhm.getBytes("ISO8859-1"),"UTF-8");
	sjh=new String(sjh.getBytes("ISO8859-1"),"UTF-8");
	xx=new String(xx.getBytes("ISO8859-1"),"UTF-8");
	dz=new String(dz.getBytes("ISO8859-1"),"UTF-8");
	yh.setXx(xx);
	yh.setWddz(dz);
	yh.setWddh(sjh);
	yh.setYhm(yhm);
	boolean flag = yhbiz.modifyYh(yh);
	
	return flag;
}
}
