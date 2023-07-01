package com.sauceDemoEcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformation {
	
WebDriver ldriver;
	
	public PaymentInformation(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = ".summary_info div")
	List<WebElement> PaymentInformation;
	
	@FindBy(css = "#finish")
	WebElement Finish;
	
	public void Payment() {
		for(int i=0;i<PaymentInformation.size()-1;i++) {
			System.out.println(PaymentInformation.get(i).getText());
		}
	}
	
	public void CloseTab() {
		Finish.click();
	}

}
