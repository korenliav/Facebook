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
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Base;

public class SignUp extends Base
{
	public static WebElement element;
	
	public static WebElement txt_Box_FirstName(WebDriver driver)
	{
		element = driver.findElement(By.name("firstname"));
		
		return element;		
	}
	
	public static WebElement txt_Box_LastName(WebDriver driver)
	{
		element = driver.findElement(By.name("lastname"));
		return element;		
	}

	public static WebElement txt_Box_Email(WebDriver driver)
	{
		element = driver.findElement(By.name("reg_email__"));
		return element;		
	}

	public static WebElement txtBox_RetypeEmail(WebDriver driver)
	{
		element = driver.findElement(By.name("reg_email_confirmation__"));
		return element;
	}
	
	public static WebElement txt_Box_Password(WebDriver driver)
	{
		element = driver.findElement(By.name("reg_passwd__"));
		return element;		
	}
	
	public static WebElement combo_Box_Birthday_Month(WebDriver driver)
	{
		element = driver.findElement(By.id("month"));

		Select selectionMonth = new Select(driver.findElement(By.id("month")));
		selectionMonth.selectByVisibleText("Feb");
		return element;		
	}
	
	public static WebElement combo_Box_Birthday_Day(WebDriver driver)
	{
		element = driver.findElement(By.id("day"));

		Select selectionMonth = new Select(driver.findElement(By.id("day")));
		selectionMonth.selectByVisibleText("27");
		return element;		
	}
	
	public static WebElement combo_Box_Birthday_Year(WebDriver driver)
	{
		element = driver.findElement(By.id("year"));

		Select selectionMonth = new Select(driver.findElement(By.id("year")));
		selectionMonth.selectByVisibleText("1995");
		return element;		
	}
	
	public static WebElement radio_gender(WebDriver driver)
	{
		element = driver.findElement(By.className("_58mt"));
		return element;		
	}
	
	public static WebElement btn_Create_Account(WebDriver driver)
	{
		element = driver.findElement(By.id("u_0_y"));
		return element;		
	}
	
	public static WebElement txt_WrongPassword(WebDriver driver) throws IOException
	{
		
		try
		{
			element = driver.findElement(By.id("reg_error_inner"));
			test.log(LogStatus.PASS, "Element wrong password  exist");
			System.out.println("Element wrong password exist");
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Element wrong password  not exist!" + e);
			System.out.println("Element wrong password  not exist");
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(scrFile, new File("C:\\SeleniumDrivers\\Reports\\results\\fail.png"));
	    	test.addScreenCapture("C:\\SeleniumDrivers\\Reports\\results");	
	    	fail("Elemenet wrong password not exist");
		}
		return element;
		
	}
	 
	
	
	
	
	
}
