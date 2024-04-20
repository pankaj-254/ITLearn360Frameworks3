package com.ITlearn3.utlities;


public class Pratice 
{
	public static void main(String[]agrs)
	{
		String fileName = "C:\\Users\\panka\\eclipse-workspace\\ITLearn360Frameworks\\TestData\\username_password.xlsx" ;
		String sheetName = "ItlearnLogin";
		String cell =  ReadExcelFile.getCellValue(fileName, sheetName, 0, 0);	
		String cell1 = ReadExcelFile.getCellValue(fileName, sheetName, 0, 1);	
		String cell2 =  ReadExcelFile.getCellValue(fileName, sheetName, 1, 0);	
		String cell3 =  ReadExcelFile.getCellValue(fileName, sheetName, 1, 1);	
		String cell4 =  ReadExcelFile.getCellValue(fileName, sheetName, 2, 0);	
		String cell5 =  ReadExcelFile.getCellValue(fileName, sheetName, 2, 1);	
		
		

		System.out.println(cell);
		System.out.println(cell1);
		System.out.println(cell2);
		System.out.println(cell3);
		System.out.println(cell4);
		System.out.println(cell5);
		
		
		int lastRow = ReadExcelFile.getLastRow(fileName, sheetName) ;
		System.out.println(lastRow);
		int lastcel = ReadExcelFile.getLastCol(fileName, sheetName) ;
		System.out.println(lastcel);
		String [][] Cellval = new String[lastRow-1][lastcel];
System.out.println("\n\n\n\n");
		for(int i = 1 ; i<lastRow ; i++)
		{
			for(int j = 0 ; j<lastcel ; j++ )
			{
				Cellval[i-1][j]=ReadExcelFile.getCellValue(fileName, sheetName, i, j);
				System.out.println(Cellval[i-1][j]);
			}
		}
		
		
	}
}
