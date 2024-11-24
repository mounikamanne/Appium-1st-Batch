package appiumpackbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPressDemo extends BaseTestDriver {

	@Test
	public void longPressTest() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		WebElement dognames = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Dog Names\")"));

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) dognames).getId(), "duration", 2000));

		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}

}
