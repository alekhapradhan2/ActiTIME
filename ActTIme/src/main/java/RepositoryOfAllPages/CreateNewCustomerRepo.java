package RepositoryOfAllPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateNewCustomerRepo {

	
	@FindBy(xpath  = "//input[contains(@class,'inputNameField')]")
	private WebElement enterCustNameBox;
	
	@FindBy(xpath = "//textarea[contains(@placeholder,'Description')]")
	private WebElement descriptionBox;
	
	@FindBy(className = "emptySelection")
	private WebElement selectCustomerDropDown;
	
	@FindBy(className = "searchItemList")
	private WebElement dropDownParent;
	
	@FindBy(xpath = "//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[3]/div[2]/span/div/div[1]/div[2]/div/div[1]/input")
	private WebElement enterexistingname;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerButton;
	
	@FindBy(css = "div[class='greyButton cancelBtn']")
	private WebElement cancelButton;
	
	@FindBy(id="headerContainer")
	private WebElement header;

	//Cunstructor
	public CreateNewCustomerRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickCustName()
	{
		
		enterCustNameBox.click();
	}
	public void enterCustName(String name)
	{
		enterCustNameBox.sendKeys(name);
	}
	public void eneterDescription(String desc)
	{
		descriptionBox.sendKeys(desc);
	}
	public void selectCustomerFromDropDown(String CustName) throws InterruptedException
	{
		selectCustomerDropDown.click();
		Thread.sleep(1000);
		enterexistingname.sendKeys(CustName);
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
	
	public void clickNewCustomerButton()
	{
		createCustomerButton.click();
	}
	public void isCustomerPageOPen()
	{
		if(header.isDisplayed())
		{
			Assert.assertTrue(true);
		}
	}
	
	
}
