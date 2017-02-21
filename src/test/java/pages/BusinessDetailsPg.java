package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BusinessDetailsPg
{
	WebDriver driver;
	
	public BusinessDetailsPg(WebDriver driver)
	{
		this.driver=driver;
	}
	public String PAGE_TITLE = "Royal Bank of Scotland - RBS Business Sole Trader Current Account application form - Business Details";
	
	public @FindBy (how=How.ID, using="Busname") WebElement Txt_BusiName;
	public @FindBy (how=How.ID, using="busiTelephoneNumber") WebElement Txt_BusiTelephoneNumber;
	public @FindBy (how=How.ID, using="busiEmail") WebElement Txt_BusiEmail;
	public @FindBy (how=How.ID, using="mobileNumber1") WebElement Txt_MobileNumber;
	public @FindBy (how=How.ID, using="building1") WebElement Txt_BuildingNumber;
	public @FindBy (how=How.ID, using="street1") WebElement Txt_Street;
	public @FindBy (how=How.ID, using="town1") WebElement Txt_Town;
	public @FindBy (how=How.ID, using="county1") WebElement Txt_County;
	public @FindBy (how=How.ID, using="post1") WebElement Txt_PostCode;
	public @FindBy (how=How.ID, using="tradingname") WebElement Txt_TradingName;
	public @FindBy (how=How.ID, using="diffTradingAddress2") WebElement Radio_TradingName;
	public @FindBy (how=How.ID, using="compareAddress") WebElement Dropdown_stat_cor_add;
	
	public @FindBy (how=How.ID, using="S_CANCEL") WebElement Btn_Cancel;
	public @FindBy (how=How.ID, using="S_NEXT") WebElement Btn_Next;
	
	public void inputBusinessDetails(String businessname)
	{
		Txt_BusiName.sendKeys(businessname);
	}
	
}