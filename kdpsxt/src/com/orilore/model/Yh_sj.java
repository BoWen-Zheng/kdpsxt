package com.orilore.model;
public class Yh_sj{
	private Integer id;
	private Integer yhid;
	public void setYhid(Integer yhid){
		this.yhid=yhid;
	}
	public Integer getYhid(){
		return this.yhid;
	}
	private Integer sjid;
	public void setJsid(Integer sjid){
		this.sjid=sjid;
	}
	public Integer getJsid(){
		return this.sjid;
	}
	private String pj;
	public void setPj(String pj){
		this.pj=pj;
	}
	public String getPj(){
		return this.pj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}