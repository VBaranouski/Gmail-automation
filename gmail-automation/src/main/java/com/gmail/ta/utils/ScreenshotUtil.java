package com.gmail.ta.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	private static final Logger LOGGER= Logger.getLogger(ScreenshotUtil.class);
	private static final String PREFIX= "scr";
	private static final SimpleDateFormat DATE = new SimpleDateFormat("dd.MMM.yyyy-HH.mm.ss[SSS]");

	public static void takeScreenshot(WebDriver driver) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("test-output/html/screenshots/" + PREFIX + "-" 
					+ DATE.format(new Date(System.currentTimeMillis())) + ".png"));
			LOGGER.info(String.format("Screenshot captured"));
		} catch (IOException e) {
			LOGGER.error("Error during taking screenshot", e);
			e.printStackTrace();
		}
	}
}

