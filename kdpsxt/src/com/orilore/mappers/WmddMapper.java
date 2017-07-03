package com.orilore.mappers;
import java.util.List;


import com.orilore.model.*;
public interface WmddMapper{
	public void insert(Wmdd bean);
	public Wmdd selectOne(int id);
	public void delete(int id);
	public List<Wmdd> select();
	public void update(Wmdd bean);
	public List<Wmdd> selectwmdd(int yhid);
}