	package com.task.automation.core;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;
import com.task.automation.util.*;

public class BaseTestCase {
	static Date now = new Date();
	public static String TimeStamp = now.toString().replace(":", "-");
	public static WebDriver driver;

	DriverManager driverManager = new DriverManager();
	public static String baseurl="";
	//protected static Logging log;
	
	@Parameters({ "ReportName", "FlowType" })
	@BeforeSuite(alwaysRun = true)
	public void config(@Optional("Optional name Automation ") String reportname, @Optional("Automation Report") String flow)
			throws IOException {
		
		ExtentReport.initialize(System.getProperty("user.dir")+"/results/"+ TimeStamp+" Test_Automation.html");
		
		// Log path
	//	utils.Logging.setLogPath("LocusApi_logs.log");

		// create logging instance
	//	log = Logging.getInstance();

	}
	@BeforeTest
	public void beforeTest() {
		driver = driverManager.getDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
		System.out.printf("Test case", "*********************************************************************");
	}
		
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
			/*if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println(result.getMethod().getMethodName()+" :Passed");
			}
			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println(result.getMethod().getMethodName()+" :Failed");
			}
			else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println(result.getMethod().getMethodName()+" :Skipped");
			}
			*/
		//Reporter.log("<a href=\"" + "screenshotfile" +"\" target=\"_blank\">View Screenshot</a><br>");
			if (result.getStatus() == ITestResult.SUCCESS) {
				ExtentReport.extentlog.log(LogStatus.PASS, "Test case: " + result.getName()+" is passed " );

			} else if (result.getStatus() == ITestResult.FAILURE) {
				ExtentReport.extentlog.log(LogStatus.FAIL, "Test case is failed " + result.getName());
				ExtentReport.extentlog.log(LogStatus.FAIL, "Test case is failed " + result.getThrowable());
			} else if (result.getStatus() == ITestResult.SKIP) {
				ExtentReport.extentlog.log(LogStatus.SKIP, "Test case is Skiped " );
			}
			ExtentReport.extentreport.endTest(ExtentReport.extentlog);
		//--------------
			String methodName=StringUtil.createRandomString(result.getMethod().getMethodName());
			System.out.println("METHOD........"+methodName);
			ScreenshotUtility.captureScreenshot(driver,methodName);
			Reporter.setCurrentTestResult(result);

	}

	@AfterTest
	public void afterTest() {
		driverManager.quitDriver();
	}
	
	@AfterSuite(alwaysRun = true)
	public void endReport() {
		//ExtentReport.extentreport.flush();
		ExtentReport.extentreport.close();
		System.out.println("Close ExtentReport");
		//Email.sendEmail();

	}

}
