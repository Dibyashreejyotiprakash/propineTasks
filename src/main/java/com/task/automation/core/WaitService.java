package com.task.automation.core;

import java.awt.TrayIcon.MessageType;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WaitService {

	private WebDriver driver;

	public WaitService(WebDriver driver) {

		this.driver = driver;
	}

	public void waitForElementVisible(WebElement element, long timeout) {

		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		} catch (ElementNotVisibleException e) {
			Reporter.log(element.toString() + "is not visible");
			Reporter.log(e.getStackTrace().toString());
		}

	}

	public void waitForElementPresent(WebElement element, long timeout) {

		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated((By) element));
		} catch (NoSuchElementException e) {
			Reporter.log(element.toString() + "is not present");
			Reporter.log(e.getStackTrace().toString());
		}
	}

}
