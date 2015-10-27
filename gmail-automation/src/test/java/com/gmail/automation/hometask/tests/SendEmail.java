package com.gmail.automation.hometask.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.automation.hometask.pages.InitialPage;
import com.gmail.automation.hometask.pages.SendingEmail;
import com.gmail.automation.hometask.pages.SignInPage;

public class SendEmail extends TestData {
	
	@Test
	public void sendEmailToSecondUser() {
		System.setProperty("webdriver.chrome.driver", "c:/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		InitialPage initialpage = new InitialPage(driver);
		initialpage.openPage(URL);
		SignInPage signinpage = new SignInPage(driver);
		signinpage.signIn(EMAIL, PASSWORD);
		SendingEmail sendmail = new SendingEmail(driver);
		sendmail.sendMessage();
		driver.close();
	}
}
