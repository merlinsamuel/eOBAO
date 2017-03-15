package temp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Class2 
{
	@Test
	public void class2test1()
	{
		Listener.test.log(LogStatus.INFO, "Inside Class 2");
		
		System.out.println("Reading class 2");
		Assert.assertTrue(true);
	}
	
}
