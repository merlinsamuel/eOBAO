package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Factory.BrowserFactory;

public class Header 
{
	WebDriver driver;
	
	public Header(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public @FindBy (how=How.PARTIAL_LINK_TEXT, using="https://www.natwest.com/apps/secure/applicationforms_dda/images/rbs_logo.gif") WebElement RBSLogo;
	
	public void HeaderValidation()
	{
		List<WebElement> allImages = BrowserFactory.driver.findElements(By.tagName("img"));
	
	
		System.out.println(allImages);
	
		System.out.println(allImages.size());
	
		String url;
	
		for (int i=0; i<allImages.size(); i++)
		{
			url = allImages.get(i).getAttribute("src");
			System.out.println(url);
		}
	}
}
