package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import utility.TestBase;

public class TC_Header extends TestBase
{
	@Test
	public void ApplicationHeader()
	{
		test = report.startTest("Header");
		test.log(LogStatus.PASS, "Browser Launch - Success");
		List<WebElement> allimage = BrowserFactory.driver.findElements(By.tagName("img"));
		test.log(LogStatus.INFO, "List of Images Obtained - Success");
		
		for(int i=0; i<allimage.size(); i++)
		{
			String url = allimage.get(i).getAttribute("src");
			System.out.println(url);
		}
		
		TestBase.EOPScreenshot("Header");
		
		test.log(LogStatus.PASS, "Url of Images Printed - Success");
	}

}
