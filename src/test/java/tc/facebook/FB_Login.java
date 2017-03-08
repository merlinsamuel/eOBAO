package tc.facebook;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import pages.facebook.FB_LoginPg;

public class FB_Login extends FB_TestBase
{
	int index;
	int j=0;
	
	@Parameters({"testcaseid", "browser"})
	@Test
	public void FBLogin(String testcaseid, String browser)
	{
		test = report.startTest("FB Login - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		test.log(LogStatus.INFO, "Browser Launch Success");
		
		driver.get(ObjFactory.getconfig().getFacebookUrl());
		
		FB_LoginPg FB = PageFactory.initElements(driver, FB_LoginPg.class);
		
		ObjFactory.getutil().WaitTillPageLoads(driver, FB.Txt_Userid);
		
		int index = ObjFactory.getexcel().getIndex(testcaseid, "FB_Login");
		
		if(index != 0)
		{
			ObjFactory.getutil().InputText(FB.Txt_Userid, ObjFactory.getexcel().getCelData("FB_Login", index, j+1));
		
			ObjFactory.getutil().InputText(FB.Txt_Password, ObjFactory.getexcel().getCelData("FB_Login", index, j+2));
			
			ObjFactory.getutil().ClickElement(FB.Btn_Login);
			
			Assert.assertTrue(FB.Profile.isDisplayed());
			
			ObjFactory.getutil().WaitTillPageLoads(driver, FB.Icon_Navigation);
			
			ObjFactory.getutil().ClickElement(FB.Icon_Navigation);
			
			ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
			
			test.log(LogStatus.PASS, "Login Success");
		}
		else
		{
			test.log(LogStatus.FAIL, "Data not available for "+testcaseid);
		}
	}
}
