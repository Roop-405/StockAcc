package com.stockAccounting.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stockAccounting.Master.stockMaster;

public class supplierwithExcel {

	
		public static void main(String[] args) throws IOException 
		{
		  	
			stockMaster sm = new stockMaster();
			String path = "D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\supplierExcel.xlsx";
	        String path1="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\results\\suppresult.xlsx";		
		   FileInputStream fi = new FileInputStream(path);
		   XSSFWorkbook wb = new XSSFWorkbook(fi);
		   XSSFSheet ws = wb.getSheet("Sheet1");
		   
		   
		   int Rc=ws.getLastRowNum();
	        sm.stockAcc_launch(sm.url);
	        sm.stockAcc_Login("admin", "master");
	
		
	        for (int i = 1; i <= Rc; i++)
			{
				XSSFRow R = ws.getRow(i);
				XSSFCell C = R.getCell(0);
				XSSFCell C1= R.getCell(1);
				XSSFCell C2 = R.getCell(2);
				XSSFCell C3= R.getCell(3);
				XSSFCell C4 = R.getCell(4);
				XSSFCell C5 = R.getCell(5);
				XSSFCell C6= R.getCell(6);
		        XSSFCell C7 = R.getCell(7);
				XSSFCell C8 = R.getCell(8);
				
				XSSFCell C9 = R.createCell(9);
				
				String sname=C.getStringCellValue();
				String sadd=C1.getStringCellValue();
				String scity=C2.getStringCellValue();
				String scnt=C3.getStringCellValue();
				String sconper=C4.getStringCellValue();
				String sphnum=C5.getStringCellValue();
				String semail=C6.getStringCellValue();
				String smob=C7.getStringCellValue();
				String snotes=C8.getStringCellValue();
				
				System.out.println(sname+"--"+sadd+"--"+scity+"--"+scnt+"--"+sconper+"--"+sphnum+"--"+semail+"--"+smob+"--"+snotes);
				String res=sm.stockAcc_suppcreation(sname, sadd, scity, scnt, sconper, sphnum, semail, smob, snotes);
				C9.setCellValue(res);
		
			}
		
	        FileOutputStream fo= new FileOutputStream(path1);
	         wb.write(fo);
	         fo.close();
           sm.stockAcc_logout();
           sm.stockAcc_close();
		
		}

}
