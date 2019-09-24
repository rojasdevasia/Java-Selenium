package com.geico.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class ExcelUtils {
	
@SuppressWarnings("unchecked")
public static HashMap<String,String> storeValues = new HashMap();
private static Object[][] dataArr=new Object[1][6] ;

	   public static Object[][] data(String filepath,String sheetName)
	   {     
	      try
	      {
	         FileInputStream fs = new FileInputStream(filepath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fs);
	         XSSFSheet sheet = workbook.getSheet(sheetName);
	         Row HeaderRow = sheet.getRow(0);
	         
	         for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
	         {
	            Row currentRow = sheet.getRow(i);
	            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
	            {
	              Cell currentCell = currentRow.getCell(j);
	              dataArr[i][j] = currentCell.getStringCellValue();
	             
	            }
	            
	         }
	         fs.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return dataArr;
	   }		
	   
	   public static void main(String args[]){
		      String worklocation = System.getProperty("user.dir");
		      
		      String src = (worklocation+"/geicoTestData.xlsx");
		      
		      Object[][] data1 = data(src,"Sheet1");
	   }
}

