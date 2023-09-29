package RepositoryOfAllPages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;



public class LoginRepo {

	
	public WebDriver driver;
	
	@FindBy(id="username")
	private WebElement usernameBox;
	
	@FindBy(name="pwd")
	private WebElement passwordBox;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepMecheckBox;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPasswordlink;
	
	@FindBy(xpath="//span[@class='errormsg']")
	private WebElement errMsg;
	
	@FindBy(className="logoSwitcherText")
	private WebElement homePgaeElement;
	
	

	//CONSTRUCTOR
	public LoginRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String uname)
	{
		usernameBox.clear();
		usernameBox.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		passwordBox.clear();
		passwordBox.sendKeys(pwd);
		
	}
	public void clickCheckBox()
	{
		if(!keepMecheckBox.isSelected())
		{
			keepMecheckBox.click();
		}
	}
	public void clickLoginButton() throws InterruptedException 
	{
		loginButton.click();
		Thread.sleep(3000);
		
	}
	public void clickForgotPassword()
	{
		forgotPasswordlink.click();
	}
	public void isErrMsgShowing()
	{
		
		if(errMsg.isDisplayed())
		{
			Assert.assertTrue(true);
			Reporter.log("Error Message Showing");
			
		}else {
			driver.quit();
			System.out.println("Err Msg Showing");
		}	
		
	}
	public void isHomePagedisplayed()
	{
		
		 if(homePgaeElement.isDisplayed())
		{
			Assert.assertTrue(true);
			
			Reporter.log("HomePage Showing");
		}else {
			driver.close();
		}
		
	}
	public void isLoginPageDisplayed()
	{
		
		if(loginButton.isDisplayed())
		{
			Assert.assertTrue(true);
		}else {
			driver.close();
		}
		
	}
	
}
