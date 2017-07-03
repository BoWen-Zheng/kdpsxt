package com.orilore.util;

import java.util.ArrayList;
import java.util.List;



public class SingleContainer {
	private static List list;
	public static List comlist(){
		if(list==null){
		list=new ArrayList();
		}
		return list;
	}
}
