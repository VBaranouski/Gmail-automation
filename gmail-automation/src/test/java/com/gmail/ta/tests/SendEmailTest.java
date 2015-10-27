package com.gmail.ta.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.ta.pages.InitialPage;
import com.gmail.ta.pages.SendingEmail;
import com.gmail.ta.pages.SignInPage;



public class SendEmailTest extends TestingDataFile {
	
	private static final Logger LOGGER = Logger.getLogger(SendEmailTest.class);
	
	@Test
	public void sendEmailToSecondUser() {
		System.setProperty("webdriver.chrome.driver", "c:/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
