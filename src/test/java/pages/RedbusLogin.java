package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import library.ObjFactory;

public class RedbusLogin
{
	WebDriver driver;
	
	public RedbusLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	String sheetname = "RedBus";
	
	public String PAGE_TITLE = "Online Bus tickets Booking, Book Volvo AC Bus Tickets, Confirmed Bus Reservation";
	
	public @FindBy (how=How.XPATH, using="//div[@id='search_div']") WebElement SearchPannel;
	public @FindBy (how=How.ID, using="src") WebElement Txt_Source;
	public @FindBy (how=How.ID, using="dest") WebElement Txt_Dest;
	
	
	public void Validate_Header_LoginPageTitle()
	{
		ObjFactory.getutil().WaitTillPageLoads(driver, SearchPannel);
		ObjFactory.getutil().Verify_RB_HeaderObjects(driver);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
	
	public void RedBusLoginOnLoad()
	{
		
	}
	
	public void RedBusLoginPageFunctions(String testcaseid)
	{
		int j=0;
		int index = ObjFactory.getutil().getIndex(testcaseid, sheetname);
		
		if (index == 0)
		{
			System.exit(0);
		}
		
		ObjFactory.getutil().AutoSuggestInputText(Txt_Source, ObjFactory.getexcel().getCelData(sheetname, index, j+1));
		ObjFactory.getutil().AutoSuggestInputText(Txt_Dest, ObjFactory.getexcel().getCelData(sheetname, index, j+2));
	}
}
