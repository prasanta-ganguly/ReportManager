package com.base;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reportsutil.ExtentManager;


public class BaseTest {
	
	public static WebDriver driver;
	
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	//***********************************Verification/Validation functions*************************
	
	public boolean verifyTitle(String title) {
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(title))
			return true;
		else
			return false;
	}
	
	
	public boolean verifyUrl(String url) {
		String actualUrl = driver.getCurrentUrl();
		
		if(actualUrl.equals(url)) 
			return true;
		else {
			return false;
		}
	}
	
	
	public boolean verifyText(String elementPath, String expectedText) {
		
		String actualText = driver.findElement(By.xpath(elementPath)).getText().trim();
		
		if(actualText.equals(expectedText))
			return true;
		else
			return false;
	}
	
	

	//***********************************Reporting Functions***************************************
	
	public static void reportPass(String msg) {
		test.log(LogStatus.PASS, msg);
	}
	
	public void reportFail(String msg) {
		test.log(LogStatus.FAIL, msg);
	}
	
public void takeScreenshot(){
		
		//filename of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		//store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			//adding an existing image as screenshot into extent report
			//test.log(LogStatus.FAIL, "Screenshot->"+test.addScreenCapture("C:\\Users\\Prasanta\\Desktop\\prasanta.jpg"));
		
		//put screenshot file in extent reports
		test.log(LogStatus.INFO, "Screenshot->"+test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		
	}
}
