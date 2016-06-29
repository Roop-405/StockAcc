package com.stockAccounting.tests;

import java.io.IOException;

import org.openqa.selenium.server.browserlaunchers.Sleeper;

import com.stockAccounting.Master.stockMaster;



public class Logintests {
	public static void main(String[] args) throws IOException
	{
		
	stockMaster sm=new stockMaster();
	String res=sm.stockAcc_launch(sm.url);
	System.out.println(res);
	
	res=sm.stockAcc_Login("admin", "master");
	System.out.println(res);
	
	res=sm.stockAcc_suppcreation( "ramu","outerringroad", "bengaluru", "india", "sati", "02020310221", "banaghaba@gmail.com", "902314561", "supplies datacables");
	System.out.println(res);
	
	Sleeper.sleepTightInSeconds(5);
	
	res=sm.stockAcc_stockcatcreat("Trees");
	System.out.println(res);
	
	Sleeper.sleepTightInSeconds(5);
	
	res=sm.stockAcc_unitofmes1("0012","Testing");
	System.out.println(res);
	
    Sleeper.sleepTightInSeconds(5);
	
	res=sm.stockAcc_stockitemcreation("datacable", "500", "800", "notes");
    System.out.println(res);
	
	res=sm.stockAcc_purchasecre("2500","datacable","cables","chargers");
	System.out.println(res);
	
	res=sm.stockAcc_custcreation("prakash", "outer rin road", "bengaluru", "india", "Prakash","02014567895", "prakash@gmail.com","9856231470", "customer for qspider");
	res=sm.stockAcc_logout();
	System.out.println(res); 
	
	sm.stockAcc_close();
	}
}