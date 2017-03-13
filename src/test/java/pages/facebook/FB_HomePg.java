package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import library.ObjFactory;

public class FB_HomePg 
{
	WebDriver driver;
	
	public FB_HomePg(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String PAGE_TITLE = "Facebook";
	
	public @FindBy (how=How.XPATH, using="//div[@class='tickerActivityStories']") WebElement NewsFeeds;
	public @FindBy (how=How.XPATH, using="//a[@class='_2s25']/span[text()='Merlin']") WebElement Profile;
	public @FindBy (how=How.ID, using="userNavigationLabel") WebElement Icon_Navigation;
	//public @FindBy (how=How.ID, using="//span[text()='Log Out']") WebElement Menu_Logout;
	

	public void Validate_Header_PageTitle()
	{
		ObjFactory.getutil().WaitTillPageLoads(driver, NewsFeeds);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
	
	public void OnLoad()
	{
		Profile.isDisplayed();
	}
	
	public void PageFunctions_Logout()
	{
		ObjFactory.getutil().ClickElement(Icon_Navigation);
		ObjFactory.getutil().threadsleep(1000);
	}
	
	public void RunStatus()
	{
		
		
	}

}
