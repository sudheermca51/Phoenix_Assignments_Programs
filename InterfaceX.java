package org.iitwf.healthcare.mmpphoenix;

public interface InterfaceX {
	
	//abstract
	public void m1();
	
	public static void m2()
	{
		
	}
	default void m3()
	{
		System.out.println("hello");
	}

}

class SimpleEx implements InterfaceX{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		
		SimpleEx s1 = new SimpleEx();
		s1.m3();
	}
	
	
	
}
