package appiumpackbasics;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestDriver {
	
	public static AndroidDriver driver;

	public void startAppiumServr() throws InterruptedException, MalformedURLException {
		
		//Starting Appium server through our script
		AppiumServiceBuilder service = new AppiumServiceBuilder();
		service.withIPAddress("127.0.0.1");
		service.usingPort(4723);
		AppiumDriverLocalService localservice = io.appium.java_client.service.local.AppiumDriverLocalService
				.buildService(service);
		localservice.start();
		System.out.println("appium server is started");
		
		//connecting through the device with appropriate app
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("emulator1");
		options.setPlatformName("Android");
//		options.setAppPackage("io.appium.android.apis");
//		options.setAppActivity("io.appium.android.apis.ApiDemos");
		
		options.setAppPackage("com.android.chrome");
		
		options.setApp("C:\\Users\\promp\\OneDrive\\Documents\\Apk2.0\\General-Store.apk");
		options.setPlatformVersion("12");
		
		options.setChromedriverExecutable("C:\\Users\\promp\\OneDrive\\Documents\\chrome 129\\chromedriver.exe");
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("autoWebView", false);
		
		//intialize android driver and give the url of server
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		Thread.sleep(6000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();

//		localservice.stop();
//		System.out.println("appium server is stopped");

	}

}
