package tc.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;

public class TestBase
{
	public static ExtentTest test;
	public ExtentReports report;
	public WebDriver driver;
	public ITestResult result;
	public int index;
	public int j=0;
	
	
	//Browser Initialize
	@Parameters({"testcaseid", "browser"})
	@BeforeClass
	public void browserLaunch(String testcaseid, String browsername)
	{
		driver = ObjFactory.getbase().InitialSetup(browsername);
		driver.get(ObjFactory.getconfig().getFacebookUrl());
		
		index = ObjFactory.getexcel().getIndex(testcaseid, "FB_Login");
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
	}
	
	
	//Browser close and Test execution status logging
	@AfterClass
	public void browserClose()
	{
		ObjFactory.getbase().teardown(driver);
		report.endTest(test);
		report.flush();
	}
	
	//Fail Screenshot
	@AfterMethod
	public void FailedScreenshot(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String Screenshotpath = ObjFactory.getscreenshot().CaptureScreenshot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(Screenshotpath));
		}
	}
}
