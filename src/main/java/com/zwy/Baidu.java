package com.zwy;
import static java.lang.System.*;
import java.io.*;
import java.net.*;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Baidu {
	
	static {
		try {
			HttpClient httpClient = new DefaultHttpClient();
			
			
			HttpResponse response;
			
			
			
			String url="http://kns.cnki.net/kns/brief/brief.aspx?";
			
			long current=System.currentTimeMillis();
			
			System.out.println(current);
			
			String pageName="pagename=ASP.brief_default_result_aspx";
			
			String isinEn="&isinEn=1";
			
			String dbPrefix="&dbPrefix=SCDB";
			
			String dbCatalog="&dbCatalog=中国学术文献网络出版总库";
			
			String ConfigFile="&ConfigFile=SCDBINDEX.xml";
			
			String rs="&research=off";
			
			String t="&t="+current;
			
			String k_V="人工智能";
			
			String KeyValue="&keyValue="+k_V;
			
			String S="&S=1";
			
			String sort="&sorttype=";
			
			String submit=url+pageName+isinEn+dbPrefix+dbCatalog+ConfigFile+rs+t+KeyValue+S+sort;
			
			HttpGet httpGet=new HttpGet(submit);
			
			String cookie="Ecp_ClientId=8190720154400931118; RsPerPage=20; cnkiUserKey=5eca3c58-2651-7af7-2470-69c505082f6b; UM_distinctid=16c22e6b09a315-0433f34f175cd7-c343162-1fa400-16c22e6b09bc11; Ecp_lout=1; ASP.NET_SessionId=20wv1buo2lhfun1uyge5ngsu; SID_kns=123122; SID_klogin=125141; Ecp_session=1; SID_crrs=125132; KNS_SortType=; _pk_ref=%5B%22%22%2C%22%22%2C1564031096%2C%22http%3A%2F%2Fwww.cnki.net%2F%22%5D; _pk_ses=*; SID_krsnew=125131; SID_kxreader_new=011123; SID_kns_kdoc=015011121; SID_knsdelivery=125121; style=md; LID=WEEvREcwSlJHSldRa1Fhb09jT0pjQjlWc3VPYmdLeW1YRlVTcDRoMEE4RT0=$9A4hF_YAuvQ5obgVAqNKPCYcEjKensW4IQMovwHtwkF4VYPoHbKxJw!!; Ecp_LoginStuts=%7B%22IsAutoLogin%22%3Afalse%2C%22UserName%22%3A%22dx1012%22%2C%22ShowName%22%3A%22%25E5%25AE%2589%25E9%2598%25B3%25E5%25B8%2588%25E8%258C%2583%25E5%25AD%25A6%25E9%2599%25A2%22%2C%22UserType%22%3A%22bk%22%2C%22r%22%3A%22PPkVRa%22%7D; c_m_LinID=LinID=WEEvREcwSlJHSldRa1Fhb09jT0pjQjlWc3VPYmdLeW1YRlVTcDRoMEE4RT0=$9A4hF_YAuvQ5obgVAqNKPCYcEjKensW4IQMovwHtwkF4VYPoHbKxJw!!&ot=07/25/2019 13:59:42; c_m_expire=2019-07-25 13:59:42";
			
			
			httpGet.setHeader("Cookie", cookie);		
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");
			
			response=httpClient.execute(httpGet);
			response.setHeader("Content-Type", "text/html;utf-8");
			HttpEntity entity=response.getEntity();
			
			entity.writeTo(new FileOutputStream("C:\\Users\\22682\\Desktop\\测试result\\1.html"));
			
			byte[] buf=new byte[1024];
			int len;
			
			
			out.println(":"+response.getStatusLine().getStatusCode());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public static void main(String[]args) {
		
	}
}
