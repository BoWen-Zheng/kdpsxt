package com.orilore.bizs;
import com.orilore.model.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
public interface ISpBiz{
	public boolean addSp(HttpServletRequest request);
	public boolean removeSp(int id);
	public boolean modifySp(Sp sp);
	public Sp getSp(int id);
	public List<Sp> findSp();
	public List<Sp> findbymap(HttpServletRequest request,int page);
	public int findcount(HttpServletRequest request);
	public List<Sp> findbysj(int sjid);
}