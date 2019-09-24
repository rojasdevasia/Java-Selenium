package com.geico.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class geicoDriverDetails {

	protected WebDriver driver;
	
	public static By maritalStatus=By.xpath("//select [@id='maritalStatus']");
	public static By driverName=By.xpath("//div/span[@id='applicantName']");
	public static By genderSelect=By.xpath("//input[@id='gender1']");
	public static By ssn=By.xpath("//input[@name='ssn']");
	public static By hasAutoInsurance=By.xpath("//select[@id='hasAutoInsurance']");
	public static By licensedBefore=By.xpath("//input[@id='licensedBeforeCertainAge1']");
	public static By student=By.xpath("//input[@id='fullTimeStudent0']");
	public static By studentType=By.xpath("//select[@id='typeOfStudent']");
	public static By military=By.xpath("//select[@id='militaryAffiliation']");
	public static By submit=By.xpath("//button[@id='btnSubmit']");
	public static By ageFirstLicesned=By.xpath("//input[@id='ageFirstLicensed']");
	public static By ageFirstLicensedError=By.xpath("//label[@id='ageFirstLicensed-error']");
	public static By licenseDateMonth=By.xpath("//input[@name='DriverForm:firstLicensedUSDate1Month']");
	public static By licenseDateDay=By.xpath("//input[@name='DriverForm:firstLicensedUSDate1Day']");
	public static By licenseDateYear=By.xpath("//input[@name='DriverForm:firstLicensedUSDate1Year']");
	public static By dateFirstLicensed=By.xpath("//select[@id='dateFirstLicensed']");

	public geicoDriverDetails(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyPageTitle() {
		String pageTitle = "GEICO";
		return getPageTitle().contains(pageTitle);
	}
	
	public String setDetails(){
	Select ms = new Select(driver.findElement(maritalStatus));
	ms.selectByValue("M");
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement gender=driver.findElement(genderSelect);
	js.executeScript("arguments[0].click();", gender);
	
	driver.findElement(ssn).sendKeys("546-44-5678");
	
	Select autoIns=new Select(driver.findElement(hasAutoInsurance));
	autoIns.selectByValue("D");
	
	WebElement licensedBefore1=driver.findElement(licensedBefore);
	js.executeScript("arguments[0].click();", licensedBefore1);
	
	driver.findElement(ageFirstLicesned).sendKeys("35");
	driver.getPageSource().contains("Review the age this driver first obtained a driver's license. The age this driver first became licensed cannot be greater than current age of the driver");
	
	driver.findElement(ageFirstLicesned).clear();
	driver.findElement(ageFirstLicesned).sendKeys("28");
	
	Select dateFirstLicensed1=new Select(driver.findElement(dateFirstLicensed));
	dateFirstLicensed1.selectByValue("02/23/2012");
	
	WebElement student1=driver.findElement(student);
	js.executeScript("arguments[0].click();", student1);

	Select st1=new Select(driver.findElement(studentType));
	st1.selectByValue("LAW");
	
	String militaryValue=driver.findElement(military).getAttribute("value");
	System.out.println("Military Affiliation Value is :" +militaryValue);
	return militaryValue;
	}	
	
	public geicoDiscountDetails clickNext(){
		driver.findElement(submit).click();
		return new geicoDiscountDetails(driver);
	}

}
