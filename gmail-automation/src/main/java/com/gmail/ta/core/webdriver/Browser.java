package com.gmail.ta.core.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser {

	private final static Logger lOGGER = Logger.getLogger(Browser.class);

    static WebDriver driver;

    public static WebDriver initChromeBrowser() {
       	System.setProperty("webdriver.chrome.driver", "c:/Selenium/chromedriver.exe");
       	WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        lOGGER.info("Browser started");
		return driver;
    }
  
}
