package com.cnik;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientPool {

	public static PoolingHttpClientConnectionManager phcm;
	
	public static void creatHttpClientPool() {
		
		PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
		
		cm.setMaxTotal(120);
		
		cm.setDefaultMaxPerRoute(10);
		
		
		phcm=cm;
		
		
		
		
	}
	
	
	
}
