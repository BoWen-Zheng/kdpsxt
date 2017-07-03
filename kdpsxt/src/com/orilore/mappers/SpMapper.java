package com.orilore.mappers;
import java.util.List;
import java.util.Map;

import com.orilore.model.*;
public interface SpMapper{
	public void insert(Sp bean);
	public Sp selectOne(int id);
	public void delete(int id);
	public List<Sp> select();
	public void update(Sp bean);
	public List<Sp> selectbymap(Map map);
	public int selectcount(Map map);
	public List<Sp> selectbysj(int sjid);
}