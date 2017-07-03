package com.orilore.mappers;
import java.util.List;
import java.util.Map;

import com.orilore.model.*;
public interface GlyMapper{
	public void insert(Gly bean);
	public Gly selectOne(int id);
	public void delete(int id);
	public List<Gly> select();
	public void update(Gly bean);
	public Gly selectlogin(Map map);
}