package com.sauceDemoEcommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.sauceDemoEcommerce.utilities.ReadConfig;

public class baseClass {
	
	ReadConfig config = new ReadConfig();

	public String URL = config.GetCurrentUrl();
	public String userName = config.UserName();
	public String passWord = config.Password();
	public String Name = config.FirstName();
	public String Surname = config.Surname();
	public String PostalCode = config.PostalCode();
	
	public static WebDriver driver;
	public static Logger logger;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br) {
		
		logger = LogManager.getLogger(baseClass.class);
		PropertyConfigurator.configure("log4j2.properties");
		BasicConfigurator.configure();
		
        if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", config.ChromeDriver());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        
        if(br.equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", config.FirefoxDriver());
    		driver = new FirefoxDriver();
    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            }
        
        if(br.equals("ie")) {
    		System.setProperty("webdriver.edge.driver", config.IeDriver());
    		driver = new EdgeDriver();
    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            }
	}
	
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String pathName = System.getProperty("user+dir")+"\\Screenshot\\"+testcaseName+".png";
		File dstFile = new File (pathName);
		FileUtils.copyFile(srcFile, dstFile);
		return pathName;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
