package com.stockAccounting.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stockAccounting.Master.stockMaster;

public class UomwithExcel {

	public static void main(String[] args) throws IOException 
	{
	  	
		stockMaster sm = new stockMaster();
		String path = "D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\uomexcel.xlsx";
        String path1="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\results\\uomres.xlsx";		
	   FileInputStream fi = new FileInputStream(path);
	   XSSFWorkbook wb = new XSSFWorkbook(fi);
	   XSSFSheet ws = wb.getSheet("uomdat");
	    XSSFRow r = ws.getRow(3);
        XSSFCell c= r.getCell(0);
        
        System.out.println(c.getStringCellValue());
        
        int Rc=ws.getLastRowNum();
        sm.stockAcc_launch(sm.url);
        sm.stockAcc_Login("admin", "master");
        
		
		for (int i = 1; i <= Rc; i++)
		{
			XSSFRow R = ws.getRow(i);
			XSSFCell C = R.getCell(0);
			XSSFCell C1= R.getCell(1);
			
			XSSFCell C2 = R.createCell(2);
			String Uid=C.getStringCellValue();
			String Udesc=C1.getStringCellValue();
			
			System.out.println(Uid+"-----"+Udesc);
			String res=sm.stockAcc_unitofmes1(Uid, Udesc);
			C2.setCellValue(res);
			
		
			}
		
	         FileOutputStream fo= new FileOutputStream(path1);
	         wb.write(fo);
	         fo.close();
            sm.stockAcc_logout();
            sm.stockAcc_close();
             
	
	}
	   
	   
	
	
}
	
	

