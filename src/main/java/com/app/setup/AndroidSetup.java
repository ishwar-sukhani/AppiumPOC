package com.app.setup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidSetup {
	
	protected AndroidDriver driver = null;

    protected void prepareAndroidForAppium() {
    	
    	try {
    		File appDir = new File("C:\\Users\\supreetgandhi\\eclipse-workspace\\AndroidTest\\src\\test\\resources\\com\\insta\\apps\\");
            File app = new File(appDir, "app-testing-v3.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
            capabilities.setCapability("device","Android");
            capabilities.setCapability("deviceName","Moto G (5s) Plus 3301");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("platformVersion","7.1.1");
            capabilities.setCapability("appActivity", "com.instarem.mobileapp.MainActivity");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            capabilities.setCapability("app", app.getAbsolutePath());
            driver =  new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Thread.sleep(5000);
            //AndroidElement loginBtn = driver.findElementByAccessibilityId("log-in-button");
            //loginBtn.click();
           // driver.findElement(By.xpath("//android.widget.ViewGroup[@content-desc='log-in-button']")).click();
            //el.click();
           driver.findElementByAccessibilityId("log-in-button").click();
           Thread.sleep(5000);
           driver.findElementByAccessibilityId("loginnewform_email").sendKeys("test003@test001.com");
           driver.findElementByAccessibilityId("loginnewform_password").sendKeys("P@ssw0rd1");
           driver.findElementByAccessibilityId("login-button").click();
           System.out.println("ALL DONE...");
    	}
    	catch(Exception e) {
    		System.out.println("In CATCH...");
    		e.printStackTrace();
    		driver.closeApp();
    	}
    }
    
    public static void main(String[] args) throws MalformedURLException,InterruptedException {
		AndroidSetup testAndroidSetup = new AndroidSetup();
		testAndroidSetup.prepareAndroidForAppium();
		System.out.println("Returned");
	}
}
