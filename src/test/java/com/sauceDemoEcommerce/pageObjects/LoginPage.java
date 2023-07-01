package com.sauceDemoEcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath ="//input[@id = 'user-name']")
	WebElement userName;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement passWord;
	
	@FindBy (xpath ="//input[@id='login-button']")
	WebElement logIN;
	
	public void setUserName(String name) {
		userName.sendKeys(name);
	}
	
	public void setUserPassword (String password) {
		passWord.sendKeys(password);
	}
	
	public void logIN() {
		logIN.click();
	}
	
}
