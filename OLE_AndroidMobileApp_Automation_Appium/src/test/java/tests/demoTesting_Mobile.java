package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class demoTesting_Mobile {
	@Test
	public void simpleScenario() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.0");
		caps.setCapability("deviceName", "HuaweiP8Lite");
		caps.setCapability("app",
				"D:\\Orange_Task_July_2019\\AndroidApp\\Pricena Shopping Comparison_v4.2.1_apkpure.com.apk");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		WebElement countrySelector = driver.findElement(By.id("Egypt"));
		countrySelector.click();

		WebElement searchTxt = driver.findElement(By.id("search_bar"));
		searchTxt.isEnabled();
		searchTxt.sendKeys("fan 26");

		driver.findElement(By.id("fan 26")).sendKeys(Keys.ENTER);

		WebElement filterBtn = driver.findElement(By.id("filter_button"));
		filterBtn.click();

		WebElement brand_Filt = driver.findElement(By.id("brand_filter"));
		brand_Filt.click();

		// Find the check box element by its name.
		List<WebElement> list = driver.findElements(By.name("checkbox"));

		// Get the number of check boxes available.
		int count = list.size();

		// Now, iterate the loop from first check box to last check box.
		for (int i = 0; i < count; i++) {

			// Store the check box name to the string variable, using 'Value'
			// attribute
			String sValue = ((WebElement) list.get(i)).getAttribute("Jac");

			// Select the check box if its value is the same that you want.
			if (sValue.equalsIgnoreCase("checkbox")) {

				((WebElement) list.get(i)).click();

				// This statement will get you out of the for loop.
				break;
			}

		}

		WebElement applyBtn_F_Time = driver.findElement(By.id("applyBtnF_id"));
		applyBtn_F_Time.click();

		Thread.sleep(3000);

		WebElement applyBtn_Sec_Time = driver.findElement(By.id("applyBtnSec_id"));
		applyBtn_Sec_Time.click();

		Thread.sleep(1000);

		WebElement displayedPrice = driver.findElement(By.name("displayedFan26Price"));
		WebElement displayedName = driver.findElement(By.name("displayedFan26Name"));
		WebElement displayedVendor = driver.findElement(By.name("displayedFan26Vendor"));

		WebElement Fan = driver.findElement(By.linkText("Fan26"));
		Fan.click();

		Thread.sleep(1000);

		WebElement price = driver.findElement(By.name("Fan26Price"));
		WebElement name = driver.findElement(By.name("Fan26Name"));
		WebElement vendor = driver.findElement(By.name("Fan26Vendor"));

		Assert.assertEquals(price.getText(), displayedPrice.getText());
		Assert.assertEquals(name.getText(), displayedName.getText());
		Assert.assertEquals(vendor.getText(), displayedVendor.getText());

	}
}
