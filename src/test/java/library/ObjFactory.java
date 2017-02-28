package library;

public class ObjFactory
{
	public static ConfigDataProvider getconfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	
	public static ExcelTestData getexcel()
	{
		ExcelTestData excel = new ExcelTestData();
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
	
	public static Utility getutil()
	{
		Utility util = new Utility();
		return util;
	}
}
