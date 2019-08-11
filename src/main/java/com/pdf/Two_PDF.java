package com.pdf;

import static java.lang.System.out;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInputStream;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

public class Two_PDF {
	
	static int t=0;
	
	
	public void init() {
		
		String path="C:\\Users\\22682\\Desktop\\释卜辞之_蔑_胡其伟.pdf";
		File file=new File(path);
		
		try {
		
		PDDocument pdd=PDDocument.load(file);
		
		int pageNum=pdd.getNumberOfPages();
		
		out.println(pageNum);
		for(int i=1;i<=1;i++) {

			PDFTextStripper stripper=new PDFTextStripper();
			
			stripper.setStartPage(i);
			
			stripper.setEndPage(i);
		
			PDPage page=pdd.getPage(i);
			
			PDResources resource=page.getResources();
			COSName cosname=COSName.BBOX;
			COSDictionary images=resource.getCOSObject();
			out.println(images.containsKey(cosname));
			out.println(resource.getCOSObject().toString());
			out.println();
			Set<COSName> set=images.keySet();
			Iterator<COSName> it=set.iterator();
	
			while(it.hasNext()) {
				
				COSName obj= it.next();
				
				out.println(" Process:  "+obj.toString()+"  "+images.getItem(obj.getName()));
				if(resource.isImageXObject(obj)) {
					out.println("这是一张照片");
					//out.println();
				}
				if(images.getItem(obj) instanceof COSArray) {
					//out.println();
					//out.println(" Process:  "+obj.toString()+"这是一个CosArray");
					
					//COSArray array=(COSArray) images.getItem(obj);
					
					//out.println(array.getName(1));
				}
				
				if(images.getItem(obj) instanceof COSName) {
					//out.println();
					//out.println(" Process:  "+obj.toString()+"这是一个CosName");
				}
				
				
				if(images.getItem(obj) instanceof COSDictionary) {
					
					//out.println();
					//out.println(" Process:  "+obj.toString()+"这是一个CosDictionary");
					
					COSDictionary cds=(COSDictionary) images.getItem(obj);
					
					Set<COSName> set1=cds.keySet();
					Iterator<COSName> it1=set1.iterator();
					
					while(it1.hasNext()) {
						
						COSName cosn=it1.next();
						String cosorm=cds.getCOSObject().toString();
						out.println(" Process2:  "+cosorm+cosn.toString()+"  "+":");
						
						
						
						if(Pattern.matches(".{1,40}COSStream.*", cosorm)) {
							
							out.println();
							COSStream costream=resource.getXObject(cosn).getCOSStream();
							Iterator<COSName> fis=costream.keySet().iterator();
							
							while(fis.hasNext()) {
								
								COSName cosn1=fis.next();
								//out.println("1 : "+costream.getItem(cosn1));
								
								if(resource.isImageXObject(cosn1)) {
									out.println("这是一张照片");
									//out.println();
								}
								
								if(costream.getItem(cosn1) instanceof COSStream) {
									
									//out.println();
									//out.println(" Process3:  "+cosn1.toString()+"这是一个CosStream");
									
								}
								
								if(costream.getItem(cosn1) instanceof COSName) {
									out.println();
									//out.println(" Process3:  "+cosn1.toString()+"这是一个CosName");
									
									
									
									
								}
								
								if(costream.getItem(cosn1) instanceof COSDictionary) {
									
									out.println();
									out.println(" Process3:  "+cosn1.toString()+"这是一个CosDictionary");
								
									COSDictionary cds2=(COSDictionary) costream.getItem(cosn1);
									
									Set<COSName> set2=cds2.keySet();
									Iterator<COSName> it2=set2.iterator();
									
									
									while(it2.hasNext()) {
										
										COSName cn1=it2.next();
										
										out.println(" Process4q:  "+cn1.toString()+"  "+cds2.getItem(cn1.getName()));
										if(resource.isImageXObject(cn1)) {
											//out.println("这是一张照片");
											//out.println();
										}
										if(cds2.getItem(cn1) instanceof COSArray) {
											out.println();
											out.println(" Process4:  "+cn1.toString()+"这是一个CosArray");
											
											COSArray array=(COSArray) cds2.getItem(cn1);
											
											out.println(array.getName(1));
										}
										
										if(cds2.getItem(cn1) instanceof COSName) {
											out.println();
											out.println(" Process4:  "+cn1.toString()+"这是一个CosName");
										}
										if(cds2.getItem(cn1) instanceof COSDictionary) {
											out.println();
											out.println(" Process4s:  "+cn1.toString()+"这是一个CosDictionary");
											
											COSDictionary cds3=(COSDictionary)( cds2.getItem(cn1.getName()));
											out.println("cds3"+cds2.getItem(cn1));
											Set<COSName> set3=cds3.keySet();
											Iterator<COSName> it3=set3.iterator();
											
											
											while(it3.hasNext()) {
												
												COSName cn2=it3.next();
												COSBase cosobj= cn2.getCOSObject();
												out.println(cosobj.toString());
												out.println("PRO : "+cn2.getCOSObject());
												if(resource.isImageXObject((COSName)cn2.getCOSObject())) {
													out.println("我进来l");
													PDImageXObject pdx=(PDImageXObject) resource.getXObject(cn2);
													out.println(pdx.getHeight());
													int len;
													byte[] buf=new byte[1024];
													FileOutputStream fois=new FileOutputStream( new File("C:\\Users\\22682\\Desktop\\PDF2\\PDF_"+t+".jpg"));
													
													
													t++;
													
													out.println("这是一张照片");
													out.println();
												}
												if(cds3.getItem(cn2) instanceof COSArray) {
													out.println();
													out.println(" Process4:  "+cn2.toString()+"这是一个CosArray");
													
													COSArray array=(COSArray) cds3.getItem(cn2);
													
													out.println(array.getName(1));
												}
												
												if(cds3.getItem(cn2) instanceof COSName) {
													out.println();
													out.println(" Process4:  "+cn1.toString()+"这是一个CosName");
												}
												if(cds3.getItem(cn2) instanceof COSDictionary) {
													out.println();
													out.println(" Process5:  "+cn2.toString()+"这是一个CosDictionary");
												}
												
												
											}
											
											
										}
										
										
										
									}
								
								}
								
								
								
							}
							
							
						}
						if(resource.isImageXObject(cosn)) {
							out.println("这是一张照片");
							//out.println();
						}
						
						if(cds.getItem(cosn) instanceof COSStream) {
							
							//out.println();
							//out.println(" Process2:  "+cosn.toString()+"这是一个CosStream");
							
						}
						
						if(cds.getItem(cosn) instanceof COSName) {
							//out.println();
							//out.println(" Process2:  "+cosn.toString()+"这是一个CosName");
							
							
							
							
						}
						
						if(cds.getItem(cosn) instanceof COSDictionary) {
							
							//out.println();
							//out.println(" Process2:  "+cosn.toString()+"这是一个CosDictionary");
						}
						
					}
					
					
					
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
		new Two_PDF().init();
	}
	
}
