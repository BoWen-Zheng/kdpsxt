package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
public interface IWmddxqBiz{
	public boolean addWmddxq(Wmddxq wmddxq);
	public boolean removeWmddxq(int id);
	public boolean modifyWmddxq(Wmddxq wmddxq);
	public Wmddxq getWmddxq(int id);
	public List<Wmddxq> findWmddxq();
}