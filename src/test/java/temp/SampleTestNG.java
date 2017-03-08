package temp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import library.ObjFactory;

public class SampleTestNG
{
	WebDriver driver;
	
	
	@Test
	public void ChromeTest() throws IOException
	{
		driver = ObjFactory.getbase().InitialSetup("chrome");
		driver.get("http://resumelink.org/");
		ObjFactory.getutil().threadsleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).click();
		ObjFactory.getutil().threadsleep(2000);
		
	}
}
		
