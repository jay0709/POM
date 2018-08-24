package com.PDP.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.owners.commonFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PdpSchoolMethods_PO {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	PdpSchoolDetails_PO ps = new PdpSchoolDetails_PO();
	PdpHeaderItems_PO ph = new PdpHeaderItems_PO();

	public void findSchoolSection(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 5);
		cf.searchMapSRP("Roswell,GA", driver);
		wait.until(ExpectedConditions.elementToBeClickable(ps.srpListBtn));
		driver.findElement(ps.srpListBtn).click();
		Thread.sleep(3000);
		cf.verticalScrollUpwards(driver);
		driver.findElement(ps.priceInList).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ph.pdpfavIcon));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ph.pdpfavIcon));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ph.pdpfavIcon));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ph.pdpfavIcon));
		cf.scrollToText("SCHOOLS", driver);
		System.out.println("School section is present in PDP..!");
	}

	public void toolTipDetailsInfo(AndroidDriver<AndroidElement> driver) {
		wait = new WebDriverWait(driver, 5);
		driver.findElement(ps.pdpSchoolExpand).click();
		wait.until(ExpectedConditions.elementToBeClickable(ps.pdpSchoolToolTip));
		driver.findElement(ps.pdpSchoolToolTip).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ps.pdpSchoolDialogueTittle));
		System.out.println("Dialogue Title Verified as: " + driver.findElement(ps.pdpSchoolDialogueTittle).getText());
		System.out.println(
				"School rating logic verified as: \n" + driver.findElement(ps.pdpSchoolDialogueDescription).getText());
		driver.findElement(ps.pdpSchoolDialogueOK).click();
	}

	public void topAssignedSchool(AndroidDriver<AndroidElement> driver) {
		List<AndroidElement> list = driver.findElements(ps.pdpTopSchoolList);
		System.out.println("No of top assigned school is: " + list.size());
		System.out.println("First School Name: " + driver.findElement(ps.pdpSchoolName).getText());
		System.out.println("First School details: " + driver.findElement(ps.pdpSchoolInfo).getText());
		System.out.println("First School Rating: " + driver.findElement(ps.pdpSchoolRating).getText());
		System.out.println("First School student grade range: " + driver.findElement(ps.pdpSchoolInfoGrade).getText());
		System.out.println("First School distance: " + driver.findElement(ps.pdpSchoolInfoDistance).getText());
		System.out.println("School data source : " + driver.findElement(ps.pdpSchoolDataSource).getText());
	}

	public void viewAllSchools(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 5);
		driver.findElement(ps.pdpViewAllSchools).click();
		System.out.println("Clicked on the View all schools..!");
		wait.until(ExpectedConditions.visibilityOfElementLocated(ps.pdpSchooDeatilslListHeader));
		Assert.assertEquals(driver.findElement(ps.pdpSchooDeatilslListHeader).getText(), "School Information");
		System.out.println("Page title verifed as: " + driver.findElement(ps.pdpSchooDeatilslListHeader).getText());
		List<AndroidElement> list = driver.findElements(ps.pdpTopSchoolList);
		System.out.println("No of schools visible in list is: " + list.size());
		cf.verticalScrollUpwards(driver);
		cf.verticalScrollUpwards(driver);
		System.out.println("Random School 1 Name: " + driver.findElement(ps.pdpSchoolName).getText());
		System.out.println("Random School 1 details: " + driver.findElement(ps.pdpSchoolInfo).getText());
		System.out.println("Random School 1 Rating: " + driver.findElement(ps.pdpSchoolRating).getText());
		System.out
				.println("Random School 1 student grade range: " + driver.findElement(ps.pdpSchoolInfoGrade).getText());
		System.out.println("Random School 1 distance: " + driver.findElement(ps.pdpSchoolInfoDistance).getText());
		try {
			cf.scrollToText("1234567890", driver);
		} catch (Exception ex) {
			System.out.println();
			System.out.println("Random School 2 Name : " + driver.findElement(ps.pdpSchoolName).getText());
			System.out.println("Random School 2 details: " + driver.findElement(ps.pdpSchoolInfo).getText());
			System.out.println("Random School 2 Rating: " + driver.findElement(ps.pdpSchoolRating).getText());
			System.out.println(
					"Random School 2 student grade range: " + driver.findElement(ps.pdpSchoolInfoGrade).getText());
			System.out.println("Random School 2 distance: " + driver.findElement(ps.pdpSchoolInfoDistance).getText());

			System.out.println("School Scroll complete..!!");
		}
		driver.findElement(ps.pdpSchoolListBackButton).click();
	}

	public void viewSchoolSourceNavigatation(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		String dataSource = driver.findElement(ps.pdpSchoolDataSource).getText();
		System.out.println(dataSource);
		driver.findElement(ps.pdpSchoolDataSource).click();
		Thread.sleep(5000);
		String activity = driver.currentActivity();
		System.out.println(activity);
		String URL = "";
		if (activity.contains("chrome")) {
			System.out.println("User navigated to Chrome Browser..!!");
			Thread.sleep(5000);
			URL = driver.findElement(ps.chromeURLBar).getText();
			System.out.println("URL is: " + URL);
		}
		Assert.assertEquals("https://www.greatschools.org", URL, "Browser not opened Greatschool.org");

	}

}
