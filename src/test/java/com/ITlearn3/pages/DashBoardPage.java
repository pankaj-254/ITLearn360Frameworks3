package com.ITlearn3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage 
{
	WebDriver driver ;
	public   DashBoardPage (WebDriver d ) 
	{
		driver =d  ; 
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath = "//a[@class='lg_button']")WebElement dashboard ;
	@FindBy(xpath = "//a[contains(text(),'Offered Academies')]")WebElement Offered_Academies  ;
	@FindBy(xpath = "(//li[@class='course academy-profile col-md-3 col-xs-12 border-radius-sm ']//button)[1]")WebElement subscribe_now ;
	
	public void dashboardPortal()
	{
		dashboard.click();
		Offered_Academies.click();
		subscribe_now.click();
		
	}
	
	
	
	
	
	
	
	
	
	
}
