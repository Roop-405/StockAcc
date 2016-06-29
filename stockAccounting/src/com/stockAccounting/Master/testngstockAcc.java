package com.stockAccounting.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class testngstockAcc 
{
     public static WebDriver drv;
     public FileInputStream fi;
     public Properties pr= new Properties();
     public static String path ="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\properties\\stockAcc.properties"; 
	 public static String url = "http:\\webapp.qedgetech.com";
	 public String expval,actval;
	 public String user="admin";
	 public String  pwd= "master";
	 public String sname="vin diesel",sadd="Hollywood";
	 public String scity="Hollywood",scntry="usa",scper="vin diesel";
	 public String sphno="00123456789",semail="diesel123@gmail.com",smobno="9874561230",snotes="Supplier supplies car toys ";
	 public String stcat="carss";
	 public String uoid="412",uodes="items";
	 public String stname="cartoyss",prpr="2000",sepr="2500";
	
	@BeforeSuite
	public void stockAcc_launch() throws IOException
	{
	  fi = new FileInputStream(path);
//	  pr= new Properties();
	  pr.load(fi);
	  expval="btnsubmit";
	  String br=pr.getProperty("browser");
	  if (br.equalsIgnoreCase("firefox"))
	  {
		drv = new FirefoxDriver();
	  }
	  else if (br.equalsIgnoreCase("chrome"))
	  {
		System.setProperty("webdriver.chrome.driver","D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\jars\\ChromeSetup.exe" );
		drv= new ChromeDriver();	
	  }
	  else if (br.equalsIgnoreCase("ie")) 
	  {
		System.setProperty("webdriver.ie.driver","D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\jars\\IEDriverServer.exe");
		drv=new InternetExplorerDriver();
	  }
	  drv.get(url);
	 
		drv.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		drv.manage().window().maximize();
		actval=drv.findElement(By.id("btnsubmit")).getAttribute("id");
		
		Assert.assertEquals(actval, expval,"Launch Has Failed");
	System.out.println("this is in launch");
	}

  @AfterSuite
  public void stockAcc_Close()
  {
	  drv.close();
	  System.out.println("this is in close");
  }

  @BeforeTest
  public void stockAcc_Login()
  {
	  expval="Administrator";
	  drv.findElement(By.id(pr.getProperty("username"))).clear();
		drv.findElement(By.id(pr.getProperty("username"))).sendKeys(user);
		drv.findElement(By.id(pr.getProperty("password"))).clear();
		drv.findElement(By.id(pr.getProperty("password"))).sendKeys(pwd);
		drv.findElement(By.id(pr.getProperty("login"))).click();
       actval=drv.findElement(By.xpath(pr.getProperty("administrator"))).getText();
       Assert.assertEquals(expval, actval,"login has failed");
       System.out.println("this is in login");
   }

 
  @AfterTest
  public void stockAcc_Logout()
  {
	  expval="btnsubmit";
	  drv.findElement(By.id(pr.getProperty("logout"))).click();
     // drv.findElement(By.id(pr.getProperty("ok"))).click();
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
      actval=drv.findElement(By.id("btnsubmit")).getAttribute("id");
		
		Assert.assertEquals(actval, expval,"Logout is not successfull");
	System.out.println("this is in logout");
  }


}
