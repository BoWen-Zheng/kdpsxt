package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.util.config;
import com.orilore.mappers.*;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
@Service
public class ShyBiz implements IShyBiz{
	@Resource
	private ShyMapper mapper;
	@Resource
	private YhMapper yhmapper;
	@Override
	public boolean addShy(HttpServletRequest request) {
			String xm=request.getParameter("xm");
			String dh=request.getParameter("dh");
			String szxx=request.getParameter("szxx");
			
			String zt=request.getParameter("zt");
			Shy shy=new Shy();
			shy.setDh(dh);
			shy.setSzxx(szxx);
			shy.setXm(xm);
			shy.setZt(Integer.parseInt(zt));
			mapper.insert(shy);
			return true;
		
	}
	@Override
	public boolean removeShy(int id) {
		
			mapper.delete(id);
			
			return true;
		
	}
	@Override
	public boolean modifyShy(Shy bean) {
		
			mapper.update(bean);
		
			return true;
		
	}
	@Override
	public Shy getShy(int id) {
		Shy bean = null;
		
			bean = mapper.selectOne(id);
		
		return bean;
	}
	@Override
	public List<Shy> findShy() {
		List<Shy> beans = null;
		
			beans = mapper.select();
		
		return beans;
	}
	@Override
	public List<Shy> findshybyxm(int page, String xm) {
		int begin=(page-1)*config.pagesize;
		Map map=new HashMap();
		map.put("yhm", xm);
		map.put("begin", begin);
		map.put("page", config.pagesize);
		return mapper.selectforpage(map);
	}
	@Override
	public int findcount(Map map) {
		int pagecount=mapper.selectcount(map);
		
		return pagecount;
	}
	@Override
	public List<Shy> findbyzt(HttpServletRequest request) {
		String yhid=request.getParameter("id");
		Yh yh=yhmapper.selectOne(Integer.parseInt(yhid));
		String xx=yh.getXx();
		
		Map map=new HashMap();
		map.put("szxx", xx);
		map.put("zt", 0);
		List<Shy> shys= mapper.selectbyzt(map);
		
		return shys;
	}
}
