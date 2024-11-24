package com.pack.utils;

import java.lang.reflect.Field;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener {

    private static com.aventstack.extentreports.ExtentReports extent = ExtentReports.setUpReport();
    private ExtentTest test;
    private AppiumDriver driver;

    @Override
    public void onStart(ITestContext context) {
        test = extent.createTest("Test Suite: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName(), "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        try {
            driver = (AppiumDriver) getFieldFromResult(result, "driver");
            String screenshotPath = getScreenshotPath(result.getMethod().getMethodName(), driver);
            test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private Object getFieldFromResult(ITestResult result, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = result.getTestClass().getRealClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(result.getInstance());
    }
}