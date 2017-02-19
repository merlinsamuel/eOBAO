package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class Screenshot 
{
	public String CaptureScreenshot(String testcasename)
	{
		TakesScreenshot ts = (TakesScreenshot) BrowserFactory.driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = DataProviderFactory.getconfig().getScreenshotPath()+testcasename+"-"+TestBase.getCurrentTimestamp()+".JPEG";
		
		try 
		{
			FileUtils.copyFile(src, new File(destination));
		} 
		catch (IOException e) 
		{
			System.out.println("Exception has occured while taking screenshot."+e.getMessage());
		}
		
		return destination;
	}
}
