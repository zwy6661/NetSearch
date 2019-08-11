package com.baiduPic;

import java.io.*;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;

public class BaseImg {
	
	public static String getPath(String path) {
		
		
		InputStream in;
		
		byte[] data=null;
		
		try {
			in=new FileInputStream(path);
			
			data=new byte[in.available()];
			
			in.read(data);
			
			in.close();
			
			
			
			
		}catch(Exception e) {
			
		}
		
		BASE64Encoder encoder=new BASE64Encoder();
		
		return URLEncoder.encode(encoder.encode(data));
		
	}
}
