package com.stockAccounting.tests;

import java.io.IOException;



import com.stockAccounting.Master.stockMaster;

public class stockAcc_Login {
	
	
	public static void main(String[] args) throws IOException
	{
		stockMaster sm=new stockMaster();
		String res=sm.stockAcc_launch(sm.url);
		System.out.println(res);
		
		
		 res=sm.stockAcc_Login("admin", "master");
		System.out.println(res);
		
		res=sm.stockAcc_logout();
		System.out.println(res);
		
		sm.stockAcc_close();
		
		
		
	}

}
