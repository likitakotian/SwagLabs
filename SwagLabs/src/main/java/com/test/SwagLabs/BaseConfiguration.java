package com.test.SwagLabs;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseConfiguration {

	public WebDriver driver;
	public Properties properties;
	
	public void initiateWebDriver() throws IOException {
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("/Users/sagarliki/git/SwagLabs/SwagLabs/resouces/data.property");
		properties.load(fileInputStream);
		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "/Users/sagarliki/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
		}
	}
	
	public WebDriver getDriver() throws NullPointerException{
		if(driver != null) {
			return driver;
		}else {
			throw new NullPointerException("The driver is empty");
		}
	}
}
