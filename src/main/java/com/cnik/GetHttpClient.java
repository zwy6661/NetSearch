package com.cnik;

import java.util.Properties;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class GetHttpClient {
	
	public static HttpClient get_HttpClient() {
		
		CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager(HttpClientPool.phcm).build();
		
		
		
		Properties systemProper=System.getProperties();
		
		String proxyIP="";
		
		String port="";
		
		systemProper.setProperty("http.proxySet", "true");
		systemProper.setProperty("http.proxyHost", proxyIP);
		systemProper.setProperty("http.proxyPort", port);
		
		
		return httpClient;
	}
	
	public static RequestConfig requestConfig() {
		RequestConfig config=RequestConfig.custom().setConnectTimeout(1000)
				.setConnectionRequestTimeout(1000)
				.setSocketTimeout(10*1000).build();
		
		return config;
	}
	
	
	
}
