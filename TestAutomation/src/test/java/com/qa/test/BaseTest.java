package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void sampleTest() {
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		System.out.println(title);
		
	}

	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}