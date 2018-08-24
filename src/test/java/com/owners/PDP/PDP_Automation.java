package com.owners.PDP;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PDP.PageFactory.PdpSchoolMethods_PO;
import com.owners.commonFunctions;
import com.owners.desiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PDP_Automation {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	PdpSchoolMethods_PO pm = new PdpSchoolMethods_PO();

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
		System.out.println("###########################\n Starting PDP Automation\n###########################");
	}

	@Test(priority = 1)
	public void verifySchoolSection() throws InterruptedException, MalformedURLException {
		pm.findSchoolSection(driver);
		System.out.println("===========================\n PASSED TEST CASE: 1 \n===========================\n");
	}

	@Test(priority = 2)
	public void verifyToolTipDetails() {
		pm.toolTipDetailsInfo(driver);
		System.out.println("===========================\n PASSED TEST CASE: 2 \n===========================\n");
	}

	@Test(priority = 3)
	public void verifyAssignedSchool() {
		pm.topAssignedSchool(driver);
		System.out.println("===========================\n PASSED TEST CASE: 3 \n===========================\n");
	}

	@Test(priority = 4)
	public void verifyViewAllSchools() throws MalformedURLException, InterruptedException {
		pm.viewAllSchools(driver);
		System.out.println("===========================\n PASSED TEST CASE: 4 \n===========================\n");
	}

	@Test(priority = 5)
	public void verifySchoolDataSource() throws MalformedURLException, InterruptedException {
		pm.viewSchoolSourceNavigatation(driver);
		System.out.println("===========================\n PASSED TEST CASE: 5 \n===========================\n");
	}

	@AfterTest
	public void afterTest() {
		driver.removeApp("io.appium.settings");
		driver.removeApp("io.appium.unlock");
		driver.quit();
		System.out.print("\n***************************\n EXECUTION COMPLETE \n***************************\n");
	}
}
