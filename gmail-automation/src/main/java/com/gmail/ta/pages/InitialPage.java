package com.gmail.ta.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage {
	
	private final Logger logger = Logger.getLogger(InitialPage.class);
	
	@FindBy(id = "gmail-sign-in")
	private WebElement buttonSubmit;

	private WebDriver driver;
	SignInPage signin = new SignInPage(driver);

	public InitialPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignInPage openPage(String URL) {
		driver.get(URL);
		logger.info("Login page opened");
		return new SignInPage(driver);
	}
}
