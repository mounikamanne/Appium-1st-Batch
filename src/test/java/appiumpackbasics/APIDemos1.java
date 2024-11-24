package appiumpackbasics;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class APIDemos1 extends BaseTestDriver {

	@Test
	public void KeyTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Content")).click();

		driver.findElement(AppiumBy.accessibilityId("Packages")).click();

		driver.findElement(AppiumBy.accessibilityId("Install Apk")).click();

		driver.findElement(AppiumBy.accessibilityId("My Source")).click();

	}

}
