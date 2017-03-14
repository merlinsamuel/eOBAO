package tc.facebook;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import pages.facebook.FB_HomePg;
import pages.facebook.FB_LoginPg;

public class FB_Login extends TestBase
{
		
	@Parameters({"testcaseid", "browser"})
	@Test (priority = 1)
	public void Login(String testcaseid, String browser)
	{
		test = report.startTest(this.getClass().getSimpleName()+" - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		test.log(LogStatus.INFO, "Browser Launch");
		
		FB_LoginPg fblogin = PageFactory.initElements(driver, FB_LoginPg.class);
		test.log(LogStatus.INFO, "Login Page Initialisation");
		
		FB_HomePg fbhome = PageFactory.initElements(driver, FB_HomePg.class);
		test.log(LogStatus.INFO, "Home Page Initialisation");
		
		//FB_LoginErrorPg fberror = PageFactory.initElements(driver, FB_LoginErrorPg.class);
		//test.log(LogStatus.INFO, "Error Page Initialisation");
		
		fblogin.Validate_Header_PageTitle();
		test.log(LogStatus.INFO, "Page Load and Header validation");
		
		fblogin.OnLoad();
		test.log(LogStatus.INFO, "OnLoad Page Validation");
		
		fblogin.PageFunctions_Login(index, j);
		test.log(LogStatus.INFO, "Login Functions");
		
		fblogin.Btn_Login.click();
		
		if(fbhome.Profile.isDisplayed())
		{
			fblogin.RunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
		}
		else
		{
			fblogin.RunStatus(index, j, "Incomplete", ObjFactory.getutil().getCurrentTimestamp());
		}
		
		Assert.assertTrue(fbhome.Profile.isDisplayed());
		
		fbhome.Validate_Header_PageTitle();
		fbhome.OnLoad();
		fbhome.PageFunctions_Logout();
		//fbhome.Menu_Logout.click();
	}
}
