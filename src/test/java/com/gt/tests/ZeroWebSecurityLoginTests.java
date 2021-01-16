package com.gt.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZeroWebSecurityLoginTests {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		try {

			WebDriverManager.chromedriver().setup();
			

			driver = new ChromeDriver();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test(groups = { "smoke" })
	public void loginTestOne() {
		try {

			driver.get("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

			Thread.sleep(5000);

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/images/HomePage.jpg"));

			System.out
					.println("Added Screenshot to : " + System.getProperty("user.dir") + "/target/images/HomePage.jpg");

			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]")).click();
			driver.findElement(By.linkText("Logout")).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	@Test(groups = { "regression" })
	public void loginTestTwo() {
		try {

			driver.get("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]")).click();
			driver.findElement(By.linkText("Logout")).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	@Test(groups = { "regression" })
	public void loginTestThree() {
		try {

			driver.get("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();

			Thread.sleep(5000);

			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]")).click();
			driver.findElement(By.linkText("Logout")).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	@AfterTest
	public void quitBrowser() {
		try {

			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
