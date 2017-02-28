package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot 
{

	public String CaptureScreenshot(WebDriver driver, String testcasename)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = ObjFactory.getconfig().getScreenshotPath()+testcasename+"-"+ObjFactory.getutil().getCurrentTimestamp()+".JPEG";
		
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
