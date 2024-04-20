package com.ITlearn3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest
{
	WebDriver driver ;
	 
	public LoginPage(WebDriver d)
	{
		this.driver=d ;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "(//a[@id='loginlabel'])[1]")WebElement HloginButton ;
	@FindBy(xpath = "(//input[@id='user_login'])[1]")WebElement userName ;
	@FindBy(xpath = "(//input[@id='user_pass'])[1]")WebElement password ;
	@FindBy(xpath = "(//input[@id='wp-submit'])[1]")WebElement login ;
	
	public void loginPortal(String uName,String pass)
	{
		HloginButton.click();
		userName.sendKeys(uName);
		password.sendKeys(pass);
		login.click();
	}
	
	
	
	//logout 
	@FindBy(xpath = "//a[@id='gk-login-toggle']") WebElement profileIcon ;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")WebElement logOutB ;
	
	public void LogoutPortal()
	{
		profileIcon.click();
		logOutB.click();
		
	}
	

}
