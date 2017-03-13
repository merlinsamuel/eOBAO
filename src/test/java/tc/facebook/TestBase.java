package tc.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
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

	//Initialize browser and test case id index
	@Parameters({"testcaseid", "browser"})
	@BeforeTest
	public void browserLaunch(String testcaseid, String browser)
	{
		driver = ObjFactory.getbase().InitialSetup(browser);
		
		index = ObjFactory.getexcel().getIndex(testcaseid, "FB_Login");
	}
	
	
	//Application Launch & ExtentReport path setup
	@BeforeClass
	public void ApplicationLaunch()
	{
		driver.get(ObjFactory.getconfig().getFacebookUrl());
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
	}
	
	
	@BeforeMethod
	public void BeforeMethod()
	{
		
	}
	
	//Fail Screenshot
	//@AfterMethod
	public void AfterMethod()
	{
		
	}
		
	//Execution status Update in Excel and in ExtentReport
	@AfterClass
	public void ExecutionStatusUpdate()
	{
		report.endTest(test);
		report.flush();
	}
	
	@AfterTest
	public void browserClose()
	{
		ObjFactory.getbase().teardown(driver);
	}
}
