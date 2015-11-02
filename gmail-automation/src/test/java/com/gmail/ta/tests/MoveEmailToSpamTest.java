package com.gmail.ta.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.gmail.ta.pages.MainPage;
import com.gmail.ta.core.webdriver.Browser;
import com.gmail.ta.pages.AbstractGmailPage;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ReadingFromCSV;
import com.gmail.ta.utils.ScreenshotUtil;


public class MoveEmailToSpamTest extends AbstractGmailPage{
	
	private static final Logger LOGGER = Logger.getLogger(MoveEmailToSpamTest.class);
	
	@Test
	public void checkEmailAndPutItToSpam() throws IOException {
		WebDriver driver = Browser.initChromeBrowser();
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
		ScreenshotUtil.takeScreenshot(driver);
		driver.close();
		
	}
	
}
