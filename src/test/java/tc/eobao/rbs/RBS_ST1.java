package tc.eobao.rbs;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.Listener;
import library.ObjFactory;
import pages.eobao.rbs.RBS_BusinessDetailsPg;
import pages.eobao.rbs.RBS_ImportantInfoPg;

public class RBS_ST1 extends TestBase
{
	@Parameters({"testdataid", "browser"})
	@Test(priority = 1)
	public void soletrader(String testcaseid, String browser)
	{
		//test = report.startTest(this.getClass().getSimpleName()+" - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		RBS_ImportantInfoPg Impinfo = PageFactory.initElements(driver, RBS_ImportantInfoPg.class);
		Listener.test.log(LogStatus.INFO, "Intro PageFactory Initialization");
		
		Impinfo.Validate_Header();		
		Listener.test.log(LogStatus.INFO, "Application Launched; Header Images and Important Info PageTitle Verification - Success");
		
		Impinfo.OnLoad();
		Listener.test.log(LogStatus.INFO, "Intro Page OnLoad controls verified");
		
		Impinfo.PageFunctions(index, j);
		Listener.test.log(LogStatus.INFO, "Static Text Validation - Success");
		
		//ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(Impinfo.Btn_Next);
		
		boolean alertpop_Intro = ObjFactory.getutil().isAlertPresent(driver);
		
		if(alertpop_Intro==false)
		{
			Impinfo.RunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
		}
		else
		{
			Impinfo.RunStatus(index, j, "Incomplete", ObjFactory.getutil().getCurrentTimestamp());
		}
		
		Assert.assertFalse(alertpop_Intro);
	
		RBS_BusinessDetailsPg bd = PageFactory.initElements(driver, RBS_BusinessDetailsPg.class);
		Listener.test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		bd.Validate_Header();
		Listener.test.log(LogStatus.INFO, "Header Images and Business Details PageTitle Verification - Success");
		
		bd.OnLoad();
		Listener.test.log(LogStatus.INFO, "Business Details Page OnLoad controls verified");
		
		bd.PageFunctions(index, j);
		Listener.test.log(LogStatus.INFO, "Business Details data input - Success");
		
		//ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		ObjFactory.getutil().ClickElement(bd.Btn_Next);
		
		boolean alertpop_bd = ObjFactory.getutil().isAlertPresent(driver);
		
		if(alertpop_bd==false)
		{
			bd.RunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
		}
		else
		{
			bd.RunStatus(index, j, "Incomplete", ObjFactory.getutil().getCurrentTimestamp());
		}
		
		Assert.assertFalse(alertpop_bd);
	}
}