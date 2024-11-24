package appiumpackbasics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GeneralStoreA extends BaseTestDriver {

	@Test
	public void generalstoretest() throws InterruptedException {

		driver.findElement(By.id("android:id/text1")).click();

		WebElement Denmark = driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Denmark\"));"));

		Denmark.click();

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mounika");

		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

		driver.findElements(By
				.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]"))
				.get(0).click();

		driver.findElements(By
				.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]"))
				.get(1).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		driver.findElement(By.className("android.widget.CheckBox")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(7000);

		Set<String> contexts = driver.getContextHandles();
		System.out.println("Avalaible contects are:" + contexts);

		for (String Context : contexts) {
			if (Context.contains("WEBVIEW_com.androidsample")) {
				driver.context(Context);

				// perform some actions

				driver.findElement(By.name("q")).sendKeys("www.facebook.com");
			}
		}

	}

}
