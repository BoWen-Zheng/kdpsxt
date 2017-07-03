package com.orilore.mappers;
import java.util.List;
import java.util.Map;

import com.orilore.model.*;
public interface SjMapper{
	public void insert(Sj bean);
	public Sj selectOne(int id);
	public void delete(int id);
	public List<Sj> select();
	public void update(Sj bean);
	public List<Sj> selectforpage(Map map);
	public int selectcount();
}