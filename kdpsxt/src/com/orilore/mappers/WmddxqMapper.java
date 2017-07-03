package com.orilore.mappers;
import java.util.List;
import com.orilore.model.*;
public interface WmddxqMapper{
	public void insert(Wmddxq bean);
	public Wmddxq selectOne(int id);
	public void delete(int id);
	public List<Wmddxq> select();
	public void update(Wmddxq bean);
}