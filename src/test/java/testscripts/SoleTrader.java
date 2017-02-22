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
		
		ObjFactory.getutil().InputText(bd.Txt_BusiName, ObjFactory.getexcel().getCelData("BD_1", index, j+1));
		ObjFactory.getutil().InputText(bd.Txt_BusiTelephoneNumber, ObjFactory.getexcel().getCelData("BD_1", index, j+2));
		ObjFactory.getutil().InputText(bd.Txt_BusiEmail, ObjFactory.getexcel().getCelData("BD_1", index, j+3));
		ObjFactory.getutil().InputText(bd.Txt_MobileNumber, ObjFactory.getexcel().getCelData("BD_1", index, j+4));
		ObjFactory.getutil().InputText(bd.Txt_BuildingNumber, ObjFactory.getexcel().getCelData("BD_1", index, j+5));
		ObjFactory.getutil().InputText(bd.Txt_Street, ObjFactory.getexcel().getCelData("BD_1", index, j+6));
		ObjFactory.getutil().InputText(bd.Txt_Town, ObjFactory.getexcel().getCelData("BD_1", index, j+7));
		ObjFactory.getutil().InputText(bd.Txt_County, ObjFactory.getexcel().getCelData("BD_1", index, j+8));
		ObjFactory.getutil().InputText(bd.Txt_PostCode, ObjFactory.getexcel().getCelData("BD_1", index, j+9));
		ObjFactory.getutil().InputText(bd.Txt_TradingName, ObjFactory.getexcel().getCelData("BD_1", index, j+10));
		ObjFactory.getutil().ClickElement(bd.Radio_TradingName);
		ObjFactory.getutil().DropDownSelection(bd.Dropdown_stat_cor_add, ObjFactory.getexcel().getCelData("BD_1", index, j+11));
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		test.log(LogStatus.PASS, "Business Details data input - Success");
	}
}