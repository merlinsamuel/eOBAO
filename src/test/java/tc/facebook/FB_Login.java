package tc.facebook;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import pages.facebook.FB_HomePg;
import pages.facebook.FB_LoginErrorPg;
import pages.facebook.FB_LoginPg;

public class FB_Login extends TestBase
{
		
	@Parameters({"testcaseid", "browser"})
	@Test
	public void FBLogin(String testcaseid, String browser)
	{
		test = report.startTest("FB Login - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		test.log(LogStatus.INFO, "Browser Launch");
		
		FB_LoginPg fblogin = PageFactory.initElements(driver, FB_LoginPg.class);
		test.log(LogStatus.INFO, "Login Page Initialisation");
		
		FB_HomePg fbhome = PageFactory.initElements(driver, FB_HomePg.class);
		test.log(LogStatus.INFO, "Home Page Initialisation");
		
		FB_LoginErrorPg fberror = PageFactory.initElements(driver, FB_LoginErrorPg.class);
		test.log(LogStatus.INFO, "Error Page Initialisation");
		
		fblogin.Validate_Header_PageTitle();
		test.log(LogStatus.INFO, "Page Load and Header validation");
		
		fblogin.OnLoad();
		test.log(LogStatus.INFO, "OnLoad Page Validation");
		
		System.out.println("Index: "+index);
		
		fblogin.PageFunctions_Login(index, j);
		test.log(LogStatus.INFO, "Login Functions");
		
			
		if(fbhome.Profile.isDisplayed())
		{
			test.log(LogStatus.PASS, "Login Success");
			fblogin.RunStatus(index, j, "Complete", ObjFactory.getutil().getCurrentTimestamp());
						
		}
		else if(fberror.Error.isDisplayed())
		{
			test.log(LogStatus.FAIL, "Login Failed");
			fblogin.RunStatus(index, j, "Incomplete", ObjFactory.getutil().getCurrentTimestamp());
		}
		else
		{
			System.out.println("Exception");
		}
			
	}
}
