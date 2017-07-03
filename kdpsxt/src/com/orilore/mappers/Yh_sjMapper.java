package com.orilore.mappers;
import java.util.List;
import com.orilore.model.*;
public interface Yh_sjMapper{
	public void insert(Yh_sj bean);
	public Yh_sj selectOne(int id);
	public void delete(int id);
	public List<Yh_sj> select();
	public void update(Yh_sj bean);
	public List<Yh_sj> selectbysj(int sjid);
}