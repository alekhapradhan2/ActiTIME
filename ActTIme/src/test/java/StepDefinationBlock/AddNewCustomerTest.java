package StepDefinationBlock;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import GenericLiabrary.BaseClass;
import RepositoryOfAllPages.CreateNewCustomerRepo;
import RepositoryOfAllPages.HomePageRepo;
import RepositoryOfAllPages.TasksPageRepo;
import RepositoryOfAllPages.createNewProjectRepo;
import Utils.JavaUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewCustomerTest extends BaseClass  {

	HomePageRepo hp;
	TasksPageRepo tp;
	CreateNewCustomerRepo cn;
	JavaUtils ju;
	
	int randomenumber;
	int randomenumber1;
	
	
	@Given("i open the Application")
	public void i_open_the_application() {
	   BaseClass.openApp();
	 
	}

	@When("i login in application")
	public void i_login_in_application() throws InterruptedException {
	   BaseClass.loginActiTIme();
	}

	@When("i click to Tasks")
	public void i_click_to_tasks() throws InterruptedException {
		hp=new HomePageRepo(driver);
		hp.clickTasksButton();
	   
	}

	@Then("i should see Task list page")
	public void i_should_see_task_list_page() throws InterruptedException {
		tp=new TasksPageRepo(driver);
		if(tp.getAddNewButton().isDisplayed())
		{
			Assert.assertTrue(true);
		}
	   
	}

	@When("i click Add new button")
	public void i_click_add_new_button() {
	   tp=new TasksPageRepo(driver);
	   tp.clickAddNewButton();
	}

	@When("i click New Customer")
	public void i_click_new_customer() {
		tp=new TasksPageRepo(driver);
		tp.clickCreateNewCustomer();
	    
	}

	@When("i Enter Customer name as {string}")
	public void i_enter_customer_page_as(String newCust) throws InterruptedException {
		Thread.sleep(2000);
		ju=new JavaUtils();
		randomenumber=ju.randomNumber();
		cn=new CreateNewCustomerRepo(driver);
		cn.clickCustName();
		cn.enterCustName(newCust+randomenumber);
		
		
	}
	
	@When("i click create customer button")
	public void i_click_create_customer_button() {
		cn=new CreateNewCustomerRepo(driver);
		cn.clickNewCustomerButton();
	}
	
	@Then("i should see that particular customer name as {string} in Task list page")
	public void i_should_see_that_particular_customer_name_as_in_task_list_page(String newCust) throws InterruptedException {
	    
		Thread.sleep(3000);
		tp=new TasksPageRepo(driver);
		tp.isParticularCustNameShowing(newCust+randomenumber);
		
	}
	
	@When("i search for this custumer name {string}")
	public void i_search_for_this_custumer_name(String newCust) {
		tp=new TasksPageRepo(driver);
		tp.setSearchBox(newCust+randomenumber);
	}
	
	@Then("my application should show the appropreate customername {string}")
	public void my_application_should_show_the_appropreate_customername(String newCust) throws InterruptedException {
		Thread.sleep(2000);
		tp=new TasksPageRepo(driver);
		tp.isCustNameShowingAfterSearch(newCust+randomenumber);
		
	}
	
	@When("i Enter Customer name as a {string}")
	public void i_enter_customer_name_as_a(String newCust) throws InterruptedException {
		Thread.sleep(2000);
		ju=new JavaUtils();
		randomenumber1=ju.randomNumber();
		cn=new CreateNewCustomerRepo(driver);
		cn.clickCustName();
		cn.enterCustName(newCust+randomenumber1);
	}
	
	@When("i Select existing customer name in dorpdown as {string}")
	public void i_select_existing_customer_name_in_dorpdown_as(String ExistingCust) throws InterruptedException {
		
		cn=new CreateNewCustomerRepo(driver);
		cn.selectCustomerFromDropDown(ExistingCust+randomenumber);
	}

	@Then("i should see that particular customer name as a {string} in Task list page")
	public void i_should_see_that_particular_customer_name_as_a_in_task_list_page(String newCust) throws InterruptedException {
		Thread.sleep(3000);
		tp=new TasksPageRepo(driver);
		tp.isParticularCustNameShowing(newCust+randomenumber1);
		
	}
	
	@When("i search for this custumer name as a {string}")
	public void i_search_for_this_custumer_name_as_a(String newCust) {
		tp=new TasksPageRepo(driver);
		tp.setSearchBox(newCust+randomenumber1);
	}
	
	@Then("my application should show the appropreate customername as a {string}")
	public void my_application_should_show_the_appropreate_customername_as_a(String newCust) throws InterruptedException {
		Thread.sleep(2000);
		tp=new TasksPageRepo(driver);
		tp.isCustNameShowingAfterSearch(newCust+randomenumber1);
	}
	
	@When("i logout the app")
	public void i_logout_the_app() {
	   BaseClass.logoutActiTime();
	}
	
	@Then("i close the browser")
	public void i_close_the_browser() {
	   driver.close();
	}
	
}
