package com.gmail.ta.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
	
	private static final Logger LOGGER = Logger.getLogger(MainPage.class);
	
	//@Name("More") - doesn't work... 
	@FindBy(xpath = "//*[@class='CJ']")
	private WebElement moreButton;
	
	@FindBy(xpath = "//a[contains(@href,'/#spam')]")
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

	public MainPage(WebDriver driver) {
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
			LOGGER.error("Inbox folder is empty");
			LOGGER.info("Reason: Email automatically marked as SPAM");
		} else {
			nameWhoSentEmail.click();
			LOGGER.info("Confirming that Email is recived");
			reportSpam.click();
			justSpamButton.click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			LOGGER.info("Email has been marked as SPAM");
		}
	}

	public void openSpam() {
		moreButton.click();
		spamButton.click();
		LOGGER.info("Open Spam folder");
	}

}
