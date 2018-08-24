package com.favourites.PageFactory;

import org.openqa.selenium.By;

public class PDP_PO {

	public By priceInList = By.id("com.owners.buyer:id/search_result_property_price");

	public By pdpCommentView = By.id("com.owners.buyer:id/property_comment_text_view");
	public By imageCountInPDP = By.id("com.owners.buyer:id/property_photos_num_text_view");
	public By pdpGalleryFavIncon = By.id("com.owners.buyer:id/property_photos_fav_button");
	public By pdpGalleryRequestTour = By.id("com.owners.buyer:id/pdp_gallery_contact_seller");
	public By pdpGalleryPropertyPrice = By.id("com.owners.buyer:id/property_details_request_tour_price");
	public By pdpGalleryDeleteImage = By.id("com.owners.buyer:id/property_details_gallery_note_image_delete");
	public By pdpGalleryNote = By.id("com.owners.buyer:id/note_image_text");
	public By pdpGalleryImageCount = By.id("com.owners.buyer:id/property_photos_num_text_view");
	public By pdpGalleryBackButton = By.id("com.owners.buyer:id/property_photos_back_button");

	public By pdpfavIcon = By.id("com.owners.buyer:id/property_details_favourite_fab");
	public By pdpFavPropertyAlertTitle = By.id("com.owners.buyer:id/alertTitle");
	public By pdpFavPropertyALertMessage = By.id("android:id/message");
	public By doNotAskCheckBox = By.id("com.owners.buyer:id/checkbox");
	public By doNotFavButton = By.id("android:id/button2");
	public By favButtonInAlert = By.id("android:id/button1");

	public By pdpPriceView = By.id("com.owners.buyer:id/property_item_price_text_view");
	public By pdpSchoolSection = By.id("com.owners.buyer:id/school_layout");
	public By pdpBackButton = By.id("com.owners.buyer:id/property_details_back_button");
	public By favToastMessage = By.id("com.owners.buyer:id/favourite_text");
	public By saveNoteButton = By.id("com.owners.buyer:id/send_layout");
	public By navigateSearchTab = By.xpath("//android.support.v7.app.ActionBar.Tab[1]//android.widget.LinearLayout[1]");

	public By requestTourPageHader = By.id("com.owners.buyer:id/tour_date_title_text_view");
	public By requestTourPageAddressFirstLine = By.id("com.owners.buyer:id/property_address_text_first");
	public By requestTourPageAddressSecondLine = By.id("com.owners.buyer:id/property_address_text_second");
	public By requestASAPTile = By.id("com.owners.buyer:id/tour_quick_date_asap");
	public By requestTourMonth = By.id("com.owners.buyer:id/tour_quick_date_month");
	public By requestTourDayOfMonth = By.id("com.owners.buyer:id/tour_quick_date_day_of_month");
	public By requestTourDayOfWeek = By.id("com.owners.buyer:id/tour_quick_date_day_of_week");
	public By requestTourEmailUser = By.id("com.owners.buyer:id/tour_email");
	public By requestTourComment = By.id("com.owners.buyer:id/contact_seller_message_edit_text");
	public By requestTourTime = By.id("com.owners.buyer:id/tour_quick_time");
	public By requestTourConsent = By.id("com.owners.buyer:id/phone_consent_text_view");
	public By requestTourSubmit = By.id("com.owners.buyer:id/contact_seller_send");
	public By requetsTourPageBackButton = By.id("com.owners.buyer:id/tour_date_back_button");

	public By requestTourFirstName = By
			.xpath("*//TextInputLayout[1]//android.widget.FrameLayout//android.widget.EditText");
	public By requestTourLastName = By
			.xpath("*//TextInputLayout[2]//android.widget.FrameLayout//android.widget.EditText");
	public By requestTourEmailID = By.xpath(
			"*//android.widget.FrameLayout[2]//android.widget.LinearLayout//TextInputLayout[1]//android.widget.FrameLayout//android.widget.EditText");

	public By requestTourInvalidInput = By.id("com.owners.buyer:id/textinput_error");
}
