package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ImportantInfoPg 
{
	public String PAGE_TITLE = "Royal Bank of Scotland - RBS Business Sole Trader Current Account application form - Important Information";
	
	//public @FindBy (how=How.CSS, using=".section-title-cell>h1") WebElement StText_Line1;
	public @FindBy (how=How.XPATH, using="//td[contains(@class, 'section-title')]/h1") WebElement StText_Line1;
	//public @FindBy (how=How.CSS, using=".copy>strong") WebElement StText_Line2;
	public @FindBy (how=How.XPATH, using="//p[@class='copy']") WebElement StText_Line2;
	
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell'][contains(text(),'Thank you')]") WebElement StText_Line3;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell'][contains(text(),'Please read')]") WebElement StText_Line4;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[contains(text(),'It will take')]") WebElement StText_Line5;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[starts-with(text(),'The following')]") WebElement StText_Line6;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[starts-with(text(),'We will ask')]") WebElement StText_Line7;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[starts-with(text(),'Please ensure')]") WebElement StText_Line8;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[starts-with(text(),'You will')]") WebElement StText_Line9;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[starts-with(text(),' We will then')]") WebElement StText_Line10;
	public @FindBy (how=How.XPATH, using="//td[@class='literal-cell']/ul/li[starts-with(text(),'Once we')]") WebElement StText_Line11;
	
	public @FindBy (how=How.ID, using="S_CANCEL") WebElement Btn_Cancel;
	public @FindBy (how=How.ID, using="S_NEXT") WebElement Btn_Next;
	
}
