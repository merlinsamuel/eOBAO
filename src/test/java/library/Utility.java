package library;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import pages.Header;

public class Utility 
{
	//Method to Verify Header
	public void VerifyHeaderObjects(WebDriver driver)
	{
		Header header = PageFactory.initElements(driver, Header.class);
		header.H_currentSection.isDisplayed();
		header.H_PgHeader.isDisplayed();
		header.H_ProgIndicator.isDisplayed();
		header.H_RBSlogo.isDisplayed();
	}
	
	//End of Page Screenshot
	public void EOPScreenshot(WebDriver driver, String Pgtitlename)
	{
		TestBase.test.log(LogStatus.PASS, TestBase.test.addScreenCapture(ObjFactory.getscreenshot().CaptureScreenshot(driver, Pgtitlename)));
	}
	
	//Current Date and Timestamp
	public String getCurrentTimestamp()
	{
		String timestamp = new SimpleDateFormat("yyy_MM_dd-HH.mm.ss").format(new Date());
		return timestamp;
	}
	
	//Explicit Wait until a WebElement is displayed in a page
	public void WaitTillPageLoads(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//WebElement Actions - Click
	public void ClickElement(WebElement element)
	{
		element.isEnabled();
		element.click();
	}
	
	//WebElement Actions - Input Text
	public void InputText(WebElement element, String input)
	{
		element.sendKeys(input);
		Assert.assertEquals(element.getAttribute("value"), input);
	}
	
	//WebElement Actions - Dropdown selection
	public void DropDownSelection(WebElement element, String dropdowntext)
	{
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(dropdowntext);
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), dropdowntext);
	}
	
	public void threadsleep()
	{
		try
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e)
		{
			System.out.println("Exception Occured while Thread sleep."+e);
		}
	}
}
