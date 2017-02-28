package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import library.TestBase;
import pages.RedbusLogin;

public class Redbus extends TestBase
{
		
	@Parameters({"browser"})
	@Test
	public void busTicketSearch(String browser)
	{
		test = report.startTest("RedBus - "+browser+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		driver.get(ObjFactory.getconfig().getRedbusUrl());
		
		RedbusLogin pg1 = PageFactory.initElements(driver, RedbusLogin.class);
		
		pg1.Validate_Header_LoginPageTitle();
		test.log(LogStatus.INFO, "Login Page loaded successfully and PageTitle Validation - Success");
		
		pg1.RedBusLoginPageFunctions();
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
	
		test.log(LogStatus.PASS, "RebBus website launch - Success");
	}
	
}
