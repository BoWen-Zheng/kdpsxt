package com.orilore.dto;

import java.util.List;

import com.orilore.model.Shy;

public class Shydto {
	private int pagecount;
	private List<Shy> shys;
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<Shy> getShys() {
		return shys;
	}
	public void setShys(List<Shy> shys) {
		this.shys = shys;
	}
}
