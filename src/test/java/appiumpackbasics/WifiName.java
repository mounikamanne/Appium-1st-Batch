package appiumpackbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class WifiName extends BaseTestDriver {

	@Test
	public void wifiTest() throws InterruptedException {
		
		//click on Preference
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		//click on Preference dependencies
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		//click on checkbox
		driver.findElement(By.id("android:id/checkbox")).click();

		//get the text 
		WebElement Wifiname = driver
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")"));
		Assert.assertEquals(Wifiname.getText(), "WiFi settings");
		
//creating own xpath
		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]"))
				.click();

		driver.setClipboardText("Mounikawifi@233");

//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.

		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElement(By.id("android:id/button1")).click();
		
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);

	}

}
