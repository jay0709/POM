package com.PDP.PageFactory;

import org.openqa.selenium.By;

public class PdpHeaderItems_PO {
	public By pdpShareIcon = By.id("com.owners.buyer:id/property_details_share_button");
	public By backButtonPDP = By.id("com.owners.buyer:id/property_details_back_button");
	public By pdpGalleryPreview = By.xpath("//android.widget.ImageView[@index=0]");
	public By pdpImageCount = By.xpath("com.owners.buyer:id/property_photos_num_text_view");
	public By pdpEMICalculator = By.xpath("com.owners.buyer:id/property_item_payments_text_view");
	public By pdpPriceView = By.id("com.owners.buyer:id/property_item_price_text_view");
	public By pdpOwnersEstimate = By.id("com.owners.buyer:id/property_owners_estimate_price");
	public By pdpBedBathPrice = By.id("com.owners.buyer:id/property_item_beds_text_view");
	public By pdpAddressView = By.id("com.owners.buyer:id/property_item_address_text_view");
	public By pdpCurrentView = By.id("com.owners.buyer:id/property_current_location");
	public By pdpRebatePrice = By.id("com.owners.buyer:id/property_rebate_offer_text_view");
	public By pdpDescsriptionExpand = By.id("com.owners.buyer:id/property_details_description_text_view");

	public By pdpfavIcon = By.id("com.owners.buyer:id/property_details_favourite_fab");
	public By favToastMessage = By.id("com.owners.buyer:id/favourite_text");
	public By pdpFavPropertyAlertTitle = By.id("com.owners.buyer:id/alertTitle");
	public By pdpFavPropertyALertMessage = By.id("android:id/message");
	public By doNotAskCheckBox = By.id("com.owners.buyer:id/checkbox");
	public By doNotFavButton = By.id("android:id/button2");
	public By favButtonInAlert = By.id("android:id/button1");
}
