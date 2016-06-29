package com.stockAccounting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAccounting.Master.testngstockAcc;

public class testngSuppliercre extends testngstockAcc

{
	
	@Test
	public void Suppliercre()
	{
		
		 expval="Add succeeded";
		 System.out.println(expval);
		 drv.findElement(By.xpath(pr.getProperty("supplier"))).click();
		 drv.findElement(By.xpath(pr.getProperty("supplieradd"))).click();
		 drv.findElement(By.id(pr.getProperty("suppname"))).sendKeys(sname);
		 drv.findElement(By.id(pr.getProperty("supadd"))).sendKeys(sadd);
		 drv.findElement(By.id(pr.getProperty("suppcity"))).sendKeys(scity);
		 drv.findElement(By.id(pr.getProperty("suppcount"))).sendKeys(scntry);
		 drv.findElement(By.id(pr.getProperty("suppconper"))).sendKeys(scper);
		 drv.findElement(By.id(pr.getProperty("supphnum"))).sendKeys(sphno);
		 drv.findElement(By.id(pr.getProperty("supemail"))).sendKeys(semail);
		 drv.findElement(By.id(pr.getProperty("supmob"))).sendKeys(smobno);
	     drv.findElement(By.id(pr.getProperty("supnotes"))).sendKeys(snotes);
	    
	     drv.findElement(By.xpath(pr.getProperty("addbtn"))).click();
	     Sleeper.sleepTightInSeconds(5);
	     drv.findElement(By.xpath(pr.getProperty("suppok"))).click();
	     Sleeper.sleepTightInSeconds(5);
	     actval=drv.findElement(By.xpath(pr.getProperty("sadds"))).getText();
	     System.out.println(actval);
	     Sleeper.sleepTightInSeconds(5);
	     drv.findElement(By.xpath(pr.getProperty("suppsucc"))).click();
	    
			Assert.assertEquals(expval, actval,"creation failed");
	
		
	}

}
