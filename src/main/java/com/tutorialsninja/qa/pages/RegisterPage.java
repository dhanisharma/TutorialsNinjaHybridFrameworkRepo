package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy (id = "input-firstname")
	private WebElement firstNameFeild;
	
	@FindBy (id = "input-lastname")
	private WebElement lastNameFeild;
	
	@FindBy (id = "input-email")
	private WebElement emailAddressFeild;
	
	@FindBy (id = "input-telephone")
	private WebElement telephoneFeild;
	
	@FindBy (id = "input-password")
	private WebElement passwordFeild;
	
	@FindBy (id = "input-confirm")
	private WebElement confirmPasswordFeild;
	
	@FindBy (name = "agree")
	private WebElement privacyPolicyFeild;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy (xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterRadioButton;
	
	@FindBy (xpath = "//div[contains(@class,'alert alert-danger')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy (xpath = "//div[contains(@class,'alert alert-danger')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy (xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement actualFirstNameWarningMessage; 
	
	@FindBy (xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement actualLastNameWarningMessage;
	
	@FindBy (xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement actualEmailWarningMessage;
	
	@FindBy (xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement actualTelephoneWarningMessage;
	
	@FindBy (xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement actualPasswordWarningMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public void enterfirstName(String firstNameText) {
		firstNameFeild.sendKeys(firstNameText);
		
	}
	
	public void enterlastName(String lastNameText) {
		lastNameFeild.sendKeys(lastNameText);
		
	}
	public void enterEmailAddress(String emailText) {
		emailAddressFeild.sendKeys(emailText);
	}
	
	public void enterTelephoneFeild(String telephoneNo) {
		telephoneFeild.sendKeys(telephoneNo);
	}
	
	public void enterPasswordFeild(String passwordText) {
		passwordFeild.sendKeys(passwordText);
	}
	
	public void enterConfirmPasswordFeild(String passwordConfirmText) {
		confirmPasswordFeild.sendKeys(passwordConfirmText);
	}

	public void selectPrivacyPolicy() {
		privacyPolicyFeild.click();
	}
	
	public void clickNewsLetterRadioButton() {
		newsLetterRadioButton.click();
	}
	
	public AccountSuccessPage clickSubmitButton() {
		submitButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerWithMandatoryFeilds(String firstNameText, String lastNameText, String emailText, String telephoneNo, String passwordText, String passwordConfirmText) {
		firstNameFeild.sendKeys(firstNameText);
		lastNameFeild.sendKeys(lastNameText);
		emailAddressFeild.sendKeys(emailText);
		telephoneFeild.sendKeys(telephoneNo);
		passwordFeild.sendKeys(passwordText);
		confirmPasswordFeild.sendKeys(passwordConfirmText);
		privacyPolicyFeild.click();
		submitButton.click();
		return new AccountSuccessPage(driver);
		
	}
	
	public AccountSuccessPage registerWithAllFeilds(String firstNameText, String lastNameText, String emailText, String telephoneNo, String passwordText, String passwordConfirmText) {
		firstNameFeild.sendKeys(firstNameText);
		lastNameFeild.sendKeys(lastNameText);
		emailAddressFeild.sendKeys(emailText);
		telephoneFeild.sendKeys(telephoneNo);
		passwordFeild.sendKeys(passwordText);
		confirmPasswordFeild.sendKeys(passwordConfirmText);
		newsLetterRadioButton.click();
		privacyPolicyFeild.click();
		submitButton.click();
		return new AccountSuccessPage(driver);
	}	
	
	public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
		
		boolean actualPrivacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);
		
		boolean actualFirstNameWarningStatus = actualFirstNameWarningMessage.getText().equals(expectedFirstNameWarning);
		
		boolean actualLastNameWarningStatus = actualLastNameWarningMessage.getText().equals(expectedLastNameWarning);
		
		boolean actualEmailWarningStatus = actualEmailWarningMessage.getText().equals(expectedEmailWarning);
		
		boolean actualTelephoneWarningStatus = actualTelephoneWarningMessage.getText().equals(expectedTelephoneWarning);
		
		boolean actualPasswordWarningStatus = actualPasswordWarningMessage.getText().equals(expectedPasswordWarning);
		
		return actualPrivacyPolicyWarningStatus && actualFirstNameWarningStatus && actualLastNameWarningStatus && actualEmailWarningStatus && actualTelephoneWarningStatus && actualPasswordWarningStatus;
		
		
		
	}
	
	public String duplicateEmailAddressWarningMessage() {
		String duplicateEmailMessage = duplicateEmailWarning.getText();
		return duplicateEmailMessage;
	}
	
	public String retrievePrivacyPolicyWarningMessage() {
		String privacyPolicyWarningMessage = privacyPolicyWarning.getText();
		return privacyPolicyWarningMessage;
	}
	
	public String retrieveActualFirstNameWarningMessage() {
		String actualFirstNameWarning = actualFirstNameWarningMessage.getText();
		return actualFirstNameWarning;
	}
	
	public String retrieveActualLastNameWarningMessage() {
		String actualLastNameWarning = actualLastNameWarningMessage.getText();
		return actualLastNameWarning;
	}
	
	public String retrieveActualEmailWarningMessage() {
		String actualEmailWarning = actualEmailWarningMessage.getText();
		return actualEmailWarning;
	}
	
	public String retrieveActualTelephoneWarningMessage() {
		String actualTelephoneWarning = actualTelephoneWarningMessage.getText();
		return actualTelephoneWarning;
	}
	
	public String retrieveActualPasswordWarningMessage() {
		String actualPasswordWarning = actualPasswordWarningMessage.getText();
		return actualPasswordWarning;
	}
}
