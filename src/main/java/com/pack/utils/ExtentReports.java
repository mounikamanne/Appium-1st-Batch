package com.pack.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports {

    private static com.aventstack.extentreports.ExtentReports extent;

    @BeforeSuite
    public static com.aventstack.extentreports.ExtentReports setUpReport() {
        // Path to the report file
        String reportPath = System.getProperty("user.dir") + "//reports//extentreports.html";

        // Create an instance of ExtentSparkReporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);

        // Configure the HTML reporter
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Appium Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);

        System.out.println("Initializing ExtentReports...");
        // Create an instance of ExtentReports
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(htmlReporter);

        System.out.println("ExtentReports initialized.");
        // Add system information to the report (optional)
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Mounika Kokkonda");
        return extent;
    }

    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            System.out.println("Flushing ExtentReports...");
            extent.flush();
        }
    }
}