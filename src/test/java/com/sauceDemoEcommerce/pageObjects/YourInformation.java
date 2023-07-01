package com.sauceDemoEcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformation {
	
WebDriver ldriver;
	
	public YourInformation(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="#first-name")
	WebElement FirstName;
	
	@FindBy(css="#last-name")
	WebElement LastName;
	
	@FindBy(css="#postal-code")
	WebElement PostalCode;
	
	@FindBy(css="#continue")
	WebElement Continue;
	
	public void AddYourInformation(String name, String surname, String pincode) {
		FirstName.sendKeys(name);
		LastName.sendKeys(surname);
		PostalCode.sendKeys(pincode);
	}
	
	public void ContinueButton() {
		Continue.click();
	}

}
