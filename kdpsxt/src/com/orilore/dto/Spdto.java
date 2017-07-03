package com.orilore.dto;

import java.util.List;

import com.orilore.model.Sp;

public class Spdto {
private int pagecount;
private List<Sp> sps;
private int page;
public int getPagecount() {
	return pagecount;
}
public void setPagecount(int pagecount) {
	this.pagecount = pagecount;
}
public List<Sp> getSps() {
	return sps;
}
public void setSps(List<Sp> sps) {
	this.sps = sps;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
}
