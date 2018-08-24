/**
 * 
 */
package com.owners.PageFactory;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class FavouriteProperty_PO {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	properties pr = new properties();
	commonFunctions cf = new commonFunctions();
	PropertDetailsPage_PO pdp = new PropertDetailsPage_PO();

	public By listPropertyAddress = By.id("com.owners.buyer:id/search_result_property_address");
	public By favPropertyList = By.id("com.owners.buyer:id/search_result_fav_button");
	public By clickFavouriteTab = By.xpath("//android.support.v7.app.ActionBar.Tab[2]//android.widget.LinearLayout[1]");
	public By favPropertyPrice = By.id("com.owners.buyer:id/property_price");
	public By favPropertyAddress = By.id("com.owners.buyer:id/property_address");
	public By favPropertyDetails = By.id("com.owners.buyer:id/property_textview");

	public void favPropertyFromList(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(favPropertyList).click();
		Thread.sleep(5000);
	}

	public String propertyAddressList(AndroidDriver<AndroidElement> driver) {
		pr.propertyAddressList = driver.findElement(listPropertyAddress).getText();
		return pr.propertyAddressList;
	}

	public void verifyPorpertyDetailsFavourite(AndroidDriver<AndroidElement> driver)
			throws InterruptedException, MalformedURLException {
		pr.propertyPriceList = pdp.getProeprtyPriceFromList(driver);
		pr.listBedBathSqft = pdp.getPropertyBedBathSqftList(driver);
		pr.propertyAddressList = propertyAddressList(driver);
		favPropertyFromList(driver);
		driver.findElement(clickFavouriteTab).click();
		Thread.sleep(5000);
		pr.propertyPriceFav = driver.findElement(favPropertyPrice).getText();
		Assert.assertEquals(pr.propertyPriceList, pr.propertyPriceFav, "Price doesn't match..!");
		pr.porpertyAddressFav = driver.findElement(favPropertyAddress).getText();
		Assert.assertEquals(pr.propertyAddressList, pr.porpertyAddressFav, "Property Adrress not matching..!");
		element = driver.findElement(favPropertyDetails);
		pr.listBedBathSqft = cf.countBedBathSqft(element.getText());
		Assert.assertEquals(pr.listBedBathSqft[0], pr.listBedBathSqft[0], "Proprty Bed count does not match..!");
		Assert.assertEquals(pr.listBedBathSqft[1], pr.listBedBathSqft[1], "Proprty Bath count does not match..!");
		Assert.assertEquals(pr.listBedBathSqft[2], pr.listBedBathSqft[2], "Proprty SqFt does not match..!");
		System.out.println("Favourited property validated..");
		driver.findElement(By.id("com.owners.buyer:id/fav_button")).click();

	}
}
