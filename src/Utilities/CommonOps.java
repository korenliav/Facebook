package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.fail;

import com.relevantcodes.extentreports.LogStatus;

public class CommonOps extends Base
{
//	public static void verifyElementExist(WebElement elem) throws IOException
//	{
//		
//	}
	
    public void selectDropDown(WebElement elem, String valueBirthdate)
    {
    	try
    	{
    	Select myValue = new Select(elem);
    	myValue.selectByValue(valueBirthdate);
		test.log(LogStatus.PASS, "Date selected");

    	}
    	catch (Exception e)
    	{
			test.log(LogStatus.FAIL, "Date not selected!" + e);
			fail("Element not exist");
    	}
    }
	

}
