package org.iitwf.healthcare.mmpphoenix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests {

	WebDriver driver;
	@Test
	public void validateBookAppointment()
	{
		
			driver = new ChromeDriver();
			driver.get("http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.name("submit")).click();
			clickMenu("Schedule Appointment");
			driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
			
			//selecting the button by considering the doctor name
			//h4[text()='Dr.Smith']/ancestor::td/following-sibling::button
			
			//selecting the book button by considering the specialization and doctorname
			//p[contains(text(), 'Description:Cardiologist')]/parent::div/preceding-sibling::h4[text()='Dr.Sophia Rich']/ancestor::ul/following-sibling::button
			bookAppointment("Smith");
			String date = FutureDateEx.getDate(30,"MM/DD/YYYY");
			System.out.println("Future Date" + date);
			//switch to a frame
			//click on date textbox
								//datepicker is opening
			//current date and future date 
			//future year = 2025
			//future month= April  
			//current year = 2025 //span[@class='ui-datepicker-year']
			//current month = March //span[@class='ui-datepicker-month']
			
			//#condition 1 futureyear!= currentyear
							//click on next
			//#condition 2 futuremonth!=currentmonth
							//click on next 
			//select the day 
			
			 
	
	}
	public void clickMenu(String menuName)
	{

		driver.findElement(By.xpath("//span[normalize-space()='"+menuName+"']")).click();

	}
	public void bookAppointment(String specialization,String doctorName)
	{
		driver.findElement(By.
				xpath("//p[contains(text(), 'Description:"+specialization+"')]/parent::div/preceding-sibling::h4[text()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
	}
	public void bookAppointment(String doctorName)
	{
		driver.findElement(By.
				xpath("//h4[text()='Dr."+doctorName+"']/ancestor::td/following-sibling::button")).click();
		
	}
}
