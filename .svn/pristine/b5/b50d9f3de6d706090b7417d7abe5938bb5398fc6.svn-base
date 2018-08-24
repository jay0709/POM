/**
* 
*/
package com.owners;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author isaacindeevervemula
 *
 */
public class desiredCapabilities {
	private AndroidDriver<AndroidElement> driver;
	private WebDriverWait wait;

	public void forAndroidTab() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "HubzuSM-T311");
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("automationName", "uiautomator2");
		// capabilities.setCapability("noReset", "true");
		capabilities.setCapability("appPackage", "com.owners.buyer");
		capabilities.setCapability("appActivity", "com.owners.buyer.MainActivity");

		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 20);
	}

	public AndroidDriver<AndroidElement> getAndroidDriver() {
		return driver;
	}

	public WebDriverWait getWebDriverWait() {
		return wait;
	}

	public void forNexus() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "HubzuSM-T311");
		capabilities.setCapability("udid", "4d00cafab04c6043");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appium-version", "1.6.4");
		capabilities.setCapability("appPackage", "com.owners.buyer");
		capabilities.setCapability("appActivity", "com.owners.buyer.MainActivity");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 20);

	}

	public void forAndroidPhone() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Lenova A6020a46");
		capabilities.setCapability("udid", "6e75c65a");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium-version", "1.6.4");
		capabilities.setCapability("appPackage", "com.owners.buyer");
		capabilities.setCapability("appActivity", "com.owners.buyer.MainActivity");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 20);

	}

	public void forEmulators() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Google Nexus");
		// capabilities.setCapability("platformVersion", "7.0.1");
		capabilities.setCapability("platformVersion", "5.1");
		// capabilities.setCapability("platformVersion", "6.1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.owners.buyer");
		capabilities.setCapability("appActivity", "com.owners.buyer.MainActivity");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 20);
	}

}
