package com.sauceDemoEcommerce.pageObjects;

import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'inventory_item']/div[2]/div[2]/button")
	List<WebElement> AddToCart;
	
	@FindBy(css = ".shopping_cart_link")
	WebElement YourCart;
	
	
	public void AddCart(){
		Iterator<WebElement> It = AddToCart.iterator();
		while(It.hasNext()==true) {
			It.next().click();
		}
	}
		
	public void ListCart() {
		YourCart.click();
	}


}
