package com.sauceDemoEcommerce.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
	String pathName = System.getProperty("user+dir")+"\\test-output\\index.html";
    ExtentSparkReporter reporter = new ExtentSparkReporter(pathName);
	reporter.config().setReportName("Web Automation Report");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Subhasish");
	return extent;
	
	}

}
