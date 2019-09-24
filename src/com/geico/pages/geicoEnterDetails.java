package com.geico.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class geicoEnterDetails {
	protected WebDriver driver;
	
	public static By assistDialogue = By.xpath("//div[@id='modal-dialog-intro-overlay']/div[2]/div]");
	public static By assistDialogueClose = By.xpath("//div[@id='modal-dialog-intro-overlay']/div[2]/button");

	public static By firstname=By.xpath("//input[@id='firstName']");
	public static By lastname=By.xpath("//input[@id='lastName']");
	public static By street=By.xpath("//input[@id='street']");
	public static By apt=By.xpath("//input[@id='apt']");
	public static By cityState=By.xpath("//input[@id='cityState']");
	public static By zipCode=By.xpath("//input[@id='zip']");

	public static By month=By.xpath("//input[@id='date-monthdob']");
	public static By day=By.xpath("//input[@id='date-daydob']");
	public static By year=By.xpath("//input[@id='date-yeardob']");

	public static By submitClick=By.xpath("//button[@id='btnSubmit']");
	public static By Dialogue=By.xpath("//div[@id='modal-dialog-intro-overlay']/div[2]/div");
	public static By DialogueClose=By.xpath("//div[@id='modal-dialog-intro-overlay']/div[2]/button");
	
	public geicoEnterDetails(WebDriver driver){
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
	
	public void checkDialogue() throws InterruptedException{
		
		if (driver.findElement(By.xpath("Dialogue")) != null)
		  {
			  WebElement element1 = driver.findElement(By.xpath("DialogueClose"));
			  Actions actions = new Actions(driver);
			  actions.moveToElement(element1).click().perform();
		  }
	}

	public void setDetails(String FirstName,String LastName,String Street,String Apt,String	DOBMonth,String	DOBDay,String DOBYear){
		driver.findElement(firstname).sendKeys(FirstName);
		driver.findElement(lastname).sendKeys(LastName);
		driver.findElement(street).sendKeys(Street);
		driver.findElement(apt).sendKeys(Apt);
		driver.findElement(month).sendKeys(DOBMonth);
		driver.findElement(day).sendKeys(DOBDay);
		driver.findElement(year).sendKeys(DOBYear);
	}
	
	public boolean validateCity(){
		String cityName="Stevens Point, WI";
		String cityNameFound=driver.findElement(cityState).getAttribute("value");
		return driver.findElement(cityState).getAttribute("value").contains(cityName);
	}
	
	public boolean validateZip(){
		String zip1="54481";	
		String zipFound=driver.findElement(zipCode).getAttribute("value");
		return driver.findElement(zipCode).getAttribute("value").contains(zip1);
	}
	
	public geicoAddVehicles clickNext(){
		driver.findElement(submitClick).click();
		return new geicoAddVehicles(driver);
	}
	
	
}
