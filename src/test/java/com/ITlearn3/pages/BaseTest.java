package com.ITlearn3.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ITlearn3.utlities.BrowserFactor;
import com.ITlearn3.utlities.ConfigDataProviders;

public class BaseTest 
{
	protected WebDriver driver ; 
	ConfigDataProviders config = new ConfigDataProviders() ;
	
	
	@BeforeClass
	public void setUp()
	{
		driver = BrowserFactor.startApplication(driver,config.getBrowser(), config.getUrl(), 30) ;
	}
	
	
	@AfterClass
	public void tearDoww()
	{
		BrowserFactor.quitBrowser(driver);
	}
	
	
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//convert webdriver objcet to TakeScreenShot interface
		TakesScreenshot screenShot = (TakesScreenshot)driver ;
	
		//step 2 : Call getScreenShotAs Method to capture image file
		
		File src = screenShot.getScreenshotAs(OutputType.FILE) ;
		File srcpath = new File("."+"//ScreenShots//"+ testName +".png") ;
		System.out.println("This is Screenshot section");
		
		//Step 3 : copy image file to destination 
		FileUtils.copyFile(src, srcpath) ;
	}
	
	
}
