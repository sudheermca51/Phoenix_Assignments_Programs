package org.iitwf.healthcare.mmpphoenix;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTests {


	WebDriver driver;
	String webDriverURL = "http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";

	@BeforeClass
	public void invokeApp()
	{
		driver = new ChromeDriver();

	}

	@Test(priority=1)
	public void validateEditLName() {
		driver.get(webDriverURL);
		login();
		clickMenu("Profile");
		driver.findElement(By.id("Ebtn")).click();
		WebElement lnameWE = driver.findElement(By.id("lname"));
		lnameWE.clear();
		String expectedText = RandomUtils.generateRandomString(8);
		lnameWE.sendKeys(expectedText);
		driver.findElement(By.id("Sbtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println("Alert message :: " + alert.getText());
		alert.accept();
		String actualText = lnameWE.getDomAttribute("value");
		Assert.assertEquals(actualText,expectedText);
	}
	@Test(priority=2)
	public void validateEditFName() {
		launchBrowser();
		login();
		clickMenu("Profile");
		String expectedText = RandomUtils.generateRandomString(8);
		String actualText = editFirstName(expectedText);
		Assert.assertEquals(actualText,expectedText);
	}
	public void launchBrowser()
	{
		driver.get(webDriverURL);
	}
	public String editFirstName(String expectedText)
	{
		driver.findElement(By.id("Ebtn")).click();
		WebElement fnameWE = driver.findElement(By.id("fname"));
		fnameWE.clear();
		 
		fnameWE.sendKeys(expectedText);
		driver.findElement(By.id("Sbtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println("Alert message :: " + alert.getText());
		alert.accept();
		String actualText = fnameWE.getDomAttribute("value");
		return actualText;
	}
	@Test(priority = 3,enabled=false)
	public void validateErrMsg() throws InterruptedException {

		driver.get(webDriverURL);
		login();
		clickMenu("Profile");

	 
		String expErrMsg = "please enter only alphabets";
		String expBlankErrMsg = "please enter Last name";
		driver.findElement(By.id("Ebtn")).click();
		WebElement ele_fname = driver.findElement(By.id("fname"));
		ele_fname.clear();
		ele_fname.sendKeys(RandomUtils.generateRandomInteger(10, 500)+"");
		driver.findElement(By.id("Sbtn")).click();
		String actErrMsg = driver.findElement(By.id("firsterr1")).getText().trim();
		System.out.println("Expected Error Message :: " + expErrMsg);
		System.out.println("Actual Error Message :: " + actErrMsg);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actErrMsg, expErrMsg);

		WebElement ele_lname = driver.findElement(By.id("lname"));
		ele_lname.clear();
		System.out.println("Actual LastName ::" + ele_lname.getDomAttribute("value"));
		driver.findElement(By.id("Sbtn")).click();
		String actBlankErrMsg = driver.findElement(By.id("lasterr")).getText().trim();
		System.out.println("Expected Error Message :: " + expBlankErrMsg);
		System.out.println("Actual Error Message :: " + actBlankErrMsg);
		sa.assertEquals(actBlankErrMsg, expBlankErrMsg);

		sa.assertAll();
		driver.close();
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
 
	public void login()
	{
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
	}
	public void clickMenu(String menuName)
	{

		driver.findElement(By.xpath("//span[normalize-space()='"+menuName+"']")).click();

	}
}
//
//Test Steps:
//1. Open the url 
//2. Login 
//3. Click on Profile
//4. Click and Edit 
//5. Clear and Update the First name- FnameRandString
//6. Click on Save.
//7. Accept the OK button in the Alert.
//8. Fetch the Firstname and validate the data entered in Step#5 should match
//the data displayed after saving the profile.
//
//Expected Result :
//FnameRandString
//
//Actual Result: 
//FnameRandString
//
//Status:
//Pass 