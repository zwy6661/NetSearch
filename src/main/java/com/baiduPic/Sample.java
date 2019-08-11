package com.baiduPic;

import com.baidu.aip.imagesearch.AipImageSearch;

public class Sample {
	
	private static final String App_id="16885736";
	
	
	private static final String key="CQaW5ULW2AKfPGzgLzK93s99";
	
	private static final String serect="TCSvGXLcXMErT6XxSK1RmtvcQwPPPsaX";
	
	private static AipImageSearch client=new AipImageSearch(App_id,key,serect);
	
	
	public static AipImageSearch getAuth() {

		return client; 
	}
	
	
	
	
}
