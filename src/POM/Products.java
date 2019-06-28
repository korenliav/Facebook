package POM;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Base;

public class Products extends Base
{
	public static WebElement element;

	public static WebElement link_Login(WebDriver driver)
	{
		element = driver.findElement(By.className("_3ptd"));
		return element;		
	}
	
	public static WebElement link_Share(WebDriver driver)
	{
		element = driver.findElement(By.className("_4l1f _52jv"));
		return element;		
	}
	
	public static WebElement link_Analytics(WebDriver driver)
	{
		element = driver.findElement(By.className("_2yes _3m9"));
		return element;		
	}
	
	public static WebElement link_Monetization(WebDriver driver)
	{
		element = driver.findElement(By.className("_2yes _3m9"));
		return element;		
	}
	
	public static WebElement link_Messenger(WebDriver driver) throws IOException
	{
		
		try
		{
			element = driver.findElement(By.className("_3ptd"));
			test.log(LogStatus.PASS, "Element Messenger Platform exist");
			System.out.println("Element Messenger Platform exist");
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Element Messenger Platform not exist!" + e);
			System.out.println("Element Messenger Platform not exist");
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(scrFile, new File("C:\\SeleniumDrivers\\Reports\\results\\fail.png"));
	    	test.addScreenCapture("C:\\SeleniumDrivers\\Reports\\results");	
	    	fail("Elemenet not exist");
		}
		return element;
	}
	
	
	
}
