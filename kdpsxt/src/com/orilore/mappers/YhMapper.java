package com.orilore.mappers;
import java.util.List;
import java.util.Map;

import com.orilore.model.*;
public interface YhMapper{
	public void insert(Yh bean);
	public Yh selectOne(int id);
	public void delete(int id);
	public List<Yh> select();
	public void update(Yh bean);
	public List<Yh> selectbyyhm(Map map);
	public int selectcount(Map map);
	public Yh selectdl(Map map);
}