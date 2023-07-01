package com.sauceDemoEcommerce.testCases;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sauceDemoEcommerce.pageObjects.HomePage;
import com.sauceDemoEcommerce.pageObjects.LoginPage;
import com.sauceDemoEcommerce.pageObjects.PaymentInformation;
import com.sauceDemoEcommerce.pageObjects.YourCart;
import com.sauceDemoEcommerce.pageObjects.YourInformation;

public class TC_AddToCart_003 extends baseClass {
	
	public HomePage hp;
	
	@ Test
	public void Login() {
		driver.get(URL);
		logger.info("URL is entered");
		
		LoginPage lp = new com.sauceDemoEcommerce.pageObjects.LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username is added for test case 3");
		
		lp.setUserPassword(passWord);
		logger.info("Password is added for test case 3");
		
		lp.logIN();
		logger.info("Logged in to Homepage for test case 3");
		
	}

	@Test(dependsOnMethods = {"Login"} )
	public void AddToCart(){
	hp = new HomePage(driver);
	hp.AddCart();
	logger.info("Products are added");
	}
	
	@Test(dependsOnMethods = {"AddToCart"})
	public void GoToCart() {
		hp.ListCart();
		logger.info("Moved to cart");
	}
	
	@Test(dependsOnMethods = {"GoToCart"} )
	public void CheckOut() {
		YourCart cart = new YourCart(driver);
		cart.Checkout();
	}
	
	@Test(dependsOnMethods = {"CheckOut"} )
	public void AddInformation() {
		YourInformation infor = new YourInformation(driver);
		infor.AddYourInformation(Name, Surname, PostalCode);
		infor.ContinueButton();
	}
	
	@Test(dependsOnMethods = {"AddInformation"})
	public void Payment() {
		PaymentInformation pay = new PaymentInformation(driver);
		pay.Payment();
		pay.CloseTab();
	}
	
	}

