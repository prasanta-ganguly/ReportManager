package com.testcases;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtenReport {
	
	ExtentReports extent; //specify the location of the report
	ExtentTest test; // what details should be populated in the report
	
	
	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir")+"//extent-reports//myreport.html",true);
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", "Prasanta");
		extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
	}
	
	@Test
	public void demoReportPass() {
		test = extent.startTest("demoReportPass started");
		Assert.assertTrue(true);
		//test.log(LogStatus.PASS, "This test is passed");
	}
	
	@Test
	public void demoReportFail() {
		test = extent.startTest("demoReportFail test started");
		Assert.assertTrue(false);
		//test.log(LogStatus.PASS, "Test is failed");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test is failed");
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test is passed");
		}else if (result.getStatus()==ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test is skipped");
		}
		
		extent.endTest(test);
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}

}
