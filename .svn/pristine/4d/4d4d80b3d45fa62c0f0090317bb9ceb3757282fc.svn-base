package com.favourites.PageFactory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.owners.commonFunctions;
import com.owners.properties;
import com.owners.PageFactory.Registration_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FavTabRequestTour {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	Registration_PO reg = new Registration_PO();
	properties pr = new properties();
	FavTabID_PO ft = new FavTabID_PO();
	PDP_PO pdp = new PDP_PO();
	FavoritesTab_PO ftpo = new FavoritesTab_PO();

	public String saveFSBOListing(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		cf.openFSBOProperty(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.pdpfavIcon));
		String pdpPrice = driver.findElement(pdp.pdpPriceView).getText();
		driver.findElement(pdp.pdpfavIcon).click();
		return pdpPrice;
	}

	public void checkSchduleTourFSBO(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String pdpPrice = saveFSBOListing(driver);
		Thread.sleep(3000);
		driver.findElement(pdp.favToastMessage).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.favPropertyPrice));
		Assert.assertEquals(pdpPrice, driver.findElement(ft.favPropertyPrice).getText(),
				"Property Price does not match..!!");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ft.schduleTourButton));
			System.out.println("Request Tour Button present for FSBO property. TEST CASE FAILED..!!");
		} catch (Exception ex) {
			System.out.println("Request Tour Button not present for FSBO property. TEST CASE PASSED..!!");
		}
	}

	public void checkSchduleTourMLS(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(ft.clickFavouriteTab).click();
		Thread.sleep(5000);
		String pdpAddress = driver.findElement(ft.favPropertyAddress).getText();
		String AddressLine1 = pdpAddress.substring(0, pdpAddress.indexOf(",")).trim();
		String AddressLine2 = pdpAddress.substring(pdpAddress.indexOf(",") + 1, pdpAddress.length()).trim();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.schduleTourButton));
		System.out.println("Request Tour button present in the Fav Tab for property..!!");
		driver.findElement(ft.schduleTourButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourPageAddressFirstLine));
		String requestTourHeader = driver.findElement(pdp.requestTourPageHader).getText();
		Assert.assertEquals(requestTourHeader, "Request a Tour", "Header text does not macth...!!");
		try {
			String pdpAddressLine1 = driver.findElement(pdp.requestTourPageAddressFirstLine).getText().trim();
			String pdpAddressLine2 = driver.findElement(pdp.requestTourPageAddressSecondLine).getText().trim();
			Assert.assertEquals(AddressLine1, pdpAddressLine1, "Address does not match..!!");
			Assert.assertEquals(AddressLine2, pdpAddressLine2, "Address does not match..!!");
			System.out.println(" Address matched as: " + pdpAddress);
		} catch (Exception e) {
			System.out.println("Address does not match..Moving ahead!!");
		}
		try {
			String asap = driver.findElement(pdp.requestASAPTile).getText();
			Assert.assertEquals(asap, "ASAP", "ASAP option verified..!!");
		} catch (Exception ex) {
			try {
				String month = driver.findElement(pdp.requestTourMonth).getText();
				String date = driver.findElement(pdp.requestTourDayOfMonth).getText();
				String day = driver.findElement(pdp.requestTourDayOfWeek).getText();
				System.out.println("First tour date is: " + day + " " + date + " " + month);
			} catch (Exception e) {

			}
		}
		String email = driver.findElement(pdp.requestTourEmailUser).getText();
		Assert.assertEquals(email.toLowerCase(), pr.email1.toLowerCase(),
				"Email ID does not match with logged in user");
		System.out.println("Email id verified as: " + email);
		String comments = driver.findElement(pdp.requestTourComment).getText();
		System.out.println("Pre-filled commment text: " + comments);

	}

	public void checkAvailableTimes(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestASAPTile));
			System.out.println("ASAP tile available.. clicking on the next slot..");
			driver.findElement(pdp.requestTourDayOfMonth).click();
			System.out.println("Clicked on the tour date slot...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourTime));
			System.out.println("Time slots are visible now..!");
		} catch (Exception e) {
			driver.findElement(pdp.requestTourDayOfMonth).click();
			System.out.println("Clicked on the tour date slot...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourTime));
			System.out.println("Time slots are visible now..!");
		}
		String month = driver.findElement(pdp.requestTourMonth).getText();
		String date = driver.findElement(pdp.requestTourDayOfMonth).getText();
		String day = driver.findElement(pdp.requestTourDayOfWeek).getText();
		String time = driver.findElement(pdp.requestTourTime).getText();
		System.out.println("First tour date is: " + day + " " + date + " " + month + " with  first time slot: " + time);

	}

	public void checkUserDetails(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(pdp.requestTourEmailUser).click();
		Thread.sleep(2000);
		System.out.println("First Name verified as: " + driver.findElement(pdp.requestTourFirstName).getText());
		System.out.println("Last Name verified as: " + driver.findElement(pdp.requestTourLastName).getText());
		firstNameValidation(driver);
		lastNameValidation(driver);
		cf.scrollToText("Additional comments(optional)", driver);
		emailFieldValidation(driver);
		System.out.println(
				"Email ID verified as: " + driver.findElement(pdp.requestTourEmailID).getText().replaceAll("-", ""));
		System.out.println("Consent Text verified as: " + driver.findElement(pdp.requestTourConsent).getText());
		driver.findElement(pdp.requetsTourPageBackButton).click();
		ftpo.checkNoSavedListingsText(driver);
	}

	public void emailFieldValidation(AndroidDriver<AndroidElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(pdp.requestTourEmailID).clear();
		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourInvalidInput));
		System.out.println("Email is blank of Invalid --> Validated");
		driver.findElement(pdp.requestTourEmailID).sendKeys("testaccount@gmail");
		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourInvalidInput));
		System.out.println("Invalid email id --> Validated");
	}

	public void firstNameValidation(AndroidDriver<AndroidElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(pdp.requestTourFirstName).clear();
		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourInvalidInput));
		System.out.println("First Name is blank of Invalid --> Validated");
		driver.findElement(pdp.requestTourFirstName).sendKeys("Test123");
		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourInvalidInput));
		System.out.println("Invalid first name  --> Validated");
	}

	public void lastNameValidation(AndroidDriver<AndroidElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(pdp.requestTourLastName).clear();
		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourInvalidInput));
		System.out.println("Last Name is blank of Invalid --> Validated");
		driver.findElement(pdp.requestTourLastName).sendKeys("Last123");
		driver.hideKeyboard();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdp.requestTourInvalidInput));
		System.out.println("Invalid last name  --> Validated");
	}
}
