package com.geico.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class geicoAddVehicles {
	
	protected WebDriver driver;
	public static By vehicleYear=By.xpath("//select[@id='vehicleYear']");
	public static By vehicleMake=By.xpath("//select[@id='vehicleMake']");
	public static By vehicleModel=By.xpath("//select[@id='vehicleModel']");
	
	public static By vehicleOwned=By.xpath("//input[@id='vehicleOwned0']");
	public static By vehicleUsage=By.xpath("//input[@id='primaryUse2']");
	public static By businessUsage=By.xpath("//select[@id='typeOfBusinessUse']");
	public static By submitButton=By.xpath("//button[@id='btnSubmit']");
	

	public geicoAddVehicles(WebDriver driver) {
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
	
	public geicoDriverDetails setDetails(String Year,String Make,String Model){
		Select yearDropDown=new Select(driver.findElement(vehicleYear));
		yearDropDown.selectByValue(Year);
		
		Select makeDropDown=new Select(driver.findElement(vehicleMake));
		makeDropDown.selectByValue(Make);
		
		Select modelDropDown=new Select(driver.findElement(vehicleModel));
		modelDropDown.selectByValue(Model);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement ownedRadioButton = driver.findElement(vehicleOwned);
		js.executeScript("arguments[0].click();", ownedRadioButton);
		
		WebElement usageRadioButton = driver.findElement(vehicleUsage);
		js.executeScript("arguments[0].click();", usageRadioButton);
		
		Select businessUsgaeDropDown=new Select(driver.findElement(businessUsage));
		businessUsgaeDropDown.selectByValue("001");
		
		driver.findElement(submitButton).click();
		return new geicoDriverDetails (driver);
		
		
	}
}
