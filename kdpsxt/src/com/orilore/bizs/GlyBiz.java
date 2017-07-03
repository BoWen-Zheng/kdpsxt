package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.mappers.*;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
@Service
public class GlyBiz implements IGlyBiz{
	@Resource
	private GlyMapper mapper;
	@Override
	public boolean addGly(Gly bean) {
		
			mapper.insert(bean);
			
			return true;
		
	}
	@Override
	public boolean removeGly(int id) {
		
			mapper.delete(id);
			
			return true;
		
	}
	@Override
	public boolean modifyGly(Gly bean) {
		
			mapper.update(bean);
		
			return true;
		
	}
	@Override
	public Gly getGly(int id) {
		Gly bean = null;
		
			bean = mapper.selectOne(id);
	
		return bean;
	}
	@Override
	public List<Gly> findGly() {
		List<Gly> beans = null;
		
			beans = mapper.select();
		
		return beans;
	}
	@Override
	public Gly getGlylogin(Map map) {
		
		return mapper.selectlogin(map);
	}
}
