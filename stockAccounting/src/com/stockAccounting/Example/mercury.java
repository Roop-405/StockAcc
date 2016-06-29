package com.stockAccounting.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mercury {

	public static void main(String[] args)
	{
		WebDriver d = new FirefoxDriver();
        d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        d.manage().window().maximize();
        d.get("http:\\https://www.mercurytravels.co.in/ontramercury/faces/jsp/flightSearch.jsp");
       

	}

}
