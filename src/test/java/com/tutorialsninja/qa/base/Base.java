package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public void loadPropertiesFile() throws Exception {
		prop = new Properties();
		File fp = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis = new FileInputStream(fp);
		prop.load(fis); 
		
		dataProp = new Properties();
		File fp1 = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream fis1 = new FileInputStream(fp1);
		dataProp.load(fis1);
		
		
	}
	
	public WebDriver openApplicationURL() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dhani\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
