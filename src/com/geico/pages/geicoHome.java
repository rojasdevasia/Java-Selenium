package com.geico.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class geicoHome {
	
	protected WebDriver driver;
	public static By zipcode = By.xpath("//input[@id='zip']");
	public static By startQuote = By.xpath("//form[@id='quoteForm']/a[@id='submitButton']");
	
	public geicoHome(WebDriver driver){
		this.driver=driver;
	}
	
	public geicoEnterDetails enterZipAndNext(String Zip){
		driver.findElement(zipcode).sendKeys(Zip);
		driver.findElement(startQuote).click();
		return new geicoEnterDetails(driver);
	}
}
