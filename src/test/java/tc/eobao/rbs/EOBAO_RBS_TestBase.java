package tc.eobao.rbs;

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

public class EOBAO_RBS_TestBase
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
		
		index = ObjFactory.getexcel().getIndex(testcaseid, "RBS_EOBAO_Status");
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
	}
	
	
	//Browser close and Test execution status logging
	@AfterClass
	public void browserClose()
	{
		ObjFactory.getbase().teardown(driver);
		
		String IntroStatus = ObjFactory.getexcel().getCelData("IntroPg", index, j+12);
		String BDStatus = ObjFactory.getexcel().getCelData("BusinessDetailsPg", index, j+27);
		
		if((IntroStatus.equalsIgnoreCase("Complete")) && (BDStatus.equalsIgnoreCase("Complete")))
		{
			ObjFactory.getexcel().setCelData("RBS_EOBAO_Status", index, j+1, "Pass");
			ObjFactory.getexcel().setCelData("RBS_EOBAO_Status", index, j+2, ObjFactory.getutil().getCurrentTimestamp());
		}
		else if((IntroStatus.equalsIgnoreCase("Incomplete")) || (BDStatus.equalsIgnoreCase("Incomplete")))
		{
			ObjFactory.getexcel().setCelData("RBS_EOBAO_Status", index, j+1, "Fail");
			ObjFactory.getexcel().setCelData("RBS_EOBAO_Status", index, j+2, ObjFactory.getutil().getCurrentTimestamp());
		}
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
