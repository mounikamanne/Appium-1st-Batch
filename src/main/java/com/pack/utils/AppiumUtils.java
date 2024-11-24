package com.pack.utils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {

	public Double getFormattedAmount(String Amount) {
		Double price = Double.parseDouble(Amount.substring(1));
		return price;
	}
	
	
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		
		//convert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);


				ObjectMapper mapper = new ObjectMapper();				
				List<HashMap<String, String>> data = mapper.readValue(jsonContent,
						new TypeReference<List<HashMap<String, String>>>() {
						});

				return data;

			}


	public void waitforElement(WebElement ele, AppiumDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "cart"));
	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		
			// Take a screenshot and store it as a file
			File src = driver.getScreenshotAs(OutputType.FILE);

			// Specify the destination where the screenshot will be saved
			 String trg =System.getProperty("user.dir")+"//reports//" + testCaseName + ".png";

			// Save the screenshot to the desired location
			FileUtils.copyFile(src,new File(trg));
			
			System.out.println("Screenshot saved successfully.");
		
		return trg;
	}
}
