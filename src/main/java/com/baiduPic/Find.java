package com.baiduPic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.imagesearch.AipImageSearch;

public class Find {
	
	public static void select() throws IOException {
		AipImageSearch client=new Sample().getAuth();
		
		
		String imgPath="C:\\Users\\22682\\Desktop\\¼×¹ÇÎÄ\\¼×¹ÇÎÄ3\\YDXK201803002_13100.jpg";
		
		//String iamge=BaseImg.getPath(imgPath);
		
		JSONObject res=client.similarSearch(imgPath, new HashMap<String,String>());
		
		System.out.println(res.toString());
		
		JSONArray array=res.getJSONArray("result");
		
		for(int i=0;i<array.length();i++) {
			
			JSONObject obj=array.getJSONObject(i);
			
			String url=obj.getString("brief");
			
			
			Object score=obj.get("score");
			
			
			
			String it="C:\\Users\\22682\\Desktop\\¼×¹ÇÎÄ\\¼×¹ÇÎÄ3\\"+url.substring(url.lastIndexOf(":")+1, url.length()-1);
			
			String ot="C:\\Users\\22682\\Desktop\\new\\"+"score_"+score+"_"+url.substring(url.lastIndexOf(":")+1, url.length()-1);
			
			FileOutputStream fos=new FileOutputStream(ot);
			
			byte[] buf=new byte[1024];
			
			int len;
			
			FileInputStream fis=new FileInputStream(it);
			
			while((len=fis.read(buf))!=-1) {
				
				fos.write(buf, 0, len);
			}
			
			fos.close();
			fis.close();
			
			
			System.out.println("µØÖ· £º "+url+" score : "+score);
			
		}
		
	}
	
	public static void main(String[]a) {
		try {
			select();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
