package com.ITlearn3.utlities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactor 
{
	public static WebDriver startApplication(WebDriver driver, String browserName,String appUrl,int implicitWait)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chorme.driver", "./Drivers/chromedriver02.exe");
			driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.chorme.driver", "./Drivers/chromedriver02.exe");
			driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chorme.driver", "./Drivers/chromedriver02.exe");
			driver= new ChromeDriver();
			
		}
		
		else 
		{
			System.setProperty("webdriver.chorme.driver", "./Drivers/chromedriver02.exe");
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
		return driver;
		
	}
	
	
	
	public static void  quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
	
}
