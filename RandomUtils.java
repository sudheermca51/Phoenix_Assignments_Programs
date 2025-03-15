package org.iitwf.healthcare.mmpphoenix;

import java.util.Random;

public class RandomUtils {
	
	public static int generateRandomInteger(int min,int max)
	{
		Random rand = new Random();
		//LB+rand.nextInt(UB-LB+1)
		int value = min+rand.nextInt(max-min+1);
		//System.out.println(value);
		return value;
	}

	public static String generateRandomString(int n)
	{
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		System.out.println("Length of the string"+ str.length());
		 
		StringBuilder randomString=new StringBuilder(n);
		int min=0,max=str.length()-1;
	 
		for(int i=0;i<10;i++)
		{
			int randomIndex= generateRandomInteger(min,max);
			char ch = str.charAt(randomIndex);
			randomString.append(ch+"");
			
		}
		System.out.println("Random String::" + randomString);
		return randomString.toString();
	}
	
	public static void main(String[] args) {
		
		 String randomEmailID="AUT_"+generateRandomString(5)+generateRandomInteger(50,100)+"@gmail.com";
		 System.out.println(randomEmailID);
		 
	}
}
