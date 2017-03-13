package tc.rebbus;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import pages.redbus.Redbus_SearchPg;

public class Redbus_Search extends TestBase
{
		
	@Parameters({"testcaseid", "browser"})
	@Test
	public void busTicketSearch(String testcaseid, String browser)
	{
		test = report.startTest(this.getClass().getSimpleName()+" - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		Redbus_SearchPg pg1 = PageFactory.initElements(driver, Redbus_SearchPg.class);
		
		pg1.Validate_Header_LoginPageTitle();
		test.log(LogStatus.INFO, "Login Page loaded successfully and PageTitle Validation - Success");
		
		pg1.RedBusLoginPageFunctions(index, j);
		test.log(LogStatus.INFO, "Performed Login Page Web Operations");
		
		//ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		pg1.RunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
	}
	
}
