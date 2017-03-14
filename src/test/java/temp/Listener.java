package temp;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import library.ObjFactory;


public class Listener implements ITestListener
{
	ITestContext context;
	
	String sheetname = "Sample";
	String testcasename;
	String TestDataid;
	String status;
			
	//@Override
	public void onTestStart(ITestResult result)
	{
	
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		testcasename = result.getTestClass().getRealClass().getSimpleName();
		status = "Pass";
		
		int i = ObjFactory.getexcel().getEmptyRowIndex(sheetname);
		int j=0;
		
		ObjFactory.getexcel().setCelData(sheetname, i, j+1, testcasename);
		ObjFactory.getexcel().setCelData(sheetname, i, j+2, TestDataid);
		ObjFactory.getexcel().setCelData(sheetname, i, j+3, status);
		ObjFactory.getexcel().setCelData(sheetname, i, j+4, ObjFactory.getutil().getCurrentTimestamp());
	}
	

	@Override
	public void onTestFailure(ITestResult result)
	{
		testcasename = result.getTestClass().getRealClass().getSimpleName();
		status = "Fail";
				
		int i = ObjFactory.getexcel().getEmptyRowIndex(sheetname);
		int j=0;
		
		ObjFactory.getexcel().setCelData(sheetname, i, j+1, testcasename);
		ObjFactory.getexcel().setCelData(sheetname, i, j+2, TestDataid);
		ObjFactory.getexcel().setCelData(sheetname, i, j+3, status);
		ObjFactory.getexcel().setCelData(sheetname, i, j+4, ObjFactory.getutil().getCurrentTimestamp());
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
		TestDataid = context.getCurrentXmlTest().getParameter("testcaseid");
		int classcount = context.getCurrentXmlTest().getClasses().size();
		
		int j=0;
		
		for(int sno=1; sno<=classcount; sno++)
		{
			ObjFactory.getexcel().setCelData(sheetname, sno, j, sno);
		}
		System.out.println();
	}

	@Override
	public void onFinish(ITestContext context)
	{
		
	}

}
