package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class TestBase
{
	public static ExtentTest test;
	public static ExtentReports report;
	
	@BeforeTest
	public void Setup()
	{
		WebDriver driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getconfig().getAppUrl());
		report = new ExtentReports(DataProviderFactory.getconfig().getReportsPath());
	}
	
	@AfterTest
	public void Teardown()
	{
		BrowserFactory.closeBrowser();
		report.endTest(test);
		report.flush();
	}
	
	@AfterMethod
	public void FailedScreenshot(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String Screenshotpath = DataProviderFactory.getscreenshot().CaptureScreenshot(result.getName());
			System.out.println(Screenshotpath);
			test.log(LogStatus.FAIL, test.addScreenCapture(Screenshotpath));
		}

	}
	
	public static void EOPScreenshot(String Pgtitlename)
	{
		test.log(LogStatus.PASS, test.addScreenCapture(DataProviderFactory.getscreenshot().CaptureScreenshot(BrowserFactory.driver.getTitle())));
	}
	
	public static void ClickElement(WebElement element)
	{
		element.isEnabled();
		element.click();
	}
	
	public static void InputText(WebElement element, String input)
	{
		element.sendKeys(input);
		Assert.assertEquals(element.getAttribute("value"), input);
	}

}
