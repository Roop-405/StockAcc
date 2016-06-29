package com.stockAccounting.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readandwrite {

	
		
			 
			public static void main(String[] args) throws IOException
			{
			       	
				Readandwrite r= new Readandwrite();
				r.read("D:\\OJT\\stockAccounting\\src\\com\\stockAccounting\\Testdata", "testdata.xlsx", "Sheet1");
			}
		
			public void read(String fPath,String fName,String shtname) throws IOException
			{
				String xl=fPath+"\\"+fName;
				FileInputStream fi=new FileInputStream(xl);
				XSSFWorkbook wb=new XSSFWorkbook(fi);
				XSSFSheet ws=wb.getSheet(shtname);
				
				int Rc=ws.getLastRowNum();
				
				for (int i = 1; i <= Rc; i++)
				{
					int cc=ws.getRow(i).getLastCellNum();
					for (int j = 0; j < cc; j++)
					{
						System.out.println(ws.getRow(i).getCell(j).getStringCellValue());
						
					}
				}
			
	               
	               	            }
	            
	            
	            

	}


