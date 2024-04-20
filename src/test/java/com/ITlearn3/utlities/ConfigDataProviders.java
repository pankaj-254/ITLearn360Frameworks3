package com.ITlearn3.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProviders 
{
	Properties pro ; 
	
	public ConfigDataProviders()
	{
	   File file = new File("./Configration/config.properties") ;
	
		try 
		{
			FileInputStream fis = new FileInputStream(file);
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Not able to load  config file "+e.getMessage());
		}
		
	}
	
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	
	public String getUrl()
	{
		return pro.getProperty("testurl");
	}

	


}
