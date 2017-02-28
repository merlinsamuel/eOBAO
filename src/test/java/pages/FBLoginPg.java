package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FBLoginPg 
{
	public @FindBy (how=How.ID, using="email") WebElement Txt_Userid;
	
	public @FindBy (how=How.ID, using="pass") WebElement Txt_Password;
	
	public @FindBy (how=How.ID, using="u_0_q") WebElement Btn_Login;
	
	public @FindBy (how=How.XPATH, using="//a[@class='_2s25']/span[text()='Merlin']") WebElement Profile;
	
	public @FindBy (how=How.ID, using="userNavigationLabel") WebElement Icon_Navigation;
	
	public @FindBy (how=How.ID, using="//span[text()='Log Out']") WebElement Menu_Logout;

}
