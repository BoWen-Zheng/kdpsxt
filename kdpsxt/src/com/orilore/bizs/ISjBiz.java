package com.orilore.bizs;
import com.orilore.dto.Sjdto;
import com.orilore.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public interface ISjBiz{
	public boolean addSj(HttpServletRequest request) throws IllegalStateException, IOException;
	public boolean removeSj(int id);
	public boolean modifySj(Sj sj);
	public Sj getSj(int id);
	public List<Sj> findSj();
	public List<Sj> findforpage(int page);
	public int findcount();
	public Sjdto showview(int page);
}