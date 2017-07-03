package com.orilore.dto;

import java.util.List;

import com.orilore.model.Sj;

public class Sjdto {
	private List<Sj> sjs;
	private int pagecount;
	private int nowpage;
	public List<Sj> getSjs() {
		return sjs;
	}
	public void setSjs(List<Sj> sjs) {
		this.sjs = sjs;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
}
