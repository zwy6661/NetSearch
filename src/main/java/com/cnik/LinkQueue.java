package com.cnik;

import java.util.HashSet;
import java.util.Set;

public class LinkQueue {
	
	private static Set visitedUrl=new HashSet();
	private static Queue unvisitedUrl=new Queue();
	
	public static Queue getUnVisitUrl() {
		
		return unvisitedUrl;
		
	}
	
	public static void addVisiterUrl(String url) {
		
		visitedUrl.add(url);
	}
	
	public static void removeVisitedUrl(String url) {
		
		visitedUrl.remove(url);
		
	}
	
	public static Object unVisitedUrlDeQueue() {
		
		return unvisitedUrl.deQueue();
		
		
	}
	
	public  static void addUnvisitedUrl(String url) {
		
		if(url!=null&&!url.trim().equals("")
				&&!visitedUrl.contains(url)
				&&!unvisitedUrl.containQueue(url)) {
			unvisitedUrl.enterQueue(url);
		}
		
	}
	
	
	public static int getVisitedNum() {
		
		return visitedUrl.size();
		
	}
	
	public static boolean unVisitedUrlEmpty() {
		
		return unvisitedUrl.isQueueEmpty();
		
	}
	
}
