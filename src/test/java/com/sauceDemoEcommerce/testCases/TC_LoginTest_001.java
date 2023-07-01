package com.sauceDemoEcommerce.testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.sauceDemoEcommerce.pageObjects.LoginPage;
import com.sauceDemoEcommerce.utilities.Reporting;


public class TC_LoginTest_001 extends baseClass{
	
	@ Test
	public void Login() {
		driver.get(URL);
		logger.info("URL is entered");
		
		LoginPage lp = new com.sauceDemoEcommerce.pageObjects.LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username is added");
		
		lp.setUserPassword(passWord);
		logger.info("Password is added");
		
		lp.logIN();
		logger.info("Logged in to Homepage");
		
		
	}

}
