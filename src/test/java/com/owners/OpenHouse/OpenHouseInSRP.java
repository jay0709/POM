package com.owners.OpenHouse;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.openhouse.PageFactory.OpenHouseDiscoverPage_PO;
import com.openhouse.PageFactory.OpenHouseInMapView_PO;
import com.openhouse.PageFactory.OpenHouseMenu_PO;
import com.openhouse.PageFactory.OpenHouse_PO;
import com.owners.commonFunctions;
import com.owners.desiredCapabilities;
import com.owners.PageFactory.DiscoverTab_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OpenHouseInSRP {
	desiredCapabilities dc = new desiredCapabilities();
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	DiscoverTab_PO dt;
	commonFunctions cf = new commonFunctions();
	OpenHouse_PO oh = new OpenHouse_PO();
	OpenHouseMenu_PO ohm = new OpenHouseMenu_PO();
	OpenHouseDiscoverPage_PO ohd = new OpenHouseDiscoverPage_PO();
	OpenHouseInMapView_PO ohq = new OpenHouseInMapView_PO();

	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException {
		dt = new DiscoverTab_PO();
		dc.forAndroidTab();
		driver = dc.getAndroidDriver();
		wait = dc.getWebDriverWait();
	}

	@Test(priority = 1)
	public void verifyOpenHousePropertyInSRP() throws InterruptedException, IOException {

		System.out.println("###########################\n Starting Execuiton\n###########################");
		// search for Atlanta, GA
		cf.deleteAllSAvedSearch(driver);
		cf.searchMapSRP("Atlanta,GA", driver);

		// Enable open house
		oh.turnOnOpenHouseFilter(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cf.searchingDialouge));

		// verify open house in SRP
		driver.findElement(oh.srpListBtn).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cf.searchingDialouge));
		cf.verticalScrollUpwards(driver);
		String openText = driver.findElement(oh.openTextInSRP).getText();
		AssertJUnit.assertEquals(openText, "OPEN", "Open house filter applied..");
		System.out.println("Open house timings : " + driver.findElement(oh.openTimeInSRP).getText());
		System.out.println("===========================\n PASSED TEST CASE: 1");
		System.out.println("===========================\n");
	}

	@Test(priority = 2)
	public void saveOpenHouseFromPDP() throws InterruptedException, IOException {
		oh.openHouseDateVerify(driver);
		oh.openHouseTimeVerify(driver);
		oh.saveOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 2");
		System.out.println("===========================\n");
	}

	@Test(priority = 3)
	public void viewOpenHouseInMeSection() throws InterruptedException, IOException {
		oh.viewSavedOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 3");
		System.out.println("===========================\n");
	}

	@Test(priority = 4)
	public void openHouseAddressVerify() throws InterruptedException {
		ohm.menuAddressVerify(driver);
		System.out.println("===========================\n PASSED TEST CASE: 4");
		System.out.println("===========================\n");
	}

	@Test(priority = 5)
	public void copyAddressOptionVerify_PDPOpen() throws InterruptedException, MalformedURLException {
		ohm.viewPDPFromOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 5");
		System.out.println("===========================\n");
	}

	@Test(priority = 6)
	public void scheduleTourFromOpenHouse() throws InterruptedException {
		ohm.scheduleTourOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 6");
		System.out.println("===========================\n");

	}

	@Test(priority = 7)
	public void getDirectionFromOpenhouse() throws InterruptedException {
		ohm.getDirectionsFromOpenHosuse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 7");
		System.out.println("===========================\n");
	}

	@Test(priority = 8)
	public void addCalendarEventFromOpenHouse() throws InterruptedException {
		ohm.navigateToCreateEvent(driver);
		System.out.println("===========================\n PASSED TEST CASE: 8");
		System.out.println("===========================\n");
	}

	@Test(priority = 9)
	public void deleteOpenHouseFromMenu() throws InterruptedException {
		ohm.deleteOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 9");
		System.out.println("===========================\n");
	}

	@Test(priority = 10)
	public void discoverPageOpenHose() throws MalformedURLException, InterruptedException {
		ohd.discoverTabOpenHouse_totalOpenHouseInMenu(driver);
		System.out.println("===========================\n PASSED TEST CASE: 10");
		System.out.println("===========================\n");
	}

	@Test(priority = 11)
	public void swipeViewOpenHouse() throws MalformedURLException, InterruptedException {
		ohd.swipeViewOpenHosueVerificaion(driver);
		System.out.println("===========================\n PASSED TEST CASE: 11");
		System.out.println("===========================\n");
	}

	@Test(priority = 12)
	public void pinViewFromCluster() throws MalformedURLException, InterruptedException {
		cf.relaunchApp(driver);
		Thread.sleep(5000);
		oh.pinView(driver);
		ohq.openHouseDateVerify(driver);
		ohq.openHouseTimeVerify(driver);
		System.out.println("===========================\n PASSED TEST CASE: 12");
		System.out.println("===========================\n");
	}

	@Test(priority = 13)
	public void newTagWithOpenHouseQuickSRP() throws MalformedURLException, InterruptedException {
		cf.relaunchApp(driver);
		ohq.newPropertiesWithOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 13");
		System.out.println("===========================\n");
	}

	@Test(priority = 14)
	public void searchStateNotChanged() throws MalformedURLException, InterruptedException {
		ohd.saveSearchNotAffected(driver);
		System.out.println("===========================\n PASSED TEST CASE: 14");
		System.out.println("===========================\n");
	}

	@Test(priority = 15)
	public void tagAndTimeVerifyInDiscover() throws MalformedURLException, InterruptedException {
		ohd.verifyTagTimeInDiscoverPage(driver);
		System.out.println("===========================\n PASSED TEST CASE: 15");
		System.out.println("===========================\n");
	}

	@Test(priority = 16)
	public void matchDataInPDPWithDiscovertab() throws MalformedURLException, InterruptedException {
		ohd.matchDataInPDP(driver);
		System.out.println("===========================\n PASSED TEST CASE: 16");
		System.out.println("===========================\n");
	}

	@Test(priority = 17)
	public void verifyFavIconInTiles() throws MalformedURLException, InterruptedException {
		ohd.favOpenHousePDP(driver);
		System.out.println("===========================\n PASSED TEST CASE: 17");
		System.out.println("===========================\n");
	}

	@Test(priority = 18)
	public void verifyFavIconDisappear() throws InterruptedException, IOException {
		ohd.unFavOpenHouse(driver);
		System.out.println("===========================\n PASSED TEST CASE: 18");
		System.out.println("===========================\n");
	}

	@Test(priority = 19)
	public void updateOpenHouseListInDiscoverTab() throws MalformedURLException, InterruptedException {
		ohd.openHouseAfterChangeSavedSearch(driver);
		System.out.println("===========================\n PASSED TEST CASE: 19");
		System.out.println("===========================\n");
	}

	@Test(priority = 20)
	public void offlineMyOpenHouseSeciton() throws InterruptedException {
		ohm.myOpenHouseInNoNetwork(driver);
		System.out.println("===========================\n PASSED TEST CASE: 20");
		System.out.println("===========================\n");
	}

	@Test(priority = 21)
	public void unauthenticatedUserOpenHouseVerify() throws MalformedURLException, InterruptedException {
		ohd.noOpenHouseUnauthenticatedUser(driver);
		System.out.println("===========================\n PASSED TEST CASE: 21");
		System.out.println("===========================\n");
	}

	@Test(priority = 22)
	public void errorMessageVerifyNoOpenHouse() throws MalformedURLException, InterruptedException {
		oh.noOpenHouseInSearch(driver);
		System.out.println("===========================\n PASSED TEST CASE: 22");
		System.out.println("===========================\n");
	}

	@AfterTest
	public void afterTest() {
		driver.removeApp("io.appium.settings");
		driver.removeApp("io.appium.unlock");
		driver.quit();
		System.out.print("\n***************************\n EXECUTION COMPLETE \n***************************\n");
	}
}
