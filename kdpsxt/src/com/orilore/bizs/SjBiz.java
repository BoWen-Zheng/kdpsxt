package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.util.config;
import com.orilore.dto.Sjdto;

import com.orilore.mappers.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
@Service
public class SjBiz implements ISjBiz{
	@Resource
	private SjMapper mapper;
	@Override
	public boolean addSj(HttpServletRequest request) throws IllegalStateException, IOException {
			MultipartRequest mrequest=(MultipartRequest)request;
			MultipartFile file=mrequest.getFile("tp");
			String path=request.getSession().getServletContext().getRealPath("/");
			String filename=System.currentTimeMillis()+file.getOriginalFilename();
			String pathfilename=path+"upload/"+filename;
			File newfile=new File(pathfilename);
			String httpname=config.url+filename;
			file.transferTo(newfile);
			
			
			String sjmc=request.getParameter("sjmc");
			String sjdz=request.getParameter("sjdz");
			String sjdh=request.getParameter("sjdh");
			String pssj=request.getParameter("pssj");
			String psfs=request.getParameter("psfs");
			String qsjg=request.getParameter("qsjg");
			String rjjg=request.getParameter("rjjg");
			String xq=request.getParameter("xq");
			Sj sj=new Sj();
			sj.setPsfs(Integer.parseInt(psfs));
			sj.setPssj(pssj);
			sj.setQsjg(Double.parseDouble(qsjg));
			sj.setRjjg(Double.parseDouble(rjjg));
			sj.setSjdh(sjdh);
			sj.setSjdz(sjdz);
			sj.setSjmc(sjmc);
			sj.setTp(httpname);
			sj.setXq(xq);
			mapper.insert(sj);
			
			return true;
		
	}
	@Override
	public boolean removeSj(int id) {
		
			mapper.delete(id);
			
			return true;
		
	}
	@Override
	public boolean modifySj(Sj bean) {
		
			mapper.update(bean);
			
			return true;
		
	}
	@Override
	public Sj getSj(int id) {
		Sj bean = null;
		
			bean = mapper.selectOne(id);
		
		return bean;
	}
	@Override
	public List<Sj> findSj() {
		List<Sj> beans = null;
		
			beans = mapper.select();
	
		return beans;
	}
	@Override
	public List<Sj> findforpage(int page) {
		int begin=config.pagesize*(page-1);
		Map map=new HashMap();
		map.put("page", config.pagesize);
		map.put("begin", begin);
		return mapper.selectforpage(map);
		
	}
	@Override
	public int findcount() {
		int pagecount=0;
	    int count= mapper.selectcount();
	    if(count%config.pagesize==0){
	    pagecount=count/config.pagesize;
	    }else{
	    	pagecount=count/config.pagesize+1;
	    }
	    	
		return pagecount;
		
	}
	@Override
	public Sjdto showview(int page) {
		int pagecount=this.findcount();
		List<Sj> sjs=this.findforpage(page);
		Sjdto dto=new Sjdto();
		dto.setSjs(sjs);
		dto.setPagecount(pagecount);
		dto.setNowpage(page);
		return dto;
	}
}
