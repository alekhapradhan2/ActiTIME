package RepositoryOfAllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TasksPageRepo {

	@FindBy(className = "plusIcon")
	private WebElement AddNewButton;
	
	@FindBy(xpath = "//div[contains(@class,'createNewCustomer')]")
	private WebElement creatNewCustomer;
	
	@FindBy(xpath = "//div[contains(@class,'createNewProject')]")
	private WebElement createNewProject;
	
	@FindBy(xpath = "//div[contains(@class,'createNewTasks')]")
	private WebElement createNewTasks;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Start typing')][1]")
	private WebElement SearchBox;
	
	@FindBy(className = "highlightToken")
	private WebElement custNameafterSearch;
	
	@FindBy(className = "titleEditButtonContainer")
	private WebElement name;
	
	@FindBy(className = "namesContainer")
	private WebElement projectTaskName;
	
	@FindBy(xpath ="//div[contains(@class,'deadlineEditor editable')]")
	private WebElement deadline;
	
	
	
	
	//Cunstroctor
	public TasksPageRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickAddNewButton()
	{
		AddNewButton.click();
	}public void clickCreateNewCustomer()
	{
		creatNewCustomer.click();
	}
	public void clickCreateNewProject()
	{
		createNewProject.click();
	}
	public void clickCreateNewTasks()
	{
		createNewTasks.click();
	}
	public void setSearchBox(String text)
	{
		SearchBox.clear();
		SearchBox.sendKeys(text);
	}
	public void isParticularCustNameShowing(String custName) {
		
		String custname=name.getText();
		Assert.assertEquals(custName, custname);
		
	}
	public void isCustNameShowingAfterSearch(String custName)
	{
		String name=custNameafterSearch.getText();
		Assert.assertEquals(name, custName);
	}
	public WebElement getAddNewButton() {
		return AddNewButton;
	}
	
	public void isTasknameShowingCorrect(String taskName)
	{
		String taskname=projectTaskName.getText();
		Assert.assertEquals(taskName, taskname);

	}
	public boolean isDeadLineShowingCorrectly(String deadlinedate)
	{
		boolean flag=false;
		String date=deadline.getText();
		if(date.contains(deadlinedate))
		{
			flag=true;
		}
		return true;
	}
	
	
	
}
