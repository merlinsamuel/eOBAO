package temp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Class3 
{
	@Test
	public void class3test1()
	{
		Listener.test.log(LogStatus.INFO, "Inside Class 3");
		
		System.out.println("Reading class 3");
		Assert.assertTrue(false);
	}

}
