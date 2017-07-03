package com.orilore.dto;

import java.util.List;

import com.orilore.model.Yh;

public class Yhdto {
	private int pagecount;
	private List<Yh> yhs;
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<Yh> getYhs() {
		return yhs;
	}
	public void setYhs(List<Yh> yhs) {
		this.yhs = yhs;
	}
	
}
