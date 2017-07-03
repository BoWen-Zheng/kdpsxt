package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.mappers.*;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
@Service
public class Yh_sjBiz implements IYh_sjBiz{
	@Resource
	private Yh_sjMapper mapper;
	@Override
	public boolean addYh_sj(Yh_sj bean) {
			mapper.insert(bean);
			return true;
		
	}
	@Override
	public boolean removeYh_sj(int id) {
			mapper.delete(id);
			return true;
		
	}
	@Override
	public boolean modifyYh_sj(Yh_sj bean) {
			mapper.update(bean);
			return true;
		
	}
	@Override
	public Yh_sj getYh_sj(int id) {
		Yh_sj bean = null;
			bean = mapper.selectOne(id);
		return bean;
	}
	@Override
	public List<Yh_sj> findYh_sj() {
		List<Yh_sj> beans = null;
			beans = mapper.select();
		return beans;
	}
	@Override
	public List<Yh_sj> findbysj(int sjid) {
		List<Yh_sj> beans= mapper.selectbysj(sjid);
		return beans;
	}
}
