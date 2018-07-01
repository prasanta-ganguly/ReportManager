package com.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest extends BaseTest{
	
	final static Logger log = Logger.getLogger(LoginTest.class);
	
	
	@BeforeClass
public void openBrowser() {
		
		test = rep.startTest("Open Browser");
		test.log(LogStatus.INFO, "Opening Browser");
		log.info("Opening Browser");
		
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse-oxygen-workspace\\Common Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public void getUrl() {
		
		test = rep.startTest("Get URL");
		test.log(LogStatus.INFO, "Launching email login page");
		log.info("Launching email login page");
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		test.log(LogStatus.INFO, "Navigating to - https://mail.rediff.com/cgi-bin/login.cgi");
		log.info("Navigating to - https://mail.rediff.com/cgi-bin/login.cgi");
		
		verifyUrl("https://mail.rediff.com/cgi-bin/login.cgis");
		
		String title = driver.getTitle();
		
		if(title.equals("Rediffmail")) {
			reportPass("Title match get passed");
		}else {
			reportFail("Title did not match");
		}
		takeScreenshot();
	}
	
	@Test(priority=2, dependsOnMethods="getUrl")
	public void login() {
		
		test = rep.startTest("Login");
		test.log(LogStatus.INFO, "Logging in to mail account");
		log.info("Logging in to mail account");
		
		test.log(LogStatus.INFO, "Typing in //*[@id=\'login1\']");
		driver.findElement(By.xpath("//*[@id=\'login1\']")).sendKeys("prashant.ganguly");
		
		test.log(LogStatus.INFO, "Typing in //*[@id=\'password\']");
		log.info("Typing in //*[@id=\'password\'");
		driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("BIGsmall123");
		
		test.log(LogStatus.INFO, "Clicking on /html/body/div/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input");
		log.info("Clicking on /html/body/div/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input");
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
		takeScreenshot();
	}
	
	@Test(priority=3, dependsOnMethods= {"getUrl", "login"})
	public void logout() {
		
		test = rep.startTest("Logout");
		test.log(LogStatus.INFO, "Loggout from mail account");
		log.info("Loggout from mail account");
		
		test.log(LogStatus.INFO, "Clicking on /html/body/div[4]/div[1]/div/div[2]/a[2]");
		log.info("Clicking on /html/body/div[4]/div[1]/div/div[2]/a[2]");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/a[2]")).click();
		takeScreenshot();
	}
	
	@AfterClass
	public void tearDown() {
		rep.endTest(test);
		rep.flush();
		driver.quit();
	}
	
	

}
