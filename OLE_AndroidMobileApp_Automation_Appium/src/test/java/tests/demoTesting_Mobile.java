package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
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

		driver.findElement(By.name("zone_id"));
		WebElement objWeb1 = driver.findElement(By.name("zone_id"));
		Select countrySelector = new Select(objWeb1);
		countrySelector.deselectByVisibleText("Egypt");

		WebElement searchTxt = driver.findElement(By.id("search_bar"));
		searchTxt.sendKeys("fan 26");

		WebElement searchBtn = driver.findElement(By.id("search_button"));
		searchBtn.click();

		WebElement filterBtn = driver.findElement(By.id("filter_button"));
		filterBtn.click();

		driver.findElement(By.name("filter_id"));
		WebElement objWeb2 = driver.findElement(By.name("filter_id"));
		Select filterOption = new Select(objWeb2);
		filterOption.deselectByVisibleText("JAC");

		WebElement submitFilterBtn = driver.findElement(By.id("submit_filter_button"));
		submitFilterBtn.click();

		WebElement displayedPrice = driver.findElement(By.name("displayedHuPrice"));
		WebElement displayedName = driver.findElement(By.name("displayedHuName"));
		WebElement displayedVendor = driver.findElement(By.name("displayedHuVendor"));

		WebElement huaweiPhone1 = driver.findElement(By.linkText("HuawaiPhoneP8Lite"));
		huaweiPhone1.click();

		Thread.sleep(1000);

		WebElement price = driver.findElement(By.name("HuPrice"));
		WebElement name = driver.findElement(By.name("HuName"));
		WebElement vendor = driver.findElement(By.name("HuVendor"));

		Assert.assertEquals(price.getText(), displayedPrice.getText());
		Assert.assertEquals(name.getText(), displayedName.getText());
		Assert.assertEquals(vendor.getText(), displayedVendor.getText());

	}
}
