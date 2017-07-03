package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.util.config;
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
public class SpBiz implements ISpBiz{
	@Resource
	private SpMapper mapper;
	@Override
	public boolean addSp(HttpServletRequest request) {
			
			String spmc=request.getParameter("spmc");
			double spjg=Double.parseDouble(request.getParameter("spjg"));
			String spxq=request.getParameter("spxq");
			int sjid=Integer.parseInt(request.getParameter("sj"));
			MultipartRequest mrequest=(MultipartRequest)request;
			MultipartFile file=mrequest.getFile("tp");
			String path=request.getSession().getServletContext().getRealPath("/");
			String filename=System.currentTimeMillis()+file.getOriginalFilename();
			String pathfilename=path+"upload/"+filename;
			File newfile=new File(pathfilename);
			String httpname=config.url+filename;
			try {
				file.transferTo(newfile);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sp sp=new Sp();
			sp.setSpjg(spjg);
			sp.setSpmc(spmc);
			sp.setSpxq(spxq);
			sp.setSjid(sjid);
			sp.setTp(httpname);
			mapper.insert(sp);
			
			return true;
		
	}
	@Override
	public boolean removeSp(int id) {
		
			mapper.delete(id);
			
			return true;
		
	}
	@Override
	public boolean modifySp(Sp bean) {
		
			mapper.update(bean);
			
			return true;
		
	}
	@Override
	public Sp getSp(int id) {
		Sp bean = null;
		
			bean = mapper.selectOne(id);
		
		return bean;
	}
	@Override
	public List<Sp> findSp() {
		List<Sp> beans = null;
		
			beans = mapper.select();
		
		return beans;
	}
	@Override
	public List<Sp> findbymap(HttpServletRequest request,int page) {
		// TODO Auto-generated method stub
		String beginjg=request.getParameter("beginjg");
		String endjg=request.getParameter("endjg");
		String spmc=request.getParameter("spmc");
		String sjid=request.getParameter("sjid");
		if(spmc!=null&&!spmc.equals("")){
			spmc="%"+spmc+"%";
		}
		int begin=(page-1)*config.pagesize;
		Map map=new HashMap();
		if(beginjg!=null&&beginjg!=""&&endjg!=null&&endjg!=""){
			double beginjg1=Double.parseDouble(beginjg);
			double endjg1=Double.parseDouble(endjg);
			map.put("beginjg", beginjg1);
			map.put("endjg", endjg1);
		}
		if(sjid!=null){
			int sj=Integer.parseInt(sjid);
			map.put("sjid", sj);
		}
		map.put("begin", begin);
		map.put("page", config.pagesize);
		map.put("spmc", spmc);
		
		return mapper.selectbymap(map);
	}
	@Override
	public int findcount(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String beginjg=request.getParameter("beginjg");
		String endjg=request.getParameter("endjg");
		String spmc=request.getParameter("spmc");
		String sjid=request.getParameter("sjid");
		Map map=new HashMap();
		if(beginjg!=null&&beginjg!=""&&endjg!=null&&endjg!=""){
			double beginjg1=Double.parseDouble(beginjg);
			double endjg1=Double.parseDouble(endjg);
			map.put("beginjg", beginjg1);
			map.put("endjg", endjg1);
		}
		if(sjid!=null){
			int sj=Integer.parseInt(sjid);
			map.put("sjid", sj);
		}
		if(spmc!=null&&!spmc.equals("")){
			spmc="%"+spmc+"%";
		}
		map.put("spmc", spmc);
		
		
		return mapper.selectcount(map);
	}
	@Override
	public List<Sp> findbysj(int sjid) {
		List <Sp> sps=mapper.selectbysj(sjid);
		return sps;
	}
}
