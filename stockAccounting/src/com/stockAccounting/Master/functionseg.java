package com.stockAccounting.Master;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class functionseg
{

	public static WebDriver driver;
	public static String srcpath="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\screenshots";
	public static void main(String[] args) throws IOException
	{
		driver = new FirefoxDriver();
		driver.get("http://google.com");
		functionseg f= new functionseg();
		f.takingscreenshot("flip.png");
		
	}
	public void takingscreenshot(String name) throws IOException
	{
		 File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
		 
				FileUtils.copyFile(srcfile, new File(srcpath+"\\"+name));
	}
}

