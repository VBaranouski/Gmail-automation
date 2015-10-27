package com.gmail.ta.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	private final Logger logger = Logger.getLogger(SignInPage.class);
	
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
		emailField.sendKeys(email);
		nextButton.click();
		passwordField.sendKeys(password);
		signInButton.click();
		logger.info("Login was successful");
		return new MainPage(driver);
	}
}