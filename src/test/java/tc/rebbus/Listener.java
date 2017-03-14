package tc.rebbus;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;


public class Listener implements ITestListener
{
			
	//@Override
	public void onTestStart(ITestResult result)
	{
	
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		TestBase.test.log(LogStatus.PASS, "[ "+result.getTestClass().getRealClass().getSimpleName()+" ] - "+result.getName()+" - method PASSED.");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		String Screenshotpath = ObjFactory.getscreenshot().CaptureScreenshot(TestBase.driver, result.getName());
		TestBase.test.log(LogStatus.INFO, TestBase.test.addScreenCapture(Screenshotpath));
		TestBase.test.log(LogStatus.FAIL, "[ "+result.getTestClass().getRealClass().getSimpleName()+" ] - "+result.getName()+" - method FAILED.");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context)
	{
				
	}

	@Override
	public void onFinish(ITestContext context)
	{
		
	}

}
