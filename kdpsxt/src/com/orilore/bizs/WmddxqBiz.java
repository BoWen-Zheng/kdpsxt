package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.mappers.*;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
@Service
public class WmddxqBiz implements IWmddxqBiz{
	@Resource
	private WmddxqMapper mapper;
	@Override
	public boolean addWmddxq(Wmddxq bean) {
			mapper.insert(bean);
			return true;
		
	}
	@Override
	public boolean removeWmddxq(int id) {
			mapper.delete(id);
			return true;
		
	}
	@Override
	public boolean modifyWmddxq(Wmddxq bean) {
			mapper.update(bean);
			return true;
		
	}
	@Override
	public Wmddxq getWmddxq(int id) {
		Wmddxq bean = null;
			bean = mapper.selectOne(id);
			return bean;
	}
	@Override
	public List<Wmddxq> findWmddxq() {
		List<Wmddxq> beans = null;
			beans = mapper.select();
		return beans;
	}
}
