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
		test = report.startTest("Header"+"-"+TestBase.getCurrentTimestamp());
		test.log(LogStatus.PASS, "Browser Launch - Success");
		
		//Listing the images and its urls
		List<WebElement> allimage = BrowserFactory.driver.findElements(By.tagName("img"));
		System.out.println("No of images: "+allimage.size());
				
		for(int i=0; i<allimage.size(); i++)
		{
			String url = allimage.get(i).getAttribute("src");
			System.out.println(url);
		}
		
		test.log(LogStatus.INFO, "SRC for header images printed");
		
		//-----------------------------------------------------------------------------------
		
		//Listing the number of frames, its id and name
		List<WebElement> iframes = BrowserFactory.driver.findElements(By.xpath("//iframe"));
		System.out.println("No of Frames: "+iframes.size());
				
		for(int i=0; i<iframes.size(); i++)
		{
			String frame_id = iframes.get(i).getAttribute("id");
			System.out.println(frame_id);
		}
		
		test.log(LogStatus.INFO, "Available frame ids printed");
		
		//-------------------------------------------------------------------------------------
		
		BrowserFactory.driver.switchTo().parentFrame();
		
		System.out.println(BrowserFactory.driver.getWindowHandle());
		
		TestBase.EOPScreenshot("Header");
		
		test.log(LogStatus.PASS, "TC_Header script Passed");
		
		}

}
