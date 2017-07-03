package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public interface IShyBiz{
	public boolean addShy(HttpServletRequest request);
	public boolean removeShy(int id);
	public boolean modifyShy(Shy shy);
	public Shy getShy(int id);
	public List<Shy> findShy();
	public List<Shy> findshybyxm(int page,String xm);
	public int findcount(Map map);
	public List<Shy> findbyzt(HttpServletRequest request);
}