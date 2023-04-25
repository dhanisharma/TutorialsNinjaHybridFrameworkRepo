package com.tutorialsninjaqa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	AccountSuccessPage accountSuccessPage;
	RegisterPage registerPage;
	public WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		loadPropertiesFile();
		driver = openApplicationURL();
		HomePage homepage = new HomePage(driver);
		registerPage = homepage.navigateToRegisterPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegistringAnAccountWithMandatoryFeilds() throws Exception {
		accountSuccessPage = registerPage.registerWithMandatoryFeilds(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(),
				dataProp.getProperty("telephoneNumber"), dataProp.getProperty("password"),
				dataProp.getProperty("confirmPassword"));

		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account success page is not displayed");

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFeilds() {
		accountSuccessPage = registerPage.registerWithAllFeilds(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(),
				dataProp.getProperty("telephoneNumber"), dataProp.getProperty("password"),
				dataProp.getProperty("confirmPassword"));

		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account success page is not displayed");

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		// here accountSuccessPage will not appear, warning message will display on the
		// same page
		registerPage.registerWithAllFeilds(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		Assert.assertEquals(registerPage.duplicateEmailAddressWarningMessage(),
				dataProp.getProperty("duplicateEmailWarning"),
				"Warning message regarding duplicate email address is not displayed");

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		registerPage.clickSubmitButton();

		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"),
				dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));

	}

}
