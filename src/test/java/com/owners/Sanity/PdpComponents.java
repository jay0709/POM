/**
 * 
 */
package com.owners.Sanity;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.owners.commonFunctions;
import com.owners.desiredCapabilities;
import com.owners.PageFactory.PropertDetailsPage_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author chakraja
 *
 */
public class PdpComponents {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	PropertDetailsPage_PO pdp;
	commonFunctions cf = new commonFunctions();

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		pdp = new PropertDetailsPage_PO();
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
	}

	@Test(priority = 1)
	public void ValidatePDPComponents() throws IOException, InterruptedException {

		// Search an city in List view
		cf.searchMapSRP("Washington,DC", driver);
		Thread.sleep(2000);

		// Validating Property details
		pdp.validatePropertyDetails(driver);

		// validating school section
		cf.scrollToText("SCHOOLS", driver);
		pdp.validateSchoolSection(driver);

		// Validating Notes section
		pdp.validateNotesSection(driver);

		// validate property features
		pdp.validatePropertyKeyDetails(driver);

		// validate property Tax
		pdp.validateProertyTax(driver);

		// validate other details
		pdp.validateOtherDetails(driver);

		// validate FSBO MLS type
		pdp.validatePropertyType(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
