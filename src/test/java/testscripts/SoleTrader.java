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
	int j=0;
	
	@Parameters({"testcaseid", "browser"})
	@Test
	public void TC_SoleTrader(String testcaseid, String browser)
	{
		test = report.startTest("SoleTrader - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		driver.get(ObjFactory.getconfig().getAppUrl());
		
		ImportantInfoPg Impinfo = PageFactory.initElements(driver, ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		Impinfo.Validate_Header_IntroPgTitle();		
		test.log(LogStatus.INFO, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
		Impinfo.IntroPageFunctions(testcaseid);
		test.log(LogStatus.INFO, "Static Text Validation - Success");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(Impinfo.Btn_Next);
		
		Assert.assertTrue(driver.getTitle().contains("Business Details"));
		
		test.log(LogStatus.PASS, "Intro Page - Success");
		
		BusinessDetailsPg bd = PageFactory.initElements(driver, BusinessDetailsPg.class);
		
		bd.Validate_Header_BDPgTitle();
		test.log(LogStatus.INFO, "Header Images and Business Details PageTitle Verification - Success");
		
		bd.BusinessDetailsPageFunctions(testcaseid);
		test.log(LogStatus.INFO, "Business Details data input - Success");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(bd.Btn_Next);
		
		Assert.assertTrue(driver.getTitle().contains("Business Additional details"));
		
		test.log(LogStatus.PASS, "Business Details Page - Success");
	}
}