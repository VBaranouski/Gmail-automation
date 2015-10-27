package com.gmail.automation.hometask.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//*[@class='CJ']")
	private WebElement moreButton;

	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/#spam']")
	private WebElement spamButton;

	@FindBy(xpath = "//*[@class = 'F cf zt']//tr[1]//td[4]")
	private WebElement nameWhoSentEmail;

	@FindBy(xpath = "//*[@class = 'F cf zt']//tr[1]//td[6]")
	private WebElement emailSubject;

	@FindBy(xpath = "//*[.='Your Primary tab is empty.']")
	private WebElement textInEmptyInbox;

	@FindBy(xpath = "//*[@id=':5']/div[2]/div[1]/div/div[2]/div[2]")
	private WebElement reportSpam;

	@FindBy(xpath = "//*[@name='rs']")
	private WebElement justSpamButton;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getSenderName() {
		String senderName = nameWhoSentEmail.getText();
		return senderName;
	}

	public String getEmailSubject() {
		String subject = emailSubject.getText();
		return subject;
	}

	public void moveMailToSpam() {
		if (textInEmptyInbox.isDisplayed()) {
			System.out.println("Didn't find your mail in Inbox");
		} else {
			nameWhoSentEmail.click();
			reportSpam.click();
			justSpamButton.click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
	}

	public void openSpam() {
		moreButton.click();
		spamButton.click();
	}

}
