package com.geico.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jetty.http.BadMessageException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestbaseSetup {
	
	private  WebDriver driver;
	private Properties prop;
	static String chromeDriverPath = "C:\\eclipse\\chromedriver_win32\\chromedriver.exe";
	static String firefoxDriverPath = "C:\\eclipse\\geckodriver.exe";
	static String filePath=System.getProperty("user.dir")+"//dataFile.properties";

	public  WebDriver getDriver(){
		return driver;
	}
	
	private static WebDriver initChromeDriver(String appURL){
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver=new ChromeDriver();
		driver.navigate().to(appURL);
		return driver;	
	}
	
	private void setDriver(String browserType,String appURL){
		switch(browserType){
		case "chrome":
			driver=initChromeDriver(appURL);
			break;
		default:
			System.out.println("Invalid browser");
			}
		}
	
	@DataProvider(name="loadData")
	public Object[][] testData() {
		Object[][] arrayObject = getExcelData("C:\\eclipse\\GeicoTestData.xls","Sheet2");
		return arrayObject;
	}
	
	public Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = null;
			try {
				wb = Workbook.getWorkbook(fs);
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new Object[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BadMessageException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	@BeforeSuite
	public void initializeTestBaseSetup() {
		System.out.println("*********************BEFORE SUITE************************");
		
		File propFile= new File("C:\\Users\\rdevasia\\workspace\\com.geico\\dataFile.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propFile);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String browser=prop.getProperty("browserType");
		String URL=prop.getProperty("appURL");
		setDriver(browser, URL);
		}
		
	@AfterSuite
	public void tearDown() {
		driver.quit();
		}
}
