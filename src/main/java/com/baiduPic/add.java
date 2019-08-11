package com.baiduPic;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.imagesearch.AipImageSearch;

import java.io.*;
public class add {
	
	public static void add() {
		AipImageSearch client=new Sample().getAuth();
		
	
		
		String imgPath="C:\\Users\\22682\\Desktop\\¼×¹ÇÎÄ\\¼×¹ÇÎÄ3";
		
		File file=new File(imgPath);
		
		File[] files=file.listFiles();
		
		for(File f:files) {
			
			
			
			String path=imgPath+"\\"+f.getName();
			
			String brief=f.getName();
			
			HashMap<String,String> options=new HashMap<String,String>();
			
			options.put("brief", "{\"name\":"+brief+"}");
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String tags=path.substring(path.lastIndexOf("_")+1, path.lastIndexOf("."));
			
			options.put("tags", tags);
			
			JSONObject res=client.similarAdd(path, options);
			
			System.out.println(res.toString(2));
			
			//System.out.println(path+" : "+brief+" : "+tags);
			
			
		}
		
		
		
		
		
	}
	
	public static void main(String[]a) {
		add();
	}
}
