package com.gmail.ta.core.webdriver;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;

public class Decorator implements WebDriver {
	
	protected WebDriver driver;

	public Decorator(WebDriver driver) {
		this.driver = driver;
	}

	public void close() {
		driver.close();	
	}

	public WebElement findElement(By by) {
		System.out.println(by.toString());
		return driver.findElement(by);
	}

	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	public void get(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public Options manage() {
		Dimension dimension = new Dimension(1000, 800);
		driver.manage().window().setSize(dimension);
		return driver.manage();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public void quit() {
		driver.close();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();	}

}
