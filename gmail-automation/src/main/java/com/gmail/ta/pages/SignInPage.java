package com.gmail.ta.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	private static final Logger LOGGER = Logger.getLogger(SignInPage.class);
	
	@FindBy(id = "Email")
	private WebElement emailField;

	@FindBy(id = "next")
	private WebElement nextButton;

	@FindBy(id = "Passwd")
	private WebElement passwordField;

	@FindBy(id = "signIn")
	private WebElement signInButton;

	private WebDriver driver;

	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public MainPage signIn(String email, String password) {
		LOGGER.info("Trying to login");
		emailField.sendKeys(email);
		nextButton.click();
		passwordField.sendKeys(password);
		signInButton.click();
		return new MainPage(driver);
	}
}