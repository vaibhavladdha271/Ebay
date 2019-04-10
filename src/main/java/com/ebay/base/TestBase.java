package com.ebay.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;;

public class TestBase {
  public static WebDriver driver;
  public static Properties property;
  
  public TestBase()
  {
	  {
			try {
			FileInputStream input=new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace\\Makemytrip\\src\\main\\java\\com\\mmt\\qa\\config\\config.properties");
			property=new Properties();
			property.load(input);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
  }
  
  public void initialize()
  {
	  String browser=property.getProperty("browser");
	  if(browser.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Geckodriver\\chromedriver.exe");
	      driver=new ChromeDriver();
	  }
	  else if(browser.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vaibhav\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	      driver=new FirefoxDriver();
	  }
	  else
	  {
		  System.setProperty("webdriver.edge.driver", "C:\\Geckodriver\\MicrosoftWebDriver.exe");
	      driver=new InternetExplorerDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
}
