package com.pack.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends AppiumUtils {

    protected static AndroidDriver driver;
    private AppiumDriverLocalService localservice;

    @BeforeClass
    public void startAppiumServer() {
        // Starting Appium server
        try {
            AppiumServiceBuilder service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723);
            localservice = AppiumDriverLocalService.buildService(service);
            localservice.start();
            System.out.println("Appium server started successfully");
        } catch (Exception e) {
            System.err.println("Failed to start Appium server: " + e.getMessage());
            throw new RuntimeException("Appium server failed to start");
        }
    }

    @BeforeMethod
    public void setupAndroidDriver() throws MalformedURLException {
        try {
            if (driver == null) {
            	
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName("emulator1");
                options.setPlatformName("Android");
                options.setApp("C:\\Users\\promp\\OneDrive\\Documents\\Apk2.0\\General-Store.apk");
                options.setPlatformVersion("12");
                options.setChromedriverExecutable(
                        "C:\\Users\\promp\\OneDrive\\Documents\\chrome 129\\chromedriver.exe");
                options.setCapability("autoGrantPermissions", true);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            }
            restartApp(); // Restart the app to the main activity
        } catch (Exception e) {
            System.err.println("Failed to initialize AndroidDriver: " + e.getMessage());
            throw new RuntimeException("AndroidDriver initialization failed");
        }
    }

    private void restartApp() {
        try {
            System.out.println("Restarting app...");
            driver.terminateApp("com.androidsample.generalstore"); // Replace with your app's package name
            driver.activateApp("com.androidsample.generalstore"); // Replace with your app's package name
            Thread.sleep(5000); // Wait for the app to load
        } catch (Exception e) {
            System.err.println("Failed to restart app: " + e.getMessage());
            throw new RuntimeException("App restart failed");
        }
    }

    @AfterClass
    public void stopAppiumServer() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully");
        }
        if (localservice != null && localservice.isRunning()) {
            localservice.stop();
            System.out.println("Appium server stopped");
        }
    }
}
