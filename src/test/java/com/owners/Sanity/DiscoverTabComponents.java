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
import com.owners.PageFactory.DiscoverTab_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author chakraja
 *
 */

public class DiscoverTabComponents {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	DiscoverTab_PO dt;
	commonFunctions cf = new commonFunctions();

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		dt = new DiscoverTab_PO();
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
	}

	@Test(priority = 1)
	public void ValidatonDiscoverTabComponents() throws InterruptedException, IOException {

		// Navigating to Discover Tab
		dt.navigateDiscoverTab(driver);

		// Validating Search my location
		dt.validateSearchMyLocation(driver);

		// Validating Most Recent Search
		dt.mostRecentSearch(driver);

		// Validating Recently Viewed Items
		dt.recentlyViewedItems(driver);

		// Validating Saved Search
		cf.scrollToText("Saved Searches", driver);
		dt.savedSearches(driver);

		// Validating Advice section
		cf.scrollToText("Advice", driver);
		dt.adviceSectionValidation(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
