package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import library.ObjFactory;

public class BusinessDetailsPg
{
	WebDriver driver;
	
	public BusinessDetailsPg(WebDriver driver)
	{
		this.driver=driver;
	}
	
	String sheetname = "BusinessDetails";
	
	public String PAGE_TITLE = "Royal Bank of Scotland - RBS Business Sole Trader Current Account application form - Business Details";
	
	public @FindBy (how=How.ID, using="Busname") WebElement Txt_BusiName;
	public @FindBy (how=How.ID, using="busiTelephoneNumber") WebElement Txt_BusiTelephoneNumber;
	public @FindBy (how=How.ID, using="busiEmail") WebElement Txt_BusiEmail;
	public @FindBy (how=How.ID, using="mobileNumber1") WebElement Txt_MobileNumber;
	
	public @FindBy (how=How.ID, using="building1") WebElement Txt_1BuildingNumber;
	public @FindBy (how=How.ID, using="street1") WebElement Txt_1Street;
	public @FindBy (how=How.ID, using="town1") WebElement Txt_1Town;
	public @FindBy (how=How.ID, using="county1") WebElement Txt_1County;
	public @FindBy (how=How.ID, using="country1") WebElement Txt_1Country;
	public @FindBy (how=How.ID, using="post1") WebElement Txt_1PostCode;
	
	public @FindBy (how=How.ID, using="tradingname") WebElement Txt_TradingName;
	public @FindBy (how=How.ID, using="contactCorrespondence") WebElement Txt_ContactName;
	
	public @FindBy (how=How.ID, using="diffTradingAddress2") WebElement Radio_TradingName;
	
	public @FindBy (how=How.ID, using="buildingNo2") WebElement Txt_2BuildingNumber;
	public @FindBy (how=How.ID, using="street2") WebElement Txt_2Street;
	public @FindBy (how=How.ID, using="town2") WebElement Txt_2Town;
	public @FindBy (how=How.ID, using="county2") WebElement Txt_2County;
	public @FindBy (how=How.ID, using="country2") WebElement Txt_2Country;
	public @FindBy (how=How.ID, using="postCode2") WebElement Txt_2PostCode;
	
	public @FindBy (how=How.ID, using="compareAddress") WebElement Dropdown_stat_cor_add;
	public @FindBy (how=How.ID, using="building3") WebElement Txt_3BuildingNumber;
	public @FindBy (how=How.ID, using="street3") WebElement Txt_3Street;
	public @FindBy (how=How.ID, using="town3") WebElement Txt_3Town;
	public @FindBy (how=How.ID, using="county3") WebElement Txt_3County;
	public @FindBy (how=How.ID, using="country3") WebElement Txt_3Country;
	public @FindBy (how=How.ID, using="postcode3") WebElement Txt_3PostCode;
	
	public @FindBy (how=How.ID, using="S_CANCEL") WebElement Btn_Cancel;
	public @FindBy (how=How.ID, using="S_NEXT") WebElement Btn_Next;
	
	public void Validate_Header_BDPgTitle()
	{
		ObjFactory.getutil().WaitTillPageLoads(driver, Txt_BusiName);
		ObjFactory.getutil().Verify_OBAO_HeaderObjects(driver);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
	
	public void BusinessDetailsPageFunctions(String testcaseid)
	{
		int j=0;
		int index = ObjFactory.getutil().getIndex(testcaseid, sheetname);
		
		if (index == 0)
		{
			System.exit(0);
		}
		
		ObjFactory.getutil().InputText(Txt_BusiName, ObjFactory.getexcel().getCelData(sheetname, index, j+1));
		ObjFactory.getutil().InputText(Txt_BusiTelephoneNumber, ObjFactory.getexcel().getCelData(sheetname, index, j+2));
		ObjFactory.getutil().InputText(Txt_BusiEmail, ObjFactory.getexcel().getCelData(sheetname, index, j+3));
		ObjFactory.getutil().InputText(Txt_MobileNumber, ObjFactory.getexcel().getCelData(sheetname, index, j+4));
		
		ObjFactory.getutil().InputText(Txt_1BuildingNumber, ObjFactory.getexcel().getCelData(sheetname, index, j+5));
		ObjFactory.getutil().InputText(Txt_1Street, ObjFactory.getexcel().getCelData(sheetname, index, j+6));
		ObjFactory.getutil().InputText(Txt_1Town, ObjFactory.getexcel().getCelData(sheetname, index, j+7));
		ObjFactory.getutil().InputText(Txt_1County, ObjFactory.getexcel().getCelData(sheetname, index, j+8));
		ObjFactory.getutil().InputText(Txt_1Country, ObjFactory.getexcel().getCelData(sheetname, index, j+9));
		ObjFactory.getutil().InputText(Txt_1PostCode, ObjFactory.getexcel().getCelData(sheetname, index, j+10));
		
		ObjFactory.getutil().InputText(Txt_TradingName, ObjFactory.getexcel().getCelData(sheetname, index, j+11));
		ObjFactory.getutil().InputText(Txt_ContactName, ObjFactory.getexcel().getCelData(sheetname, index, j+12));
		
		ObjFactory.getutil().ClickElement(Radio_TradingName);
		
		ObjFactory.getutil().InputText(Txt_2BuildingNumber, ObjFactory.getexcel().getCelData(sheetname, index, j+14));
		ObjFactory.getutil().InputText(Txt_2Street, ObjFactory.getexcel().getCelData(sheetname, index, j+15));
		ObjFactory.getutil().InputText(Txt_2Town, ObjFactory.getexcel().getCelData(sheetname, index, j+16));
		ObjFactory.getutil().InputText(Txt_2County, ObjFactory.getexcel().getCelData(sheetname, index, j+17));
		ObjFactory.getutil().InputText(Txt_2Country, ObjFactory.getexcel().getCelData(sheetname, index, j+18));
		ObjFactory.getutil().InputText(Txt_2PostCode, ObjFactory.getexcel().getCelData(sheetname, index, j+19));
		
		ObjFactory.getutil().DropDownSelection(Dropdown_stat_cor_add, ObjFactory.getexcel().getCelData(sheetname, index, j+20));
		
		ObjFactory.getutil().InputText(Txt_3BuildingNumber, ObjFactory.getexcel().getCelData(sheetname, index, j+21));
		ObjFactory.getutil().InputText(Txt_3Street, ObjFactory.getexcel().getCelData(sheetname, index, j+22));
		ObjFactory.getutil().InputText(Txt_3Town, ObjFactory.getexcel().getCelData(sheetname, index, j+23));
		ObjFactory.getutil().InputText(Txt_3County, ObjFactory.getexcel().getCelData(sheetname, index, j+24));
		ObjFactory.getutil().InputText(Txt_3Country, ObjFactory.getexcel().getCelData(sheetname, index, j+25));
		ObjFactory.getutil().InputText(Txt_3PostCode, ObjFactory.getexcel().getCelData(sheetname, index, j+26));
				
	}
}