package com.pack.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pack.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products_Page extends AndroidActions {

	AndroidDriver driver;

	public Products_Page(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		// Initialize the PageFactory elements
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Cart;

	public void addItemtoCrtbyIndex(int index) {

		addToCart.get(index).click();

	}

	public Cart_Page goToCartPage() throws InterruptedException {

		Thread.sleep(3000);
		Cart.click();
		return new Cart_Page(driver);

	}

}



