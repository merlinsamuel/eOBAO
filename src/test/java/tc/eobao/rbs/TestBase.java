package tc.eobao.rbs;

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
		index = ObjFactory.getexcel().getIndex(testcaseid, "IntroPg");
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
	}
	
	
	//Browser initialization & Application Launch
	@Parameters({"browser", "testcaseid"})
	@BeforeClass
	public void ApplicationLaunch(String browser, String testcaseid)
	{
		driver = ObjFactory.getbase().InitialSetup(browser);
		
		driver.get(ObjFactory.getconfig().getAppUrl());
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
		/*String IntroStatus = ObjFactory.getexcel().getCelData("IntroPg", index, j+12);
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
		}*/
		report.endTest(test);
		report.flush();
		
		ObjFactory.getbase().teardown(driver);
				
	}
	
	@AfterTest
	public void Aftertest()
	{
	
	}

}
