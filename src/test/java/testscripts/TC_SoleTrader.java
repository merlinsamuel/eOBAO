package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import pages.ImportantInfoPg;
import utility.TestBase;

public class TC_SoleTrader extends TestBase
{
	@Test
	public void IntroPg()
	{
		test = report.startTest("SoleTrader_E2E");
		
		test.log(LogStatus.PASS, "Browser Launch - Success");
				
		ImportantInfoPg Impinfo = PageFactory.initElements(BrowserFactory.driver, ImportantInfoPg.class);
		
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		Assert.assertEquals(BrowserFactory.driver.getTitle(), Impinfo.PAGE_TITLE);
		
		test.log(LogStatus.PASS, "Important Info PageTitle Verification - Success");
		
		Assert.assertEquals(Impinfo.StText_Line1.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 0));
		
		Assert.assertEquals(Impinfo.StText_Line2.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 1));
		
		Assert.assertEquals(Impinfo.StText_Line3.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 2));
		
		Assert.assertEquals(Impinfo.StText_Line4.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 3));
		
		Assert.assertEquals(Impinfo.StText_Line5.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 4));
		
		Assert.assertEquals(Impinfo.StText_Line6.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 5));
		
		Assert.assertEquals(Impinfo.StText_Line7.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 6));
		
		Assert.assertEquals(Impinfo.StText_Line8.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 7));
		
		Assert.assertEquals(Impinfo.StText_Line9.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 8));
		
		Assert.assertEquals(Impinfo.StText_Line10.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 9));
		
		Assert.assertEquals(Impinfo.StText_Line11.getText(), DataProviderFactory.getexcel().getExcelData(0, 0, 10));
		
		test.log(LogStatus.PASS, "Static Text Validation - Success");
		
		TestBase.ClickElement(Impinfo.Btn_Next);
		
		TestBase.EOPScreenshot(BrowserFactory.driver.getTitle());
		
		test.log(LogStatus.PASS, "IntroPg - Success");
	}
}
