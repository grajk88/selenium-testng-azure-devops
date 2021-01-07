package com.gt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZeroWebSecurityLoginTests {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		try {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

			driver = new ChromeDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void loginTest() {
		try {

			driver.get("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_logi")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

			Thread.sleep(5000);

			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]")).click();
			driver.findElement(By.linkText("Logout")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void quitBrowser() {
		try {

			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
