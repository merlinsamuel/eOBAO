package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import library.ObjFactory;

public class SampleTestNG
{
	WebDriver driver;
	
	
	@Test
	public void ChromeTest()
	{
		driver = ObjFactory.getbase().InitialSetup("firefox");
		driver.get("http://resumelink.org/");
		ObjFactory.getutil().threadsleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).click();
		ObjFactory.getutil().threadsleep(2000);
		
		ObjFactory.getutil().FileUpload("firefox", "C:\\Users\\TOMLIN\\Desktop\\Job_Search\\Xavient\\Posting1656.txt");
	}
}
		
