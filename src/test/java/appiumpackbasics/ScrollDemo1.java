package appiumpackbasics;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo1 extends BaseTestDriver {

	@Test
	public void scrollTestDemo() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		driver.findElement(AppiumBy.accessibilityId("WebView")).click();

	}

}