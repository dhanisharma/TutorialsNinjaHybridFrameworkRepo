package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name = "email")
	private WebElement emailAddressFeild;
	
	@FindBy(name = "password")
	private WebElement passwordFeild;
	
	@FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public AccountPage login(String emailText, String passwordText) {
		emailAddressFeild.sendKeys(emailText);
		passwordFeild.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;
	}

}
