package com.orilore.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orilore.bizs.IKsddBiz;
import com.orilore.bizs.IShyBiz;
import com.orilore.bizs.IYhBiz;
import com.orilore.dto.Jldto;
import com.orilore.dto.Ksdddto;
import com.orilore.dto.PrintTemplate;
import com.orilore.model.Ksdd;
import com.orilore.model.Shy;
import com.orilore.model.Yh;
import com.orilore.util.KdGoldAPI;
import com.orilore.util.KdniaoTrackQueryAPI;

import atg.taglib.json.JsonObjectTag;
import net.sf.json.JSONObject;


@Controller
public class zrzdcontroller {
	@Resource
	public IShyBiz shybiz;
	@Resource
	public IYhBiz yhbiz;
	@Resource
	public IKsddBiz ksddbiz;
	@RequestMapping(value="/dd")
	public @ResponseBody String ddxq(HttpServletRequest request) throws UnsupportedEncodingException{
		String md="";
		String ddid=request.getParameter("ddid");
		String fhdz=request.getParameter("jjrdz");
		String jjrcs=request.getParameter("jjrcs");
		String shdz=request.getParameter("sjrdz");
		String sjrcs=request.getParameter("sjrcs");
		String wpzl=request.getParameter("wpzl");
		String wplx=request.getParameter("wplx");
		String kdgs=request.getParameter("kdgs");
		String jg=request.getParameter("jg");
		String sjrxm=request.getParameter("sjrxm");
		String jjrdh=request.getParameter("jjrdh");
		String sjrdh=request.getParameter("sjrdh");
		String jjrxm=request.getParameter("jjrxm");
		jjrdh=new String(jjrdh.getBytes("ISO8859-1"),"UTF-8");
		sjrdh=new String(sjrdh.getBytes("ISO8859-1"),"UTF-8");
		jjrcs=new String(jjrcs.getBytes("ISO8859-1"),"UTF-8");
		sjrcs=new String(sjrcs.getBytes("ISO8859-1"),"UTF-8");
		fhdz=new String(fhdz.getBytes("ISO8859-1"),"UTF-8");
		shdz=new String(shdz.getBytes("ISO8859-1"),"UTF-8");
		wpzl=new String(wpzl.getBytes("ISO8859-1"),"UTF-8");
		wplx=new String(wplx.getBytes("ISO8859-1"),"UTF-8");
		kdgs=new String(kdgs.getBytes("ISO8859-1"),"UTF-8");
		jg=new String(jg.getBytes("ISO8859-1"),"UTF-8");
		jjrxm=new String(jjrxm.getBytes("ISO8859-1"),"UTF-8");
		sjrxm=new String(sjrxm.getBytes("ISO8859-1"),"UTF-8");
		String[] jjrcss=jjrcs.split("-");
		String[] sjrcss=sjrcs.split("-");
		
		KdGoldAPI kd=new KdGoldAPI();
		String jjrsheng=jjrcss[0];
		String sjrsheng=sjrcss[0];
		String jjrshi="";
		String jjrqu="";
		String sjrshi="";
		String sjrqu="";
		String kdgsmc="";
		double zl=Double.parseDouble(wpzl);
		if(jjrcss.length>2){
			
			
			jjrshi=jjrcss[1];
			jjrqu=jjrcss[2];
		
			
		}else{
			
			
			jjrshi=jjrcss[0];
			jjrqu=jjrcss[1];
			
		}
		if(sjrcss.length>2){
			sjrshi=sjrcss[1];
			sjrqu=sjrcss[2];
		}else{
			sjrshi=sjrcss[0];
			sjrqu=sjrcss[1];
		}
		if(kdgs=="Ë³·á¿ìµÝ"||"Ë³·á¿ìµÝ".equals(kdgs)){
			kdgsmc="SF";
		}
		try {
		
			md=kd.orderOnlineByJson(ddid,kdgsmc, jjrsheng, jjrshi, jjrqu, fhdz, sjrsheng, sjrshi, sjrqu, shdz, wplx, zl,jjrxm,sjrxm,jjrdh,sjrdh);
		
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ê§°Ü");
		}
		
		
		return md;
	}
	@RequestMapping(value="/hyfw")
	public @ResponseBody String[] hyfw(@RequestParam(value="id")int id) throws Exception{
		
		List<Ksdd> ksdds=ksddbiz.selectksddbyyhid(id);
		String[] xxs = new String[ksdds.size()];
		System.out.println(ksdds.size());
		for (int i=0;i<ksdds.size();i++) {
			String ddh=ksdds.get(i).getDdh()+"";
			String kdgs=ksdds.get(i).getKdgs();
			KdniaoTrackQueryAPI kdcx=new KdniaoTrackQueryAPI();
			if(kdgs.equals("Ë³·á¿ìµÝ")){
				kdgs="SF";
				
			}
			kdgs=new String(kdgs.getBytes("ISO8859-1"),"UTF-8");
			String xx=kdcx.getOrderTracesByJson(kdgs, ddh);
			xxs[i]=xx;
		}
		
		return xxs;
	}
}
