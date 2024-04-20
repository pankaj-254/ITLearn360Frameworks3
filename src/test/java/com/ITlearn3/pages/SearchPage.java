package com.ITlearn3.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
	WebDriver d ; 
	public SearchPage(WebDriver driver )
	{
		this.d=driver ;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "(//form[@name=\"search-course\"])[1]//input") WebElement SearchCourse ;
	@FindBy(xpath = "(//form[@name='search-course']//button)[1]") WebElement searchButton ;
	
	
	public void searchCoursePortal(String courseName)
	{
	
		SearchCourse.sendKeys(courseName);
		searchButton.click();
	}
	
}
