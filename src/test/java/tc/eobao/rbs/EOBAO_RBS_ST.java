package tc.eobao.rbs;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import pages.eobao.rbs.RBS_BusinessDetailsPg;
import pages.eobao.rbs.RBS_ImportantInfoPg;

public class EOBAO_RBS_ST extends EOBAO_RBS_TestBase
{

	@Parameters({"testcaseid", "browser"})
	@Test(priority = 1)
	public void Intro(String testcaseid, String browser)
	{
		test = report.startTest("SoleTrader - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		driver.get(ObjFactory.getconfig().getAppUrl());
		
		RBS_ImportantInfoPg Impinfo = PageFactory.initElements(driver, RBS_ImportantInfoPg.class);
		test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		Impinfo.Validate_Header_IntroPgTitle();		
		test.log(LogStatus.INFO, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
		Impinfo.IntroOnLoad();
		test.log(LogStatus.INFO, "Intro Page OnLoad controls verified");
		
		Impinfo.IntroPageFunctions(index, j);
		test.log(LogStatus.INFO, "Static Text Validation - Success");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(Impinfo.Btn_Next);
		
		if(ObjFactory.getutil().isAlertPresent(driver)==false)
		{
			Impinfo.ImportantInfoRunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
			test.log(LogStatus.PASS, "Intro Page - Success");
		}
		else
		{
			Impinfo.ImportantInfoRunStatus(index, j, "Incomplete", ObjFactory.getutil().getCurrentTimestamp());
			test.log(LogStatus.FAIL, "Intro Page - Failed");
		}
	}
	
	@Test(priority = 2)
	public void BD()
	{
		RBS_BusinessDetailsPg bd = PageFactory.initElements(driver, RBS_BusinessDetailsPg.class);
		
		bd.Validate_Header_BDPgTitle();
		test.log(LogStatus.INFO, "Header Images and Business Details PageTitle Verification - Success");
		
		bd.BusinessDetailsOnLoad();
		test.log(LogStatus.INFO, "Business Details Page OnLoad controls verified");
		
		bd.BusinessDetailsPageFunctions(index, j);
		test.log(LogStatus.INFO, "Business Details data input - Success");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(bd.Btn_Next);
		
		if(ObjFactory.getutil().isAlertPresent(driver)==false)
		{
			bd.BusinessDetailsRunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
			test.log(LogStatus.PASS, "Business Details Page - Success");
		}
		else
		{
			bd.BusinessDetailsRunStatus(index, j, "Incomplete", ObjFactory.getutil().getCurrentTimestamp());
			test.log(LogStatus.FAIL, "Business Details Page - Failed");
		}
	}
}