package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Base;

public class Footer extends Base
{
	public static WebElement element;

	public static WebElement link_Groups(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Groups"));
		return element;		
	}
	
	public static WebElement link_Pages(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Pages"));
		return element;		
	}
	
	public static WebElement link_Developers(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Developers"));
		return element;		
	}
	
	
}
