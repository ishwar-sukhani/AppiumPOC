package com.app.setup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidSetup {
	
	AndroidDriver<MobileElement> driver = null;
	String apkPath = "D:\\InstaWorkspace\\android13122018\\src\\test\\resources\\com\\insta\\apps\\";
	String apkFileName = "app-testing-v12.apk";
	String appiumURL = "http://0.0.0.0:4723/wd/hub";
	
	/* HomePage Locators */
	String homepageLogin = "log-in-button";
	String homepageSignUp = "sign-up-button";
	
	/* LoginPage Locators */
	String loginEmail = "loginnewform_email";
	String loginPassword = "loginnewform_password";
	String loginBtn = "login-button";	
	
	/* SignUpPage Locators */
	String signupEmail = "signup1form_email";
	String signupPassword = "signup1form_password";
	String signupBtn = "sign-up-button";
	
	/* YouPage Locators */
	String individualSignUp = "signup1form_individual";
	String corporateSignUp = "signup1form_corporate";
	String countryDropDown = "signup1form_country_code";
	String searchInput = "search_input";
	String selectCountry = "select-country-option-0";
	String termsCondChkBox = "signup1form_is_term_conditions_accepted";
	String getStarted = "get-started-button";
	
	/* EnableFingerprintPage Locators */
	String enableFingerprint = "";
	String cancelFingerprint = "cancel-button";
	
	/* PersonalInfoPage Locators */
	String titleDropDown = "personalinfoform_title";
	String selectTitle = "title-option-0";
	String firstname = "personalinfoform_first_name";
	String middlename = "personalinfoform_middle_name";
	String lastname = "personalinfoform_last_name";
	String DOB = "";
	String referralCode = "personalinfoform_referred_by_referral_code";
	String politicalExposedYes = "";
	String politicalExposedNo = "";
	String countryCode = "";
	String mobileNumber = "personalinfoform_mobile_number";
	String nationalityDropDown = "personalinfoform_nationality";
	String selectNationality = "nationality-option-0";
	String employmentStatusDropDown = "personalinfoform_employment_status";
	String selectEmploymentStatus = "employment-status-option-0";
	String fundsDropDown = "personalinfoform_source_of_funds";
	String selectFundsSource = "source-of-funds-option-0";
	String accountUseDropDown = "personalinfoform_intended_use_of_account";
	String selectAccountUse = "intended-use-of-account-option-0";
	String saveAndContinueBtn = "save-and-continue-button";
	
    public void installOrOpenApp() {
    	
    	try {
    		File appDir = new File(apkPath);
            File app = new File(appDir, apkFileName);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("device","Android");
            capabilities.setCapability("deviceName","Moto G (5s) Plus 3301");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("platformVersion","8.1.0");
            capabilities.setCapability("appActivity", "com.instarem.mobileapp.MainActivity");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            capabilities.setCapability("unicodeKeyboard", true);
            //capabilities.setCapability("resetKeyboard", true);
            capabilities.setCapability("app", app.getAbsolutePath());
            
            driver =  new AndroidDriver<MobileElement>(new URL(appiumURL), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Thread.sleep(5000);
            System.out.println("Mobile app is opened");
    	}
    	catch(Exception e) {
    		System.out.println("Something went wrong while installing or opening the mobile app");
    		e.printStackTrace();
    		driver.closeApp();
    	}
    }
    
    public void loginToApp() {
    	
    	try {
    		/* HomePage Login */
            driver.findElementByAccessibilityId(homepageLogin).click();
            Thread.sleep(5000);
            /* Login */
            driver.findElementByAccessibilityId(loginEmail).sendKeys("test003@test001.com");
            driver.findElementByAccessibilityId(loginPassword).sendKeys("P@ssw0rd1");
            driver.findElementByAccessibilityId(loginBtn).click();
            System.out.println("Login to Mobile app is successful");
		}
    	catch (Exception e) {
    		System.out.println("Something went wrong while Login...");
    		e.printStackTrace();
    		driver.closeApp();
		}
    }
    
    public void signUp() {
    	try {
    		/* HomePage Signup */
    		Thread.sleep(10000);
    		driver.findElementByAccessibilityId(homepageSignUp).click();
    		driver.hideKeyboard();
            Thread.sleep(5000);
            /* Sign Up */
            driver.findElementByAccessibilityId(signupEmail).sendKeys("tech131@insta.com");
            driver.findElementByAccessibilityId(signupPassword).sendKeys("Tech@1234");
            driver.findElementByAccessibilityId(signupBtn).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(individualSignUp).click();
            driver.findElementByAccessibilityId(countryDropDown).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(searchInput).sendKeys("Australia");
            driver.findElementByAccessibilityId(selectCountry).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(termsCondChkBox).click();
            driver.findElementByAccessibilityId(getStarted).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(cancelFingerprint).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(titleDropDown).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(selectTitle).click();
            Thread.sleep(5000);
            driver.findElementByAccessibilityId(firstname).sendKeys("Zafar");
            driver.findElementByAccessibilityId(middlename).sendKeys("Mohammad");
            driver.findElementByAccessibilityId(lastname).sendKeys("Qureshi");
            //driver.pressKey(new KeyEvent().withKey(AndroidKey.TAB));
            TouchActions action = new TouchActions(driver);
            action.scroll(driver.findElementByAccessibilityId(mobileNumber), 10, 100);
            driver.findElementByAccessibilityId(mobileNumber).sendKeys("9152123456");
            System.out.println("Sign up successful");
		}
    	catch (Exception e) {
    		System.out.println("Something went wrong while Signing Up...");
    		e.printStackTrace();
    		driver.closeApp();
		}
    }
    
  
    public static void main(String[] args) throws MalformedURLException,InterruptedException {
		AndroidSetup testAndroidSetup = new AndroidSetup();
		testAndroidSetup.installOrOpenApp();
		//testAndroidSetup.loginToApp();
		testAndroidSetup.signUp();
		System.out.println("ALL DONE");
	}
}