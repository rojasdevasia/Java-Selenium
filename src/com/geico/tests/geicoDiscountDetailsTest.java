package com.geico.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.geico.base.TestbaseSetup;
import com.geico.pages.geicoAddVehicles;
import com.geico.pages.geicoDiscountDetails;
import com.geico.pages.geicoDriverDetails;
import com.geico.pages.geicoEnterDetails;
import com.geico.pages.geicoHome;

public class geicoDiscountDetailsTest extends TestbaseSetup{
	
	protected WebDriver driver;
	private geicoHome geicoHme;
	private geicoEnterDetails geicoDtls;
	private geicoAddVehicles geicoVehicles;
	private geicoDriverDetails geicoDriverDtls;
	private geicoDiscountDetails geicoDiscountDtls;
	
	@BeforeClass
	public void setup(){
		driver=getDriver();
	}
	
	@Test(dataProvider="loadData",dataProviderClass=TestbaseSetup.class)
	public void addDriver(String Zip,String FirstName,String LastName,String Street,String Apt,String	DOBMonth,String	DOBDay,String DOBYear, String Year, String Make, String Model){
		geicoHme=new geicoHome(driver);
		
		geicoDtls=geicoHme.enterZipAndNext(Zip);
		geicoDtls.setDetails(FirstName,LastName,Street,Apt,DOBMonth,DOBDay,DOBYear);
		Assert.assertTrue(geicoDtls.validateCity(), "City Name do not match");
		Assert.assertTrue(geicoDtls.validateZip(), "Zip Code do not match");
		
		geicoVehicles=geicoDtls.clickNext();
		Assert.assertTrue(geicoVehicles.verifyPageTitle(), "Page Title do not match");
		
		geicoDriverDtls=geicoVehicles.setDetails(Year,Make,Model);
		geicoDriverDtls.verifyPageTitle();
		String militaryValue=geicoDriverDtls.setDetails();
		Assert.assertEquals(militaryValue, "DNA");
		
		geicoDiscountDtls=geicoDriverDtls.clickNext();
		geicoDiscountDtls.setDetails();
	}


}
