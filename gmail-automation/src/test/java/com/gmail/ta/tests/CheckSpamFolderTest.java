package com.gmail.ta.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.ta.pages.MainPage;

import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SignInPage;
import com.gmail.ta.utils.ScreenshotUtil;


public class CheckSpamFolderTest extends TestingDataFile{
	
	private static final Logger LOGGER = Logger.getLogger(CheckSpamFolderTest.class);
	
	@Test
	public void checkSpamFolder() {
			System.setProperty("webdriver.chrome.driver", "c:/Selenium/chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			InitialPage initialpage = new InitialPage(driver);
			initialpage.openPage(URL);
			SignInPage signinpage = new SignInPage(driver);
			signinpage.signIn(SECONDEMAIL, SECONDPASSWORD);
			MainPage homepage = new MainPage(driver);
			homepage.openSpam();
			String actualEmailSubject = homepage.getEmailSubject();
			assertEquals(SUBJECT, actualEmailSubject);
			ScreenshotUtil.takeScreenshot(driver);
			LOGGER.info("Email was found in SPAM folder");
			driver.close();
	}

}
