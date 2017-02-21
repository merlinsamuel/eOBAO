package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.BusinessDetailsPg;
import pages.ImportantInfoPg;
import utility.TestBase;

public class SoleTrader extends TestBase
{
	int index;
	int j;
	
	@Parameters({"testcaseid"})
	@Test(priority = 1)
	public void IntroPg(String testcaseid)
	{
		int row = DataProviderFactory.getexcel().getRowCount("Intro_0");
		Object [][] data = new Object[row][1];
		
		test = report.startTest("SoleTrader"+"-"+TestBase.getCurrentTimestamp());
		
		BrowserFactory.driver.get(DataProviderFactory.getconfig().getAppUrl());
		
		ImportantInfoPg Impinfo = PageFactory.initElements(BrowserFactory.driver, ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		DataProviderFactory.getbase().WaitTillPageLoads("DDA_FORM");
		
		VerifyHeaderObjects();
		Assert.assertEquals(BrowserFactory.driver.getTitle(), Impinfo.PAGE_TITLE);
		test.log(LogStatus.INFO, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
		for(int i=0; i<row; i++)
		{
			data[i][0]=DataProviderFactory.getexcel().getCelData("Intro_0", i, 0);
			if(data[i][0].equals(testcaseid))
			{
				index = i;
				j=0;
			}
		}
		
		Assert.assertEquals(Impinfo.StText_Line1.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+1));
		Assert.assertEquals(Impinfo.StText_Line2.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+2));
		Assert.assertEquals(Impinfo.StText_Line3.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+3));
		Assert.assertEquals(Impinfo.StText_Line4.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+4));
		Assert.assertEquals(Impinfo.StText_Line5.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+5));
		Assert.assertEquals(Impinfo.StText_Line6.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+6));
		Assert.assertEquals(Impinfo.StText_Line7.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+7));
		Assert.assertEquals(Impinfo.StText_Line8.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+8));
		Assert.assertEquals(Impinfo.StText_Line9.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+9));
		Assert.assertEquals(Impinfo.StText_Line10.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+10));
		Assert.assertEquals(Impinfo.StText_Line11.getText(), DataProviderFactory.getexcel().getCelData("Intro_0", index, j+11));
		
		test.log(LogStatus.INFO, "Static Text Validation - Success");
		
		//EOPScreenshot(BrowserFactory.driver.getTitle());
		ClickElement(Impinfo.Btn_Next);
		
		test.log(LogStatus.PASS, "IntroPg - Success");
	}
	
	@Test(priority = 2)
	public void BD()
	{
		j=0;
		
		BusinessDetailsPg bd = PageFactory.initElements(BrowserFactory.driver, BusinessDetailsPg.class);
		test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		DataProviderFactory.getbase().WaitTillPageLoads("Busname");
				
		VerifyHeaderObjects();
		Assert.assertEquals(BrowserFactory.driver.getTitle(), bd.PAGE_TITLE);
		test.log(LogStatus.INFO, "Header Images and Business Details PageTitle Verification - Success");
		
		InputText(bd.Txt_BusiName, DataProviderFactory.getexcel().getCelData("BD_1", index, j+1));
		InputText(bd.Txt_BusiTelephoneNumber, DataProviderFactory.getexcel().getCelData("BD_1", index, j+2));
		InputText(bd.Txt_BusiEmail, DataProviderFactory.getexcel().getCelData("BD_1", index, j+3));
		InputText(bd.Txt_MobileNumber, DataProviderFactory.getexcel().getCelData("BD_1", index, j+4));
		InputText(bd.Txt_BuildingNumber, DataProviderFactory.getexcel().getCelData("BD_1", index, j+5));
		InputText(bd.Txt_Street, DataProviderFactory.getexcel().getCelData("BD_1", index, j+6));
		InputText(bd.Txt_Town, DataProviderFactory.getexcel().getCelData("BD_1", index, j+7));
		InputText(bd.Txt_County, DataProviderFactory.getexcel().getCelData("BD_1", index, j+8));
		InputText(bd.Txt_PostCode, DataProviderFactory.getexcel().getCelData("BD_1", index, j+9));
		InputText(bd.Txt_TradingName, DataProviderFactory.getexcel().getCelData("BD_1", index, j+10));
		ClickElement(bd.Radio_TradingName);
		DropDownSelection(bd.Dropdown_stat_cor_add, DataProviderFactory.getexcel().getCelData("BD_1", index, j+11));
		
		//EOPScreenshot(BrowserFactory.driver.getTitle());
		
		test.log(LogStatus.PASS, "Business Details data input - Success");
	}
}