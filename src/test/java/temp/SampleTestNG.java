package temp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import library.ObjFactory;

public class SampleTestNG
{
	WebDriver driver;
	@FindBy (how=How.ID, using="src") WebElement autosuggest;
	
	@Test
	public void ChromeTest()
	{
		System.setProperty("webdriver.chrome.driver", ObjFactory.getconfig().getChromeDriverPath());
		driver = new ChromeDriver();
		driver.get(ObjFactory.getconfig().getRedbusUrl());
		
		//SampleTestNG pg = PageFactory.initElements(driver, SampleTestNG.class);
		//autosuggestfn(pg.autosuggest);
		
		autosuggest.click();
		autosuggest.sendKeys("Chennai");
		ObjFactory.getutil().threadsleep(500);
		autosuggest.sendKeys(Keys.TAB);
		
	}
	
	public void autosuggestfn(WebElement element)
	{
		
	}
}
		
