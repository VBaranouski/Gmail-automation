package com.gmail.automation.hometask.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.automation.hometask.pages.HomePage;
import com.gmail.automation.hometask.pages.InitialPage;
import com.gmail.automation.hometask.pages.SignInPage;

public class CheckSpamFolder extends TestData{

	@Test
	public void checkSpamFolder() {
			System.setProperty("webdriver.chrome.driver", "c:/Selenium/chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			InitialPage initialpage = new InitialPage(driver);
			initialpage.openPage(URL);
			SignInPage signinpage = new SignInPage(driver);
			signinpage.signIn(SECONDEMAIL, SECONDPASSWORD);
			HomePage homepage = new HomePage(driver);
			homepage.openSpam();
			String actualEmailSubject = homepage.getEmailSubject();
			assertEquals(SUBJECT, actualEmailSubject);
			driver.close();
	}

}
