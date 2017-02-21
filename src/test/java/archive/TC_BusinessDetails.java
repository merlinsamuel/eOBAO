package archive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dataprovider.ApplicationData;
import factory.BrowserFactory;
import pages.BusinessDetailsPg;
import utility.TestBase;

public class TC_BusinessDetails extends TestBase
{
	@Test(dataProviderClass = ApplicationData.class, dataProvider = "BusinessDetailsPg")
	public void BD(String Txt_BusiName, String Txt_BusiTelephoneNumber, String Txt_BusiEmail, String Txt_MobileNumber, String Txt_BuildingNumber, String Txt_Street, String Txt_County, String Txt_Town, String Txt_PostCode, String Txt_TradingName, String Dropdown_stat_cor_add)
	{
		TestBase.VerifyHeaderObjects();
		test.log(LogStatus.INFO, "Header Objects has been verified");
		
		BusinessDetailsPg bd = PageFactory.initElements(BrowserFactory.driver, BusinessDetailsPg.class);
		test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		Assert.assertEquals(BrowserFactory.driver.getTitle(), bd.PAGE_TITLE);
		test.log(LogStatus.PASS, "Business Details PageTitle Verification - Success");
		
		TestBase.InputText(bd.Txt_BusiName, Txt_BusiName);
		
		TestBase.InputText(bd.Txt_BusiTelephoneNumber, Txt_BusiTelephoneNumber);
		
		TestBase.InputText(bd.Txt_BusiEmail, Txt_BusiEmail);
		
		TestBase.InputText(bd.Txt_MobileNumber, Txt_MobileNumber);
		
		TestBase.InputText(bd.Txt_BuildingNumber, Txt_BuildingNumber);
		
		TestBase.InputText(bd.Txt_Street, Txt_Street);
		
		TestBase.InputText(bd.Txt_Town, Txt_Town);
		
		TestBase.InputText(bd.Txt_County, Txt_County);
				
		TestBase.InputText(bd.Txt_PostCode, Txt_PostCode);
		
		TestBase.InputText(bd.Txt_TradingName, Txt_TradingName);
		
		TestBase.ClickElement(bd.Radio_TradingName);
		
		TestBase.DropDownSelection(bd.Dropdown_stat_cor_add, Dropdown_stat_cor_add);
		
		test.log(LogStatus.INFO, "Business Details data input - Success");
	}
}
