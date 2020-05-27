package com.task.automation.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.task.automation.core.BaseTestCase;
import com.task.automation.pages.homePage;
import com.task.automation.util.*;

public class HomeScreen  extends BaseTestCase{
	//SignInPage signInPage = new SignInPage(driver);
	
	@Test(description = "Verify date in format 01-01-2020",groups="Smoke")
	public void TC_validateoutputDateInFormat() throws Exception 
	{
		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateWelcomeMessage",
				"Verify welcome message");
	
       homePage homepage = new homePage(driver);
       homepage.launch();
       String date = homepage.getDate(JsonUtil.getdatafromjson("validdate"));
       assertEquals(date.contains("Wed Jan 01 2020 00:00:00 GMT+0000"),true);
       
	}
	
	@Test(description = "Verify date with month day more than 31",groups="Regression")
	public void TC_validateoutputDateInvalidFormat() throws Exception 
	{
		ExtentReport.extentlog = ExtentReport.extentreport.startTest("TC_validateWelcomeMessage",
				"Verify welcome message");
	
       homePage homepage = new homePage(driver);
       homepage.launch();
       String date = homepage.getDate(JsonUtil.getdatafromjson("invalidDate"));
       assertEquals(date.contains("Invalid date"),true);
       
	}
	
	
}
