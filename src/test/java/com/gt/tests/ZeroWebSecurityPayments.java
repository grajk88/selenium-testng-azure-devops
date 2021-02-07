package com.gt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ZeroWebSecurityPayments {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "environment" })
	public void launchBrowser(String browser, String environment) {

		try {

			System.out.println("++++++++++++++++++++++++++++++++++++++++++");

			System.out.println("BROWSER: " + browser.toUpperCase().toString());

			System.out.println("ENVIRONMENT: " + environment.toUpperCase().toString());

			System.out.println("++++++++++++++++++++++++++++++++++++++++++");

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("ignore-certificate-errors");
			options.addArguments("--test-type");
			options.setAcceptInsecureCerts(true);
			// options.addArguments("--incognito");
			options.setHeadless(true);
			
			driver = new ChromeDriver(options);
			driver.get("http://zero.webappsecurity.com/");

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(groups = { "smoke", "regression" })
	public void loginTestOne() {
		try {

			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();
			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
			driver.findElement(By.id("logout_link")).click();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(groups = { "regression" })
	public void loginTestTwo() {
		try {

			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();
			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
			driver.findElement(By.id("logout_link")).click();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(groups = { "regression" })
	public void loginTestThree() {
		try {

			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();
			driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
			driver.findElement(By.id("logout_link")).click();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}

	}

	@AfterMethod()
	public void quitBrowser() {
		try {

			System.out.println("Called AfterMethod");
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.assertTrue(false);
		}
	}

}
