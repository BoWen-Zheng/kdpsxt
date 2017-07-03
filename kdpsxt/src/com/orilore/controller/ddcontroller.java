package com.orilore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orilore.bizs.IWmddBiz;
import com.orilore.bizs.IWmddxqBiz;
import com.orilore.model.Wmdd;
import com.orilore.model.Wmddxq;

@Controller
public class ddcontroller {
	@Resource
	public IWmddBiz wmddbiz;
	@Resource
	public IWmddxqBiz wmddxqbiz;
	@RequestMapping(value="/addwmdd")
	public @ResponseBody boolean addwmdd(@RequestParam(value="yhid") int yhid,@RequestParam(value="sjid") int sjid,@RequestParam(value="jg") double jg,@RequestParam(value="spidsls") String spidsls){
		Wmdd wmdd=new Wmdd();
		wmdd.setJg(jg);
		wmdd.setSjid(sjid);
		wmdd.setYhid(yhid);
		wmdd.setZt(0);
		boolean flag1=wmddbiz.addWmdd(wmdd);
		int id=wmdd.getId();
		Wmddxq wmddxq=new Wmddxq();
		wmddxq.setWmddid(id);
		boolean flag2=false;
		String substring = spidsls.substring(0, spidsls.length()-1);
		String[] split = substring.split(",");
		for(int i=0;i<split.length;i++){
			String[] split2 = split[i].split(":");
			wmddxq.setSpid(Integer.parseInt(split2[0]));
			wmddxq.setSpsl(Integer.parseInt(split2[1]));
			wmddxqbiz.addWmddxq(wmddxq);
			flag2=true;
		}
		
		return flag1&&flag2;
	}
	@RequestMapping(value="/selectwmdd")
	public @ResponseBody List<Wmdd> selectwmdd(@RequestParam(value="yhid") int yhid){
		return wmddbiz.findWmdds(yhid);
		
	}
}
