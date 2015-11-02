package com.gmail.ta.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.gmail.ta.core.webdriver.Browser;
import com.gmail.ta.pages.AbstractGmailPage;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SendingEmail;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ReadingFromCSV;


public class SendEmailTest extends AbstractGmailPage {
	
	private static final Logger LOGGER = Logger.getLogger(SendEmailTest.class);
	private WebDriver driver;
	private ReadingFromCSV reader;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	
	@Before
	public void openBrowserAndReadData() throws IOException {
		WebDriver driver = Browser.initChromeBrowser();
		InitialPage initialpage = new InitialPage(driver);
		initialpage.openPage(URL);
		ReadingFromCSV reader = new ReadingFromCSV();
		reader.readFromCSV();
	}
	
	@After
	public void closeBrowser(){
		driver.close();
	}
		
	
	@Test
	public void sendEmailToSecondUser() {
		SignInPage signinpage = new SignInPage(driver);
		signinpage.signIn(reader.getEmail(), reader.getPassword());
		LOGGER.info("Login was succesful");
		SendingEmail sendmail = new SendingEmail(driver);
		sendmail.sendMessage();
	}
	
}
