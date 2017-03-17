package temp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.Listener;

public class Class1 
{
	
	@Test
	public void class1test1()
	{
		Listener.test.log(LogStatus.INFO, "Inside Class 1");
		
		System.out.println("Reading class 1");
		Assert.assertTrue(false);
	}
}
