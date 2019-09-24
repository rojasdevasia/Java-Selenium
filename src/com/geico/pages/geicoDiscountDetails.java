package com.geico.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class geicoDiscountDetails {

	protected WebDriver driver;
	public static By associationBERK=By.xpath("//input[@id='BERK']");
	public static By associationPERF=By.xpath("//input[@id='PROF']");
	public static By associationEDU=By.xpath("//input[@id='EDU']");
	public static By selctFromGroup=By.xpath("//select[@id='sponsoredMarketingSelect']");
	public static By paperlessBilling1=By.xpath("//input[@id='paperlessbilling-discounts-email']");
	public static By paperlessPolicy=By.xpath("//input[@id='paperlesspolicy-discounts-policy']");
	public static By originalAddress=By.xpath("//input[@id='originalAddress']");
	public static By submitButton=By.xpath("//button[@id='btnSubmit']");

	public geicoDiscountDetails(WebDriver driver) {
		this.driver=driver;
	}

	public void setDetails(){
		driver.findElement(associationBERK).click();
		driver.findElement(associationPERF).click();
		driver.findElement(associationEDU).click();
		
		Select g1= new Select (driver.findElement(selctFromGroup));
		g1.selectByValue("017921");
		
		driver.findElement(By.cssSelector("input[type=email]")).sendKeys("abcd@gmail.com");;
		driver.findElement(paperlessBilling1).click();
		driver.findElement(paperlessPolicy).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement originalAdd=driver.findElement(originalAddress);
		js.executeScript("arguments[0].click();", originalAdd);
		
		driver.findElement(submitButton).click();
		
	}
}
