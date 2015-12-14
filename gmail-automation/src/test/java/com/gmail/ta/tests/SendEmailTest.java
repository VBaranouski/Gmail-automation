package com.gmail.ta.tests;

import com.gmail.ta.core.webdriver.Browser;
import com.gmail.ta.pages.AbstractGmailPage;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SendingEmail;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ReadingFromCSV;
import com.gmail.ta.utils.ScreenshotUtil;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class SendEmailTest extends AbstractGmailPage {
	
	private static final Logger LOGGER = Logger.getLogger(SendEmailTest.class);
	
	@After
	public void closeBrowser() {
		Browser.closeDriver();		
	}
			
	@Test
	public void sendEmailToSecondUser() throws IOException {
		WebDriver driver = Browser.initChromeBrowser();
		InitialPage initialpage = new InitialPage(driver);
		initialpage.openPage(URL);
		ReadingFromCSV reader = new ReadingFromCSV();
		reader.readFromCSV();
		SignInPage signinpage = new SignInPage(driver);
		signinpage.signIn(reader.getEmail(), reader.getPassword());
		LOGGER.info("Login was successful");
		SendingEmail sendmail = new SendingEmail(driver);
		sendmail.sendMessage();
		ScreenshotUtil.takeScreenshot(driver);
	}
	
}