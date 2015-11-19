package com.gmail.ta.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage extends AbstractGmailPage {
	
	private static final Logger LOGGER = Logger.getLogger(InitialPage.class);
	
	@FindBy(id = "gmail-sign-in")  //not using at this time
	private WebElement buttonSubmit;

	
	private WebDriver driver;
	SignInPage signin = new SignInPage(driver);

	public InitialPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver openPage(String URL) {
		driver.get(URL);
		LOGGER.info("Sign In page opened");
		return driver;
	}
}
