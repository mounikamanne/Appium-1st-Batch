package appiumpackbasics;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppPackage_Activity {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("emulator1");
		options.setAppPackage("io.appium.android.apis");
		options.setAppActivity("io.appium.android.apis.os.Sensors");

		options.setPlatformVersion("12");
		options.setAutomationName("UiAutomator2");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		Thread.sleep(6000);
		driver.quit();

	}

}
