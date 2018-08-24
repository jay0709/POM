/**
 * 
 */
package com.favourites.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.owners.commonFunctions;
import com.owners.properties;
import com.owners.PageFactory.Registration_PO;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Jayabrata
 *
 */
public class EditDeleteAssest_PO {
	AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	Registration_PO reg = new Registration_PO();
	properties pr = new properties();
	FavTabID_PO ft = new FavTabID_PO();
	FavoritesTab_PO ftpo = new FavoritesTab_PO();

	public void editCommentFromFavTab(AndroidDriver<AndroidElement> driver, String textToBeAdded)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(ft.commentTextView).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentdeleteButtonInEditPage));
		wait.until(ExpectedConditions.elementToBeClickable(ft.saveNoteButtonInEditPage));
		driver.findElement(ft.commentInEditPage).clear();
		System.out.println(
				"Default text in edit section is verified as : " + driver.findElement(ft.commentInEditPage).getText());
		driver.findElement(ft.commentInEditPage).sendKeys(textToBeAdded);
		Thread.sleep(2000);
		if (driver.findElement(ft.commentInEditPage).getText().contains(textToBeAdded)) {
			driver.findElement(ft.saveNoteButtonInEditPage).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentContainer));
			String lastComment = driver.findElement(ft.commentTextView).getText().trim().substring(12);
			System.out.println(
					"Asset added time is: " + driver.findElement(ft.commentTextView).getText().trim().substring(4, 10));
			System.out.println("New comment is : " + lastComment);
		} else
			System.out.println("Comment not edited properly...");

	}

	public void deleteCommentsFromProperty(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		cf.relaunchApp(driver);
		Thread.sleep(5000);
		driver.findElement(ft.clickFavouriteTab).click();
		try {
			while (driver.findElement(ft.commentTextView).isEnabled()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentTextView));
				Thread.sleep(2000);
				driver.findElement(ft.commentTextView).click();
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentdeleteButtonInEditPage));
				} catch (Exception e) {
					driver.findElement(ft.commentTextView).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentdeleteButtonInEditPage));
				}
				driver.findElement(ft.commentdeleteButtonInEditPage).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(ft.deleteNoteConfirmationDialouge));
				System.out.println("Delete note confirmation dialouge is visible..!!");
				driver.findElement(ft.delteNoteDeleteButton).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentTextView));
			}
		} catch (Exception e) {
			System.out.println("No Comments are found in the fav tab..!!");
		}

	}

	public void addImageAssetFromCamera(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		deleteCommentsFromProperty(driver);
		cf.relaunchApp(driver);
		driver.findElement(ft.clickFavouriteTab).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(ft.cameraIcon).click();
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(ft.allowMediaAccessDialouge));
			// System.out.println(driver.findElement(ft.allowMediaAccess).getText());
			driver.findElement(ft.allowMediaAccess).click();
		} catch (Exception e) {
			System.out.println("Media Access is already allowed..!!");
		}
		driver.findElement(ft.cameraButtonInDialouge).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.captureImageFromCamera));
		driver.findElement(ft.captureImageFromCamera).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.saveImageAfterClicking));
		driver.findElement(ft.saveImageAfterClicking).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.imageInAssetEditSection));
		driver.findElement(ft.editTextField).sendKeys("Image from camera added as asset..!!");
		driver.hideKeyboard();
		driver.findElement(ft.saveAssetButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ft.sendTextProgressBar));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentTextView));
			wait.until(ExpectedConditions.visibilityOfElementLocated(ft.imageAddedAsAsset));
			System.out.println("Comment added as : " + driver.findElement(ft.commentTextView).getText());
		} catch (Exception e) {
			System.out.println("Comment added but not relfected in the view..");
		}
		System.out.println("Asset addition completed.. CAMERA..");
	}

	public void addImageFromGallery(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		deleteCommentsFromProperty(driver);
		cf.relaunchApp(driver);
		driver.findElement(ft.clickFavouriteTab).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(ft.cameraIcon).click();
		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(ft.allowMediaAccessDialouge));
			// System.out.println(driver.findElement(ft.allowMediaAccess).getText());
			driver.findElement(ft.allowMediaAccess).click();
		} catch (Exception e) {
			System.out.println("Media Access is already allowed..!!");
		}

		driver.findElement(ft.photoButtonInDialouge).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.selectImageFromGallery));
		driver.findElement(ft.selectImageFromGallery).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ft.imageInAssetEditSection));
		driver.findElement(ft.editTextField).sendKeys("Image from Gallery added as asset..!!");
		driver.hideKeyboard();
		driver.findElement(ft.saveAssetButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ft.sendTextProgressBar));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ft.commentTextView));
			wait.until(ExpectedConditions.visibilityOfElementLocated(ft.imageAddedAsAsset));
			System.out.println("Comment added as : " + driver.findElement(ft.commentTextView).getText());
		} catch (Exception e) {
			System.out.println("Comment added but not relfected in the view..");
		}
		System.out.println("Asset addition completed.. GALLERY..");
	}

	public void deleteImageFromAsset(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(ft.showAllText).click();
		driver.findElement(ft.commentTextView).click();
		driver.findElement(ft.addedImageRemoveButton).click();
		System.out.println("Clicked on the delete button.. Saving the note now..!!");
		driver.findElement(ft.saveNoteButtonInEditPage).click();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(ft.imageAddedAsAsset));
			System.out.println("Image has not been deleted from the comments section..!");
		} catch (Exception e) {
			System.out.println("Image is deleted from asset..!!");
		}
	}

}
