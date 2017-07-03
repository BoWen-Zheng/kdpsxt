package com.orilore.bizs;
import com.orilore.model.*;
import com.orilore.mappers.*;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
@Service
public class KsddBiz implements IKsddBiz{
	@Resource
	private KsddMapper mapper;
	@Override
	public boolean addKsdd(Ksdd bean) {
			mapper.insert(bean);
			return true;
		
	}
	@Override
	public boolean removeKsdd(int id) {
			mapper.delete(id);
			return true;
		
	}
	@Override
	public boolean modifyKsdd(Ksdd bean) {
			mapper.update(bean);
			return true;
		
	}
	@Override
	public Ksdd getKsdd(int id) {
		Ksdd bean = null;
			bean = mapper.selectOne(id);
		return bean;
	}
	@Override
	public List<Ksdd> findKsdd() {
		List<Ksdd> beans = null;
			beans = mapper.select();
		return beans;
	}
	@Override
	public List<Ksdd> selectksddbyyhid(int yhid) {
		List<Ksdd> ksdd=mapper.selectbyyhid(yhid);
		return ksdd;
	}
}
