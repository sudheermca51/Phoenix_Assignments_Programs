package org.iitwf.healthcare.mmpphoenix;

import java.util.Random;

public class RandomEx {
	 
	
	public static void main(String[] args) {
		
		
		Random rand = new Random();
		int value = 1+rand.nextInt(100);
		System.out.println(value);
		
		//50 to 100
		//LB+rand.nextInt(UB-LB+1)
		value = 50+rand.nextInt(100-50+1);
		System.out.println(value);
		
		//60 to 200
		value = 60+rand.nextInt(200-60+1);
		System.out.println(value);
	}

}
 
