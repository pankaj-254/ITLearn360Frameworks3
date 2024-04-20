package com.ITlearn3.utlities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerClass implements ITestListener 
{
	ExtentSparkReporter htmlReporter ;
	ExtentReports reports ;
	ExtentTest test ;
	
	public void configureReport()
	{
		htmlReporter = new ExtentSparkReporter("ExtentListnerReportDemo.html") ;
		reports = new ExtentReports() ;
		reports.attachReporter(htmlReporter);
	
		//add system information/envo info to reports
		reports.setSystemInfo("machine", "Pankaj PC");
		reports.setSystemInfo("OS", "Windows11");
	
		htmlReporter.config().setDocumentTitle("Extent Listner Report Demo");
		htmlReporter.config().setReportName("This is my first Report");;
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	public void onTestStart(ITestResult result)
	{
		System.out.println();
	}
	
	
	public void onTestSuccess(ITestResult result )
	{
		System.out.println("Name of the test method successfully executed "+result.getName());
		test =reports.createTest(result.getName()) ;
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is : "+result.getName(), ExtentColor.GREEN) ) ;
	
	}
	
	
	public void onTestFailure(ITestResult result )
	{
		System.out.println("Name of the test method Failed "+result.getName());
		test =reports.createTest(result.getName()) ;
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed test case is : "+result.getName(), ExtentColor.RED) ) ;
	
		String screenShotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".png" ;
		
		File screenShotFile = new File(screenShotPath) ;
		
		if(screenShotFile.exists())
		{
			test.fail("Captured ScreenShot is below: "+test.addScreenCaptureFromPath(screenShotPath)) ;
		}
		
	}
	
	
	public void onTestSkipped(ITestResult result )
	{
		System.out.println("Name of the test method Skipped "+result.getName());
	}
	
	
	
	

	public void onStart(ITestContext Context)
	{
		System.out.println("Test execution started ");
		configureReport();
	}
	
	
	
	
	public void onFinish(ITestContext Context)
	{
		System.out.println("Test execution Completed");
		reports.flush();
	}
	
	
		
}
