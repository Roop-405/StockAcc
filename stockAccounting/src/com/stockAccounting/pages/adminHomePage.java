package com.stockAccounting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminHomePage 
{

	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(linkText="Stock Items")
	WebElement stockitems;
	
	
	@FindBy(linkText="Suppliers")
	WebElement suppliers;
	
	@FindBy(linkText="Purchases")
	WebElement purchases;
	
	@FindBy(linkText="Customers")
	WebElement customers;
	
	@FindBy(linkText="Sales")
	WebElement sales;
	
	@FindBy(linkText="Outstandings")
	WebElement outstandings;
	
	@FindBy(linkText="Administrator")
	WebElement administrator;
	
	@FindBy(linkText="Settings")
	WebElement settings;
	
	@FindBy(xpath=".//*[@id='mi_logout']/a")
	WebElement logout;
	
	@FindBy(xpath=".//*[@id='msUserName']/font/strong")
	WebElement admin;
	
	public void stockitemsclick()
	{
		stockitems.click();
	}
	public void dashboardclick()
	{
		dashboard.click();
	}
	public void suppliersclick()
	{
		suppliers.click();
	}
	
	public void  purchasesclick()
	{
		 purchases.click();
	}
	public void customersclick()
	{
		customers.click();
	}
	public void salesclick()
	{
		sales.click();
	}
	public void  outstandingsclick()
	{
		 outstandings.click();
	}
	public void administratorclick()
	{
		administrator.click();
	}
	
	public void settingsclick()
	{
		settings.click();
	}
	public void logoutclick()
	{
		logout.click();
	}
	
	
}
