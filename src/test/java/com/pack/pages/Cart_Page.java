package com.pack.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pack.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cart_Page extends AndroidActions {

	AndroidDriver driver;

	public Cart_Page(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		// Initialize the PageFactory elements
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productprices;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")
	private WebElement checkBox;

	public List<WebElement> getPrice() {
		return productprices;
	}

	public double getProductsSum() {
		int count = productprices.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {

			String amountstring = productprices.get(i).getText();
			Double price = getFormattedAmount(amountstring);
			totalSum = totalSum + price;

		}

		return totalSum;

	}

	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());

	}

	public void acceptterms() {
		LongPress(terms);
		acceptButton.click();
	}

	public void clickProceed() {
		proceed.click();
	}

	public void clickCheckBox() {
		checkBox.click();
	}

}
