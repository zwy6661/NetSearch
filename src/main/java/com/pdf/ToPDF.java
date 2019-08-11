package com.pdf;

import java.io.*;

import static java.lang.System.*;

import java.awt.image.BufferedImage;
import java.util.*;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInputStream;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.w3c.dom.Entity;


public class ToPDF {
	
	public void test(String path1,String path2) {
		 int t=0;
		
		File file=new File(path1);
		
		try {
			
			PDDocument pdd=PDDocument.load(file);
			
			int pageNum=pdd.getNumberOfPages();
			
			out.print(pageNum);
			for(int i=0;i<pageNum;i++) {
				
				
				
				PDFTextStripper stripper=new PDFTextStripper();
				
				stripper.setStartPage(i);
				
				stripper.setEndPage(i);
				
				
				//FileOutputStream fos=new FileOutputStream("C:\\Users\\22682\\Desktop\\新建文件夹\\PDF_"+(i)+".txt");
				
				//OutputStreamWriter osw=new OutputStreamWriter(fos,"unicode");
				
				
				
				
				//stripper.writeText(pdd, osw);
				
				//osw.close();
				
				//fos.close();
				
				
				PDPage page=pdd.getPage(i);
				
				PDResources resource=page.getResources();
				
				COSDictionary images=resource.getCOSObject();
				out.println(images);
				out.println(images.getValues());
				//cosDict(images,resource);
				Set<COSName> set=images.keySet();
				Iterator<COSName> it=set.iterator();
				
				
				while(it.hasNext()) {
					
					COSName obj= it.next();
					
					out.println(" : "+obj.toString()+images.getItem(obj.getName()));
					
					
					if(resource.isImageXObject(obj)) {
						out.println("COSName : "+obj.getName()+" is Image ");
						
						PDImageXObject pdx=(PDImageXObject) resource.getXObject(obj);
						
						String stuf=pdx.getSuffix();
						
						BufferedImage bi=pdx.getImage();
						
						ImageIO.write(bi, stuf, new File("D:\\甲骨文文献\\照片\\"+path2+"_"+t+".jpg"));
						t++;
					}
					
					
					if(images.getItem(obj.getName()) instanceof COSDictionary) {
						
						
						COSDictionary base=(COSDictionary) images.getItem(obj.getName());
						Iterator<COSName> its=base.keySet().iterator();
						
						while(its.hasNext()) {
							
							COSName cosName=its.next();
							
							if(resource.isImageXObject(cosName)) {
								
								out.println("COSName : "+cosName.getName()+" is Image ");
								
								PDImageXObject pdx=(PDImageXObject) resource.getXObject(cosName);
								
								out.println(pdx.getWidth()+pdx.getSuffix());
								/*COSInputStream cis=pdx.getCOSStream().createInputStream();
								
								FileOutputStream fos1=new FileOutputStream("C:\\Users\\22682\\Desktop\\PDF2\\PDF_"+t+".jpg");
								
								
								
								
								byte[] buf=new byte[1024];
								
								int len=0;
								
								while((len=cis.read(buf))!=-1) {
									
									fos1.write(buf,0,len);
									
								}
								
								fos1.close();
								
								cis.close();*/
								
								String stuf=pdx.getSuffix();
								
								BufferedImage bi=pdx.getImage();
								
								ImageIO.write(bi, stuf, new File("D:\\甲骨文文献\\照片\\"+path2+"_"+t+".jpg"));
								t++;
							}
							
							
						}
						
						out.println(" :1 "+base.getCOSObject());
					}
					
					
					out.println();
					
					
				}
				
				
				
				
				
				
			}
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			
		}finally {
			
			
			
			
		}
		
		
		
		
	}
	
	public static void main(String[]a) {
		
		
		File file=new File("D:\\甲骨文文献\\other");
		
		
		File[] files=file.listFiles();
		
		for(File f:files) {
			
			String path=f.getAbsolutePath();
			String abspath=f.getName();
			
			new ToPDF().test(path,abspath);
		}
		
		
		
		
	}
	
	
	public static COSDictionary cosDict(COSDictionary cos,PDResources resource) throws IOException, InterruptedException {
		
		
		out.println();
		out.println();
		System.err.println("进入递归     "+cos);
		err.println();
		System.err.println("进入递归    "+cos.getValues());
		Set<COSName> set=cos.keySet();
		
		Iterator<COSName> it=set.iterator();
		
		while(it.hasNext()) {
			
			COSName obj= it.next();
			
			out.println();
			out.println(cos.getItem(obj));
			out.println(" : "+obj.toString()+cos.getItem(obj.getName()));
			
			Thread.sleep(2000);
			
			
			if(cos.getItem(obj) instanceof COSDictionary){
					return cosDict((COSDictionary)cos.getItem(obj.getName()),resource);
 
			}else {
				obj=forCos(cos,obj,resource);
				if(resource.isImageXObject(obj)) {
					out.println("COSName : "+obj.getName()+" is Image ");
					
					PDImageXObject pdx=(PDImageXObject) resource.getXObject(obj);
					
					String stuf=pdx.getSuffix();
					
					BufferedImage bi=pdx.getImage();
					
					ImageIO.write(bi, stuf, new File("C:\\Users\\22682\\Desktop\\PDF2\\PDF_"+".jpg"));
					//t++;
				}
								
			}
	
		}
		
		return null;
		
	}
	
	public static COSName forCos(COSDictionary cos,COSName obj,PDResources resource) {
		
		if(cos.getItem(obj) instanceof COSName) {
			return forCos(cos,(COSName) cos.getItem(obj),resource);
		}else if(cos.getItem(obj) instanceof COSStream) {
			return forCos(cos,(COSName) cos.getItem(obj),resource);
			
		}else
		return obj;
	}
	
}
