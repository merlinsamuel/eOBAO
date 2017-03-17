package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import library.ObjFactory;

public class FB_LoginPg 
{
	WebDriver driver;
	
	public FB_LoginPg(WebDriver driver)
	{
		this.driver = driver;
	}
	
	String sheetname = "FB_Login";
	
	public String PAGE_TITLE = "Facebook - Log In or Sign Up";
	
	public @FindBy (how=How.ID, using="email") WebElement Txt_Userid;
	public @FindBy (how=How.ID, using="pass") WebElement Txt_Password;
	public @FindBy (how=How.ID, using="u_0_q") WebElement Btn_Login;
	
	public @FindBy (how=How.ID, using ="u_0_3") WebElement Txt_Firstname;
	public @FindBy (how=How.ID, using ="u_0_5") WebElement Txt_Lastname;
	public @FindBy (how=How.ID, using ="u_0_8") WebElement Txt_MobEmail;
	public @FindBy (how=How.ID, using ="u_0_b") WebElement Txt_ReMobEmail;
	public @FindBy (how=How.ID, using ="u_0_f") WebElement Txt_NewPassword;
	public @FindBy (how=How.ID, using ="month") WebElement Drpdown_Month;
	public @FindBy (how=How.ID, using ="day") WebElement Drpdown_Day;
	public @FindBy (how=How.ID, using ="year") WebElement Drpdown_Year;
	//public @FindBy (how=How.CLASS_NAME, using ="_5k_2 _5dba") WebElement Radio_Gender;
	public @FindBy (how=How.ID, using ="u_0_j") WebElement Btn_Createaccount;
	
		
	public void Validate_Header_PageTitle()
	{
		ObjFactory.getutil().WaitTillPageLoads(driver, Txt_Userid);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
	
	public void OnLoad()
	{
		Txt_Firstname.isDisplayed();
		Txt_Lastname.isDisplayed();
		Txt_MobEmail.isDisplayed();
		Txt_ReMobEmail.isDisplayed();
		Txt_NewPassword.isDisplayed();
		Drpdown_Month.isDisplayed();
		Drpdown_Day.isDisplayed();
		Drpdown_Year.isDisplayed();
		//Radio_Gender.isDisplayed();
		Btn_Createaccount.isDisplayed();
	}
	
	public void PageFunctions_Login(int index, int col)
	{
		ObjFactory.getutil().InputText(Txt_Userid, ObjFactory.getexcel().getCelData(sheetname, index, col+1));
		ObjFactory.getutil().InputText(Txt_Password, ObjFactory.getexcel().getCelData(sheetname, index, col+2));
	}
	
	public void PageFunctions_Newaccount()
	{
		
	}
	
	public void RunStatus(int index, int col, String status, String timestamp)
	{
		ObjFactory.getexcel().setCelData(sheetname, index, col+3, status);
		ObjFactory.getexcel().setCelData(sheetname, index, col+4, timestamp);
	}
}
