package com.stockAccounting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stockAccounting.Master.testngstockAcc;

public class tetstngUomcre extends testngstockAcc
{
 
	@Test(dataProvider="dataa")
	public void Uomcre(String uid,String udes)
	{
		expval="Add succeeded";
        WebElement stock_we=drv.findElement(By.xpath(pr.getProperty("stockitems")));
			
			Actions ac=new Actions(drv);
			ac.moveToElement(stock_we).build().perform();
			
			drv.findElement(By.xpath(pr.getProperty("uom"))).click();
			drv.findElement(By.xpath(pr.getProperty("uomadd"))).click();
			drv.findElement(By.id(pr.getProperty("uomid"))).sendKeys(uid);
			drv.findElement(By.id(pr.getProperty("uomdescription"))).sendKeys(udes);
			drv.findElement(By.id(pr.getProperty("uomad"))).click();
			Sleeper.sleepTightInSeconds(5);
			drv.findElement(By.xpath(pr.getProperty("uomok"))).click();
			Sleeper.sleepTightInSeconds(5);
		actval= drv.findElement(By.xpath(pr.getProperty("scuomsc"))).getText();	   
         System.out.println(actval);
         drv.findElement(By.xpath(pr.getProperty("uomsucc"))).click();
         
         Assert.assertEquals(expval,actval ,"uom not created");
	}


@DataProvider
public Object[] [] dataa()
{
	Object[] [] d= new Object[3][2];
	d[0][0]="412";
	d[0][1]="this is Rs";
    d[1][0]="415";
    d[1][1]="this is Dr";
    d[2][0]="418";
    d[2][1]="this is gknk";
	
	
	
	
	return d;	
}
}