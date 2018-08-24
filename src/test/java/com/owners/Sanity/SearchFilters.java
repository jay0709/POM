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
import com.owners.properties;
import com.owners.PageFactory.SearchFilters_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchFilters {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	SearchFilters_PO sf;
	properties pr = new properties();
	commonFunctions cf = new commonFunctions();

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		sf = new SearchFilters_PO();
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
	}

	@Test(priority = 1)
	public void SearchFiltersVAlidation() throws IOException, InterruptedException {

		// Searching a ZIP
		cf.searchMapSRP("30350,Atlanta", driver);

		// Applying filter
		sf.selectAndApplyFilter(driver);

		// Verifying the listed properties as per filter
		sf.validateFiltersApplied(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
