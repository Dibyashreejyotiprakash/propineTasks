package com.task.automation.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.task.automation.core.BaseTestCase;


public class ScreenshotUtility extends BaseTestCase {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			
			Thread.sleep(10000);
			//object for class TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			//getScreenshotAs to capture and save the ss
			File source = ts.getScreenshotAs(OutputType.FILE);
		    System.setProperty("org.uncommons.reportng.escape-output", "false");
		    File destinationPath=new File("./target/surefire-reports/screenshots/" + screenshotName + ".png");
		    FileUtils.copyFile(source,destinationPath );
            //Reporter.log("<a href='"+ destinationPath.getAbsolutePath() + "'> <img src='"+ destinationPath.getAbsolutePath() + "' height='100' width='100'/> </a>");
		    Reporter.log("<br/><a href='"+ destinationPath.getAbsolutePath() + "'>View Screenshot</a><br/>");

		} catch (Exception e) {

		}
	}
}
