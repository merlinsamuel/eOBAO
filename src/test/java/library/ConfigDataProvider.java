package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider
{
	Properties prop;
	
	public ConfigDataProvider()
	{
		File src = new File("C:\\Merlin_Neon\\com.eobao\\Configuration\\config.properties");
		
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			System.out.println("Exception message is: "+e.getMessage());
		}
	}
	
	public String getChromeDriverPath()
	{
		return prop.getProperty("ChromeDriverPath");
	}
	
	public String getIEDriverPath()
	{
		return prop.getProperty("IEDriverPath");
	}
	
	public String getFireFoxDriverPath()
	{
		return prop.getProperty("FireFoxDriverPath");
	}
	
	public String getTestDataPath()
	{
		return prop.getProperty("TestDataPath");
	}
	
	public String getScreenshotPath()
	{
		return prop.getProperty("ScreenshotPath");
	}
	
	public String getReportsPath()
	{
		return prop.getProperty("ReportPath");
	}
	
	public String getAppUrl()
	{
		return prop.getProperty("Appurl");
	}
	
	public String getRedbusUrl()
	{
		return prop.getProperty("Redbus");
	}
	
	public String getFacebookUrl()
	{
		return prop.getProperty("Facebook");
	}
	
	public String getFileUploader(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			return prop.getProperty("ChromeFileUploader");
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			return prop.getProperty("FirefoxFileUploader");
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			return prop.getProperty("IEFileUploader");
		}
		
		return "File Uploader not defined for the browser";
	}
	
	public String getFileDownloader()
	{
		return prop.getProperty("FileDownloader");
	}
}
