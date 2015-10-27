package com.gmail.ta.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendingEmail extends MainPage {

	private static final Logger LOGGER = Logger.getLogger(SendingEmail.class);
	
	private static final String EMAIL = "vlad.autotest4@gmail.com";
	private static final String SUBJECT = "Hey hey hey";
	
	@FindBy(xpath = "//*[.='COMPOSE']")
	private WebElement composeButton;

	@FindBy(name = "to")
	private WebElement emailToField;

	@FindBy(name = "subjectbox")
	private WebElement emailSubjectField;

	@FindBy(xpath = "//*[.='Send']")
	private WebElement emailSendButton;

	
	public SendingEmail(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
		
	public void sendMessage() {
		composeButton.click();
		emailToField.sendKeys(EMAIL);
		emailSubjectField.sendKeys(SUBJECT);
		emailSendButton.click();
		LOGGER.info("Email to second user has been sent");

	}

}
