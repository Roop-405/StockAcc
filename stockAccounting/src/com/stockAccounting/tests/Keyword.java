package com.stockAccounting.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.stockAccounting.Master.stockMaster;

public class Keyword
{

	@Test
	public void keyword() throws IOException
	{
		stockMaster sm = new stockMaster();
		String res=null;
		String path="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\Keyword.xlsx";
		String Keyout="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\results\\Keyout.xlsx";
		FileInputStream fi= new FileInputStream(path);
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet ws1= wb.getSheet("TestCase");
		XSSFSheet ws2 =wb.getSheet("TestSteps");
		XSSFSheet ws3=wb.getSheet("TestData");
		
		int tcrc=ws1.getLastRowNum();
		int tsrc=ws2.getLastRowNum();
		int tdrc=ws3.getLastRowNum();
		for (int i = 1; i <= tcrc; i++) 
		{
		 String TcEx=ws1.getRow(i).getCell(2).getStringCellValue();
		 
		 if(TcEx.equalsIgnoreCase("Y"))
		 {
			 String TcId=ws1.getRow(i).getCell(0).getStringCellValue();
			 for (int j = 0; j < tsrc; j++) 
			 {
			    String tsId= ws2.getRow(j).getCell(0).getStringCellValue();
			    if(TcId.equalsIgnoreCase(tsId))
			    {
			    	String key=ws2.getRow(j).getCell(3).getStringCellValue();
			    	switch (key)
			    	{
			    	case "sLanch":
			    		res=sm.stockAcc_launch(sm.url);
						break;
			    		
			    	
			    	case "sLogin":
			    		
			    		
						res=sm.stockAcc_Login("admin", "master");
						
						break;
			    	case "sLogout":
			    		
			    		res=sm.stockAcc_logout();
			    		
			    		break;
			    	case "sSupplier":
			    		
			    		String Sname=ws3.getRow(1).getCell(0).getStringCellValue();
						String Sadd=ws3.getRow(1).getCell(1).getStringCellValue();
						String Scity=ws3.getRow(1).getCell(2).getStringCellValue();
						String Scntry=ws3.getRow(1).getCell(3).getStringCellValue();
						String Sconper=ws3.getRow(1).getCell(4).getStringCellValue();
						String Sphno=ws3.getRow(1).getCell(5).getStringCellValue();
						String Semail=ws3.getRow(1).getCell(6).getStringCellValue();
						String Smobno=ws3.getRow(1).getCell(7).getStringCellValue();
						String Snotes=ws3.getRow(1).getCell(8).getStringCellValue();
			    		res= sm.stockAcc_suppcreation(Sname, Sadd, Scity, Scntry, Sconper, Sphno, Semail, Smobno, Snotes);
			    		
						
						break;
			    		
			    	case "sCat":
			    		String Scat=ws3.getRow(1).getCell(9).getStringCellValue();
			    		res=sm.stockAcc_stockcatcreat(Scat);
			    		
			    	    break;
			    		
			    	case "sUom":
			    		String uid=ws3.getRow(1).getCell(10).getStringCellValue();
			    		String Udes=ws3.getRow(1).getCell(11).getStringCellValue();
			    		res=sm.stockAcc_unitofmes1(uid, Udes);
			    		
			    		break;
			    	
			    	
			    	default :
			    		System.out.println("select proper Keyword");
			    		break;
			    	
			    	
			    	}
			    	ws2.getRow(j).createCell(4).setCellValue(res);
					
					
					if (!ws2.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail")) 
					{
						ws1.getRow(i).createCell(3).setCellValue(res);
					}
					else
					{
						ws1.getRow(i).createCell(3).setCellValue("Fail");
					}
			    	
			    	
			    	
			    	
			    	
			    }
				 
				 
				 
			}
		 }
		 else
		 {
			 ws1.getRow(i).createCell(3).setCellValue("BLOCKED");
		 }
		}

		FileOutputStream fo=new FileOutputStream(Keyout);
		wb.write(fo);
		fo.close();
		
	}
}
