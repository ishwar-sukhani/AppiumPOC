package com.app.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage {
	
	@iOSFindBy(className = "log")
	@AndroidFindBy(accessibility = "log-in-button")
	private MobileElement homeLogin;
	
	@iOSFindBy(className = "sign")
	@AndroidFindBy(accessibility = "sign-up-button")
	private MobileElement homeSignUp;

	// Constructor
	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickLogin() {
		if(homeLogin.isEnabled())
			homeLogin.click();
	}
	
	public void clickSignUp() {
		if(homeSignUp.isEnabled())
			homeSignUp.click();
	}
}
