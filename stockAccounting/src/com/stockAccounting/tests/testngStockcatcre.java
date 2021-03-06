package com.stockAccounting.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAccounting.Master.testngstockAcc;

public class testngStockcatcre extends testngstockAcc
{

	@Test
	public void Stockcatcre()
	{
		Sleeper.sleepTightInSeconds(5);
		expval="Add succeeded";
        WebElement stockw=drv.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a "));
		
		Actions ac=new Actions(drv);
		ac.moveToElement(stockw).build().perform();
		
		drv.findElement(By.xpath(pr.getProperty("stockcategories"))).click();;
		drv.findElement(By.xpath(pr.getProperty("catadd"))).click();
		drv.findElement(By.id(pr.getProperty("catnam"))).sendKeys(stcat);
		drv.findElement(By.id(pr.getProperty("cataddb"))).click();
		Sleeper.sleepTightInSeconds(5);
		drv.findElement(By.xpath(pr.getProperty("catok"))).click();
		Sleeper.sleepTightInSeconds(5);
		actval=drv.findElement(By.xpath(".//div[@class='alert alert-success ewSuccess']")).getText();
		System.out.println(actval);
		Sleeper.sleepTightInSeconds(5);
		drv.findElement(By.xpath(pr.getProperty("catsucc"))).click();
		
		Assert.assertEquals(expval, actval,"categoery not created");
	}
	
	
}
