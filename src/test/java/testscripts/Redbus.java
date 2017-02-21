package testscripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.TestBase;

public class Redbus extends TestBase
{
	@Parameters({"browser"})
	@Test
	public void busTicketSearch(String browser)
	{
		test = report.startTest("RedBus - "+browser+" - "+getCurrentTimestamp());
		
		BrowserFactory.driver.get(DataProviderFactory.getconfig().getRedbusUrl());
		
		DataProviderFactory.getbase().WaitTillPageLoads("search_div");
		
		//BrowserFactory.driver.switchTo().alert().dismiss();
		
		test.log(LogStatus.INFO, "RebBus website launch - Success");
	}
	

}
