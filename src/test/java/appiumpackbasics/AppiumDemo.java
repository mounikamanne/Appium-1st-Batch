package appiumpackbasics;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumDemo {

	public static void main(String[] args) throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("motorola edge 50 fusion");
//		options.setApp("C:\\Users\\promp\\OneDrive\\Documents\\Apk2.0\\ApiDemos.apk");
		options.setChromedriverExecutable("C:\\Users\\promp\\OneDrive\\Documents\\Drivers\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");

		options.setPlatformVersion("14");
		options.setAutomationName("UiAutomator2");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("Moounika");

//		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
//		driver.findElement(AppiumBy.accessibilityId("Loading")).click();

//		driver.quit();

	}

}
