package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import library.ObjFactory;

public class ImportantInfoPg 
{
	WebDriver driver;
	
	public ImportantInfoPg(WebDriver driver)
	{
		this.driver=driver;
	}
	
	String sheetname = "Intro_0";
	
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
	

	public void Validate_Header_IntroPgTitle()
	{
		ObjFactory.getutil().WaitTillPageLoads(driver, StText_Line1);
		ObjFactory.getutil().Verify_OBAO_HeaderObjects(driver);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
	
	public void IntroPageFunctions(String testcaseid)
	{
		int j=0;
		int index = ObjFactory.getutil().getIndex(testcaseid, sheetname);
		
		if (index == 0)
		{
			System.exit(0);
		}
		
		Assert.assertEquals(StText_Line1.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+1));
		Assert.assertEquals(StText_Line2.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+2));
		Assert.assertEquals(StText_Line3.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+3));
		Assert.assertEquals(StText_Line4.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+4));
		Assert.assertEquals(StText_Line5.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+5));
		Assert.assertEquals(StText_Line6.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+6));
		Assert.assertEquals(StText_Line7.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+7));
		Assert.assertEquals(StText_Line8.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+8));
		Assert.assertEquals(StText_Line9.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+9));
		Assert.assertEquals(StText_Line10.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+10));
		Assert.assertEquals(StText_Line11.getText(), ObjFactory.getexcel().getCelData(sheetname, index, j+11));
		
	}
}
