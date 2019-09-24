package com.geico.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Guice;

import com.geico.base.TestbaseSetup;
import com.geico.pages.geicoAddVehicles;
import com.geico.pages.geicoEnterDetails;
import com.geico.pages.geicoHome;

public class geicoAddVehiclesTest extends TestbaseSetup {
	
	private WebDriver driver;
	private geicoHome geicoHme;
	private geicoEnterDetails geicoDtls;
	private geicoAddVehicles geicoVehicles;
	
	@BeforeClass
	public void setUp(){
		driver=getDriver();
	}
	
	@Test(dataProvider="loadData",dataProviderClass=TestbaseSetup.class)
	public void addVehicle(String Zip,String FirstName,String LastName,String Street,String Apt,String	DOBMonth,String	DOBDay,String DOBYear, String Year, String Make, String Model){
		geicoHme=new geicoHome(driver);
		geicoDtls=geicoHme.enterZipAndNext(Zip);
		geicoDtls.setDetails(FirstName,LastName,Street,Apt,DOBMonth,DOBDay,DOBYear);
		geicoVehicles=geicoDtls.clickNext();
		
		Assert.assertTrue(geicoVehicles.verifyPageTitle(), "Page Title do not match");
		geicoVehicles.setDetails(Year,Make,Model);
	
	}
}

