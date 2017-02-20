package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.Header;

public class TestBase
{
	public static ExtentTest test;
	public static ExtentReports report;
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void Setup(String browser)
	{
		driver = BrowserFactory.getBrowser(browser);
		report = new ExtentReports(DataProviderFactory.getconfig().getReportsPath(), false);
	}
	
	@AfterTest
	public void Teardown()
	{
		BrowserFactory.closeBrowser();
		report.endTest(test);
		report.flush();
	}
	
	//Method to Verify Header
	public static void VerifyHeaderObjects()
	{
		Header header = PageFactory.initElements(BrowserFactory.driver, Header.class);
		header.H_currentSection.isDisplayed();
		header.H_PgHeader.isDisplayed();
		header.H_ProgIndicator.isDisplayed();
		header.H_RBSlogo.isDisplayed();
	}
	
	//Failed Screenshot
	@AfterMethod
	public void FailedScreenshot(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String Screenshotpath = DataProviderFactory.getscreenshot().CaptureScreenshot(BrowserFactory.driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(Screenshotpath));
		}

	}
	
	//End of Page Screenshot
	public static void EOPScreenshot(String Pgtitlename)
	{
		test.log(LogStatus.PASS, test.addScreenCapture(DataProviderFactory.getscreenshot().CaptureScreenshot(BrowserFactory.driver, BrowserFactory.driver.getTitle())));
	}
	
	//Current Date and Timestamp
	public static String getCurrentTimestamp()
	{
		String timestamp = new SimpleDateFormat("yyy_MM_dd-HH.mm.ss").format(new Date());
		return timestamp;
	}
	
	//Explicit Wait until a WebElement is displayed in a page
	public WebElement EmplicitWait(String elementid)
	{
		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementid)));
		return element;
	}
	
	//WebElement Actions - Click
	public static void ClickElement(WebElement element)
	{
		element.isEnabled();
		element.click();
	}
	
	//WebElement Actions - Input Text
	public static void InputText(WebElement element, String input)
	{
		element.sendKeys(input);
		Assert.assertEquals(element.getAttribute("value"), input);
	}
	
	//WebElement Actions - Dropdown selection
	public static void DropDownSelection(WebElement element, String dropdowntext)
	{
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(dropdowntext);
	}

}
