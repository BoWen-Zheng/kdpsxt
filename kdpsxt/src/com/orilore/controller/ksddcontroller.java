package com.orilore.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orilore.bizs.IKsddBiz;
import com.orilore.model.Ksdd;

@Controller
public class ksddcontroller {
@Resource
public IKsddBiz ksddbiz;
@RequestMapping(value="/addksdd")
public @ResponseBody int addksdd(@RequestParam(value="fhdz") String fhdz,@RequestParam(value="shdz") String shdz,@RequestParam(value="yhid") int yhid,@RequestParam(value="shyid") int shyid,@RequestParam(value="zl") String zl,@RequestParam(value="xq") String xq,@RequestParam(value="wpzl") double wpzl,@RequestParam(value="jg") double jg,@RequestParam(value="kdgs") String kdgs) throws UnsupportedEncodingException{
	Ksdd ksdd=new Ksdd();
	fhdz=new String(fhdz.getBytes("ISO8859-1"),"UTF-8");
	shdz=new String(shdz.getBytes("ISO8859-1"),"UTF-8");
	zl=new String(zl.getBytes("ISO8859-1"),"UTF-8");
	xq=new String(xq.getBytes("ISO8859-1"),"UTF-8");
	kdgs=new String(kdgs.getBytes("ISO8859-1"),"UTF-8");
	ksdd.setCfdz(fhdz);
	ksdd.setJg(jg);
	ksdd.setKdgs(kdgs);
	ksdd.setShdz(shdz);
	ksdd.setShyid(shyid);
	ksdd.setWpzl(wpzl);
	ksdd.setXq(xq);
	ksdd.setYhid(yhid);
	ksdd.setZl(zl);
	ksdd.setZt(0);
	ksddbiz.addKsdd(ksdd);
	int id=ksdd.getId();
	return id;
}
@RequestMapping(value="/updateksdd")
public @ResponseBody boolean updataksdd(@RequestParam(value="id")int id,@RequestParam(value="ddh")String ddh){
	Ksdd ksdd = ksddbiz.getKsdd(id);
	ksdd.setDdh(Long.parseLong(ddh));
	return true;
}
}
