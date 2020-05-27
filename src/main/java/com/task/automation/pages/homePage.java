package com.task.automation.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.task.automation.util.JsonUtil;
import com.task.automation.util.ScreenshotUtility;

public class homePage {

	WebDriver driver;
	WebDriverWait wait;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}

	public void launch () throws Exception, IOException {
		homePage homepage = new homePage(driver);
		homepage.launchPage();
		//Thread.sleep(3000);
	}
	public void launchPage() {
		
		driver.manage().deleteAllCookies();
		driver.get("https://vast-dawn-73245.herokuapp.com/");
		//driver.get("http://test$_@gmail.com:test123@localhost:3001/signin");
		driver.manage().window().maximize();
		
		waitForPageToLoad(pageIdentifier);
	}
	
	public void waitForPageToLoad(){
		//explicit wait need with condition
		wait.until(ExpectedConditions.visibilityOf(pageIdentifier));
	}
	
	public void waitForPageToLoad(WebElement webele){
		//explicit wait need with condition
		wait.until(ExpectedConditions.visibilityOf(webele));
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Propine Date Parser')]")
	public WebElement pageIdentifier;
	
	@FindBy(xpath="//input[@placeholder='date']")
	public WebElement inputDate;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//h3[contains(text(),'Results')]//following-sibling::div")
	public WebElement outputDate;
	
	
	
	
	public String getDate(String inputdate) throws InterruptedException {
		homePage homepage = new homePage(driver);
	       homepage.inputDate.sendKeys(inputdate);
	       homepage.submit.click();
	       Thread.sleep(2000);
	       String outputdate;
	       return outputdate =  homepage.outputDate.getText();
	}
	
	
	public static boolean isDialogPresent(WebDriver driver) {
        try {
            driver.getTitle();
            return false;
        } catch (UnhandledAlertException e) {
            // Modal dialog showed
            return true;
        }
    }
	public static String getTestData(String input) throws IOException, ParseException {
		String testdata;
	//	return  testdata = JsonUtil.getData().get(input).toString();
		return testdata = (String) JsonUtil.getJsonData().get(input);
	}

}
