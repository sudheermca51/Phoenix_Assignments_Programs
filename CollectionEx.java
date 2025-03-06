package javaprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionEx {
	
	public static void main(String[] args) {
		
		
		Set<Integer> exSet = new HashSet<Integer>();
		exSet.add(10);
		exSet.add(20);
		exSet.add(30);
		exSet.add(30);
		System.out.println("Size of the Set   " + exSet.size());
		System.out.println("Printing the Set of Values");
		for(Integer i : exSet)
		{
			System.out.println(i);
		}
		
		
		List<Integer> exList = new ArrayList<Integer>();
		exList.add(10);
		exList.add(20);
		exList.add(30);
		exList.add(30);
		System.out.println("Size of the List   " + exList.size());
		System.out.println("Printing the List of Values");
		for(int i=0;i<exList.size();i++)
		{
			System.out.println(exList.get(i));
		}
		
		
		
		HashMap<String,Integer> expectedHMap = new HashMap<String,Integer>();
		expectedHMap.put(null, -6);
		expectedHMap.put("John", 50);
		
		System.out.println(expectedHMap.get("James"));
		System.out.println(expectedHMap);
		
		HashMap<String,Integer> actualHMap = new HashMap<String,Integer>();
		actualHMap.put("John", 50);
		actualHMap.put("James", 63);
		
		if(actualHMap.equals(expectedHMap))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Printing the values of the HashMap using loop
		Set<String> keys= expectedHMap.keySet();
		
		for(int i=0;i< keys.size();i++)
		{
			
		}
		for(String s : keys)
		{
			System.out.println("keys" + s);
		}
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
