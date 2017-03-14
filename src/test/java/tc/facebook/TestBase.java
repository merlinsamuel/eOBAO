package tc.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import library.ObjFactory;

public class TestBase
{
	public static ExtentTest test;
	public ExtentReports report;
	public static WebDriver driver;
	public ITestResult result;
	public static int index;
	public static int j=0;

	//Test case id index & ExtentReport path setup
	@Parameters({"testcaseid"})
	@BeforeTest
	public void browserLaunch(String testcaseid)
	{
		index = ObjFactory.getexcel().getIndex(testcaseid, "FB_Login");
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
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
		
	//Execution status Update in Excel and in ExtentReport
	@AfterClass
	public void ExecutionStatusUpdate_browserClose()
	{
		report.endTest(test);
		report.flush();
		
		ObjFactory.getbase().teardown(driver);
	}
	
	@AfterTest
	public void Afterest()
	{
		
	}
}
