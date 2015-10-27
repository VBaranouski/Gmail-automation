package com.gmail.automation.hometask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendingEmail extends HomePage {

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
		emailToField.sendKeys("vlad.autotest2@gmail.com");
		emailSubjectField.sendKeys("Hey hey hey");
		emailSendButton.click();

	}

}
