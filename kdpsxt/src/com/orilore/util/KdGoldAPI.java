package com.orilore.util;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest; 

/**
 *
 * ���������浥�ӿ�
 *
 * @����QQȺ: 340378554
 * @see: http://kdniao.com/api-eorder
 * @copyright: �����п�����ݼ����������޹�˾
 * 
 * ID��Key�뵽�������룺http://kdniao.com/reg
 */
 
public class KdGoldAPI {
	
	//����ID
	private String EBusinessID="1285758";	
	//���̼���˽Կ��������ṩ��ע�Ᵽ�ܣ���Ҫй©
	private String AppKey="9066c67c-0abd-4013-a27b-7ce889715609";	
	//����url, ��ʽ������ַ��http://api.kdniao.cc/api/Eorderservice    ���Ի�����ַ��http://testapi.kdniao.cc:8081/api/EOrderService
	private String ReqURL="http://testapi.kdniao.cc:8081/api/Eorderservice";	
	

	/**
     * Json��ʽ �����浥
	 * @throws Exception 
     */
	public String orderOnlineByJson(String ddid,String kdgs,String jjrsheng,String jjrshi,String jjrqu,String jjrdz,String sjrsheng,String sjrshi,String sjrqu,String sjrdz,String wplx,double wpzl,String jjrxm,String sjrxm,String jjrdh,String sjrdh) throws Exception{
		String requestData= "{'OrderCode': '"+ddid+"'," +
                "'ShipperCode':'"+kdgs+"'," +
                "'PayType':1," +
                "'ExpType':1," +
                "'Cost':1.0," +
                "'OtherCost':1.0," +
                "'Sender':" +
                "{" +
                "'Company':'null','Name':'"+jjrxm+"','Mobile':'"+jjrdh+"','ProvinceName':'"+jjrsheng+"','CityName':'"+jjrshi+"','ExpAreaName':'"+jjrqu+"','Address':'"+jjrdz+"'}," +
                "'Receiver':" +
                "{" +
                "'Company':'null','Name':'"+sjrxm+"','Mobile':'"+sjrdh+"','ProvinceName':'"+sjrsheng+"','CityName':'"+sjrshi+"','ExpAreaName':'"+sjrqu+"','Address':'"+sjrdz+"'}," +
                "'Commodity':" +
                "[{" +
                "'GoodsName':'"+wplx+"','Goodsquantity':1,'GoodsWeight':"+wpzl+"}]," +
                "'Weight':"+wpzl+"," +
                "'Quantity':1," +
                "'Volume':0.0," +
                "'Remark':'С�����'," +
                "'IsReturnPrintTemplate':1}";
		Map<String, String> params = new HashMap<String, String>();
		//params.put("RequestData", urlEncoder(requestData, "UTF-8"));
		params.put("RequestData", requestData);
		params.put("EBusinessID", EBusinessID);
		params.put("RequestType", "1007");
		String dataSign=encrypt(requestData, AppKey, "UTF-8");
		//params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
		params.put("DataSign", dataSign);
		params.put("DataType", "2");
		
		String result=sendPost(ReqURL, params);	
		
		//���ݹ�˾ҵ�����ص���Ϣ......
		
		return result;
	}
	/**
     * MD5����
     * @param str ����       
     * @param charset ���뷽ʽ
	 * @throws Exception 
     */
	@SuppressWarnings("unused")
	private String MD5(String str, String charset) throws Exception {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(str.getBytes(charset));
	    byte[] result = md.digest();
	    StringBuffer sb = new StringBuffer(32);
	    for (int i = 0; i < result.length; i++) {
	        int val = result[i] & 0xff;
	        if (val <= 0xf) {
	            sb.append("0");
	        }
	        sb.append(Integer.toHexString(val));
	    }
	    return sb.toString().toLowerCase();
	}
	
	/**
     * base64����
     * @param str ����       
     * @param charset ���뷽ʽ
	 * @throws UnsupportedEncodingException 
     */
	private String base64(String str, String charset) throws UnsupportedEncodingException{
		String encoded = Base64.encode(str.getBytes(charset));
		return encoded;    
	}	
	
	@SuppressWarnings("unused")
	private String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
		String result = URLEncoder.encode(str, charset);
		return result;
	}
	
	/**
     * ����Signǩ������
     * @param content ����   
     * @param keyValue Appkey  
     * @param charset ���뷽ʽ
	 * @throws UnsupportedEncodingException ,Exception
	 * @return DataSignǩ��
     */
	@SuppressWarnings("unused")
	private String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception
	{
		if (keyValue != null)
		{
			return base64(MD5(content + keyValue, charset), charset);
		}
		return base64(MD5(content, charset), charset);
	}
	
	 /**
     * ��ָ�� URL ����POST����������     
     * @param url ��������� URL    
     * @param params ����Ĳ�������     
     * @return Զ����Դ����Ӧ���
     */
	@SuppressWarnings("unused")
	private String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;        
        StringBuilder result = new StringBuilder(); 
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST����
            conn.setRequestMethod("POST");
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // ��ȡURLConnection�����Ӧ�������
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // �����������            
            if (params != null) {
		          StringBuilder param = new StringBuilder(); 
		          for (Map.Entry<String, String> entry : params.entrySet()) {
		        	  if(param.length()>0){
		        		  param.append("&");
		        	  }	        	  
		        	  param.append(entry.getKey());
		        	  param.append("=");
		        	  param.append(entry.getValue());		        	  
		        	  System.out.println(entry.getKey()+":"+entry.getValue());
		          }
		          System.out.println("param:"+param.toString());
		          out.write(param.toString());
            }
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {            
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
}
