package com.zwy;
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class reader {
	
	 static  {
		
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\22682\\Desktop\\取乎学_传诸学_赵鹏 (1).caj");
			
			BufferedReader bw=new BufferedReader(new InputStreamReader(fis,"gbk"));
			
			String str;
			while((str=bw.readLine())!=null) {
				out.println(str);
			}
			
			bw.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 public static void main(String[]a) {
		 
	 }
	
}
