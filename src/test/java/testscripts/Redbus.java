package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_div")));
		
		RedbusLogin pg1 = PageFactory.initElements(driver, RedbusLogin.class);
		
		System.out.println(pg1.Txt_Source.hashCode());
		
		ObjFactory.getutil().EOPScreenshot(driver, driver.getTitle());
	
		test.log(LogStatus.PASS, "RebBus website launch - Success");
	}
	
}
