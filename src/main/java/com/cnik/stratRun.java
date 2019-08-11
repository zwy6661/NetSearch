package com.cnik;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class stratRun {
	
	public static void startRun(String url) {
		
		HttpClient httpClient=GetHttpClient.get_HttpClient();
		
		HttpGet httpGet=new HttpGet(url);
		
		httpGet.setConfig(GetHttpClient.requestConfig());
		
		String user_agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36";
		
		String cookie="Ecp_notFirstLogin=1vGHSH; Ecp_ClientId=8190720154400931118; RsPerPage=20; cnkiUserKey=5eca3c58-2651-7af7-2470-69c505082f6b; UM_distinctid=16c22e6b09a315-0433f34f175cd7-c343162-1fa400-16c22e6b09bc11; style=md; KNS_DisplayModel=listmode@SCDB; LID=WEEvREcwSlJHSldRa1FhdkJkVG1BdXBuMzNGb1J2RE5rRVJGQjJKZ3Vxaz0=$9A4hF_YAuvQ5obgVAqNKPCYcEjKensW4IQMovwHtwkF4VYPoHbKxJw!!; ASP.NET_SessionId=2pk2u2xdqvklchqgdedpgyf1; SID_kns=123105; Ecp_session=1; SID_klogin=125144; SID_crrs=125131; Ecp_LoginStuts=%7B%22IsAutoLogin%22%3Afalse%2C%22UserName%22%3A%22dx1012%22%2C%22ShowName%22%3A%22%25E5%25AE%2589%25E9%2598%25B3%25E5%25B8%2588%25E8%258C%2583%25E5%25AD%25A6%25E9%2599%25A2%22%2C%22UserType%22%3A%22bk%22%2C%22r%22%3A%221vGHSH%22%7D; _pk_ref=%5B%22%22%2C%22%22%2C1564101621%2C%22http%3A%2F%2Fwww.cnki.net%2F%22%5D; _pk_ses=*; c_m_LinID=LinID=WEEvREcwSlJHSldRa1FhdkJkVG1BdXBuMzNGb1J2RE5rRVJGQjJKZ3Vxaz0=$9A4hF_YAuvQ5obgVAqNKPCYcEjKensW4IQMovwHtwkF4VYPoHbKxJw!!&ot=07/26/2019 09:09:04; c_m_expire=2019-07-26 09:09:04; KNS_SortType=SCDB%21%28%25e4%25b8%258b%25e8%25bd%25bd%25e9%25a2%2591%25e6%25ac%25a1%252c%2527INTEGER%2527%29+desc";
		
		httpGet.setHeader(new BasicHeader("User-Agent",user_agent));
		
		httpGet.setHeader(new BasicHeader("Cookie",cookie));
		
		
		HttpResponse response;
		
		try {
			response=httpClient.execute(httpGet);
			
			if(response.getStatusLine().getStatusCode()==200) {
				HttpEntity entity=response.getEntity();
				
				Document doc=Jsoup.parse(entity.getContent(),"utf-8",url);
				
				Elements elements=doc.select("a[href]");
				
				for(Element link:elements) {
					
					Element em=link.parent().parent();
					
					
					
					
					String linkUrl=link.attr("href");
					
					String linkText=link.attr("title");
					
					String linkValue=link.text();
					
					if(linkText.equals("阅读")) {
						
						Element element=em.child(1);
						
						String TitleText=element.text();
						
						Element element2=(Element)em.child(3);
						
						String TitleText2=element2.text();
						
						if(Pattern.matches(".*企业.*", TitleText2)||Pattern.matches(".*商业.*", TitleText2)
								||Pattern.matches(".*人力资源.*", TitleText2)
								||Pattern.matches(".*中国工业和信息化.*", TitleText2)
								||Pattern.matches(".*互联网经济.*", TitleText2)
								||Pattern.matches(".*互联网.*", TitleText2)
								||Pattern.matches(".*中国外资.*", TitleText2)
								||Pattern.matches(".*工业设计.*", TitleText2)
								||Pattern.matches(".*软件集成电路.*", TitleText2)) {
							
						}else {
						
						linkUrl="http://kns.cnki.net/"+linkUrl;
						System.out.println(linkText+"  "+linkUrl);
						System.out.println();
						}
					}else if(linkText.equals("HTML阅读")){
						Element element=em.child(1);
						
						String TitleText=element.text();
						
						Element element2=(Element)em.child(3);
						
						String TitleText2=element2.text();
						
						if(Pattern.matches(".*企业.*", TitleText2)||Pattern.matches(".*商业.*", TitleText2)
								||Pattern.matches(".*人力资源.*", TitleText2)
								||Pattern.matches(".*中国工业和信息化.*", TitleText2)
								||Pattern.matches(".*互联网经济.*", TitleText2)
								||Pattern.matches(".*互联网.*", TitleText2)
								||Pattern.matches(".*中国外资.*", TitleText2)
								||Pattern.matches(".*工业设计.*", TitleText2)
								||Pattern.matches(".*软件集成电路.*", TitleText2)) {
							
						}else {
						linkUrl="http://kns.cnki.net/"+linkUrl;
						System.out.println(linkText+"  "+linkUrl);
						System.out.println();
						}
					}else if(Pattern.matches(".*curpage=[0-9]{1,}.*", linkUrl)) {
						linkUrl="http://kns.cnki.net/kns/brief/brief.aspx"+linkUrl;
						String page=link.text();
						System.out.println(" 第  "+page+" 页："+linkText+":"+linkUrl);
						System.out.println();
					}else if(Pattern.matches("下载_.*页", linkUrl)) {
						
						Element element=em.child(1);
						
						String TitleText=element.text();
						
						Element element2=(Element)em.child(3);
						
						String TitleText2=element2.text();
						
						if(Pattern.matches(".*企业.*", TitleText2)||Pattern.matches(".*商业.*", TitleText2)
								||Pattern.matches(".*人力资源.*", TitleText2)
								||Pattern.matches(".*中国工业和信息化.*", TitleText2)
								||Pattern.matches(".*互联网经济.*", TitleText2)
								||Pattern.matches(".*互联网.*", TitleText2)
								||Pattern.matches(".*中国外资.*", TitleText2)
								||Pattern.matches(".*工业设计.*", TitleText2)
								||Pattern.matches(".*软件集成电路.*", TitleText2)) {
							
						}else {
						
						
						linkUrl="http://kns.cnki.net/kns/"+linkUrl;
						
						System.out.println(" 下载   页："+linkText+":"+linkUrl);
						System.out.println();
						}
					}
					
				}
				
				
				
				
				
			}
			
			
			
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
