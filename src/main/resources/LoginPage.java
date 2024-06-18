package com.login;

public class LoginPage{
	
	@FindBy(id="identifierId")
	WebElement usernameGmail;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordGmail;
	

	public static void loginIntoGmail()
	{
		driver.
	}
	
}
