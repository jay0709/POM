package com.openhouse.PageFactory;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.owners.commonFunctions;
import com.owners.properties;
import com.owners.PageFactory.Registration_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OpenHouse_PO {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	Registration_PO reg = new Registration_PO();
	properties pr = new properties();

	public By srpMapBtn = By.id("com.owners.buyer:id/search_map_view");
	public By srpListBtn = By.id("com.owners.buyer:id/search_list_view");
	public By srpSwipeBtn = By.id("com.owners.buyer:id/search_swipe_view");
	public By filtersTab = By.id("com.owners.buyer:id/search_filter_view");
	public By filtersClearAll = By.id("com.owners.buyer:id/property_filters_clear_button");
	public By openHouseToggle = By.id("com.owners.buyer:id/filter_toggle_switch");
	public By applyFilterButton = By.id("com.owners.buyer:id/property_filters_done_button");
	public By appliedFilterTextInSRP = By.id("com.owners.buyer:id/filter_text");
	public By noResultErrorTextInSRP = By.id("com.owners.buyer:id/no_result_error_text");
	public By noResultErrorMessage = By.id("com.owners.buyer:id/no_result_error_container");
	public By noResultErrorHeader = By.id("com.owners.buyer:id/no_result_error");
	public By noResultErrorDescription = By.id("com.owners.buyer:id/no_result_error_description");
	public By editSearch = By.id("com.owners.buyer:id/no_result_error_edit_search");

	public By openTextInSRP = By.id("com.owners.buyer:id/search_result_open_house");
	public By openTimeInSRP = By.id("com.owners.buyer:id/search_result_open_house_time");

	public By openHouseHeaderTime = By.id("com.owners.buyer:id/search_result_open_house_time");
	public By openHouseHeaderText = By.id("com.owners.buyer:id/search_result_open_house");
	public By saveOpenHousePDP = By.id("com.owners.buyer:id/button_save_open_house");
	public By openHouseDate = By.id("com.owners.buyer:id/tv_open_house_date");
	public By openHouseTime = By.id("com.owners.buyer:id/tv_open_house_time");

	public By savedOpenHouse = By.id("com.owners.buyer:id/tv_open_house_saved_info");
	public By saveOpenHouseIcon = By.id("com.owners.buyer:id/img_open_house_saved_state");

	public By openHouseTabVerify = By.xpath("//*[contains(@text, 'My Open Houses')]");
	public By onboarding_SignInTabFooter = By
			.xpath("//android.support.v7.app.ActionBar.Tab[5]//android.widget.LinearLayout");
	public By openHouseInMe = By.xpath("//*[contains(@text,'My Open Houses')]");

	public By viewOpenHouseFromMenu = By.id("com.owners.buyer:id/open_house_view");
	public By openHouseTittleInMenu = By.id("com.owners.buyer:id/open_house_view_titlee");
	public By noSavedOpenHouse = By.xpath("//*[contains(@text,'No Saved Open Houses')]");

	public By DOM = By.id("com.owners.buyer:id/search_result_filter_days_selection");
	public By lessSevenDaysDOM = By.xpath("//android.widget.LinearLayout[@index='3']");

	public void turnOnOpenHouseFilter(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		driver.findElement(filtersTab).click();
		Thread.sleep(2000);
		driver.findElement(filtersClearAll).click();
		cf.scrollToText("Days on Owners.com", driver);
		cf.verticalScrollDownwrds(driver);
		System.out.println(driver.findElement(openHouseToggle).getText());
		if (driver.findElement(openHouseToggle).getText().equals("OFF")) {
			driver.findElement(openHouseToggle).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(openHouseToggle).getText(), "ON",
					"Open house toggle is turned on..!");
		} else
			System.out.println("Open house filter already turned on..");
		driver.findElement(applyFilterButton).click();
	}

	public void openHouseDateVerify(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		cf.verticalScrollUpwards(driver);
		String srpDate = driver.findElement(openTimeInSRP).getText().toLowerCase();
		String[] dateSRP = srpDate.split(",");
		System.out.println("Open House details in List SRP View: " + driver.findElement(openTimeInSRP).getText());

		driver.findElement(openTimeInSRP).click();
		Thread.sleep(10000);
		// cf.verticalScrollUpwards(driver);
		String pdpDate = driver.findElement(openHouseHeaderTime).getText().toLowerCase();
		String[] datePDP = pdpDate.split(",");
		Assert.assertEquals(dateSRP[0], datePDP[0], "Open House DATE is not matching");
	}

	public void openHouseTimeVerify(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		String pdpTime = driver.findElement(openHouseHeaderTime).getText().toLowerCase();
		String timePDP = pdpTime.substring(pdpTime.indexOf(",") + 2, pdpTime.indexOf("-")).trim().toLowerCase();
		cf.scrollToText("SAVE TO OPEN HOUSE SCHEDULE", driver);
		String sectionTime = driver.findElement(openHouseTime).getText().toLowerCase();
		String[] timeSection = sectionTime.split("-");
		Assert.assertEquals(timePDP, timeSection[0], "Open House Time is not matching");
		System.out.println("** Open house date is: " + driver.findElement(openHouseDate).getText().toUpperCase());
		System.out.println("** Open house time is: " + sectionTime.toUpperCase());
	}

	public void noOfOpenHouseInSavedSearch(AndroidDriver<AndroidElement> driver) {
		String openHouse = driver.findElement(openHouseTittleInMenu).getText();
		System.out.println(openHouse);
	}

	public void viewOpenHouse(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		driver.findElement(viewOpenHouseFromMenu).click();
		Thread.sleep(5000);
	}

	public void saveOpenHouse(AndroidDriver<AndroidElement> driver) {
		driver.findElement(saveOpenHousePDP).click();
		System.out.println("Clicked on Save Open House..!");
		wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(reg.onboarding_SignInBtn));
			// Enter email ID
			driver.findElement(reg.onboarding_RegnEmail).click();
			driver.findElement(reg.onboarding_RegnEmail).sendKeys(pr.email1);
			System.out.println("Entered the email ID: " + pr.email1);

			// Enter PWD
			driver.hideKeyboard();
			driver.findElement(reg.onboarding_RegnPassword).sendKeys(pr.password);
			System.out.println("Entered the password: " + pr.password);

			// Click on SignIn Button
			driver.hideKeyboard();
			driver.findElement(reg.onboarding_SignInBtn).click();
			System.out.println("Clicked on Sign In Button");

			wait.until(ExpectedConditions.visibilityOfElementLocated(saveOpenHouseIcon));
			System.out.println(driver.findElement(savedOpenHouse).getText().toUpperCase());
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(saveOpenHouseIcon));
			System.out.println(driver.findElement(savedOpenHouse).getText().toUpperCase());
		}
	}

	public void viewSavedOpenHouse(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 10);
		String savedOpenHouseText = driver.findElement(savedOpenHouse).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedOpenHouse));
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveOpenHouseIcon));
		Assert.assertEquals(savedOpenHouseText, "Saved to your Open Houses Schedule.", "Open house is not saved..");
		System.out.println("Open House icon is Visible..!");
		driver.findElement(savedOpenHouse).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(openHouseTabVerify));
		System.out.println("User landed in My Open Houses section..!");
	}

	public void pinView(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {
		cf.searchMapSRP("Roswell,GA", driver);
		Thread.sleep(5000);
		turnOnOpenHouseFilter(driver);
		cf.fromClusterToPinView(driver);
	}

	public void lessSevenDaysFilterWithOpenHouse(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		driver.findElement(filtersTab).click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filtersClearAll));
		driver.findElement(filtersClearAll).click();
		cf.scrollToText("Show Open Houses Only", driver);
		cf.verticalScrollUpwards(driver);
		System.out.println(driver.findElement(openHouseToggle).getText());
		if (driver.findElement(openHouseToggle).getText().equals("OFF")) {
			driver.findElement(openHouseToggle).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(openHouseToggle).getText(), "ON",
					"Open house toggle is turned on..!");
		} else
			System.out.println("Open house filter already turned on..");

		cf.scrollToText("Any", driver);
		driver.findElement(DOM).click();
		Thread.sleep(2000);
		driver.findElement(lessSevenDaysDOM).click();
		Thread.sleep(2000);
		driver.findElement(applyFilterButton).click();
	}

	public void noOpenHouseInSearch(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		wait = new WebDriverWait(driver, 10);
		cf.relaunchApp(driver);
		cf.searchMapSRP("Denver,IL", driver);
		turnOnOpenHouseFilter(driver);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(noResultErrorTextInSRP));
			System.out.println("Filter applied is : " + driver.findElement(noResultErrorTextInSRP).getText());
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(noResultErrorMessage));
			System.out.println(driver.findElement(noResultErrorHeader).getText());
			System.out.println(
					driver.findElement(noResultErrorDescription).getText() + driver.findElement(editSearch).getText());
			System.out.println("No open house found.. Error Message shown in SRP..");
		}
		cf.clearAllFilters(driver);

	}

}
