package com.geico.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.geico.base.TestbaseSetup;
import com.geico.pages.geicoEnterDetails;
import com.geico.pages.geicoHome;

public class geicoEnterDetailsTest extends TestbaseSetup {
	
	private WebDriver driver;
	private geicoHome geicoHme;
	private geicoEnterDetails geicoDtls;
	
	@BeforeClass
	public void setUp(){
		driver=getDriver();
	}
	
	@Test(dataProvider="loadData",dataProviderClass=TestbaseSetup.class)
	public void VerifyDetail(String Zip,String FirstName,String LastName,String Street,String Apt,String DOBMonth,String DOBDay,String DOBYear) throws InterruptedException{
		Assert.assertTrue("page title not matching", geicoDtls.verifyPageTitle());
		geicoDtls.checkDialogue();
		geicoDtls.setDetails(FirstName,LastName,Street,Apt,DOBMonth,DOBDay,DOBYear);
		Assert.assertTrue("CITY not matching", geicoDtls.validateCity());
		Assert.assertTrue("ZIP CODE not matching", geicoDtls.validateZip());
		geicoDtls.clickNext();
		
	}

}
