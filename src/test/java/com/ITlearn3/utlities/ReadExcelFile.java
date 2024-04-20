package com.ITlearn3.utlities;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook ;
	public static XSSFSheet excelSheet ;
	public static XSSFRow row ;
	public static XSSFCell cell ;
	
	
	public static String getCellValue(String fileName , String sheetName ,int rowNo, int cellNo )
	{
		try 
		{
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			cell = excelSheet.getRow(rowNo).getCell(cellNo);
			workbook.close();	
			
			return cell.getStringCellValue() ;
		}
		catch (Exception e) 
		{
			return "unable to read data from excel sheet"; 
 		}
	}
	
	
	
	public static int getLastRow(String fileName , String sheetName )
	{ 
		int lastRow  ;
		
		try 
		{
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			lastRow = excelSheet.getLastRowNum()+1;
			workbook.close();
			
			return lastRow;

		} 
		catch (Exception e) 
		{
			System.out.println("Excel file not found");
			return  0;	
		} 
		
		
	}
	
	
	
	public static int getLastCol(String fileName , String sheetName  )
	{ 
		int lastCol  ;
		
		try 
		{
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(sheetName);
			lastCol = excelSheet.getRow(1).getLastCellNum() ;
			workbook.close();
			
			return lastCol;

		} 
		catch (Exception e) 
		{
			System.out.println("Excel file not found");
			return  0;	
		} 
		
		
	}
	
	
	
	
	
//to test wheather Excel reader works or not 	
	
	public static void main(String agrs[])
	{
		String fileName ="C:\\Users\\panka\\eclipse-workspace\\ITLearn360Frameworks\\TestData\\username_password.xlsx";
		String sheetName = "CardDetails" ;
//		int ttlRow = ExcelFileReader.getLastRow(fileName, sheetName);
//		int ttlCol = ExcelFileReader.getLastColumn(fileName, sheetName);
	
		
		
		System.out.println( getCellValue(fileName, sheetName, 1, 0));
		System.out.println( getCellValue(fileName, sheetName, 2, 0));
		System.out.println( getCellValue(fileName, sheetName, 3, 0));
		
		
		System.out.println(getLastCol(fileName, sheetName));
		System.out.println(getLastRow(fileName, sheetName));
		
		
		
		
	}
	
	
}
