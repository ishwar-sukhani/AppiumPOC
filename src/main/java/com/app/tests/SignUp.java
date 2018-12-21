package com.app.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.app.pages.HomePage;
import com.app.setup.MobileCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignUp {

	String platform = "android";
	HomePage homepage = null;
	MobileCapabilities capabilities = null;
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		capabilities = new MobileCapabilities();
		if (platform.equalsIgnoreCase("Android")) {
			driver = new AppiumDriver<>(new URL(capabilities.appiumURL), capabilities.androidCapability());
			homepage = new HomePage(driver);
		}
		else if (platform.equalsIgnoreCase("iOS")) {
			
		}
	}
	
	@Test
	public void testSignUp() {
		try {
			Thread.sleep(10000); // Giving sometime for app to load
			homepage.clickSignUp();
		}
		catch (Exception e) {
			System.out.println("Something went wrong... ");
		}
	}
}
