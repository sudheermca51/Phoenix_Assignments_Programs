package org.iitwf.healthcare.mmpphoenix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
			 
			
			
			//switch to a frame
			driver.switchTo().frame("myframe");
			//click on date textbox
			//datepicker is opening
			 
			driver.findElement(By.id("datepicker")).click();
			
			String date = FutureDateEx.getDate(365,"MMMM/d/YYYY");
			System.out.println("Future Date" + date);
			//expected date and actual date 
			String expectedYear = date.split("/")[2];
			String expectedMonth=date.split("/")[0];
			String expectedDay = date.split("/")[1];
			System.out.println("Expected Year:::" + expectedYear);//2025
			System.out.println("Expected Month:::" + expectedMonth);//04
			System.out.println("Expected Day:::" + expectedDay);//21
			
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			while (!expectedYear.equals(actualYear)) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();
			}
			while (!expectedMonth.equals(actualMonth)) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();
			}

			driver.findElement(By.linkText(expectedDay)).click();
			
			Select timeSelect  = new Select(driver.findElement(By.xpath("//select[@id='time']")));

			timeSelect.selectByVisibleText("11Am");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("status"),"OK")); 
			
			
			driver.findElement(By.id("ChangeHeatName")).click();
			driver.switchTo().defaultContent(); // you are now outside both frames
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit']"))); 
			 
			driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys("Cold, cough and fever");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3[@class='panel-title']']"),"Patient Portal")); 
			
			String actualOutput = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1])")).getText();
			
			System.out.println("Actual Output" +actualOutput );
	
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
				xpath("//h4[text()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		
	}
}
