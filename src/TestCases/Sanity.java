package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;

import POM.Footer;
import POM.Products;
import POM.SignUp;
import Utilities.Base;

public class Sanity extends Base
{
	@BeforeClass
	public static void startSession()  
	{
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		instanceReport();
	
	} 
	
	@Test
	public void test1() throws InterruptedException, IOException, SAXException, ParserConfigurationException
	{
		initReportTest("test1", "Verify wrong pass element");
//		SignUp.txt_Box_FirstName(driver).sendKeys("Automation");
		SignUp.txt_Box_FirstName(driver).sendKeys(getData("FirstName"));
		SignUp.txt_Box_LastName(driver).sendKeys(getData("LastName"));
		
//		SignUp.txt_Box_LastName(driver).sendKeys("My Last Name");
		SignUp.txt_Box_Email(driver).sendKeys("Tester@test.com");
		Thread.sleep(2000);
		SignUp.txtBox_RetypeEmail(driver).sendKeys("Tester@test.com");
		SignUp.txt_Box_Password(driver).sendKeys("12345");
		SignUp.combo_Box_Birthday_Month(driver);
		SignUp.combo_Box_Birthday_Day(driver);
		SignUp.combo_Box_Birthday_Year(driver);
		SignUp.radio_gender(driver).click();
		SignUp.btn_Create_Account(driver).click();
		Thread.sleep(9000);
		SignUp.txt_WrongPassword(driver);
		//CommonOps.verifyElementExist(SignUp.txt_WrongPassword(driver));
	}
	
	@Test
	public void test2() throws InterruptedException, IOException
	{

		driver.get("https://en-gb.facebook.com/");
		initReportTest("test2", "Verify Messenger element");
		((JavascriptExecutor)driver).executeScript("scroll(0,1000);");
		Thread.sleep(2000);
		Footer.link_Developers(driver).click();
		((JavascriptExecutor)driver).executeScript("scroll(0,200);");
		Products.link_Messenger(driver);
	}
	
	
	@After
	public void afterTest()
	{
		finalizeReportTest();
	}
	
	@AfterClass
	public static void closeSession()
	{
		finalizeReport();
		driver.quit();
	}
	
}
