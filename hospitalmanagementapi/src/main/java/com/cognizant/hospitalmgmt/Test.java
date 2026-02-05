package com.cognizant.hospitalmgmt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ConcurrentHashMap<Long, String> map = new ConcurrentHashMap<>();
       map.put(1L, "One");
       map.put(2L, "Two");
       map.put(3L, "Three");
       
       Iterator<Entry<Long,String>> itr=map.entrySet().iterator();
       while(itr.hasNext()) {
		   Entry<Long, String> entry=itr.next();
		   System.out.println(entry.getKey()+" "+entry.getValue());
		   map.put(4L, "Four");
		   map.put(5L, "Five");
	   }
		
	}

}
