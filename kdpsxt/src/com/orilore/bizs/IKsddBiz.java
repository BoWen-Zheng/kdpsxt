package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
public interface IKsddBiz{
	public boolean addKsdd(Ksdd ksdd);
	public boolean removeKsdd(int id);
	public boolean modifyKsdd(Ksdd ksdd);
	public Ksdd getKsdd(int id);
	public List<Ksdd> findKsdd();
	public List<Ksdd> selectksddbyyhid(int yhid);
}