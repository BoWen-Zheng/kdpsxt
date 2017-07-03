package com.orilore.model;
public class Wmdd{
	private Sj sj;
	private Integer id;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	private Integer yhid;
	public void setYhid(Integer yhid){
		this.yhid=yhid;
	}
	public Integer getYhid(){
		return this.yhid;
	}
	private Integer sjid;
	public void setSjid(Integer sjid){
		this.sjid=sjid;
	}
	public Integer getSjid(){
		return this.sjid;
	}
	private Double jg;
	public void setJg(Double jg){
		this.jg=jg;
	}
	public Double getJg(){
		return this.jg;
	}
	private Integer zt;
	public void setZt(Integer zt){
		this.zt=zt;
	}
	public Integer getZt(){
		return this.zt;
	}

	public Sj getSj() {
		return sj;
	}

	public void setSj(Sj sj) {
		this.sj = sj;
	}
}