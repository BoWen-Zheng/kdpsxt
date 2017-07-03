package com.orilore.mappers;
import java.util.List;
import com.orilore.model.*;
public interface KsddMapper{
	public void insert(Ksdd bean);
	public Ksdd selectOne(int id);
	public void delete(int id);
	public List<Ksdd> select();
	public void update(Ksdd bean);
	public List<Ksdd> selectbyyhid(int yhid);
}