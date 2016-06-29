package com.stockAccounting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.stockAccounting.Master.testngstockAcc;

public class testngStockitcre extends testngstockAcc
{

	@Test
	public void stockcre()
	{
		expval="Add succeeded";
        WebElement stock_we=drv.findElement(By.xpath(pr.getProperty("stockitems")));
		
		Actions ac=new Actions(drv);
		ac.moveToElement(stock_we).build().perform();
		drv.findElement(By.xpath(pr.getProperty("stockitems"))).click();
		drv.findElement(By.xpath(pr.getProperty("stoadd"))).click();
		WebElement listbox = 	drv.findElement(By.id(pr.getProperty("stocat")));
		Select list = new Select (listbox);
		list.selectByVisibleText(stcat);
		WebElement listbox1 = 	drv.findElement(By.id(pr.getProperty("stosuno")));
		Select sel= new Select (listbox1);
		sel.selectByVisibleText(sname);
		
		//drv.findElement(By.id(pr.getProperty("stocat"))).sendKeys("data");
		//drv.findElement(By.id(pr.getProperty("stosuno"))).sendKeys(uomdes);
		
		drv.findElement(By.id(pr.getProperty("stoname"))).sendKeys(stname);
		WebElement listbox2 = 	drv.findElement(By.id(pr.getProperty("stouom")));
		Select sele= new Select (listbox2);
		sele.selectByVisibleText(uodes);



		drv.findElement(By.id(pr.getProperty("stopur"))).sendKeys(prpr);
        drv.findElement(By.id(pr.getProperty("stose"))).sendKeys(sepr);
        drv.findElement(By.id(pr.getProperty("stonot"))).sendKeys("notes");
        drv.findElement(By.id(pr.getProperty("stocradd"))).click();
        Sleeper.sleepTightInSeconds(5);
        List<WebElement> button=drv.findElements(By.tagName("button"));
		System.out.println(button.size());
        for (int i = 0; i < button.size(); i++) 
		{
			String text=button.get(i).getText();
			
			if (text.equalsIgnoreCase("OK!"))
			{
				button.get(i).click();
				break;
			}
		}


		
        Sleeper.sleepTightInSeconds(5);
		actval=drv.findElement(By.xpath(pr.getProperty("stoadm"))).getText();
        System.out.println(actval);
        drv.findElement(By.xpath(pr.getProperty("stoadok"))).click();
	
	
	}
}
