package com.ITlearn3.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ITlearn3.pages.BaseTest;
import com.ITlearn3.pages.LoginPage;
import com.ITlearn3.utlities.ReadExcelFile;

public class loginPageTest extends BaseTest
{
	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLogin(String uname ,String pword) throws InterruptedException, IOException
	{
		LoginPage lp =new LoginPage(driver);
		String userName ="Demo12" ;
		String password ="Test123456$" ;
		
		lp.loginPortal(uname, pword);
		
		Thread.sleep(5000);
		
		if(uname.equals(userName) && pword.equals(password))
			{
				System.out.println("Test Passed");
				Assert.assertTrue(true);
				lp.LogoutPortal();
				
			}
		else
		{
			captureScreenShot(driver, "Verify login");
			Assert.assertTrue(false);
		}
	}
	
//	@DataProvider(name = "LoginDataProvider")
//	public static String[][] LoginDataProvider()
//	{	
//		String fileName = "C:\\Users\\panka\\eclipse-workspace\\ITLearn360Frameworks\\TestData\\username_password.xlsx" ;
//		String sheetName = "ItlearnLogin";
//		
//		int ttlRow = ReadExcelFile.getLastRow(fileName, sheetName);
//		int ttlCol = ReadExcelFile.getLastCol(fileName, sheetName) ;
//		
//		String[][] cellValue = new String[ttlRow-1][ttlCol];
//		for(int i = 1 ; i<ttlRow; i++)
//		{
//			for(int j=0;j<ttlCol;j++)
//			{
//			 	System.out.println(cellValue[i-1][j]=ReadExcelFile.getCellValue(fileName, sheetName, i, j));	
//			}
//		}
//		return cellValue;
//		
//	}
	
	
	//---------------------
	@DataProvider(name = "LoginDataProvider")
	public static String[][] LoginDataProvider()
	{
		String fileName = "C:\\Users\\panka\\eclipse-workspace\\ITLearn360Frameworks\\TestData\\username_password.xlsx" ;
		String sheetName = "ItlearnLogin";
		
		 //String sheetName = "LoginData" ;
		int ttlRow = ReadExcelFile .getLastRow(fileName, sheetName);
		int ttlCol = ReadExcelFile.getLastCol(fileName, sheetName);
		
		
		String[][] cellValue = new String[ttlRow-1][ttlCol];
		for(int i = 1 ; i<ttlRow; i++)
		{
			for(int j = 0 ;j<ttlCol	; j++)
			{
			cellValue[i-1][j]=ReadExcelFile.getCellValue(fileName, sheetName, i, j);
			}
		}
		
		
		return cellValue;
	}
	
	
	
	//--------------
	
//	public static void main(String[]args )
//	{
//		LoginDataProvider().toString(); 
//	}
//	
	
}


