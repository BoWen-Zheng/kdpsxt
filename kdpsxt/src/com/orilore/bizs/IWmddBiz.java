package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
public interface IWmddBiz{
	public boolean addWmdd(Wmdd wmdd);
	public boolean removeWmdd(int id);
	public boolean modifyWmdd(Wmdd wmdd);
	public Wmdd getWmdd(int id);
	public List<Wmdd> findWmdd();
	public List<Wmdd> findWmdds(int yhid);
}