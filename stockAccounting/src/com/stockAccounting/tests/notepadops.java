package com.stockAccounting.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Branch;

import com.stockAccounting.Master.stockMaster;

public class notepadops {

	

	public static void main(String[] args) throws IOException 
	{
	    String x; 
		String path = "D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\UOM.txt";
		String path1="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\results\\uomresult.txt";
		FileReader fir=new FileReader(path);
		BufferedReader bur=new BufferedReader(fir);
		
		bur.readLine();
		
		FileWriter fwr= new FileWriter(path1);
		BufferedWriter bwr = new BufferedWriter(fwr);
		bwr.write("Uid&UDesc&Result");
		bwr.newLine();
		
		stockMaster sm = new stockMaster();
		sm.stockAcc_launch(sm.url);
		sm.stockAcc_Login("admin", "master");
		
		
		
		while((x=bur.readLine())!=null)
		{
			System.out.println(x);
			String[] split =x.split("&");
			String U= split[0];
			String D= split[1];
			System.out.println(U+""+D);
          String res= sm.stockAcc_unitofmes1(U,D);
          bwr.write(x+"&"+res);
          bwr.newLine();
		
		
		}
	      bwr.close();
	      bur.close();
	      sm.stockAcc_logout();
	      sm.stockAcc_close();
	
	
	}

}
