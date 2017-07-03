package com.orilore.dto;

import java.util.List;

import com.orilore.model.Sj;
import com.orilore.model.Sp;

public class Showspdto {
	private Sj sj;
	private List<Sp> sps;
	private List<Yhpjdto> yhpj;
	public Sj getSj() {
		return sj;
	}
	public void setSj(Sj sj) {
		this.sj = sj;
	}
	public List<Sp> getSps() {
		return sps;
	}
	public void setSps(List<Sp> sps) {
		this.sps = sps;
	}
	public List<Yhpjdto> getYhpj() {
		return yhpj;
	}
	public void setYhpj(List<Yhpjdto> yhpj) {
		this.yhpj = yhpj;
	}
}
