package com.tutorialsninjaqa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	AccountPage accountPage;
    LoginPage loginPage;
	public WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		loadPropertiesFile();
		driver = openApplicationURL();
		HomePage homepage = new HomePage(driver);
		loginPage = homepage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() { // we can give any method name instead of tearDown()
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
        accountPage = loginPage.login(email, password);
		
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(),
				"Edit your account information option is not displayed");

	}
	
	@DataProvider(name = "validCredentialsSupplier")
	public Object [][] supplyTestData() {
	
		Object [][] data = {{"pooja12@gmail.com","12345"},
				{"pooja13@gmail.com","12345"},
				{"pooja14@gmail.com","12345"}}; 
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() throws Exception {
		accountPage = loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));

		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(), dataProp.getProperty("emailPasswordNoMatchWarning"), "Expected Warning message is not displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		accountPage = loginPage.login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));

		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(), dataProp.getProperty("emailPasswordNoMatchWarning"), "Expected Warning message is not displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		accountPage = loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));

		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(), dataProp.getProperty("emailPasswordNoMatchWarning"), "Expected Warning message is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() throws Exception {
		accountPage = loginPage.login("","");

		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(), dataProp.getProperty("emailPasswordNoMatchWarning"), "Expected Warning message is not displayed");

	}

}
