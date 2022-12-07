package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.CommonUtils;

public class LoginPage {
	
	private static LoginPage loginInstance;
	
	private LoginPage() {
		
	}
	
	public static LoginPage getInstance() {
		
		if(loginInstance==null) {
		loginInstance=new LoginPage();
		}
		return loginInstance;
	}
	@FindBy(xpath="//input[@class=\"_2IX_2- VJZDxU\"]")
	private WebElement userName;
	
	@FindBy(xpath="//input[@class=\"_2IX_2- _3mctLh VJZDxU\"]")
	private WebElement password;
	
	@FindBy(xpath="//button[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]")
	private WebElement loginButton;

	public WebElement getUserName() {
		CommonUtils.getInstance().highlightText(userName);
		return userName;
	}

	public WebElement getPassword() {
		CommonUtils.getInstance().highlightText(password);
		return password;
	}

	public WebElement getLoginButton() {
		CommonUtils.getInstance().highlightText(loginButton);
		return loginButton;
	}

	

}
