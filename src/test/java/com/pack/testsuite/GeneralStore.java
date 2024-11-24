package com.pack.testsuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pack.pages.Cart_Page;
import com.pack.pages.Form_Page;
import com.pack.pages.Products_Page;
import com.pack.utils.BaseTest;

public class GeneralStore extends BaseTest {

	@Test(dataProvider = "loginData")
	public void GeneralStoretest(HashMap<String, String> input) throws InterruptedException {
		// Fill out the form
		Form_Page fm = new Form_Page(driver);
		fm.setName(input.get("name"));
		fm.setGender(input.get("gender"));
		fm.setCountrySelection(input.get("country"));

		// Navigate to the Products page
		Products_Page pc = fm.submitform();

		// Add items to the cart
		pc.addItemtoCrtbyIndex(0);
		pc.addItemtoCrtbyIndex(0);

		// Navigate to the Cart page
		Cart_Page cp = pc.goToCartPage();

		// Verify the total price
		double totalSum = cp.getProductsSum();
		double displayedSum = cp.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayedSum, "The calculated total does not match the displayed total.");

		// Accept terms and proceed
//		cp.acceptterms();
		cp.clickCheckBox();
		cp.clickProceed();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\Data.json");
		return new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) } };

//    	return new Object[][] {{data.get(0)}};

//        return new Object[][] {
//            { "Mounika", "female", "Denmark" },
//            { "Anand", "male", "Argentina" },
//            { "Mounika", "female", "Denmark" },
//        };
	}
}
