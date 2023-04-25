package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	
	
	@FindBy (linkText = "HP LP3065")
	private WebElement validProductDisplayed;
	
	@FindBy (xpath = "//*[text()='There is no product that matches the search criteria.']")
	private WebElement noProductMatchForinvalidProductProduct;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validProductDisplayStatus() {
		boolean displayStatus=  validProductDisplayed.isDisplayed();
		return displayStatus;
	}
	
	public String retrieveNoProductMatchMessageText() {
		String invalidProductMessage = noProductMatchForinvalidProductProduct.getText();
		return invalidProductMessage;
	}


}
