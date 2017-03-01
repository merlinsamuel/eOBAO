package library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
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
	//Method to Verify OBAO Header
	public void Verify_OBAO_HeaderObjects(WebDriver driver)
	{
		Header header = PageFactory.initElements(driver, Header.class);
		header.OBAO_Header();
	}
	
	//Method to Verify RedBus Header
	public void Verify_RB_HeaderObjects(WebDriver driver)
	{
		Header header = PageFactory.initElements(driver, Header.class);
		header.RB_Header();
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
		element.isEnabled();
		element.clear();
		element.sendKeys(input);
		Assert.assertEquals(element.getAttribute("value"), input);
	}
	
	//WebElement Actions - Drop down selection
	public void DropDownSelection(WebElement element, String dropdown_option)
	{
		element.isEnabled();
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(dropdown_option);
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), dropdown_option);
	}
		
	//WebElement Actions - Radio Option Selection
	public void RadioOptionSelection(List <WebElement> element, String radio_option)
	{
		for(WebElement value : element)
		{
			if(value.getAttribute("value").equalsIgnoreCase(radio_option))
			{
				value.isEnabled();
				value.click();
				Assert.assertTrue(value.isSelected());
			}
		}
	}
	
	//WebElement Actions - AutoSuggest Text boxes
	public void AutoSuggestInputText(WebElement element, String input)
	{
		element.isEnabled();
		element.click();
		element.sendKeys(input.substring(0, 4));
		threadsleep(2000);
		element.sendKeys(Keys.TAB);
		Assert.assertEquals(element.getAttribute("value"), input);
	}
	
	public void threadsleep(int sleeptime)
	{
		try
		{
			Thread.sleep(sleeptime);
		} 
		catch (InterruptedException e)
		{
			System.out.println("Exception Occured while Thread sleep."+e);
		}
	}
	
	public int getIndex(String testcaseid, String sheetname)
	{
		int index=0;
		
		int row = ObjFactory.getexcel().getRowCount(sheetname);
		Object [][] data = new Object[row][1];
		
		for(int i=0; i<row; i++)
		{
			data[i][0]=ObjFactory.getexcel().getCelData(sheetname, i, 0);
			if(data[i][0].equals(testcaseid))
			{
				index = i;
				break;
			}
		}
		return index;
	}
}
