package com.sauceDemoEcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCart {
	
	WebDriver ldriver;

	public YourCart(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "#checkout")
	WebElement CheckOut;
	
	public void Checkout() {
		CheckOut.click();
	}

}
