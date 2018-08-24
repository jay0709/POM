package com.PDP.PageFactory;

import org.openqa.selenium.By;

public class PdpRebateSection_PO {
	public By rebateBackButton = By.id("com.owners.buyer:id/property_details_back_button");
	public By rebatePageTittle = By.id("com.owners.buyer:id/property_rebate_title_text_view");
	public By rebateListPrice = By.id("com.owners.buyer:id/rebate_full_price_text_view");
	public By rebateListPriceText = By.xpath("//android.widget.TextView[@index=1]");
	public By rebateListPriceDecleartion = By.xpath("//android.widget.TextView[@index=2]");
	public By rebateRate = By.id("com.owners.buyer:id/rebate_rate_text_view");
	public By rebateRateText = By.xpath("//android.widget.TextView[@index=4]");
	public By rebateCommisionText = By.xpath("//android.widget.TextView[@index=5]");
	public By rebatePrice = By.id("com.owners.buyer:id/rebate_discount_text_view");
	public By rebatePotentialSavings = By.xpath("//android.widget.TextView[@index=8]");
	public By savingsDescrition = By.xpath("//android.widget.TextView[@index=9]");
	public By rebateTermsButton = By.id("com.owners.buyer:id/rebate_terms_button");
	public By rebateContactButton = By.id("com.owners.buyer:id/rebate_contact_button");

	public By rebateContactSellerConsentLanguage = By.id("com.owners.buyer:id/phone_consent_text_view");
	public By rebateContactSellerMessage = By.id("com.owners.buyer:id/contact_seller_message_edit_text");
	public By rebateContactSellerSubmit = By.id("com.owners.buyer:id/contact_seller_send_fab");
	public By rebateContactSellerFirstName = By.xpath(
			"*//android.widget.LinearLayout/TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText");
	public By rebateContactSellerLastName = By.xpath(
			"*//android.widget.LinearLayout/TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText");
	public By rebateContactSellerEmailAddress = By.xpath(
			"*//android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/TextInputLayout/android.widget.FrameLayout/android.widget.EditText");

	public By rebateContactSellerPhoneNumber = By.xpath(
			"*//android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.LinearLayout/TextInputLayout/android.widget.FrameLayout/android.widget.EditText");

}
