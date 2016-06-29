package com.stockAccounting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage
{
   public static String url="http://webapp.qedgetech.com";
   public static String user="admin",pwd="master";
   
   @FindBy(id="username")
   WebElement username;
   @FindBy(id="password")
   WebElement password;
   @FindBy(id="btnsubmit")
   WebElement login;
   @FindBy(id="btnreset")
   WebElement reset;
   
	public void sto_login(String user,String pwd)
	{
		reset.click();
		username.clear();
		password.clear();
		username.sendKeys(user);
		password.sendKeys(pwd);
		login.click();
	}
	
	
	
	
}
