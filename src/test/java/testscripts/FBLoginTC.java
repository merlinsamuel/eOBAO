package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;
import library.TestBase;
import pages.FBLoginPg;

public class FBLoginTC extends TestBase
{
	int index , j;
	
	@Parameters({"testcaseid", "browser"})
	@Test
	public void FBLogin(String testcaseid, String browser)
	{
		test = report.startTest("FB Login - "+browser+" - "+testcaseid+" - "+ObjFactory.getutil().getCurrentTimestamp());
		
		test.log(LogStatus.INFO, "Browser Launch Success");
		
		driver.get(ObjFactory.getconfig().getFacebookUrl());
		
		FBLoginPg FB = PageFactory.initElements(driver, FBLoginPg.class);
		
		int row = ObjFactory.getexcel().getRowCount("FBLogin");
		
		Object[][] data = new Object[row][1];
		
		for(int i=0; i<row; i++)
		{
			data[i][0] = ObjFactory.getexcel().getCelData("FBLogin", i, 0);
			if(data[i][0].equals(testcaseid))
			{
				index=i;
				j=0;
				break;
			}
		}
		
		ObjFactory.getutil().WaitTillPageLoads(driver, FB.Txt_Userid);
		
		ObjFactory.getutil().InputText(FB.Txt_Userid, ObjFactory.getexcel().getCelData("FBLogin", index, j+1));
		
		ObjFactory.getutil().InputText(FB.Txt_Password, ObjFactory.getexcel().getCelData("FBLogin", index, j+2));
		
		ObjFactory.getutil().ClickElement(FB.Btn_Login);
		
		Assert.assertTrue(FB.Profile.isDisplayed());
		
		ObjFactory.getutil().WaitTillPageLoads(driver, FB.Icon_Navigation);
		
		ObjFactory.getutil().ClickElement(FB.Icon_Navigation);
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
		
		test.log(LogStatus.PASS, "Login Success");
	}

}
