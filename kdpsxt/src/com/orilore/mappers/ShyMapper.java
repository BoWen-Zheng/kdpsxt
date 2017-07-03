package com.orilore.mappers;
import java.util.List;
import java.util.Map;



import com.orilore.model.*;
public interface ShyMapper{
	public void insert(Shy bean);
	public Shy selectOne(int id);
	public void delete(int id);
	public List<Shy> select();
	public void update(Shy bean);
	public int selectcount(Map map);
	public List<Shy> selectforpage(Map map);
	public List<Shy> selectbyzt(Map map);
}