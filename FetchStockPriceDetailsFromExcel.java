package javaprograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchStockPriceDetailsFromExcel {

	//Different results from the same action modelled as different methods

	public static HashMap<String,Double> getData(String fileName) throws IOException
	{
		HashMap<String,Double> expectedHMap = new HashMap<String,Double>();

		File f = new File(fileName);
		FileInputStream fis  = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) 
		{
			XSSFRow row = sheet.getRow(i);
			Cell keyCell = row.getCell(0); // Assuming the first column is the key
			Cell valueCell = row.getCell(1); // Assuming the second column is the value

			if (keyCell != null && valueCell != null) 
			{
				String key = keyCell.getStringCellValue();
				Double value = valueCell.getNumericCellValue();
				expectedHMap.put(key, value);
			}
		}

		return expectedHMap;
	}

	public static void main(String args[]) throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");

		HashMap<String,Double> expectedHMap = getData("stockdata.xlsx");

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
