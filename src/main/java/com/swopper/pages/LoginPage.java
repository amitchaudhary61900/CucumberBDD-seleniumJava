package com.swopper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	private WebDriver driver;
	
	
	//By locators
	private By emailInputlocator= By.xpath("//input[@type='email']");
	private By passwordInputlocator= By.xpath("//input[@type='password']");
	private By loginButtonlocator= By.xpath("//button[text()='Login']");
	private By ValidationMessagelocator= By.xpath("//div[text()='Logout']");
	private By errorValidationMessagelocator= By.xpath("//div[text()='Login failed']");

	
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//Page methods
	public void enterEmail(String email) {
		WebElement emailInput= driver.findElement(emailInputlocator);
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		WebElement passwordInput= driver.findElement(passwordInputlocator);
		passwordInput.sendKeys(password);
	}
	
	public void loginButton() throws InterruptedException {
		WebElement loginButton= driver.findElement(loginButtonlocator);
		loginButton.click();
		Thread.sleep(3000);
		
	}
	public String assertUsingLogoutButton() {
		return driver.findElement(ValidationMessagelocator).getText();
		
	}
	public String assertWhileInvalidCred() {
		return driver.findElement(errorValidationMessagelocator).getText();
		
	}
	 public HomePage doLogin(String username, String password) throws InterruptedException {
		 WebElement emailInput= driver.findElement(emailInputlocator);
			emailInput.sendKeys(username);
			WebElement passwordInput= driver.findElement(passwordInputlocator);
			passwordInput.sendKeys(password);
			WebElement loginButton= driver.findElement(loginButtonlocator);
			loginButton.click();
			Thread.sleep(3000);
			return new HomePage(driver);
			
	 }
	
	
}

