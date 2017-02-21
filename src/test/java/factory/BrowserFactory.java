package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory
{
	public static WebDriver driver;
	
	public static WebDriver getBrowser(String browsername)
	{
		if (browsername.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", DataProviderFactory.getconfig().getFireFoxDriverPath());
			driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getconfig().getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getconfig().getIEDriverPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
}
