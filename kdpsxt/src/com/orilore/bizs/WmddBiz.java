package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.mappers.*;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
@Service
public class WmddBiz implements IWmddBiz{
	@Resource
	private WmddMapper mapper;
	@Override
	public boolean addWmdd(Wmdd bean) {
			mapper.insert(bean);
			return true;
		
	}
	@Override
	public boolean removeWmdd(int id) {
			mapper.delete(id);
			return true;
		
	}
	@Override
	public boolean modifyWmdd(Wmdd bean) {
			mapper.update(bean);
			return true;
		
	}
	@Override
	public Wmdd getWmdd(int id) {
		Wmdd bean = null;
			bean = mapper.selectOne(id);
		return bean;
	}
	@Override
	public List<Wmdd> findWmdd() {
		List<Wmdd> beans = null;
			beans = mapper.select();
		return beans;
	}
	@Override
	public List<Wmdd> findWmdds(int yhid) {
		
		return mapper.selectwmdd(yhid);
	}
}
