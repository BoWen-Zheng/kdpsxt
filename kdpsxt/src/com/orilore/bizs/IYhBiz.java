package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public interface IYhBiz{
	public boolean addYh(Yh yh);
	public boolean removeYh(int id);
	public boolean modifyYh(Yh yh);
	public Yh getYh(int id);
	public List<Yh> findYh();
	public List<Yh> findYhbyyhm(int page,String yhm);
	public int findcount(Map map);
	public Yh finddl(Map map);
}