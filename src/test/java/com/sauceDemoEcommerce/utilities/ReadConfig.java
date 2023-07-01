package com.sauceDemoEcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;




public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration Files/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		
		catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
		 
	}
	
	public String GetCurrentUrl() {
		String BaseUrl = pro.getProperty("URL");
		return BaseUrl;
	}
	
	public String Password() {
		String BasePassword = pro.getProperty("passWord");
		return BasePassword;
	}
	
	public String UserName() {
		String BaseuserName = pro.getProperty("userName");
		return BaseuserName;
	}
	
	public String ChromeDriver() {
		String BaseChropath = pro.getProperty("ChroPath");
		return BaseChropath;
	}
	
	public String FirefoxDriver() {
		String BaseFirepath = pro.getProperty("FirePath");
		return BaseFirepath;
	}
	
	public String IeDriver() {
		String BaseIePath = pro.getProperty("IePath");
		return BaseIePath;
	}
	
	public String FirstName() {
		String FirstName = pro.getProperty("FirstName");
		return FirstName;
	}
	
	public String Surname() {
		String Surname = pro.getProperty("LastName");
		return Surname;
	}
	
	public String PostalCode() {
		String Pincode = pro.getProperty("PinCode");
		return Pincode;
	}
	
}
