package testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import pages.BusinessDetailsPg;
import utility.TestBase;

public class TC_BusinessDetails extends TestBase
{
	@Test
	public void BD()
	{
		BusinessDetailsPg bd = PageFactory.initElements(BrowserFactory.driver, BusinessDetailsPg.class);
		
		test.log(LogStatus.INFO, "Business Details PageFactory Initialization");
		
		Assert.assertEquals(BrowserFactory.driver.getTitle(), bd.PAGE_TITLE);
		
		test.log(LogStatus.PASS, "Business Details PageTitle Verification - Success");
		
		TestBase.InputText(bd.Txt_BusiName, DataProviderFactory.getexcel().getExcelData("BD_1", 0, 0));
		
		TestBase.EOPScreenshot(BrowserFactory.driver.getTitle());
		
		test.log(LogStatus.INFO, "Business Details data input - Success");
	}

}
