package library;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	
	//Browser Initialize
	@Parameters("browser")
	@BeforeClass
	public void Setup(String browsername)
	{
		if (browsername.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", DataProviderFactory.getconfig().getFireFoxDriverPath());
			driver = new FirefoxDriver();
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
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);
	}
	
	//Browser close and Test execution logging
	@AfterClass
	public void Teardown()
	{
		driver.quit();
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
