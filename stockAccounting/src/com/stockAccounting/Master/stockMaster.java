package com.stockAccounting.Master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class stockMaster {

	public static String url="http://webapp.qedgetech.com";
	
	
	//public String cpath= "D:\\chromedriver.exe";
	
	public static WebDriver driver;
	public static String expval,actval;
	public static Properties pr;
	public static FileInputStream fis;
	public static String prop="D:\\Roop-se\\stockAccounting\\src\\com\\stockAccounting\\properties\\stockAcc.properties";
	public static String name="datacables";
	public static String supname= "Qspider";
	public static String uomdes= "10 Tons";
	
	
	
	
	
		
		public String stockAcc_launch(String url) throws IOException
		{
		   fis= new FileInputStream(prop);
		   pr= new Properties();
		   pr.load(fis);
			
			expval="login";
			//System.setProperty("webdriver.chrome.driver",cpath);
			//driver= new ChromeDriver();
			driver= new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
			if (expval.equalsIgnoreCase(actval))
			{
				return "Pass";
				
			}
			else
			{
				return "Fail";
			}
			
			
		}
		
		public String stockAcc_Login(String user,String pwd) throws IOException
		{
			expval="administrator";
			driver.findElement(By.id(pr.getProperty("username"))).clear();
			driver.findElement(By.id(pr.getProperty("username"))).sendKeys(user);
			driver.findElement(By.id(pr.getProperty("password"))).clear();
			driver.findElement(By.id(pr.getProperty("password"))).sendKeys(pwd);
			driver.findElement(By.id(pr.getProperty("login"))).click();
			actval=driver.findElement(By.xpath(pr.getProperty("administrator"))).getText();
			if (expval.equalsIgnoreCase(actval))
			{
				return "Pass";			
				
			}
			else
			{
				return "Fail";
			}

		}	
	    
		public String stockAcc_suppcreation(String Supname,String suppadd,String supcity,String supcount,String supconper,String suphnum,String suppemail,String suppmob,String suppnotes) throws IOException
			{
				 expval="Add succeeded";
				 System.out.println(expval);
				 driver.findElement(By.xpath(pr.getProperty("supplier"))).click();
				 driver.findElement(By.xpath(pr.getProperty("supplieradd"))).click();
				 driver.findElement(By.id(pr.getProperty("suppname"))).sendKeys(supname);
				 driver.findElement(By.id(pr.getProperty("supadd"))).sendKeys(suppadd);
				 driver.findElement(By.id(pr.getProperty("suppcity"))).sendKeys(supcity);
				 driver.findElement(By.id(pr.getProperty("suppcount"))).sendKeys(supcount);
				 driver.findElement(By.id(pr.getProperty("suppconper"))).sendKeys(supconper);
				 driver.findElement(By.id(pr.getProperty("supphnum"))).sendKeys(suphnum);
				 driver.findElement(By.id(pr.getProperty("supemail"))).sendKeys(suppemail);
				 driver.findElement(By.id(pr.getProperty("supmob"))).sendKeys(suppmob);
			     driver.findElement(By.id(pr.getProperty("supnotes"))).sendKeys(suppnotes);
			    
			     driver.findElement(By.xpath(pr.getProperty("addbtn"))).click();
			     Sleeper.sleepTightInSeconds(5);
			     driver.findElement(By.xpath(pr.getProperty("suppok"))).click();
			     Sleeper.sleepTightInSeconds(5);
			     actval=driver.findElement(By.xpath(pr.getProperty("sadds"))).getText();
			     System.out.println(actval);
			     Sleeper.sleepTightInSeconds(5);
			     driver.findElement(By.xpath(pr.getProperty("suppsucc"))).click();
			     if (expval.equalsIgnoreCase(actval))
					{
						return "Pass";
					}
					else
					{
						return "Fail";
					}
			
			
			
			
			
			}
			
		public String stockAcc_stockcatcreat(String name) throws IOException
			{
				expval="Add succeeded";
                WebElement stock_we=driver.findElement(By.xpath(pr.getProperty("stockitems")));
				
				Actions ac=new Actions(driver);
				ac.moveToElement(stock_we).build().perform();
				
				driver.findElement(By.xpath(pr.getProperty("stockcategories"))).click();;
				driver.findElement(By.xpath(pr.getProperty("catadd"))).click();
				driver.findElement(By.id(pr.getProperty("catnam"))).sendKeys(name);
				driver.findElement(By.id(pr.getProperty("cataddb"))).click();
				Sleeper.sleepTightInSeconds(5);
				driver.findElement(By.xpath(pr.getProperty("catok"))).click();
				Sleeper.sleepTightInSeconds(5);
				actval=driver.findElement(By.xpath(pr.getProperty("scsuccsc"))).getText();
				System.out.println(actval);
				Sleeper.sleepTightInSeconds(5);
				driver.findElement(By.xpath(pr.getProperty("catsucc"))).click();
				if (expval.equalsIgnoreCase(actval))
				{
					return "Pass";
				}
				else
				{
					return "Fail";
				}
			}
			
		public String stockAcc_unitofmes(String unomid) throws IOException
			{
				expval="Add succeeded";
               WebElement stock_we=driver.findElement(By.xpath(pr.getProperty("stockitems")));
				
				Actions ac=new Actions(driver);
				ac.moveToElement(stock_we).build().perform();
				
				driver.findElement(By.xpath(pr.getProperty("uom"))).click();
				driver.findElement(By.xpath(pr.getProperty("uomadd"))).click();
				driver.findElement(By.id(pr.getProperty("uomid"))).sendKeys(unomid);
				driver.findElement(By.id(pr.getProperty("uomdescription"))).sendKeys(uomdes);
				driver.findElement(By.id(pr.getProperty("uomad"))).click();
				Sleeper.sleepTightInSeconds(5);
				driver.findElement(By.xpath(pr.getProperty("uomok"))).click();
				Sleeper.sleepTightInSeconds(5);
				actval=driver.findElement(By.xpath(pr.getProperty("scuomsc"))).getText();
	            System.out.println(actval);
	            driver.findElement(By.xpath(pr.getProperty("uomsucc"))).click();
	            
				if (expval.equalsIgnoreCase(actval))
				{
					return "Pass";
				}
				else
				{
					return "Fail";
				}
			}
			
		public String stockAcc_unitofmes1(String unomid,String Uomdes1) throws IOException
			{
				expval="Add succeeded";
               WebElement stock_we=driver.findElement(By.xpath(pr.getProperty("stockitems")));
				
				Actions ac=new Actions(driver);
				ac.moveToElement(stock_we).build().perform();
				
				driver.findElement(By.xpath(pr.getProperty("uom"))).click();
				driver.findElement(By.xpath(pr.getProperty("uomadd"))).click();
				driver.findElement(By.id(pr.getProperty("uomid"))).sendKeys(unomid);
				driver.findElement(By.id(pr.getProperty("uomdescription"))).sendKeys(Uomdes1);
				driver.findElement(By.id(pr.getProperty("uomad"))).click();
				Sleeper.sleepTightInSeconds(5);
				driver.findElement(By.xpath(pr.getProperty("uomok"))).click();
				Sleeper.sleepTightInSeconds(5);
				actval=driver.findElement(By.xpath(pr.getProperty("scuomsc"))).getText();
	            System.out.println(actval);
	            driver.findElement(By.xpath(pr.getProperty("uomsucc"))).click();
	            
				if (expval.equalsIgnoreCase(actval))
				{
					return "Pass";
				}
				else
				{
					return "Fail";
				}
			}
			
		public String stockAcc_stockitemcreation(String stname,String purpr,String sepr,String stnotes)
			{
				expval="Add succeeded";
                WebElement stock_we=driver.findElement(By.xpath(pr.getProperty("stockitems")));
				
				Actions ac=new Actions(driver);
				ac.moveToElement(stock_we).build().perform();
				driver.findElement(By.xpath(pr.getProperty("stockitems"))).click();
				driver.findElement(By.xpath(pr.getProperty("stoadd"))).click();
				WebElement listbox = 	driver.findElement(By.id(pr.getProperty("stocat")));
				Select list = new Select (listbox);
				list.selectByVisibleText(name);
				WebElement listbox1 = 	driver.findElement(By.id(pr.getProperty("stosuno")));
				Select sel= new Select (listbox1);
				sel.selectByVisibleText(supname);
				
				//driver.findElement(By.id(pr.getProperty("stocat"))).sendKeys("data");
				//driver.findElement(By.id(pr.getProperty("stosuno"))).sendKeys(uomdes);
				
				driver.findElement(By.id(pr.getProperty("stoname"))).sendKeys(stname);
				WebElement listbox2 = 	driver.findElement(By.id(pr.getProperty("stouom")));
				Select sele= new Select (listbox2);
				sele.selectByVisibleText(uomdes);

//              driver.findElement(By.id(pr.getProperty("stocuadd"))).click();
//              driver.findElement(By.id(pr.getProperty("uomid"))).sendKeys(unomid);
//				driver.findElement(By.id(pr.getProperty("uomdescription"))).sendKeys(uomdes);
//              driver.findElement(By.xpath("stouomadd")).click();

				driver.findElement(By.id(pr.getProperty("stopur"))).sendKeys(purpr);
	            driver.findElement(By.id(pr.getProperty("stose"))).sendKeys(sepr);
	            driver.findElement(By.id(pr.getProperty("stonot"))).sendKeys(stnotes);
	            driver.findElement(By.id(pr.getProperty("stocradd"))).click();
	            Sleeper.sleepTightInSeconds(5);
	            List<WebElement> button=driver.findElements(By.tagName("button"));
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
	
//				driver.findElement(By.xpath(pr.getProperty("stook"))).click();
				
	            Sleeper.sleepTightInSeconds(5);
				actval=driver.findElement(By.xpath(pr.getProperty("stoadm"))).getText();
	            System.out.println(actval);
	            driver.findElement(By.xpath(pr.getProperty("stoadok"))).click();
			
			
			

				if (expval.equalsIgnoreCase(actval))
				{
					return "Pass";
				}
				else
				{
					return "Fail";
				}
			
			
			}
			
		public String stockAcc_purchasecre(String total,String name1,String name2,String name3)
			{
				 WebElement stock_we=driver.findElement(By.xpath(pr.getProperty("purchases")));
					
					Actions ac=new Actions(driver);
					ac.moveToElement(stock_we).build().perform();
					driver.findElement(By.xpath(pr.getProperty("purchases"))).click();
					
					driver.findElement(By.xpath(pr.getProperty("puraddd"))).click();
					WebElement listbox = 	driver.findElement(By.id(pr.getProperty("pursuid")));
					Select list = new Select (listbox);
					list.selectByVisibleText(supname);
//					
					WebElement listbox1 = 	driver.findElement(By.id(pr.getProperty("pursuno1")));
					Select list1 = new Select (listbox1);
					list1.selectByVisibleText(supname);
					WebElement listbox2 = 	driver.findElement(By.id(pr.getProperty("purstoi1")));
					Select list2 = new Select (listbox2);
					list2.selectByVisibleText(name1);
					
					driver.findElement(By.id(pr.getProperty("purqua1"))).clear();
					driver.findElement(By.id(pr.getProperty("purqua1"))).sendKeys("10");
					driver.findElement(By.id(pr.getProperty("purqua1"))).click();
					driver.findElement(By.id(pr.getProperty("purtot1"))).click();

					
					WebElement listbox3 = 	driver.findElement(By.id(pr.getProperty("pursuno2")));
					Select list3 = new Select (listbox3);
					list3.selectByVisibleText(supname);
					WebElement listbox4 = 	driver.findElement(By.id(pr.getProperty("purstoi2")));
					Select list4 = new Select (listbox4);
					list4.selectByVisibleText(name2);
					
					driver.findElement(By.id(pr.getProperty("purqua2"))).clear();
					driver.findElement(By.id(pr.getProperty("purqua2"))).sendKeys("10");
					driver.findElement(By.id(pr.getProperty("purqua2"))).click();
					driver.findElement(By.id(pr.getProperty("purtot2"))).click();
					
										
					WebElement listbox5 = 	driver.findElement(By.id(pr.getProperty("pursuno3")));
					Select list5 = new Select (listbox5);
					list5.selectByVisibleText(supname);
					WebElement listbox6 = 	driver.findElement(By.id(pr.getProperty("purstoi3")));
					Select list6 = new Select (listbox6);
					list6.selectByVisibleText(name3);
					
					driver.findElement(By.id(pr.getProperty("purqua3"))).clear();
					driver.findElement(By.id(pr.getProperty("purqua3"))).sendKeys("10");
					driver.findElement(By.id(pr.getProperty("purqua3"))).click();
					Sleeper.sleepTight(4000);
					driver.findElement(By.id(pr.getProperty("purtot3"))).click();

					
			// 		
					//driver.findElement(By.xpath(pr.getProperty("purcdel"))).click();
					//driver.findElement(By.xpath(pr.getProperty("purcde"))).click();

					driver.findElement(By.id(pr.getProperty("purpay"))).click();
					driver.findElement(By.id(pr.getProperty("purpay"))).sendKeys(total);
					
					driver.findElement(By.id(pr.getProperty("purad"))).click();
					Sleeper.sleepTightInSeconds(5);
					
					
					 List<WebElement> button=driver.findElements(By.tagName("button"));
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
//					driver.findElement(By.xpath(pr.getProperty("purok"))).click();
					Sleeper.sleepTightInSeconds(5);
					actval=driver.findElement(By.xpath(pr.getProperty("puraddm"))).getText();
		            System.out.println(actval);
		            driver.findElement(By.xpath(pr.getProperty("puraddok"))).click();
		            
					if (expval.equalsIgnoreCase(actval))
					{
						return "Pass";
					}
					else
					{
						return "Fail";
					}
				}
					
		public String stockAcc_custcreation(String cname ,String caddr ,String ccity,String ccntry,String cconp ,String cphnum ,String cemail ,String cmob,String cnot ) throws IOException
			{
				 expval="Add succeeded";
				 System.out.println(expval);
				 WebElement stock_we=driver.findElement(By.xpath(pr.getProperty("customers")));
					
					Actions ac=new Actions(driver);
					ac.moveToElement(stock_we).build().perform();
					driver.findElement(By.xpath(pr.getProperty("customers"))).click();
					
				 driver.findElement(By.xpath(pr.getProperty("cusadd"))).click();
				 
				 driver.findElement(By.id(pr.getProperty("cusnam"))).sendKeys(cname);
				 driver.findElement(By.id(pr.getProperty("cusads"))).sendKeys(caddr);
				 driver.findElement(By.id(pr.getProperty("cuscy"))).sendKeys(ccity);
				 driver.findElement(By.id(pr.getProperty("cuscry"))).sendKeys(ccntry);
				 driver.findElement(By.id(pr.getProperty("cuscon"))).sendKeys(cconp);
				 driver.findElement(By.id(pr.getProperty("cusph"))).sendKeys(cphnum);
				 driver.findElement(By.id(pr.getProperty("cusemail"))).sendKeys(cemail);
				 driver.findElement(By.id(pr.getProperty("cusmob"))).sendKeys(cmob);
			     driver.findElement(By.id(pr.getProperty("cusnot"))).sendKeys(cnot);
			    
			     driver.findElement(By.id(pr.getProperty("cusad"))).click();
			     Sleeper.sleepTightInSeconds(5);
			    // driver.findElement(By.xpath(pr.getProperty("cusok"))).click();
			     List<WebElement> button=driver.findElements(By.tagName("button"));
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
			     actval=driver.findElement(By.xpath(pr.getProperty("cusaddd"))).getText();
			     System.out.println(actval);
			     Sleeper.sleepTightInSeconds(5);
			     driver.findElement(By.xpath(pr.getProperty("cusokk"))).click();
			     if (expval.equalsIgnoreCase(actval))
					{
						return "Pass";
					}
					else
					{
						return "Fail";
					}
			
			
			
			
			
			}			
						   
        					
					
					
			
			
			
			
		

			
	
        public String  stockAcc_logout() throws IOException
        {
        	expval="login";
        	driver.findElement(By.id(pr.getProperty("logout"))).click();
        	//driver.findElement(By.xpath(pr.getProperty("ok"))).click();
        	List<WebElement> button=driver.findElements(By.tagName("button"));
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

        		actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
        	
			if (expval.equalsIgnoreCase(actval))
			{
				return "Pass";
				
			}
			else 
			{
				return "Fail";
			
			}
        }
        public  void stockAcc_close()
         {
    	    driver.close();
         }


}
