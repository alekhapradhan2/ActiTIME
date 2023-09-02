package RepositoryOfAllPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class createNewProjectRepo {


	@FindBy(xpath = "(//input[@class='inputFieldWithPlaceholder'])[1]")
	private WebElement TaskName;
	
	@FindBy(xpath = "(//button[@class='x-btn-text'])[1]")
	private WebElement setDeadLine;
	
	@FindBy(xpath = "(//div[@class='hideButton_panelContainer'])[3]")
	private WebElement closeProjectDetailssidebar;
	
	@FindBy(xpath = "(//div[@class='value ellipsis'])[2]")
	private WebElement typeofwork;
	
	@FindBy(xpath = "//table[contains(@id,'ext-gen')]")
	private WebElement calenderTable;
	
	@FindBy(xpath = "(//button[contains(@id,'ext-gen')])[4]")
	private WebElement month_and_year;
	
	@FindBy(className = "x-date-right")
	private WebElement nextmonth;
	
	@FindBy(className="x-date-inner")
	private WebElement calTable;
	
	@FindBy(xpath = "//div[text()='Create Project']")
	private WebElement createProjectBtn;
	
	@FindBy(xpath = "//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/input")
	private WebElement existingCust;
	
	@FindBy(className = "emptySelection")
	private WebElement selectCustomerDropDown;
	
	@FindBy(className = "searchItemList")
	private WebElement dropDownParent;
	
	public createNewProjectRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setTasksName(String taskName)
	{
		TaskName.sendKeys(taskName);
	}
	
	public void setDeadLine(String caldate) throws InterruptedException
	{
		setDeadLine.click();
		Thread.sleep(1000);
		String deadline=caldate;
		String [] date=deadline.split("/");
		String dt=date[0];  //15/August 2023
		String monthAndYear=date[1];
		String clamonthandyear= month_and_year.getText();
		while(!monthAndYear.equals(clamonthandyear))
		{
			nextmonth.click();
			clamonthandyear= month_and_year.getText();
			
		}
		List<WebElement> row=calTable.findElements(By.tagName("tr"));
		for(int i=1;i<row.size();i++)
		{
			List<WebElement> cols=row.get(i).findElements(By.tagName("td"));
			for(WebElement value:cols)
			{
				if(value.getText().equals(dt))
				{
					value.click();
					break;
				}
			}
		}
		
	}
	
	public void clickProjectButton()
	{
		createProjectBtn.click();
	}
	
	public void selectCustomerFromDropDown(String CustName) throws InterruptedException
	{
		selectCustomerDropDown.click();
		Thread.sleep(1000);
		existingCust.sendKeys(CustName);
		Thread.sleep(2000);
		List<WebElement>drop=dropDownParent.findElements(By.xpath("//div[contains(@class,'cpItemRow')]"));
		for(WebElement data:drop)
		{
			
			String name=data.getText();
			if(name.equals(CustName))
			{
				data.click();
				break;
				
			}
		}
				
	}
	
	

	
	
	
	
}