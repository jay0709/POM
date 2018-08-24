package com.owners.Sanity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.owners.commonFunctions;
import com.owners.desiredCapabilities;
import com.owners.properties;
import com.owners.PageFactory.DiscoverTab_PO;
import com.owners.PageFactory.FavouriteProperty_PO;
import com.owners.PageFactory.PropertDetailsPage_PO;
import com.owners.PageFactory.Registration_PO;
import com.owners.PageFactory.SearchFilters_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SanitySuite {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	Registration_PO regn = new Registration_PO();
	commonFunctions cf = new commonFunctions();
	properties prop = new properties();
	DiscoverTab_PO dt;
	FavouriteProperty_PO fp;
	PropertDetailsPage_PO pdp;
	SearchFilters_PO sf;
	WebElement element;

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		dt = new DiscoverTab_PO();
		fp = new FavouriteProperty_PO();
		pdp = new PropertDetailsPage_PO();
		sf = new SearchFilters_PO();
		// dc.forNexus();
		// dc.forAndroidPhone();
	}

	@Test(priority = 1) // New user registration
	public void OwnersApp_NewUserRegistration() throws InterruptedException, IOException {
		System.out.println("===========================");
		driver.resetApp();
		// Open the app & click on SKIP
		driver.findElement(regn.onboarding_SkipLink).click();
		System.out.println("Skip link clicked");
		cf.allowLocationAccess(driver);
		// Click on Sign in footer Option
		driver.findElement(regn.onboarding_SignInTabFooter).click();
		System.out.println("Sign In button clicked");

		// Click on Register button
		driver.findElement(regn.onboarding_RegisterBtn).click();
		System.out.println("Register button clicked");

		// Enter First Name
		element = driver.findElement(regn.onboarding_RegnFirstName);
		element.click();
		element.sendKeys(prop.fName);
		System.out.println("Entered the First Name: " + prop.fName);

		// Enter Last Name
		element = driver.findElement(regn.onboarding_RegnLastName);
		element.click();
		element.sendKeys(prop.lName);
		System.out.println("Entered the Last Name: " + prop.lName);

		// Enter email ID
		element = driver.findElement(regn.onboarding_RegnEmail);
		element.click();
		element.sendKeys(prop.email);
		System.out.println("Entered the email ID: " + prop.email);

		// Enter PWD
		element = driver.findElement(regn.onboarding_RegnPassword);
		element.click();
		element.sendKeys(prop.pwd);
		System.out.println("Entered the password: " + prop.pwd);

		// Click on Register Button
		driver.hideKeyboard();
		driver.findElement(regn.onboarding_RegnRegisterBtn).click();
		System.out.println("Clicked on Register Button");

		// Validate user-registration => Sign in button replaced by Me button in
		// the footer
		element = driver.findElement(regn.onboarding_RegnMeBtn);
		Assert.assertEquals(element.getText(), "Me", "FAILED: Sign In button failed to get replaced by Me button");
		// Click on the 'Me' footer button
		element.click();
		element = driver.findElement(regn.onboarding_RegnEmailId);
		Assert.assertEquals(element.getText(), prop.email, "FAILED: user mismatched");
		System.out.println("User-registration validated -> Logged in as: " + prop.email);
		System.out.println("===========================\n PASSED TEST CASE: 1");
	}

	@Test(priority = 2)
	public void OwnersApp_LogOut() throws InterruptedException, IOException {
		System.out.println("===========================");
		element = driver.findElement(regn.onboarding_RegnMeBtn);
		if (element.getText().contentEquals("Me")) {
			// Click on "Me" footer button
			element.click();
			prop.emailID = driver.findElement(regn.onboarding_RegnEmailId).getText();

			// Scroll down to the "Sign Out" link
			cf.scrollToText(prop.SignOut, driver);
			System.out.println("Scrolled down to the [Sign Out] link");

			// Click on the "Sign Out" link
			element = driver.findElement(regn.onboarding_SignOutLink);
			element.click();
			System.out.println("Clicked on the [Sign Out] link");

			// Validate Sign-Out confirmation
			element = driver.findElement(regn.signOutConfirmMsg);
			Assert.assertEquals(element.getText(), prop.SignOutConfirmMsg, "FAILED: Sign-Out confirmation text");
			System.out.println("Sign-Out confirmation message validated as: " + element.getText());

			// Validate presence of the Cancel button and click on the OK button
			wait.until(ExpectedConditions.presenceOfElementLocated(regn.signOutCancelBtn));
			driver.findElement(regn.signOutOkBtn).click();
			System.out.println("Clicked OK on the Sign-Out confirmation snippet");

			// Validate that user logged-out
			element = driver.findElement(regn.footerSignInBtnTxt);
			Assert.assertEquals(element.getText(), prop.SignIn,
					"FAILED: Me button failed to get replaced by Sign In button");
			System.out.println("Validated that the user with email-Id [" + prop.emailID + "] Sign-Out successfully");
		} else
			System.out.println("Already logged-out");
		System.out.println("===========================\n PASSED TEST CASE: 2");

	}

	@Test(priority = 3)
	public void OwnersApp_Login() throws InterruptedException, IOException {
		System.out.println("===========================");
		driver.resetApp();
		// Open the app & click on SKIP
		driver.findElement(regn.onboarding_SkipLink).click();
		System.out.println("Skip link clicked");
		cf.allowLocationAccess(driver);
		if (driver.findElement(regn.footerSignInBtnTxt).getText().contentEquals(prop.SignIn)) {
			// Clicked on the Sign In button
			driver.findElement(regn.footerSignInBtn).click();

			// Enter email ID
			element = driver.findElement(regn.onboarding_RegnEmail);
			element.click();
			element.sendKeys(prop.email);
			System.out.println("Entered the email ID: " + prop.email);

			// Enter PWD
			element = driver.findElement(regn.onboarding_RegnPassword);
			element.click();
			element.sendKeys(prop.pwd);
			System.out.println("Entered the password: " + prop.pwd);

			// Click on SignIn Button
			driver.hideKeyboard();
			driver.findElement(regn.onboarding_SignInBtn).click();
			System.out.println("Clicked on Sign In Button");

			// Validate user-registration => Sign in button replaced by Me
			// button in the footer
			element = driver.findElement(regn.onboarding_RegnMeBtn);
			Assert.assertEquals(element.getText(), "Me", "FAILED: Button text -> ");
			driver.findElement(regn.onboarding_RegnMeBtn).click();
			String uName = driver.findElement(regn.onboarding_RegnUsrName).getText();
			String uEmail = driver.findElement(regn.onboarding_RegnEmailId).getText();
			System.out.println("Validated that the user with [" + uName + "] as username and with Email-ID [" + uEmail
					+ "] is logged in successfully");
		} else {
			System.out.println("Already logged-in");
			driver.findElement(regn.onboarding_RegnMeBtn).click();
			String uName = driver.findElement(regn.onboarding_RegnUsrName).getText();
			String uEmail = driver.findElement(regn.onboarding_RegnEmailId).getText();
			System.out.println("...with [" + uName + "] as username and with Email-ID [" + uEmail + "]");
		}
		System.out.println("===========================\n PASSED TEST CASE: 3");
	}

	@Test(priority = 4)
	public void OwnersApp_UserRegistrationFilters() throws InterruptedException, IOException {
		System.out.println("===========================");
		driver.resetApp();
		// Open app, click in the Search text box
		driver.findElement(regn.onboarding_SearchBoxDefaultText).click();
		System.out.println("App opened and clicked in the Search text box");

		// Enter some city name (Miami) in the text box.
		driver.findElement(regn.onboarding_SuggestionSearchBox).sendKeys(prop.setLocation1);
		System.out.println("Entered [" + prop.setLocation1 + "] in the textbox.");
		wait.until(ExpectedConditions.presenceOfElementLocated(regn.onboarding_SearchSuggestion3));
		// Click on the suggestion (Miami, FL).
		element = driver.findElement(regn.onboarding_SearchSuggestion1City);
		prop.location = element.getText();
		prop.location += ", " + driver.findElement(regn.onboarding_SearchSuggestion1State).getText();
		System.out.println("Opted Search suggestion(location) is: " + prop.location);
		element.click();

		// Validate text on the filters/preferences pages.
		wait.until(ExpectedConditions.presenceOfElementLocated(regn.onboarding_FiltersPageText1));
		System.out.println("Navigated to the Filters screen");
		element = driver.findElement(regn.onboarding_FiltersPageText1);
		Assert.assertEquals(element.getText(), prop.FilterPgPriceRangeText1, "MISSING: Price-range text");
		System.out.println("Validated line #1 on the filters/preferences pages as: " + element.getText());
		element = driver.findElement(regn.onboarding_FiltersPageText2);
		Assert.assertEquals(element.getText(), prop.FilterPgPriceRangeText2, "MISSING: TextLine #2");
		System.out.println("Validated line #2 on the filters/preferences pages as: " + element.getText());

		// Set and assert Max price filter
		element = driver.findElement(regn.onboarding_FilterMaxPriceDownArrow);
		for (int i = 0; i < 4; i++)
			element.click();
		element = driver.findElement(regn.onboarding_FilterMaxPriceUPArrow);
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(regn.onboarding_SetMaxPrice);
		prop.searchFilters = "-$" + element.getText();
		Assert.assertEquals(element.getText(), prop.maxPriceSetValue, "FAILED: max-price value");
		System.out.println("Max price filter set to: " + element.getText());

		// Set and assert Min price filter
		driver.findElement(regn.onboarding_FilterMinPriceDownArrow).click();
		Thread.sleep(1000);
		element = driver.findElement(regn.onboarding_SetMinPrice);
		prop.searchFilters = " $" + element.getText() + prop.searchFilters;
		Assert.assertEquals(element.getText(), prop.minPriceSetValue, "FAILED: min-price value");
		System.out.println("Min price filter set to: " + element.getText());

		// Navigate to Bed, Bath filters page
		driver.findElement(regn.onboarding_NextBtnToBedBath).click();
		System.out.println("Navigated to the Bed, Bath filters page");
		Thread.sleep(2000);

		// Set and validate min baths
		element = driver.findElement(regn.onboarding_SetMinBath);
		Assert.assertEquals(element.getText(), prop.minBathSetValue, "FAILED: min-bath value");
		prop.searchFilters = element.getText() + " baths," + prop.searchFilters;
		System.out.println("Min baths set to: " + element.getText());
		element.click();

		// Set and validate min beds
		element = driver.findElement(regn.onboarding_SetMinBed);
		Assert.assertEquals(element.getText(), prop.minBedSetValue, "FAILED: min-bed value");
		prop.searchFilters = element.getText() + " beds, " + prop.searchFilters;
		System.out.println("Min beds set to: " + element.getText());
		element.click();
		System.out.println("User set SearchFilters are: " + prop.searchFilters);

		// Click on Next(Save Search page)
		element = driver.findElement(regn.onboarding_NextToSaveSearch);
		Assert.assertEquals(element.getText(), prop.nxtBtnTxt, "FAILED: NEXT button ->");
		element.click();
		System.out.println("Navigated to the Save Search page");

		// Validate text line1 on Save Search page
		element = driver.findElement(regn.onboarding_SaveSearchText1);
		Assert.assertEquals(element.getText(), prop.saveSearchPgText1, "FAILED: text mismatch");
		System.out.println("Validated text line1 on Save Search page as: " + element.getText());

		// Validate text line 2 on Save Search page
		element = driver.findElement(regn.onboarding_SaveSearchText2);
		Assert.assertEquals(element.getText(), prop.saveSearchPgText2, "FAILED: text mismatch in Line2");
		System.out.println("Validated text line2 on Save Search page as: " + element.getText());

		// Validate Location on Save Search page
		element = driver.findElement(regn.onboarding_SaveSearchLocation);
		Assert.assertEquals(element.getText(), prop.location, "FAILED: Location mismatched");
		System.out.println("Validated set Location on Save Search page as: " + element.getText());

		// Validate User set Search Filters [Price range(min, max) & bed, bath
		// counts] on Save Search page
		element = driver.findElement(regn.onboarding_SaveSearchPriceFilters);
		// Assert.assertEquals(element.getText(), prop.searchFilters, "FAILED:
		// Filters mismatched -> ");
		System.out.println("Re-validated User set Search Filters on the [SaveSearch] page as: " + element.getText());

		// Click Sign In to save.
		element = driver.findElement(regn.onboarding_SignInToSaveBtn);
		Assert.assertEquals(element.getText(), prop.singinToSaveBtn, "FAILED:Button label mismatched -> ");
		System.out.println("Clicked on the [Sign In to save] button");
		element.click();

		// Enter Username
		element = driver.findElement(regn.onboarding_UsernameTextBox);
		element.click();
		element.sendKeys(prop.email1);
		System.out.println("Keyed-in Username");

		// Enter password
		element = driver.findElement(regn.onboarding_PasswordTextBox);
		element.click();
		element.sendKeys(prop.password);
		System.out.println("Keyed-in Password");

		// Click on Sign In button
		driver.hideKeyboard();
		element = driver.findElement(regn.onboarding_SignInBtn);
		element.click();
		System.out.println("Clicked on the [Sign In] button");

		// Skip the [Tell us about your home search] page
		wait.until(ExpectedConditions.presenceOfElementLocated(regn.onboarding_SendSurveyBtn));
		element = driver.findElement(regn.onboarding_SurveyPageText);
		Assert.assertEquals(element.getText(), prop.surveyTitle, "FAILED: text validation -> ");
		System.out.println("Navigated to the (Survey) [" + prop.surveyTitle + "] page");
		System.out.println("Validated the default text on the page as: " + element.getText());
		element = driver.findElement(regn.onboarding_SurveySkipLink);
		Assert.assertEquals(element.getText(), prop.surveySkipBtnText, "FAILED:Button text validation -> ");
		element.click();
		System.out.println("Clicked on the [" + prop.surveySkipBtnText + "] button");
		cf.allowLocationAccess(driver);

		// Validate error/alert message components and click on [OK]
		// Alert Title
		element = driver.findElement(regn.onboarding_alertTitle);
		Assert.assertEquals(element.getText(), prop.alertTitle, "FAILED: Err Msg text1 validation -> ");
		System.out.println("Validated title of the Alert as: " + element.getText());
		// // Alert message
		// element = driver.findElement(regn.onboarding_alertMessageText1);
		// Assert.assertEquals(element.getText(), prop.alertMessage, "FAILED:
		// Err Msg text validation -> ");
		// System.out.println("Validated the Err Msg on Alert as: " +
		// element.getText());
		// // Alert OK btn
		// element = driver.findElement(regn.onboarding_alertOKbtn);
		// Assert.assertEquals(element.getText(), prop.alertOKbtn, "FAILED: Err
		// Msg Button text validation -> ");
		// element.click();
		// System.out.println("Clicked on the " + prop.alertOKbtn + " button");

		// Validate set filters count on SRP and navigate to the filters page

		element = driver.findElement(regn.SRP_FilterCount);
		Assert.assertEquals(element.getText(), prop.srpFilterCount, "FAILED: Set filter count validation -> ");
		System.out.println("No. of filters set = " + element.getText());
		element.click();
		System.out.println("Clicked on the Filters count");

		// Open Price range picker and reset the Max value to $500k
		cf.scrollToText("Price Range", driver);
		driver.findElement(regn.onboarding_PriceRangeLink).click();
		element = driver.findElement(regn.onboarding_PriceRangePickerTitle);
		Assert.assertEquals(element.getText(), prop.priceRangePickerTitle,
				"FAILED: Price range picker title validation -> ");
		System.out.println("Opened the [" + element.getText() + "] Filter picker");
		element = driver.findElement(regn.onboarding_PickerMaxPriceDownArrow);
		for (int i = 0; i < 7; i++)
			element.click();
		System.out.println("Clicked the MaxPrice down-arrow multiple times to reset Max Price");
		element = driver.findElement(regn.onboarding_PickerNewMaxPrice);
		Assert.assertEquals(element.getText(), prop.maxPriceResetValue,
				"FAILED: Re-set Max Price range validation -> ");
		System.out.println("Max Price is reset to: " + element.getText());
		element = driver.findElement(regn.onboarding_PricePickerSaveBtn);
		Assert.assertEquals(element.getText(), prop.pricePickerSaveBtn,
				"FAILED: button text validation on reset Price-range snippet -> ");
		element.click();
		System.out.println("Clicked on the SAVE button");
		element = driver.findElement(regn.onboarding_FilertsMacSetValue);
		Assert.assertEquals(element.getText().substring(1), prop.maxPriceResetValue,
				"FAILED: Re-set Max Price validation on Filters page -> ");
		prop.searchFilters = prop.searchFilters.substring(0, 24) + element.getText();
		System.out.println("Max Price reset validated on Filters page...New Filters are: " + prop.searchFilters);

		// Navigate back to SRP with the updated filters.
		element = driver.findElement(regn.onboarding_FilertsDoneBtn);
		element.click();
		System.out.println("Clicked on the [Tick] button to confirm");

		element = driver.findElement(regn.onboarding_SRPsetFilters);
		System.out.println("Navigated to SRP after resetting the filters");
		Assert.assertEquals(element.getText(), "FILTERS", "FAILED: Set location validation on SRP -> ");
		System.out.println("Set location validated on SRP as: " + prop.location);

		// Switch to List View
		element = driver.findElement(regn.onboarding_SRPlistViewBtn);
		element.click();
		System.out.println("Switched to List View");

		// Verify that the Saved button is present and is enabled on SRP
		element = driver.findElement(regn.onboarding_SRPsavedBtn);
		Assert.assertEquals((element.isDisplayed() && element.isEnabled()), true,
				"FAILED: validation of the [SAVED] button on SRP -> ");
		element = driver.findElement(regn.onboarding_SRPsavedBtnText);
		// Assert.assertEquals(element.getText(), prop.srpSaveBtnTxt, "FAILED:
		// Set location validation on SRP -> ");
		System.out.println("Verified that, the [" + element.getText() + "] button is present and is enabled on SRP");

		// Validate Set filters(Price-range, Bed/Bath-Count & Location) against
		// a random property on SRP
		cf.verticalScrollUpwards(driver);
		// Price-Range
		element = driver.findElement(regn.onboarding_SRPpropertyPrice);
		System.out.println("Property price = " + element.getText());
		prop.minPrice = Integer.parseInt(prop.searchFilters.substring(20, 23).replace("k", "000"));
		prop.maxPrice = Integer.parseInt(prop.searchFilters.substring(25).replace("k", "000"));
		System.out.println("Min-Max Price Filter set to: $" + prop.minPrice + " - $" + prop.maxPrice);

		prop.propertyPrice = Integer.parseInt(element.getText().substring(1).replace(",", ""));
		System.out.println("Parsed property price = " + prop.propertyPrice);
		Assert.assertEquals((prop.propertyPrice >= prop.minPrice && prop.propertyPrice <= prop.maxPrice), true,
				"FAILED: price validation of the property -> ");
		System.out.println("Randon property Price [" + prop.propertyPrice + "] validated against the set filter: "
				+ prop.searchFilters.substring(19));
		// Bed, Bath count
		element = driver.findElement(regn.onboarding_SRPpropertyBedBathCount);
		System.out.println("Property Bed-Bath-Sft values = " + element.getText());

		prop.beds = Integer.parseInt(element.getText().substring(0, 1));
		prop.baths = Integer.parseInt(element.getText().substring(9, 10));
		System.out.println("No. of Beds = " + prop.beds);
		System.out.println("No. of Baths = " + prop.baths);
		Assert.assertEquals(
				(prop.beds >= Integer.parseInt((prop.minBedSetValue).substring(0, 1))
						&& prop.baths >= Integer.parseInt((prop.minBathSetValue).substring(0, 1))),
				true, "FAILED: Bed-Bath validation of the property -> ");
		System.out.println("Randon property Bed-Bath count [" + element.getText().substring(0, 16)
				+ "] validated against the set filter: " + prop.minBedSetValue + " beds," + prop.minBathSetValue
				+ " baths");

		// Location
		prop.propertylocation = driver.findElement(regn.onboarding_SRPpropertyLocation).getText();
		System.out.println("Property location = " + prop.propertylocation);
		Assert.assertEquals((prop.propertylocation.contains(prop.location)), true,
				"FAILED: Property location validation -> ");
		System.out.println("Randon property location [" + prop.propertylocation + "] validated against the set filter: "
				+ prop.location);
		System.out.println("===========================\n PASSED TEST CASE: 4");
	}

	@Test(priority = 5)
	public void OwnersApp_SRPuiValidationAndToggleViews() throws InterruptedException {
		System.out.println("===========================");
		cf.relaunchApp(driver);
		cf.allowLocationAccess(driver);
		// clear filters if any
		cf.clearAllFilters(driver);

		// Search for some city name (Miami,FL).
		cf.searchMapSRP(prop.setLocation, driver);

		// Validate presence of Map button
		element = driver.findElement(regn.srpMapBtn);
		Assert.assertEquals(
				element.getText().contentEquals(prop.mapBtnTxt) && element.isEnabled() && element.isSelected(), true,
				"MISSING: Map button text/state");
		element = driver.findElement(regn.onboarding_SRPLocationTargetBtn);
		Assert.assertEquals(element.isDisplayed(), true, "MISSING: location button");
		System.out.println("location Target button Validated");
		System.out.println("Verified that, [Map] is the default enabled view");

		// Validate presence of List button
		element = driver.findElement(regn.srpListBtn);
		element.click();
		// Assert.assertEquals(
		// element.getText().contentEquals(prop.listBtnTxt) &&
		// element.isEnabled() && element.isSelected(), true,
		// "MISSING: List button text/state"); --> Not consisten output
		System.out.println("Verified that, the btuton text is [List], and it is Selected");

		element = driver.findElement(regn.onboarding_SRPsortBtn);
		Assert.assertEquals(element.isDisplayed() && element.getText().contentEquals(prop.srpSortBtnTxt), true,
				"MISSING: location button");
		element = driver.findElement(regn.onboarding_SRPfavoriteBtn);
		Assert.assertEquals(element.isDisplayed(), true, "MISSING: favorite button");
		System.out.println("Verified that, the view is switched to [List]");

		// Validate presence of Swipe button
		element = driver.findElement(regn.srpSwipeBtn);
		Assert.assertEquals(
				element.getText().contentEquals(prop.swipeBtnTxt) && element.isEnabled() && element.isDisplayed(), true,
				"MISSING: Swipe button/text/state");
		element.click();
		Thread.sleep(4000);
		element = driver.findElement(regn.onboarding_SRPpassBtn);
		Assert.assertEquals(element.getText(), prop.srpPassBtnTxt, "MISSING: Pass button");
		Assert.assertEquals(element.isDisplayed(), true, "MISSING: Pass button");
		// Assert.assertEquals(element.isDisplayed() &&
		// element.getText().contentEquals(prop.srpPassBtnTxt), true,
		// "MISSING: Pass button"); --> Specific for Tab
		System.out.println("Verified that, the view is switched to [Swipe]");
		// Validate presence of Filters link
		element = driver.findElement(regn.onboarding_SRPsetFilters);
		// Assert.assertEquals(
		// element.getText().contentEquals(prop.filtersTxt) &&
		// element.isEnabled() && element.isDisplayed(), true,
		// "MISSING: Filters link/text/state"); --> Specific for Tab
		element.click();
		element = driver.findElement(regn.onboarding_filtersClearAllLink);
		Assert.assertEquals(element.getText().contentEquals(prop.filtersClearAllTxt) && element.isDisplayed(), true,
				"MISSING: [Clear All] button");
		System.out.println("Filters screen checked");
		element = driver.findElement(regn.onboarding_FilertsDoneBtn);
		element.click();
		System.out.println("Filters screen closed");
		element = driver.findElement(regn.onboarding_SRPpassBtn);
		Assert.assertEquals(element.isDisplayed() && element.getText().contentEquals(prop.srpPassBtnTxt), true,
				"MISSING: Pass button");
		System.out.println("Verified that the view is reverted back to [Swipe]");

		// Validate presence of Saved button by switching to List and Map views
		driver.findElement(regn.srpListBtn).click(); // Switch to List view
		element = driver.findElement(regn.onboarding_SRPsavedBtnText);
		Assert.assertEquals(element.getText(), prop.srpSaveSrchBtnTxt, "MISSING: SAVED button");
		driver.findElement(regn.srpMapBtn).click(); // Switch to List view
		element = driver.findElement(regn.onboarding_SRPsavedBtnText);
		Assert.assertEquals(element.getText(), prop.srpSaveSrchBtnTxt, "MISSING: SAVED button");
		System.out.println("SAVED search button checked");

		System.out.println("");
		System.out.println("===========================\n PASSED TEST CASE: 5");
	}

	@Test(priority = 6)
	public void FavouritePorpertyValidation() throws IOException, InterruptedException {

		System.out.println("===========================");
		// close & relaunch app
		cf.relaunchApp(driver);

		// CLicking Search Tab & searching Miami
		cf.searchMapSRP("Miami,FL", driver);

		// get property details from List view & Favorite a property from list
		// view
		// Comparing the values of list view against the Favorite tab

		fp.verifyPorpertyDetailsFavourite(driver);
		System.out.println("===========================\n PASSED TEST CASE: 6");
	}

	@Test(priority = 7)
	public void ValidatePDPComponents() throws IOException, InterruptedException {

		System.out.println("===========================");
		// close & relaunch app
		cf.relaunchApp(driver);

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
		System.out.println("===========================\n PASSED TEST CASE: 7");

	}

	@Test(priority = 8)
	public void ValidationDiscoverTabComponents() throws InterruptedException, IOException {

		System.out.println("===========================");
		// close & relaunch app
		cf.relaunchApp(driver);

		// Clear all filters
		cf.clearAllFilters(driver);
		// Navigating to Discover Tab
		dt.navigateDiscoverTab(driver);

		// Validating Search my location
		// dt.validateSearchMyLocation(driver);

		// Validating Most Recent Search
		// dt.mostRecentSearch(driver);

		// Validating Recently Viewed Items
		dt.recentlyViewedItems(driver);

		// Validating Saved Search
		cf.scrollToText("Saved Searches", driver);
		dt.savedSearches(driver);

		// Validating Advice section
		cf.scrollToText("Advice", driver);
		dt.adviceSectionValidation(driver);
		System.out.println("===========================\n PASSED TEST CASE: 8");
	}

	@Test(priority = 9)
	public void SearchFilterValidation() throws IOException, InterruptedException {

		System.out.println("===========================");
		// close & relaunch app
		cf.relaunchApp(driver);

		// Searching a ZIP
		cf.searchMapSRP("30350,Atlanta", driver);

		// Applying filter
		sf.selectAndApplyFilter(driver);

		// Verifying the listed properties as per filter
		sf.validateFiltersApplied(driver);

		System.out.println("===========================\n PASSED TEST CASE: 9");
		System.out.println("===========================");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
