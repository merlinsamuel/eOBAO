package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header 
{
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'rbs_logo.gif')]") WebElement H_RBSlogo;
	
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'prog-indicator.gif')]") WebElement H_ProgIndicator;
	
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'rbs_cur_section.gif')]") WebElement H_currentSection;
	
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'rbs_title_bus_sole_curr.gif')]") WebElement H_PgHeader;
}
