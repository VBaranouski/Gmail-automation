package com.gmail.ta.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HighlightElement {


 public static void highlightElement (WebDriver driver, WebElement elementToHighlight){
     JavascriptExecutor jsEx = ((JavascriptExecutor) driver);
     jsEx.executeScript("arguments[0].style.border='4px groove green'", elementToHighlight);
     ScreenshotUtil.takeScreenshot(driver);

 }
}
