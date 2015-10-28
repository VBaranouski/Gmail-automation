package com.gmail.ta.core.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser {

	private final static Logger lOGGER = Logger.getLogger(Browser.class);

    static WebDriver driver;
    private static String driverPath = "src\\main\\resources\\drivers\\";
    private static String chromeDriverPath = driverPath + "chromedriver_win_x32_2_17.exe";


    public static WebDriver initChromeBrowser() {
       	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
       	WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        lOGGER.info("Browser started");
		return driver;
    }
  
}
