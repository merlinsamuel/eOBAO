package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class FB_LoginErrorPg 
{
	WebDriver driver;
	
	public FB_LoginErrorPg(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String PAGE_TITLE = "Log into Facebook | Facebook";
	
	public @FindBy (how=How.ID, using="//div[@class='_4-u2 _1w1t _4-u8 _52jv']") WebElement Error;
	
	public void Validate_Header_PageTitle()
	{
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
	
	public void OnLoad()
	{
	
	}
	
	public void PageFunctions()
	{
		
	}
	
	public void RunStatus()
	{
		
	}

}
