package tc.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import library.ObjFactory;

public class TestBase
{
	public static WebDriver driver;
	public static int index;
	public static int j=0;
	
	
	//Initializing Test Data index
	@Parameters({"testdataid"})
	@BeforeTest
	public void setup(String testdataid)
	{
		index = ObjFactory.getexcel().getIndex(testdataid, "FB_Login");
	}
	
	
	//Browser initialization & Application Launch
	@Parameters({"browser"})
	@BeforeClass
	public void ApplicationLaunch(String browser)
	{
		driver = ObjFactory.getbase().InitialSetup(browser);
		
		driver.get(ObjFactory.getconfig().getFacebookUrl());
	}
	
	
	@BeforeMethod
	public void Beforemethod()
	{
		
	}
	
	
	@AfterMethod
	public void Aftermethod()
	{
		
	}
	
	
	//Browser close
	@AfterClass
	public void browserClose()
	{
		ObjFactory.getbase().teardown(driver);
	}
	
	
	@AfterTest
	public void Aftertest()
	{
	
	}

}
