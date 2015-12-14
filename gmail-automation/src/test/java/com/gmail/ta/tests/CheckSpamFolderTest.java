package com.gmail.ta.tests;

import com.gmail.ta.core.webdriver.Browser;
import com.gmail.ta.pages.AbstractGmailPage;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.MainPage;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ReadingFromCSV;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CheckSpamFolderTest extends AbstractGmailPage {
	
	private static final Logger LOGGER = Logger.getLogger(CheckSpamFolderTest.class);
	private static final String SUBJECT = "Hey hey hey";
	
	@After
	public void closeBrowser() {
		WebDriver driver = Browser.getInstance();
		Browser.closeDriver();
	}

	@Test
	public void checkSpamFolder() throws IOException {
			WebDriver driver = Browser.initChromeBrowser();
			InitialPage initialpage = new InitialPage(driver);
			initialpage.openPage(URL);
			ReadingFromCSV reader = new ReadingFromCSV();
			reader.readFromCSV();			
			SignInPage signinpage = new SignInPage(driver);
			signinpage.signIn(reader.getSecondEmail(), reader.getSecondPassword());
			LOGGER.info("Login was successful");
			MainPage homepage = new MainPage(driver);
			homepage.openSpam();
			String actualEmailSubject = homepage.getEmailSubject();
			LOGGER.info("Comparing subjects");
			assertEquals(SUBJECT, actualEmailSubject);
			LOGGER.info("Email was found in SPAM folder");


	}

}