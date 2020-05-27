package com.task.automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.task.automation.core.BaseTestCase;
import com.task.automation.core.WaitService;

public class AsserttionService extends BaseTestCase {

	WaitService waitService = new WaitService(driver);

	public void assertElementPresent(WebElement elementLocator,long timeout) {
		
		waitService.waitForElementPresent(elementLocator, timeout);
	}

	public void assertElementVisible(WebElement element, long timeout) {

		waitService.waitForElementVisible(element, timeout);
	}

	public void verytElementPresent(WebElement elementLocator,String successMessage,String failureMessage,long timeout) {
		try {
			waitService.waitForElementPresent(elementLocator, timeout);
			Reporter.log(successMessage);
		} catch (Exception ex) {
			Reporter.log(failureMessage);
		}
		
	}

	public void verifyElementVisible(WebElement elementLocator,String successMessage,String failureMessage,long timeout) {

		try {
			waitService.waitForElementVisible(elementLocator, timeout);
			Reporter.log(successMessage);
		} catch (Exception ex) {
			Reporter.log(failureMessage);
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean verifyTrue(boolean b, String failMessage, String successMessage) {
		try {
			assertTrue(b, failMessage, successMessage);
			return true;
		} catch (Error e) {
			Reporter.log(e.toString());
		}
		return false;
	}

	public boolean verifyFalse(boolean b, String failMessage, String successMessage) {
		return verifyTrue(!b, failMessage, successMessage);
	}

	public void assertTrue(boolean b, String failMsg, String successMsg) {
		if (!b) {
			throw new AssertionError(failMsg);
		}
		Reporter.log("<br/>"+successMsg);
	}

	public void assertFalse(boolean b, String failMsg, String successMsg) {
		assertTrue(!b, failMsg, successMsg);
	}

}
