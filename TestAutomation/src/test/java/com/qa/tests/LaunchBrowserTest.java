package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTest {
	
	
	public static void main(String[] args) {
		
	
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.quit();
	}

}
