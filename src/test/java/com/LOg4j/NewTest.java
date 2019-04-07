package com.LOg4j;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class NewTest {
	public WebDriver driver;
	@BeforeTest
	public void beforeLaunch2() {
		System.setProperty("webdriver.chrome.driver","G:\\file_new\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ultimatix.net");
		System.out.println("Hello=dfssdfdgret");
	}
	

	@Test(dataProvider="LoginProvider")
	public void testDemo(String username, String password) throws InterruptedException
		{
			System.out.println("Hello");
			WebElement user = driver.findElement(By.id("USER"));
			user.sendKeys(username);
			WebElement pass = driver.findElement(By.id("PASSWORD"));
			pass.sendKeys(password);
			driver.findElement(By.id("login_button")).click();
			String testValue = user.getAttribute("value");
			System.out.println(testValue + "::::" + username);
		String testValue1 = pass.getAttribute("value");
			System.out.println(testValue1 + "::::" + password);
			Thread.sleep(2000);
		}
	



 

			
			static Workbook book;
			static Sheet sheet;
			public static String TESTDATA_SHEET_PATH = "‪C:\\Users\\ABC\\Desktop\\TestData.xls";
			public static Object[][] SearchProvider(String sheetName) {
				FileInputStream file = null;
				try {
					file = new FileInputStream(TESTDATA_SHEET_PATH);
				} catch (FileNotFoundException e) {
				}

				try {
					book = WorkbookFactory.create(file);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				Sheet sheet = book.getSheet(sheetName);
				Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				for (int i = 0; i < sheet.getLastRowNum(); i++) {

					for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
						data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					}

				}

				return data;
			}
			
			 @DataProvider(name = "LoginProvider")
 
			 
				public Object[][] SearchProvider() {
					Object data[][] =NewTest.SearchProvider("Sheet1");
					return data;
			}
	
}

