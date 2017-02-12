package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import dataprovider.ApplicationData;
import pages.ImportantInfoPg;
import utility.TestBase;

public class TC_SoleTrader extends TestBase
{
	
	@Test(dataProviderClass = ApplicationData.class, dataProvider = "IntroPg")
	public void IntroPg(String StText_Line1, String StText_Line2, String StText_Line3, String StText_Line4, String StText_Line5, String StText_Line6, String StText_Line7, String StText_Line8, String StText_Line9, String StText_Line10, String StText_Line11)
	{
		test = report.startTest("SoleTrader_E2E"+"-"+TestBase.getCurrentTimestamp());
				
		TestBase.VerifyHeaderObjects();
		test.log(LogStatus.PASS, "Browser Launch and Header Verification - Success");
		
		ImportantInfoPg Impinfo = PageFactory.initElements(BrowserFactory.driver, ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		Assert.assertEquals(BrowserFactory.driver.getTitle(), Impinfo.PAGE_TITLE);
		test.log(LogStatus.PASS, "Important Info PageTitle Verification - Success");
		
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
		
		TestBase.ClickElement(Impinfo.Btn_Next);
		
		TestBase.EOPScreenshot(BrowserFactory.driver.getTitle());
		
		test.log(LogStatus.PASS, "IntroPg - Success");
	}
}


