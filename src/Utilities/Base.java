package Utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base 
{
	public static  WebElement element;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
//	public static CommonOps comOps = new CommonOps();
	
	public static void instanceReport()
	{
		extent = new ExtentReports("C:\\SeleniumDrivers\\Reports\\results\\Report.html",true);
	}
	
	public static void initReportTest(String testName, String testDescription)
	{
		test = extent.startTest(testName, testDescription);
	}
	
	public static void finalizeReportTest()
	{
		extent.endTest(test);
	}
	
	public static void finalizeReport()
	{
		extent.flush();
		extent.close();
	}
		
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
	File fXmlFile = new File("C:\\Users\\User\\Documents\\Automation\\external files.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile); 
	doc.getDocumentElement().normalize();
	return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
}
