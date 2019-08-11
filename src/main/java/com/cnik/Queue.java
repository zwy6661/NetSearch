package com.cnik;

import java.util.LinkedList;

public class Queue {

	private LinkedList queue=new LinkedList();
	
	public void enterQueue(String url) {
		queue.addLast(url);
	}
	
	public Object deQueue() {
		return queue.removeFirst();
	}
	
	public boolean isQueueEmpty() {
		
		return queue.isEmpty();
	}
	
	public boolean containQueue(String url) {
		
		return queue.contains(url);
	}
	
	
	
}
