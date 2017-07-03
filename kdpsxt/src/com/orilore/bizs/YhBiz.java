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
public class YhBiz implements IYhBiz{
	@Resource
	private YhMapper mapper;
	@Override
	public boolean addYh(Yh bean) {
		
			mapper.insert(bean);
			
			return true;
	
	}
	@Override
	public boolean removeYh(int id) {
		
			mapper.delete(id);
			
			return true;
		
	}
	@Override
	public boolean modifyYh(Yh bean) {
		
			mapper.update(bean);
			
			return true;
		
	}
	@Override
	public Yh getYh(int id) {
		Yh bean = null;
		
			bean = mapper.selectOne(id);
		
		return bean;
	}
	@Override
	public List<Yh> findYh() {
		List<Yh> beans = null;
		
			beans = mapper.select();
		
		return beans;
	}
	@Override
	public List<Yh> findYhbyyhm(int page,String yhm) {
		int begin=(page-1)*config.pagesize;
		Map map=new HashMap();
		map.put("yhm", yhm);
		map.put("begin", begin);
		map.put("page", config.pagesize);
		return mapper.selectbyyhm(map);
		
	}
	@Override
	public int findcount(Map map){
		int pagecount=mapper.selectcount(map);
		
		return pagecount;
	}
	@Override
	public Yh finddl(Map map) {
		return mapper.selectdl(map);
		
	}
}
