package dataprovider;

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
	
	public String getTestDataPath()
	{
		return prop.getProperty("TestDataPath");
	}
	
	public String getAppUrl()
	{
		return prop.getProperty("Appurl");
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
	
	public String getScreenshotPath()
	{
		return prop.getProperty("ScreenshotPath");
	}
	
	public String getReportsPath()
	{
		return prop.getProperty("ReportPath");
	}
}
