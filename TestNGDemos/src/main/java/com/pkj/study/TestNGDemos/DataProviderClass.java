package com.pkj.study.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="dataProviderForMul")
	public Object[][] dataProviderForMul() {		
		return new Object[][] {{1,2},{2,4},{3,5},{4,6},{5,7}};
	}
	
	@DataProvider(name="dataProviderForAddFromExcel")
	public Object[][] dataProviderForAddFromExcel(){
		
		
		Integer[][] result=null;
		
		
		try {
			File file=new File("C:\\Users\\PrashantKumarjhaJha\\Documents\\dataforadd.xlsx");
			
			FileInputStream fis=new FileInputStream(file);
			
			Workbook wb=new XSSFWorkbook(fis);
			Sheet sh=wb.getSheetAt(0);
			
			int rows=sh.getPhysicalNumberOfRows();
					
			result=new Integer[rows-1][2];
		   int index=0;
			for(int i=1;i<rows;i++) {				
				Row row=sh.getRow(i);
				result[index][0]= (int)row.getCell(0).getNumericCellValue();
				result[index][1]=(int)row.getCell(1).getNumericCellValue();			
				index++;
			}
			System.out.println(Arrays.deepToString(result));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	
}
