package RepositoryOfAllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageRepo {

	
	@FindBy(id="container_tt")
	private WebElement Time_Track_Button;
	
	@FindBy(id="container_tasks")
	private WebElement Tasks_Button;
	
	@FindBy(id="container_reports")
	private WebElement Report_Button;
	
	@FindBy(id="container_users")
	private WebElement user_Button;
	
	@FindBy(linkText = "Logout")
	private WebElement Logout_Link;
	
	@FindBy(linkText = "Enter Time-Track")
	private WebElement Enter_Time_Track_Link;
	
	@FindBy(linkText = "View Time-Track")
	private WebElement View_TIme_Track_Link;
	
	@FindBy(linkText = "Lock Time-Track")
	private WebElement Lock_Time_Track_Link;
	
	@FindBy(linkText = "Approve Time-Track")
	private WebElement Approve_Time_Track_Link;
	
	public HomePageRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void clickTimeTrackButton()
	{
		Time_Track_Button.click();
	}
	public void clickTasksButton()
	{
		Tasks_Button.click();
	}
	public void clickRaportButton()
	{
		Report_Button.click();
	}
	public void clickUserButton()
	{
		user_Button.click();
	}
	public void clickLogoutLink()
	{
		Logout_Link.click();
	}
	





		
}
