package com.pack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pack.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Form_Page extends AndroidActions {

	public Form_Page(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	AndroidDriver driver;

	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement name;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement dropdown;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopbutton;

	public void setName(String uname) throws InterruptedException {
		Thread.sleep(3000);
		name.sendKeys(uname);
	}

	public void setGender(String gender) {
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}

	public void setCountrySelection(String countryname) {
		dropdown.click();
		scrollToText(countryname);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryname + "']")).click();
	}

	public Products_Page submitform() {
		shopbutton.click();
		return new Products_Page(driver);
	}

}
