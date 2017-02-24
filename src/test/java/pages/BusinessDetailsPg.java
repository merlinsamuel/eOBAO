package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BusinessDetailsPg
{
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
	
}