package com.favourites.PageFactory;

import org.openqa.selenium.By;

public class FavTabID_PO {
	public By listPropertyAddress = By.id("com.owners.buyer:id/search_result_property_address");
	public By favPropertyList = By.id("com.owners.buyer:id/search_result_fav_button");
	public By clickFavouriteTab = By.xpath("//android.support.v7.app.ActionBar.Tab[2]//android.widget.LinearLayout[1]");
	public By favPropertyPrice = By.id("com.owners.buyer:id/property_price");
	public By favPropertyAddress = By.id("com.owners.buyer:id/property_address");
	public By favPropertyDetails = By.id("com.owners.buyer:id/property_textview");
	public By imageContainerInFav = By.xpath("//android.widget.ImageView[@index ='0']");

	public By createGroup = By.id("com.owners.buyer:id/create_group_toolbar_action");
	public By favTabHeader = By.xpath("//android.widget.TextView[@index = '0']");
	public By noFavProperties = By.xpath("//android.widget.TextView[@index = '1']");
	public By emptyMessage = By.id("com.owners.buyer:id/favorites_empty_message_text_view");

	public By favIcon = By.id("com.owners.buyer:id/fav_button");
	public By schduleTourButton = By.id("com.owners.buyer:id/property_details_call_to_action");
	public By cameraIcon = By.id("com.owners.buyer:id/icon_camera");
	public By editTextField = By.id("com.owners.buyer:id/et_text");
	public By saveAssetButton = By.id("com.owners.buyer:id/tv_send");
	public By remainingChars = By.id("com.owners.buyer:id/property_comment_char_remaining_text_view");
	public By commentContainer = By.id("com.owners.buyer:id/property_comment_container");
	public By imageConatinerPhotoCount = By.id("com.owners.buyer:id/tv_photos_page_number");

	public By confirmDisclaimerFirstTime = By.id("property_comment_disclaimer_container");
	public By privateNoteTextHeader = By.xpath("//android.widget.TextView[@index = '1']");
	public By privateNoteDescription = By.xpath("//android.widget.TextView[@index = '2']");
	public By disclaimerAcceptButton = By.id("com.owners.buyer:id/property_comment_disclaimer_accept_button");

	public By sendTextProgressBar = By.id("com.owners.buyer:id/progressBar");
	public By commentTextView = By.id("com.owners.buyer:id/property_comment_text_view");
	public By commentAuthorInitials = By.id("com.owners.buyer:id/property_comment_author_icon");
	public By showAllText = By.id("com.owners.buyer:id/property_comment_read_more_button");
	public By collapseAllButton = By.id("com.owners.buyer:id/property_notes_collapse_button");

	public By listSRPTab = By.id("com.owners.buyer:id/search_list_view");
	public By allowMediaAccessDialouge = By.id("com.android.packageinstaller:id/permission_message");
	public By allowMediaAccess = By.id("com.android.packageinstaller:id/permission_allow_button");

	public By coShopAlertTitle = By.id("com.owners.buyer:id/alertTitle");
	public By alertTittleMessage = By.id("android:id/message");
	public By notNowButton = By.id("android:id/button2");
	public By createGroupButton = By.id("android:id/button1");
	public By doNotAskAgain = By.id("com.owners.buyer:id/checkbox");

	public By commentPropertyPriceInEditPage = By.id("com.owners.buyer:id/property_comment_price_text_view");
	public By commentInEditPage = By.id("com.owners.buyer:id/property_comment_edit_text");
	public By commentdeleteButtonInEditPage = By.id("com.owners.buyer:id/property_comment_delete_button");
	public By saveNoteButtonInEditPage = By.id("com.owners.buyer:id/property_comment_save_button");
	public By noteEditPageHeader = By.xpath("//android.widget.TextView[@index=1']");
	public By cancelButtonInEditPage = By.id("com.owners.buyer:id/property_comment_back_button");
	public By deleteNoteConfirmationDialouge = By.id("android:id/message");
	public By delteNoteDeleteButton = By.id("android:id/button1");

	public By uploadPhotoDialougeHeaderText = By.id("com.owners.buyer:id/alertTitle");
	public By uploadPhotoDialougeMessage = By.id("android:id/message");
	public By cameraButtonInDialouge = By.id("android:id/button1");
	public By photoButtonInDialouge = By.id("android:id/button2");
	public By cancelButtonInDialouge = By.id("android:id/button3");
	public By captureImageFromCamera = By.id("com.android.camera2:id/photo_video_button");
	public By saveImageAfterClicking = By.id("com.android.camera2:id/done_button");
	public By selectImageFromGallery = By.id("com.android.documentsui:id/date");
	public By imageInAssetEditSection = By.id("com.owners.buyer:id/iv_thumbnail");
	public By addedImageRemoveButton = By.id("com.owners.buyer:id/thumbnail_cross");
	public By imageAddedAsAsset = By.id("com.owners.buyer:id/iv_thumbnail");

	public By favIconInQuickSRP = By.id("com.owners.buyer:id/search_item_fav_button");
	public By quickViewPrice = By.id("com.owners.buyer:id/search_item_price_text_view");
	public By bedBathSqFtQuickView = By.id("com.owners.buyer:id/search_item_info_text_view");
	public By addressQuickView = By.id("com.owners.buyer:id/search_item_address_text_view");

}
