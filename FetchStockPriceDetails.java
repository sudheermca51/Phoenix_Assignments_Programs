package javaprograms;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchStockPriceDetails {


	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");

		HashMap<String,Double> expectedHMap = new HashMap<String,Double>();
		expectedHMap.put("Hemo Organic",9.67);
		expectedHMap.put("Somi Conveyor Beltin",185.5);
		expectedHMap.put("ABC",185.5);
		Set<String> stocksKeysSet = expectedHMap.keySet();
		//stocksKeysSet.toArray();

		HashMap<String,Double> actualHMap = new HashMap<String,Double>();		
		for(String stockNameKey:stocksKeysSet)
		{
			try 
			{
				Double stockPrice = Double.parseDouble(driver.
						findElement(By.
								xpath("//a[normalize-space()='"+stockNameKey+"']/parent::td/following-sibling::td[3]")).
						getText());
				actualHMap.put(stockNameKey,stockPrice);
			}
			catch(NoSuchElementException e)
			{
						System.out.println("######StockName :::" + stockNameKey+" Not found in the UI ##########");
			}
		}

		System.out.println("Actual HashMap " + actualHMap);
		System.out.println("Expected HashMap " + expectedHMap);

		if(actualHMap.equals(expectedHMap))
		{
			System.out.println("TC Pass");
		}
		else
		{
			System.out.println("TC Fails");
		}
	}

}
