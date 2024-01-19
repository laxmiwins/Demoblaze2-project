package com.demotest.utilities;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import com.demotest.stepdefinitions.TestBase;

public class WaitFor {
	private static FluentWait<WebDriver> wait;
	static{
		wait = new FluentWait<WebDriver>(TestBase.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.withTimeout(Duration.ofSeconds(60));
		
	}

	public static void staleElement(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static void elementToBePresentInList(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
public static void alertToBePresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
