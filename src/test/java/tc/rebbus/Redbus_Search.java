package tc.rebbus;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import pages.redbus.Redbus_SearchPg;

public class Redbus_Search extends Redbus_TestBase
{
		
	@Parameters({"testcaseid", "browser"})
	@Test
	public void busTicketSearch(String testcaseid, String browser)
	{
		test = report.startTest("RedBus - "+browser+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		driver.get(ObjFactory.getconfig().getRedbusUrl());
		
		Redbus_SearchPg pg1 = PageFactory.initElements(driver, Redbus_SearchPg.class);
		
		pg1.Validate_Header_LoginPageTitle();
		test.log(LogStatus.INFO, "Login Page loaded successfully and PageTitle Validation - Success");
		
		pg1.RedBusLoginPageFunctions(testcaseid);
		test.log(LogStatus.INFO, "Performed Login Page Web Operations");
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
	
		test.log(LogStatus.PASS, "RebBus Login Page - Success");
	}
	
}
