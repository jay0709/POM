/**
 * 
 */
package com.owners.PageFactory;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.owners.commonFunctions;
import com.owners.properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author chakraja
 *
 */
public class PropertDetailsPage_PO {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	properties pr = new properties();
	commonFunctions cf = new commonFunctions();

	public By favIconInList = By.id("com.owners.buyer:id/search_result_fav_button");
	public By priceInList = By.id("com.owners.buyer:id/search_result_property_price");
	public By priceInPDP = By.id("com.owners.buyer:id/property_item_price_text_view");
	public By listBedBathSqft = By.id("com.owners.buyer:id/search_result_property_textview");
	public By pdpBedBathSqftId = By.id("com.owners.buyer:id/property_item_beds_text_view");
	public By expandSchoolInfo = By.id("com.owners.buyer:id/school_layout");
	public By viewAllSchools = By.id("com.owners.buyer:id/property_details_view_all_schools");
	public By statusOfProperty = By.id("com.owners.buyer:id/property_details_active_status");
	public By viewAllFeature = By.id("com.owners.buyer:id/property_details_features_button");
	public By backButton = By.id("com.owners.buyer:id/property_details_back_button");
	public By tourRequest = By.id("com.owners.buyer:id/property_details_call_to_action_text_view");
	public By listSRPTab = By.id("com.owners.buyer:id/search_list_view");
	public By editTextNote = By.id("com.owners.buyer:id/et_text");
	public By cameraIcon = By.id("com.owners.buyer:id/icon_camera");
	public By notesHeader = By.id("com.owners.buyer:id/property_details_section_title_text_view");

	public String getProeprtyPriceFromList(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(listSRPTab).click();
		Thread.sleep(2000);
		cf.verticalScrollUpwards(driver);
		cf.verticalScrollUpwards(driver);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(favIconInList));
		pr.propertyPriceList = driver.findElement(priceInList).getText();
		return pr.propertyPriceList;
	}

	public String[] getPropertyBedBathSqftList(AndroidDriver<AndroidElement> driver) {
		String getListBedBathSqftText = driver.findElement(listBedBathSqft).getText();
		pr.listBedBathSqft = cf.countBedBathSqft(getListBedBathSqftText);
		return pr.listBedBathSqft;
	}

	public void validatePropertyDetails(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 20);
		pr.propertyPriceList = getProeprtyPriceFromList(driver);
		pr.listBedBathSqft = getPropertyBedBathSqftList(driver);
		driver.findElement(priceInList).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
		pr.propertyPricePDP = driver.findElement(priceInPDP).getText();
		Assert.assertEquals(pr.propertyPricePDP, pr.propertyPriceList, "Property price not matching in PDP");
		System.out.println("Property price is: " + pr.propertyPricePDP);
		String pdpBedBathSqftText = driver.findElement(pdpBedBathSqftId).getText();
		pr.pdpBedBathSqft = cf.countBedBathSqft(pdpBedBathSqftText);
		Assert.assertEquals(pr.pdpBedBathSqft[0], pr.listBedBathSqft[0], "Bed count does not match..!");
		Assert.assertEquals(pr.pdpBedBathSqft[1], pr.listBedBathSqft[1], "Bath count does not match..!");
		Assert.assertEquals(pr.pdpBedBathSqft[2], pr.listBedBathSqft[2], "Sqft count does not match..!");
		System.out.println(pr.pdpBedBathSqft[0] + ":" + pr.pdpBedBathSqft[1] + ":" + pr.pdpBedBathSqft[2]);
	}

	public void validateSchoolSection(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException {
		driver.findElement(expandSchoolInfo).click();
		cf.scrollToText("VIEW ALL SCHOOLS", driver);
		Thread.sleep(2000);
		cf.takeScreenshot("School_info.jpg", driver);
		Assert.assertEquals(driver.findElement(viewAllSchools).getText(), "VIEW ALL SCHOOLS",
				"Schols section not Validated..!");
		System.out.println("School section validated");
	}

	public void validatePropertyKeyDetails(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, IOException {
		try {
			cf.scrollToText("STATUS", driver);
			System.out.println("Prperty status is: " + driver.findElement(statusOfProperty).getText());
		} catch (Exception e) {
			System.out.println("Property status not available..!");
		}

		cf.scrollToText("VIEW ALL FEATURES", driver);
		driver.findElement(viewAllFeature).click();
		System.out.println("Property all feature is validated..!");
		Thread.sleep(2000);
		cf.takeScreenshot("All_Feature.jpg", driver);
		driver.findElement(backButton).click();
	}

	public void validateProertyTax(AndroidDriver<AndroidElement> driver) {
		try {
			cf.scrollToText("Property Tax", driver);
			cf.takeScreenshot("Property_tax.jpg", driver);
		} catch (Exception e) {
			System.out.println("No tax section available");
		}

	}

	public void validateNotesSection(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		cf.scrollToText("Notes", driver);
		System.out.println("Notes section validated..");
		try {
			if (driver.findElement(cameraIcon).isEnabled())
				driver.findElement(notesHeader).click();
		} catch (Exception e) {

		}

		Assert.assertEquals(driver.findElement(notesHeader).getText(), "Notes", "Notes section not found..!");
	}

	public void validatePropertyType(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException {
		if (driver.findElement(tourRequest).getText().equals("Contact Seller")) {
			System.out.println("This is a FSBO or Featured property..");
		}
		if (driver.findElement(tourRequest).getText().equals("Request a Tour")) {
			System.out.println("This is a MLS property..");
			cf.scrollToText("Make an Offer", driver);
			System.out.println("Make an offer section validated..!");
			cf.takeScreenshot("Other_deatils.jpg", driver);
			cf.scrollToText("Similar Properties", driver);
			System.out.println("Similar properties section validated..!");
		}

	}

	public void validateOtherDetails(AndroidDriver<AndroidElement> driver) {
		try {
			cf.scrollToText("Estimated monthly payment", driver);
			System.out.println("Mortgage calulator section validated..!");
			cf.scrollToText("Estimate my commute", driver);
			System.out.println("Commute Time section validated..!");
		} catch (Exception e) {
			System.out.println("Other details not found..!");
		}
	}

}
