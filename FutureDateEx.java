package org.iitwf.healthcare.mmpphoenix;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FutureDateEx {
	
	
	/**
	 * 
	 * https://www.facebook.com/r.php?entry_point=login
	 * @param args
	 */
	public static void main(String[] args) {
		
	 
		getDate(30,"MM/dd/YYYY");
		getDate(0,"dd-MM-YYYY");
		String formattedDate= getDate(-365,"dd-MMM-YYYY");
		String dateArray[]=formattedDate.split("-");
		String day = dateArray[0];
		String month= dateArray[1];
		String year=dateArray[2];
		
		
		 
		
		getDate(10,"dd-MMMM-YYYY");
		
	}
	public static String getDate(int n,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, n);
		Date date = cal.getTime();
		
		//format date
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(date);
		System.out.println("The formattedDate for the "+format +" is -->"+formattedDate);
		return formattedDate;
	}

}
