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
import com.owners.properties;
import com.owners.PageFactory.FavouriteProperty_PO;
import com.owners.PageFactory.PropertDetailsPage_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author chakraja
 *
 */
public class SaveFavouriteProperty {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	PropertDetailsPage_PO pdp;
	FavouriteProperty_PO fp;
	properties pr = new properties();
	commonFunctions cf = new commonFunctions();

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		fp = new FavouriteProperty_PO();
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
	}

	@Test(priority = 1)
	public void FavouritePorpertyValidation() throws IOException, InterruptedException {

		// CLicking Search Tab & searching Miami
		cf.searchMapSRP("Miami,FL", driver);

		// get property details from List view & Favorite a property from list
		// view
		// Comparing the values of list view against the Favorite tab

		fp.verifyPorpertyDetailsFavourite(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}