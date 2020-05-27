package com.task.automation.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ISuiteListener, ITestListener, IInvokedMethodListener {

	// private final Log logger = LogFactoryImpl.getLog(getClass());

	static Logger logger = LogManager.getLogger();

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		logger.debug("onTestStart: start");
		System.out.println("Started..." + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + " :Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + " :Failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName() + " :Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {

		// System.setProperty("Dlog4j.configurationFile","log4j2.xml");
		
		//PropertyConfigurator.configure("log4j.properties");

		Logger logger = LogManager.getLogger(TestListner.class);
		logger.debug("Getting errors");
		logger.info("this is information");
		logger.warn("this is warning");

	}
}
