package temp;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import library.ObjFactory;


public class Listener implements ITestListener
{
	public ExtentReports report;
	public static ExtentTest test;
	
	String sheetname = "Sample";
	
	String TestDataid;
	String browsername;
	
	String testcasename;
	String status;
			
	//@Override
	public void onTestStart(ITestResult result)
	{
		test = report.startTest(result.getTestClass().getRealClass().getSimpleName()+" - "+TestDataid+" - "+browsername);
		
		test.log(LogStatus.INFO, result.getTestClass().getRealClass().getSimpleName()+" - test script STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(LogStatus.PASS, result.getTestClass().getRealClass().getSimpleName()+" - test script PASSED");
		
		testcasename = result.getTestClass().getRealClass().getSimpleName();
		status = "Pass";
		
		
		
		int i = ObjFactory.getexcel().getEmptyRowIndex(sheetname);
		int j=0;
		
		ObjFactory.getexcel().setCelData(sheetname, i, j+1, testcasename);
		ObjFactory.getexcel().setCelData(sheetname, i, j+2, TestDataid);
		ObjFactory.getexcel().setCelData(sheetname, i, j+3, status);
		ObjFactory.getexcel().setCelData(sheetname, i, j+4, ObjFactory.getutil().getCurrentTimestamp());
		
		report.endTest(test);
		report.flush();
	}
	

	@Override
	public void onTestFailure(ITestResult result)
	{
		test.log(LogStatus.ERROR, result.getThrowable().toString());
		test.log(LogStatus.FAIL, result.getTestClass().getRealClass().getSimpleName()+" - test script FAILED");
		
		testcasename = result.getTestClass().getRealClass().getSimpleName();
		status = "Fail";
				
		int i = ObjFactory.getexcel().getEmptyRowIndex(sheetname);
		int j=0;
		
		ObjFactory.getexcel().setCelData(sheetname, i, j+1, testcasename);
		ObjFactory.getexcel().setCelData(sheetname, i, j+2, TestDataid);
		ObjFactory.getexcel().setCelData(sheetname, i, j+3, status);
		ObjFactory.getexcel().setCelData(sheetname, i, j+4, ObjFactory.getutil().getCurrentTimestamp());
		
		report.endTest(test);
		report.flush();
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
		TestDataid = context.getCurrentXmlTest().getParameter("testdataid");
		browsername = context.getCurrentXmlTest().getParameter("browser");
		
		report = new ExtentReports(ObjFactory.getconfig().getReportsPath(), false);

	}

	@Override
	public void onFinish(ITestContext context)
	{
		//ObjFactory.getexcel().setCelData(sheetname, 0, 0, "SNO");
	}

}
