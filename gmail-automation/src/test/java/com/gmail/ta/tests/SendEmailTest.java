package com.gmail.ta.tests;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.gmail.ta.core.webdriver.Browser;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SendingEmail;
import com.gmail.ta.pages.SignInPage;


public class SendEmailTest extends TestingDataFile {
	
	private static final Logger LOGGER = Logger.getLogger(SendEmailTest.class);
	
	@Test
	public void sendEmailToSecondUser() {
		WebDriver driver = Browser.initChromeBrowser();
		InitialPage initialpage = new InitialPage(driver);
		initialpage.openPage(URL);
		SignInPage signinpage = new SignInPage(driver);
		signinpage.signIn(EMAIL, PASSWORD);
		LOGGER.info("Login was succesful");
		SendingEmail sendmail = new SendingEmail(driver);
		sendmail.sendMessage();
		driver.close();
	}
}
