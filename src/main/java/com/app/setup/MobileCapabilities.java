package com.app.setup;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class MobileCapabilities {
	
	String apkPath = "D:\\InstaWorkspace\\MobilePOC\\src\\test\\resources\\com\\insta\\apps\\";
	String apkFileName = "app-testing-v12.apk";
	public String appiumURL = "http://0.0.0.0:4723/wd/hub";
	
	DesiredCapabilities capabilities;
	
	public DesiredCapabilities androidCapability() {
		File appDir = new File(apkPath);
        File app = new File(appDir, apkFileName);
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName","Moto G (5s) Plus 3301");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","8.1.0");
        capabilities.setCapability("appActivity", "com.instarem.mobileapp.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("app", app.getAbsolutePath());
        return capabilities;
	}
	
	public DesiredCapabilities iOSCapability() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", "false");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "abhisheksingh_iPhone");
        capabilities.setCapability("automationName", "XCUITTest");
        capabilities.setCapability("udid", "407c1f8b7a7944fc77cf47880cf438dddc30c769");
        capabilities.setCapability("xcodeOrgId", "4CMML4Z284");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("safariInitialUrl", "https://preprod.instarem.com");
        capabilities.setCapability("startIWDP", true);
        capabilities.setCapability("launchTimeout", 12000000);
        capabilities.setCapability("app", "/Users/testers/workspace/com.instarem.automationTestngCucumber/src/main/java/app/mobileappb2c.ipa");
        //host=4732;
        return capabilities;
	}
}
