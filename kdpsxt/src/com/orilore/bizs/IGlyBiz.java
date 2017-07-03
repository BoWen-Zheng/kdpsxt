package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
import java.util.Map;
public interface IGlyBiz{
	public boolean addGly(Gly gly);
	public boolean removeGly(int id);
	public boolean modifyGly(Gly gly);
	public Gly getGly(int id);
	public List<Gly> findGly();
	public Gly getGlylogin(Map map);
}