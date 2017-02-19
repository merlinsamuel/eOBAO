package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dataprovider.ApplicationData;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.BusinessDetailsPg;
import pages.ImportantInfoPg;
import utility.TestBase;

public class TC_SoleTrader extends TestBase
{
	
	@Test(priority = 1, dataProviderClass = ApplicationData.class, dataProvider = "IntroPg")
	public void IntroPg(String StText_Line1, String StText_Line2, String StText_Line3, String StText_Line4, String StText_Line5, String StText_Line6, String StText_Line7, String StText_Line8, String StText_Line9, String StText_Line10, String StText_Line11)
	{
		test = report.startTest("SoleTrader"+"-"+TestBase.getCurrentTimestamp());
		
		BrowserFactory.driver.get(DataProviderFactory.getconfig().getAppUrl());
		
		ImportantInfoPg Impinfo = PageFactory.initElements(BrowserFactory.driver, ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		VerifyHeaderObjects();
		Assert.assertEquals(BrowserFactory.driver.getTitle(), Impinfo.PAGE_TITLE);
		test.log(LogStatus.PASS, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
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
		
		test.log(LogStatus.PASS, "Static Text Validation - Success");
		
		EOPScreenshot(BrowserFactory.driver.getTitle());
		ClickElement(Impinfo.Btn_Next);
		
		test.log(LogStatus.PASS, "IntroPg - Success");
	}
	
	@Test(priority = 2, dataProviderClass = ApplicationData.class, dataProvider = "BusinessDetailsPg")
	public void BD(String Txt_BusiName, String Txt_BusiTelephoneNumber, String Txt_BusiEmail, String Txt_MobileNumber, String Txt_BuildingNumber, String Txt_Street, String Txt_County, String Txt_Town, String Txt_PostCode, String Txt_TradingName, String Dropdown_stat_cor_add)
	{
		BusinessDetailsPg bd = PageFactory.initElements(BrowserFactory.driver, BusinessDetailsPg.class);
		test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		VerifyHeaderObjects();
		Assert.assertEquals(BrowserFactory.driver.getTitle(), bd.PAGE_TITLE);
		test.log(LogStatus.PASS, "Header Images and Business Details PageTitle Verification - Success");
		
		InputText(bd.Txt_BusiName, Txt_BusiName);
		InputText(bd.Txt_BusiTelephoneNumber, Txt_BusiTelephoneNumber);
		InputText(bd.Txt_BusiEmail, Txt_BusiEmail);
		InputText(bd.Txt_MobileNumber, Txt_MobileNumber);
		InputText(bd.Txt_BuildingNumber, Txt_BuildingNumber);
		InputText(bd.Txt_Street, Txt_Street);
		InputText(bd.Txt_Town, Txt_Town);
		InputText(bd.Txt_County, Txt_County);
		InputText(bd.Txt_PostCode, Txt_PostCode);
		InputText(bd.Txt_TradingName, Txt_TradingName);
		ClickElement(bd.Radio_TradingName);
		DropDownSelection(bd.Dropdown_stat_cor_add, Dropdown_stat_cor_add);
		EOPScreenshot(BrowserFactory.driver.getTitle());
		
		test.log(LogStatus.INFO, "Business Details data input - Success");
	}
}