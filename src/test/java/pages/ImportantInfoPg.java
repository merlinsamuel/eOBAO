package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ImportantInfoPg 
{
WebDriver driver;
	
	public ImportantInfoPg(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String PAGE_TITLE = "Royal Bank of Scotland - RBS Business Sole Trader Current Account application form - Important Information";
	
	public @FindBy (how=How.CSS, using=".section-title-cell>h1") WebElement StText_Line1;
	public @FindBy (how=How.CSS, using=".copy>strong") WebElement StText_Line2;
	
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[2]/td") WebElement StText_Line3;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[3]/td") WebElement StText_Line4;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[1]") WebElement StText_Line5;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[2]") WebElement StText_Line6;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[3]") WebElement StText_Line7;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[4]") WebElement StText_Line8;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[5]") WebElement StText_Line9;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[6]") WebElement StText_Line10;
	public @FindBy (how=How.XPATH, using=".//*[@id='DDA_FORM']/table/tbody/tr[4]/td/ul/li[7]") WebElement StText_Line11;
	
	public @FindBy (how=How.ID, using="S_CANCEL") WebElement Btn_Cancel;
	public @FindBy (how=How.ID, using="S_NEXT") WebElement Btn_Next;
	
}
