package appiumpackbasics;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pack.utils.BaseTest;

public class StartActivity extends BaseTest {

	@Test
	public void startacttest() {
		driver.executeScript("mobile: startActivity", Map.ofEntries(Map.entry("intent",
				"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies")));
		driver.findElement(By.id("android:id/checkbox")).click();

	}
}