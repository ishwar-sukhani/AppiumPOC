package com.app.setup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidSetup {
	
	protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException,InterruptedException {
    	
        File appDir = new File("C:\\Users\\supreetgandhi\\eclipse-workspace\\AndroidTest\\src\\test\\resources\\com\\insta\\apps\\");
        File app = new File(appDir, "app-testing-v3.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Moto G (5s) Plus 3301");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appActivity", "com.instarem.mobileapp.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        //other caps
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        
        Thread.sleep(5000);
        //driver.closeApp();
        //driver.findElement(By.name("log-in-button")).click();
        //driver.findElementByAndroidUIAutomator("UiSelector().description(\"log-in-button\")").click();
       // driver.findElementByLinkText("Log In");
        //driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='log-in-button']")).click();
        //driver.findElement(By.xpath("//android.view.ViewGroup[@text='Log In']")).click();
        
        driver.findElementByAccessibilityId("log-in-button").click();
        driver.			
        System.out.println("ALL DONE...");
    }
    
    public static void main(String[] args) throws MalformedURLException,InterruptedException {
		AndroidSetup testAndroidSetup = new AndroidSetup();
		testAndroidSetup.prepareAndroidForAppium();
		System.out.println("Returned");
	}
}
