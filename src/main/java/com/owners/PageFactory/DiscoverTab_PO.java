/**
 * 
 */
package com.owners.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author chakraja
 *
 */
public class DiscoverTab_PO {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;

	public By clickDiscoverTab = By.xpath("//android.support.v7.app.ActionBar.Tab[3]//android.widget.LinearLayout[1]");
	public By searchMyLocation = By.id("com.owners.buyer:id/property_details_icon_title_text_view");
	public By mostRecentSearchHeader = By.xpath("//*[contains(@text, 'Most recent search')]");
	public By mostRecentSearchText = By.id("com.owners.buyer:id/property_details_icon_subtitle_text_view");
	public By recenlyViewedHeader = By.id("com.owners.buyer:id/search_section_title");
	public By propertyInfo = By.id("com.owners.buyer:id/item_recent_property_info_line_1");
	public By savedSearchesHeader = By.xpath("//*[contains(@text, 'Saved Searches')]");
	public By savedSearchName = By.id("com.owners.buyer:id/item_just_for_you_search_name");
	public By adviceSectionHeader = By.xpath("//*[contains(@text, 'Advice')]");
	public By firstAdviceSection = By.id("com.owners.buyer:id/advice_article_title_text_view");

	public void navigateDiscoverTab(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(clickDiscoverTab));
		driver.findElement(clickDiscoverTab).click();
		System.out.println("Discover Tab clicked");
	}

	public void validateSearchMyLocation(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(searchMyLocation));
		WebElement element = driver.findElement(searchMyLocation);
		Assert.assertEquals(element.getText(), "Search my location", "Search my location text not found");
		System.out.println("Search My Location text validated");

	}

	public void mostRecentSearch(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(mostRecentSearchHeader));
		element = driver.findElement(By.xpath("//*[contains(@text, 'Most recent search')]"));
		Assert.assertEquals(element.getText(), "Most recent search", "Most recent search Text not found");
		System.out.println("Most recent search text validated");
		wait.until(ExpectedConditions.presenceOfElementLocated(mostRecentSearchText));
		element = driver.findElement(mostRecentSearchText);
		Assert.assertEquals(element.getText(), "Washington, DC", "Dallas was not the Most Recent Search");
		System.out.println("Most recent searched " + element.getText() + " validated");
	}

	public void recentlyViewedItems(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(recenlyViewedHeader));
		element = driver.findElement(recenlyViewedHeader);
		Assert.assertEquals(element.getText(), "Recently Viewed", "No Recently Viewed items are present");
		System.out.println("Recently Viewed secion is validated");
		element = driver.findElement(propertyInfo);
		System.out.println("Recently viewed property validated, having address as " + element.getText());
	}

	public void savedSearches(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(savedSearchesHeader));
		element = driver.findElement(savedSearchesHeader);
		Assert.assertEquals(element.getText(), "Saved Searches", "No Saved searches are present");
		element = driver.findElement(savedSearchName);
		System.out.println("Saved search is of " + element.getText());
	}

	public void adviceSectionValidation(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(adviceSectionHeader));
		element = driver.findElement(adviceSectionHeader);
		Assert.assertEquals(element.getText(), "Advice", "Advice section not visible");
		element = driver.findElement(firstAdviceSection);
		System.out.println("First Advice section is " + element.getText());
	}
}
