package com.sauceDemoEcommerce.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sauceDemoEcommerce.pageObjects.LoginPage;
import com.sauceDemoEcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends baseClass{
	
	@Test(dataProvider = "Login Data")
	public void Login(String user, String pwd) {
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is provided");
		lp.setUserPassword(pwd);
		logger.info("Password is provided");
		lp.logIN();
		logger.info("Logged in to the Homepage");
		
	}

	@DataProvider(name = "Login Data")
	public static String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\sauceDemoEcommerce\\testData\\Login Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cellnum = XLUtils.getCellCount(path, "Sheet1", rownum);
		String[][] loginData = new String[rownum][cellnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<cellnum;j++) {
				loginData[i-1][j]= XLUtils.getCellValue(path, "Sheet1",i, j);
			}
		}
		return loginData;
	}
	
	
}
