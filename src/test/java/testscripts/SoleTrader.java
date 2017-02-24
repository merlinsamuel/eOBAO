package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import library.TestBase;
import pages.BusinessDetailsPg;
import pages.ImportantInfoPg;

public class SoleTrader extends TestBase
{
	int index;
	int j;
	
	@Parameters({"testcaseid", "browser"})
	@Test(priority = 1)
	public void IntroPg(String testcaseid, String browser)
	{
		int row = ObjFactory.getexcel().getRowCount("Intro_0");
		Object [][] data = new Object[row][1];
		
		test = report.startTest("SoleTrader - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		driver.get(ObjFactory.getconfig().getAppUrl());
		
		ImportantInfoPg Impinfo = PageFactory.initElements(driver, ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		ObjFactory.getutil().WaitTillPageLoads(driver, Impinfo.StText_Line1);
		
		ObjFactory.getutil().VerifyHeaderObjects(driver);
		
		Assert.assertEquals(driver.getTitle(), Impinfo.PAGE_TITLE);
		test.log(LogStatus.INFO, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
		for(int i=0; i<row; i++)
		{
			data[i][0]=ObjFactory.getexcel().getCelData("Intro_0", i, 0);
			if(data[i][0].equals(testcaseid))
			{
				index = i;
				j=0;
				break;
			}
		}
		
		Assert.assertEquals(Impinfo.StText_Line1.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+1));
		Assert.assertEquals(Impinfo.StText_Line2.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+2));
		Assert.assertEquals(Impinfo.StText_Line3.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+3));
		Assert.assertEquals(Impinfo.StText_Line4.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+4));
		Assert.assertEquals(Impinfo.StText_Line5.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+5));
		Assert.assertEquals(Impinfo.StText_Line6.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+6));
		Assert.assertEquals(Impinfo.StText_Line7.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+7));
		Assert.assertEquals(Impinfo.StText_Line8.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+8));
		Assert.assertEquals(Impinfo.StText_Line9.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+9));
		Assert.assertEquals(Impinfo.StText_Line10.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+10));
		Assert.assertEquals(Impinfo.StText_Line11.getText(), ObjFactory.getexcel().getCelData("Intro_0", index, j+11));
		
		test.log(LogStatus.INFO, "Static Text Validation - Success");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(Impinfo.Btn_Next);
		
		test.log(LogStatus.PASS, "IntroPg - Success");
	}
	
	@Test(priority = 2)
	public void BD()
	{
		j=0;
		
		BusinessDetailsPg bd = PageFactory.initElements(driver, BusinessDetailsPg.class);
		test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		ObjFactory.getutil().WaitTillPageLoads(driver, bd.Txt_BusiName);
		
		ObjFactory.getutil().VerifyHeaderObjects(driver);
		
		Assert.assertEquals(driver.getTitle(), bd.PAGE_TITLE);
		test.log(LogStatus.INFO, "Header Images and Business Details PageTitle Verification - Success");
		
		ObjFactory.getutil().InputText(bd.Txt_BusiName, ObjFactory.getexcel().getCelData("sample", index, j+1));
		ObjFactory.getutil().InputText(bd.Txt_BusiTelephoneNumber, ObjFactory.getexcel().getCelData("sample", index, j+2));
		ObjFactory.getutil().InputText(bd.Txt_BusiEmail, ObjFactory.getexcel().getCelData("sample", index, j+3));
		ObjFactory.getutil().InputText(bd.Txt_MobileNumber, ObjFactory.getexcel().getCelData("sample", index, j+4));
		
		ObjFactory.getutil().InputText(bd.Txt_1BuildingNumber, ObjFactory.getexcel().getCelData("sample", index, j+5));
		ObjFactory.getutil().InputText(bd.Txt_1Street, ObjFactory.getexcel().getCelData("sample", index, j+6));
		ObjFactory.getutil().InputText(bd.Txt_1Town, ObjFactory.getexcel().getCelData("sample", index, j+7));
		ObjFactory.getutil().InputText(bd.Txt_1County, ObjFactory.getexcel().getCelData("sample", index, j+8));
		ObjFactory.getutil().InputText(bd.Txt_1Country, ObjFactory.getexcel().getCelData("sample", index, j+9));
		ObjFactory.getutil().InputText(bd.Txt_1PostCode, ObjFactory.getexcel().getCelData("sample", index, j+10));
		
		ObjFactory.getutil().InputText(bd.Txt_TradingName, ObjFactory.getexcel().getCelData("sample", index, j+11));
		ObjFactory.getutil().InputText(bd.Txt_ContactName, ObjFactory.getexcel().getCelData("sample", index, j+12));
		
		ObjFactory.getutil().ClickElement(bd.Radio_TradingName);
		
		ObjFactory.getutil().InputText(bd.Txt_2BuildingNumber, ObjFactory.getexcel().getCelData("sample", index, j+14));
		ObjFactory.getutil().InputText(bd.Txt_2Street, ObjFactory.getexcel().getCelData("sample", index, j+15));
		ObjFactory.getutil().InputText(bd.Txt_2Town, ObjFactory.getexcel().getCelData("sample", index, j+16));
		ObjFactory.getutil().InputText(bd.Txt_2County, ObjFactory.getexcel().getCelData("sample", index, j+17));
		ObjFactory.getutil().InputText(bd.Txt_2Country, ObjFactory.getexcel().getCelData("sample", index, j+18));
		ObjFactory.getutil().InputText(bd.Txt_2PostCode, ObjFactory.getexcel().getCelData("sample", index, j+19));
		
		//ObjFactory.getutil().threadsleep();
		
		ObjFactory.getutil().DropDownSelection(bd.Dropdown_stat_cor_add, ObjFactory.getexcel().getCelData("sample", index, j+20));
		
		ObjFactory.getutil().InputText(bd.Txt_3BuildingNumber, ObjFactory.getexcel().getCelData("sample", index, j+21));
		ObjFactory.getutil().InputText(bd.Txt_3Street, ObjFactory.getexcel().getCelData("sample", index, j+22));
		ObjFactory.getutil().InputText(bd.Txt_3Town, ObjFactory.getexcel().getCelData("sample", index, j+23));
		ObjFactory.getutil().InputText(bd.Txt_3County, ObjFactory.getexcel().getCelData("sample", index, j+24));
		ObjFactory.getutil().InputText(bd.Txt_3Country, ObjFactory.getexcel().getCelData("sample", index, j+25));
		ObjFactory.getutil().InputText(bd.Txt_3PostCode, ObjFactory.getexcel().getCelData("sample", index, j+26));
				
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(bd.Btn_Next);
		
		System.out.println(driver.getTitle());
		
		test.log(LogStatus.PASS, "Business Details data input - Success");
	}
}