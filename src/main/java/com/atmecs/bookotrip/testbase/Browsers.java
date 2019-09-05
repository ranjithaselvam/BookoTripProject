package com.atmecs.bookotrip.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Browsers {
	protected static WebDriver driver;
	Properties property1 = new Properties();

	@BeforeTest
	public void setup() throws IOException {
		/*
		 * Drivers file path . All the drivers are stored in lib folder
		 */
		FileInputStream stream1 = new FileInputStream(
				"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\DataProvider\\resource\\testdata\\config.properties");

		property1.load(stream1);

		String url = property1.getProperty("url");
		String browser = property1.getProperty("browsername");
		switch (browser) {
		// to automate in chrome browser
		case "chrome":
			// to configure driver
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\DataProvider\\lib\\chromedriver.exe");
			// create the chrome driver
			driver = new ChromeDriver();
			break;
		// to automate in firefox browser
		case "firefox":

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\Bookotrip\\lib\\geckodriver.exe");
			// create the firefox driver
			driver = new FirefoxDriver();
			break;
		// to automate in IE browser
		case "IE":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\Bookotrip\\lib\\IEDriverServer.exe");
			// create IE driver
			driver = new InternetExplorerDriver();
			break;
		}
		// get url from .property file("config.properties")
		driver.get(url);

	}
	 @AfterTest 
	  public void close() 
	  { 
		  driver.close(); 
		  }
	 


}
