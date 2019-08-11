package com.pdf;

import java.util.Scanner;
import static java.lang.System.*;
public class PDF2Image {

	    public static void main(String[]a){
	    	
	    	long cur=currentTimeMillis();
	    	//Scanner scan=new Scanner(in);
	        double sum=0;
	        double n=80000000;
	        
	        double m=25;
	         
	        if(n%(2*m)!=0){
	            
	        }else{
	           
	            int flag=-1;
	           
	            for(int i=1,j=0;i<=n;j++,i++){
	                if(j!=0&&j%m==0) {
	                	flag=-flag;
	                }
	            	
	                  
	                
	                  sum+=(i*flag);
 
	                
	            }
	        }
	        out.println((int)sum);
	        out.println((currentTimeMillis()-cur));
	    }
	
}
