package library;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase
{
	public static ExtentTest test;
	public ExtentReports report;
	public WebDriver driver;
	public ITestResult result;
	public ITestContext content;
	public int index;
	public int j=0;
	
	
	//Browser Initialize
	@Parameters({"testcaseid", "browser"})
	@BeforeClass
	public void Setup(String testcaseid, String browsername)
	{
		if (browsername.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", ObjFactory.getconfig().getFireFoxDriverPath());
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("marionette", true);
			driver = new FirefoxDriver(cap);
		}
		else if (browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ObjFactory.getconfig().getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("profile.default_content_setting_values.notifications", 2);
						
			options.addArguments("--disable-extensions");
			options.setExperimentalOption("prefs", map);
			
			driver = new ChromeDriver(options);
		}
		else if (browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", ObjFactory.getconfig().getIEDriverPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		index = ObjFactory.getexcel().getIndex(testcaseid, "RBS_EOBAO_Status");
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
	}
	
	
	//Browser close and Test execution logging
	@AfterClass
	public void Teardown()
	{
		driver.quit();
		
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
