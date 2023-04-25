package com.tutorialsninjaqa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	
	SearchPage searchPage;
	HomePage homePage;
	public WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		loadPropertiesFile();
		driver = openApplicationURL();
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.validProductDisplayStatus(),
				"Valid product HP is not displayed in the search results");
	}

	@Test(priority = 2)
	public void searchWithInvalidProduct() {
	    searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals(searchPage.retrieveNoProductMatchMessageText(), "abcd",
				"No product in search results is not displayed");
	}

	@Test(priority = 3, dependsOnMethods = {"searchWithInvalidProduct", "verifySearchWithValidProduct"})
	public void verifySearchWithoutAnyProduct() {
		 
		searchPage = homePage.clickOnSearchButton(); 

		Assert.assertEquals(searchPage.retrieveNoProductMatchMessageText(), dataProp.getProperty("noProductTextInSearchResults"),
				"No product in search results is not displayed");

	}

}
