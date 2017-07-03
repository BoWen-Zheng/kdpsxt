package com.orilore.model;
public class Sp{
	private int sjid;
	private Integer id;
	private Sj sj;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	private String spmc;
	public void setSpmc(String spmc){
		this.spmc=spmc;
	}
	public String getSpmc(){
		return this.spmc;
	}
	private String spxq;
	public void setSpxq(String spxq){
		this.spxq=spxq;
	}
	public String getSpxq(){
		return this.spxq;
	}
	private Double spjg;
	public void setSpjg(Double spjg){
		this.spjg=spjg;
	}
	public Double getSpjg(){
		return this.spjg;
	}
	private String tp;
	public void setTp(String tp){
		this.tp=tp;
	}
	public String getTp(){
		return this.tp;
	}

	public int getSjid() {
		return sjid;
	}

	public void setSjid(int sjid) {
		this.sjid = sjid;
	}

	public Sj getSj() {
		return sj;
	}

	public void setSj(Sj sj) {
		this.sj = sj;
	}
}