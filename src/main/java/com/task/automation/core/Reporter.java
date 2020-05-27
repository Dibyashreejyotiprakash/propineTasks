package com.task.automation.core;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

public class Reporter{

	private final Log logger = LogFactoryImpl.getLog(Reporter.class);

	public static void log(String msg) {
		log(msg);
	}

	public static void logWithScreenShot(String msg) {
	}
	
	public static void main(String args[]) {
	}
}
