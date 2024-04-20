package com.ITlearn3.testcases;

import org.testng.annotations.Test;

import com.ITlearn3.pages.BaseTest;
import com.ITlearn3.pages.DashBoardPage;
import com.ITlearn3.pages.LoginPage;
import com.ITlearn3.pages.PaymentPage;
import com.ITlearn3.utlities.ReadExcelFile;

public class PaymentTestCase extends BaseTest
{	
	String fileName = "C:\\Users\\panka\\eclipse-workspace\\ITLearn360Frameworks\\TestData\\username_password.xlsx" ;
	String loginCred ="ItlearnLogin" ;
	String courseSheet = "SearchCourse";
	
	@Test(priority = 1)
	public void paymentTest()	
	{
		LoginPage lp = new LoginPage(driver) ;
		String userName = ReadExcelFile.getCellValue(fileName, loginCred, 1, 0) ;
		String password = ReadExcelFile.getCellValue(fileName, loginCred, 1, 1) ;
		
		lp.loginPortal(userName, password);
		
		DashBoardPage dp= new DashBoardPage(driver);
		dp.dashboardPortal();
		
		PaymentPage pg =new PaymentPage(driver ) ;
		String cardDetail = "CardDetails";
		
		
		String CrNum = ReadExcelFile.getCellValue(fileName, cardDetail, 1, 0) ;
		System.out.println("Card number : "+CrNum);
		String CrExpDate = ReadExcelFile.getCellValue(fileName, cardDetail, 2, 0) ;
		System.out.println("Card ExpiryDate : "+CrExpDate);
		String CrCVC = ReadExcelFile.getCellValue(fileName, cardDetail, 3, 0) ;
			System.out.println("Card Cvc : "+CrCVC);
		pg.paymentPortal(CrNum, CrExpDate, CrCVC);

		
	}
	
} 	
