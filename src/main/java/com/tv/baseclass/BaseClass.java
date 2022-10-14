package com.tv.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static  WebDriver driver;
	public static Properties prop;
	
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		intiProperties();
		intiDriver(prop.getProperty("BrowserType"));
	}
	
	public void intiProperties() throws IOException {
		prop = new Properties();
		FileInputStream inputStream = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
		prop.load(inputStream);
	}

	public void intiDriver(String browserType) throws Exception {
		if(browserType.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("EDGE")) {
			System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Browser Type Not Supported");
		}
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}


}
