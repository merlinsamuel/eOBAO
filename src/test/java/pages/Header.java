package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header 
{
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'rbs_logo.gif')]") WebElement OBAO_RBSlogo;
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'prog-indicator.gif')]") WebElement OBAO_ProgIndicator;
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'rbs_cur_section.gif')]") WebElement OBAO_currentSection;
	public @FindBy (how=How.XPATH, using="//img[contains(@src,'rbs_title_bus_sole_curr.gif')]") WebElement OBAO_PgHeader;
	
	public @FindBy (how=How.XPATH, using="//a[@class='redbus-logo'][text()='redbus']") WebElement RB_redbuslogo;
	public @FindBy (how=How.XPATH, using="//nav[@class='product-nav fl']/ul/li/a[text()='BUS TICKETS']") WebElement RB_BusTickets;
	public @FindBy (how=How.XPATH, using="//nav[@class='product-nav fl']/ul/li/a[text()='HOTELS']") WebElement RB_Hotels;
	public @FindBy (how=How.XPATH, using="//nav[@class='product-nav fl']/ul/li/a[text()='BUS HIRE']") WebElement RB_BusHire;
	public @FindBy (how=How.XPATH, using="//nav[@class='product-nav fl']/ul/li[4]/a") WebElement RB_Pilgrimages;
	
	public @FindBy (how=How.XPATH, using="//div[@class='config-wrapper fr']/div[@class='fr print-sms print-sms-cont site-links']") WebElement RB_PrintSMSTicket;
	public @FindBy (how=How.XPATH, using="//div[@class='config-wrapper fr']/div[@id='cancellation']") WebElement RB_CancelTicket;
	public @FindBy (how=How.XPATH, using="//div[@class='config-wrapper fr']/div[@id='call-us-at']") WebElement RB_CallUsAt;
	public @FindBy (how=How.XPATH, using="//div[@class='config-wrapper fr']/div[@id='chat-with-us']") WebElement RB_WriteToUs;
	public @FindBy (how=How.ID, using="signin-block") WebElement RB_Profile;
	
	public void OBAO_Header()
	{
		OBAO_currentSection.isDisplayed();
		OBAO_PgHeader.isDisplayed();
		OBAO_ProgIndicator.isDisplayed();
		OBAO_RBSlogo.isDisplayed();
	}
	
	public void RB_Header()
	{
		RB_redbuslogo.isDisplayed();
		RB_BusTickets.isDisplayed();
		RB_Hotels.isDisplayed();
		RB_BusHire.isDisplayed();
		RB_Pilgrimages.isDisplayed();
		RB_PrintSMSTicket.isDisplayed();
		RB_CancelTicket.isDisplayed();
		RB_CallUsAt.isDisplayed();
		RB_WriteToUs.isDisplayed();
		RB_Profile.isDisplayed();
	}
}
