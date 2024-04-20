package com.ITlearn3.testcases;

import org.testng.annotations.Test;

import com.ITlearn3.pages.BaseTest;
import com.ITlearn3.pages.LoginPage;
import com.ITlearn3.pages.SearchPage;
import com.ITlearn3.utlities.ReadExcelFile;

public class SearchTestCase extends BaseTest
{
	String fileName = "C:\\Users\\panka\\eclipse-workspace\\ITLearn360Frameworks\\TestData\\username_password.xlsx" ;
	String loginCred ="ItlearnLogin" ;
	String courseSheet = "SearchCourse";
	
	@Test(priority = 1)
	public void searchCourseTest()	
	{
		LoginPage lp = new LoginPage(driver) ;
		String userName = ReadExcelFile.getCellValue(fileName, loginCred, 1, 0) ;
		String password = ReadExcelFile.getCellValue(fileName, loginCred, 1, 1) ;
		
		lp.loginPortal(userName, password);
		
		SearchPage sp =new SearchPage(driver);
		String CourseName = ReadExcelFile.getCellValue(fileName, courseSheet, 1, 0) ;
		sp.searchCoursePortal(CourseName);
		
	}

}
