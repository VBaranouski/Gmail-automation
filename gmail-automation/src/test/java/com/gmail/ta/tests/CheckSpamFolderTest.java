package com.gmail.ta.tests;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.gmail.ta.pages.MainPage;
import com.gmail.ta.core.webdriver.Browser;
import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ScreenshotUtil;


public class CheckSpamFolderTest extends TestingDataFile{
	
	private static final Logger LOGGER = Logger.getLogger(CheckSpamFolderTest.class);
		
	@Test
	public void checkSpamFolder() {
		    WebDriver driver = Browser.initChromeBrowser();
		    InitialPage initialpage = new InitialPage(driver);
			initialpage.openPage(URL);
			SignInPage signinpage = new SignInPage(driver);
			signinpage.signIn(SECONDEMAIL, SECONDPASSWORD);
			LOGGER.info("Login was succesful");
			MainPage homepage = new MainPage(driver);
			homepage.openSpam();
			String actualEmailSubject = homepage.getEmailSubject();
			LOGGER.info("Comparing subjects");
			assertEquals(SUBJECT, actualEmailSubject);
			LOGGER.info("Email was found in SPAM folder");
			ScreenshotUtil.takeScreenshot(driver);
			driver.close();
	}

}
