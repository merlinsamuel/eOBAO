 package tc.eobao.rbs;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.TestDataProvider;
import pages.eobao.rbs.RBS_BusinessDetailsPg;
import pages.eobao.rbs.RBS_ImportantInfoPg;
import library.ObjFactory;

public class SoleTraderDP extends EOBAO_RBS_TestBase
{
	
	@Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "IntroPg")
	public void IntroPg(String StText_Line1, String StText_Line2, String StText_Line3, String StText_Line4, String StText_Line5, String StText_Line6, String StText_Line7, String StText_Line8, String StText_Line9, String StText_Line10, String StText_Line11)
	{
		test = report.startTest("SoleTrader DP -"+ObjFactory.getutil().getCurrentTimestamp());
		
		driver.get(ObjFactory.getconfig().getAppUrl());
		
		RBS_ImportantInfoPg Impinfo = PageFactory.initElements(driver, RBS_ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		ObjFactory.getutil().WaitTillPageLoads(driver, Impinfo.StText_Line1);
		
		ObjFactory.getutil().Verify_OBAO_HeaderObjects(driver);
		
		Assert.assertEquals(driver.getTitle(), Impinfo.PAGE_TITLE);
		test.log(LogStatus.INFO, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
		Assert.assertEquals(Impinfo.StText_Line1.getText(), StText_Line1);
		Assert.assertEquals(Impinfo.StText_Line2.getText(), StText_Line2);
		Assert.assertEquals(Impinfo.StText_Line3.getText(), StText_Line3);
		Assert.assertEquals(Impinfo.StText_Line4.getText(), StText_Line4);
		Assert.assertEquals(Impinfo.StText_Line5.getText(), StText_Line5);
		Assert.assertEquals(Impinfo.StText_Line6.getText(), StText_Line6);
		Assert.assertEquals(Impinfo.StText_Line7.getText(), StText_Line7);
		Assert.assertEquals(Impinfo.StText_Line8.getText(), StText_Line8);
		Assert.assertEquals(Impinfo.StText_Line9.getText(), StText_Line9);
		Assert.assertEquals(Impinfo.StText_Line10.getText(), StText_Line10);
		Assert.assertEquals(Impinfo.StText_Line11.getText(), StText_Line11);
		
		test.log(LogStatus.INFO, "Static Text Validation - Success");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(Impinfo.Btn_Next);
		
		test.log(LogStatus.PASS, "IntroPg - Success");
	}
	
	@Test(priority = 2, dataProviderClass = TestDataProvider.class, dataProvider = "BusinessDetailsPg")
	public void BD(String Txt_BusiName, String Txt_BusiTelephoneNumber, String Txt_BusiEmail, String Txt_MobileNumber, String Txt_BuildingNumber, String Txt_Street, String Txt_County, String Txt_Town, String Txt_PostCode, String Txt_TradingName, String Dropdown_stat_cor_add)
	{
		RBS_BusinessDetailsPg bd = PageFactory.initElements(driver, RBS_BusinessDetailsPg.class);
		test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		ObjFactory.getutil().WaitTillPageLoads(driver, bd.Txt_BusiName);
		
		ObjFactory.getutil().Verify_OBAO_HeaderObjects(driver);
		
		Assert.assertEquals(driver.getTitle(), bd.PAGE_TITLE);
		test.log(LogStatus.INFO, "Header Images and Business Details PageTitle Verification - Success");
		
		ObjFactory.getutil().InputText(bd.Txt_BusiName, Txt_BusiName);
		ObjFactory.getutil().InputText(bd.Txt_BusiTelephoneNumber, Txt_BusiTelephoneNumber);
		ObjFactory.getutil().InputText(bd.Txt_BusiEmail, Txt_BusiEmail);
		ObjFactory.getutil().InputText(bd.Txt_MobileNumber, Txt_MobileNumber);
		ObjFactory.getutil().InputText(bd.Txt_1BuildingNumber, Txt_BuildingNumber);
		ObjFactory.getutil().InputText(bd.Txt_1Street, Txt_Street);
		ObjFactory.getutil().InputText(bd.Txt_1Town, Txt_Town);
		ObjFactory.getutil().InputText(bd.Txt_1County, Txt_County); 
		ObjFactory.getutil().InputText(bd.Txt_1PostCode, Txt_PostCode);
		ObjFactory.getutil().InputText(bd.Txt_TradingName, Txt_TradingName);
		//ObjFactory.getutil().ClickElement(bd.Radio_TradingName);
		ObjFactory.getutil().DropDownSelection(bd.Dropdown_stat_cor_add, Dropdown_stat_cor_add);
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		test.log(LogStatus.PASS, "Business Details data input - Success");
	}
}