package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
public interface IYh_sjBiz{
	public boolean addYh_sj(Yh_sj yh_sj);
	public boolean removeYh_sj(int id);
	public boolean modifyYh_sj(Yh_sj yh_sj);
	public Yh_sj getYh_sj(int id);
	public List<Yh_sj> findYh_sj();
	public List<Yh_sj> findbysj(int sjid);
}