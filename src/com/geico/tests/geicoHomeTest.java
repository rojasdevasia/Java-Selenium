package com.geico.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.geico.base.TestbaseSetup;
import com.geico.pages.geicoHome;

public class geicoHomeTest extends TestbaseSetup{

	private WebDriver driver;
	
	@BeforeClass
	public void setup(){
		driver=getDriver();
	}
	
	@Test(dataProvider="loadData",dataProviderClass=TestbaseSetup.class)
	public void verifyHome(String Zip){
		geicoHome geicoHme= new geicoHome(driver);
		geicoHme.enterZipAndNext(Zip);
	}
}
