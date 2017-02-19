package factory;

import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;
import utility.Screenshot;
import utility.TestBase;

public class DataProviderFactory
{
	
	public static ConfigDataProvider getconfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getexcel()
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}
	
	public static TestBase getbase()
	{
		TestBase base = new TestBase();
		return base;
	}
	
	public static Screenshot getscreenshot()
	{
		Screenshot screenshot = new Screenshot();
		return screenshot;
	}
}
