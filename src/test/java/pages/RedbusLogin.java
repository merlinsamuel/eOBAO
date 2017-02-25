package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RedbusLogin
{
	public @FindBy (how=How.ID, using="src") WebElement Txt_Source;
	
	public @FindBy (how=How.ID, using="dest") WebElement Txt_Dest;

}
