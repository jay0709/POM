package com.openhouse.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.owners.commonFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OpenHouseTimeFormat_PO {
	static AndroidDriver<AndroidElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	OpenHouse_PO oh = new OpenHouse_PO();

	public void openHouseDateVerifyInSRPT() {
		String deviceTime = driver.getDeviceTime();
		// Wed Nov 8 03:13:17 EST 2017
		// Sun 11/12, 2PM
		String dtDayOfWeek = deviceTime.substring(0, 3).toUpperCase();
		String dtMonth = deviceTime.substring(4, 7);
		String dtDay = deviceTime.substring(9, 10);
		int dtTime = Integer.parseInt(deviceTime.substring(11, deviceTime.indexOf(":")));

		String srpDate = "Sun 11/12, 2PM"; // driver.findElement(oh.openTimeInSRP).getText().toLowerCase();
		String srpDayOfWeek = srpDate.substring(0, 3).toUpperCase();
		String srpDay = srpDate.substring(srpDate.indexOf("/"), srpDate.indexOf(","));
		int srpTime = Integer.parseInt(srpDate.substring(srpDate.indexOf(","), srpDate.indexOf("P")));

		int Time = Integer.parseInt(deviceTime.substring(11, deviceTime.indexOf(":")));
	}

}
