package com.gmail.ta.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.gmail.ta.pages.MainPage;
import com.gmail.ta.core.webdriver.BrowserSingleton;
import com.gmail.ta.pages.AbstractGmailPage;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ReadingFromCSV;
import com.gmail.ta.utils.ScreenshotUtil;


public class MoveEmailToSpamTest extends AbstractGmailPage{
	
	private static final Logger LOGGER = Logger.getLogger(MoveEmailToSpamTest.class);
	
	@After
	public void closeBrowser() {
		WebDriver driver = BrowserSingleton.getInstance();
		ScreenshotUtil.takeScreenshot(driver);
		BrowserSingleton.closeDriver();
	}
		
	@Test
	public void checkEmailAndPutItToSpam() throws IOException {
		WebDriver driver = BrowserSingleton.initChromeBrowser();
		InitialPage initialpage = new InitialPage(driver);
		initialpage.openPage(URL);
		ReadingFromCSV reader = new ReadingFromCSV();
		reader.readFromCSV();
		SignInPage signinpage = new SignInPage(driver);
		signinpage.signIn(reader.getSecondEmail(), reader.getSecondPassword());
		LOGGER.info("Login was succesful");
		MainPage homepage = new MainPage(driver);
		homepage.moveMailToSpam();
		LOGGER.info("Emal has been moved to Spam folder");
		
	}
}
