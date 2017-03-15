package library;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Browserbase
{
	WebDriver driver;
	
	//Browser Initialize
	public WebDriver InitialSetup(String browsername)
	{
				
		if (browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ObjFactory.getconfig().getFireFoxDriverPath());
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("marionette", true);
			driver = new FirefoxDriver(cap);
		}
		else if (browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ObjFactory.getconfig().getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("profile.default_content_setting_values.notifications", 2);
						
			options.addArguments("--disable-extensions");
			options.setExperimentalOption("prefs", map);
			
			driver = new ChromeDriver(options);
		}
		else if (browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", ObjFactory.getconfig().getIEDriverPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	//Browser close
	public void teardown(WebDriver driver)
	{
		driver.quit();
	}
}
