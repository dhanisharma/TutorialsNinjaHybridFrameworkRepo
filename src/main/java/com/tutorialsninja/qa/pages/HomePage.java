package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	// Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	 
	@FindBy (xpath = "//input[@name='search']")
	private WebElement searchBoxFeild;
	
	@FindBy (xpath = "//button[contains(@class,'btn-default')]")
    private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public void myAccountOption() {
		myAccountDropMenu.click();
	}
	
	public LoginPage loginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDropMenu.click(); 
		loginOption.click();
		return new LoginPage(driver);
	}
	
	
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click(); 
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductInSearchBoxFeild(String productText) {
		searchBoxFeild.sendKeys(productText);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForAProduct(String productText) {
		searchBoxFeild.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
	}
	

}
