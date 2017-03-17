package temp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import library.Listener;

public class Class4 
{
	@Test
	public void class4test1()
	{
		Listener.test.log(LogStatus.INFO, "Inside Class 4");
		
		System.out.println("Reading class 4");
		Assert.assertTrue(true);
	}

}
