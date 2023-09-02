package StepDefinationBlock;

import org.testng.Assert;

import GenericLiabrary.BaseClass;
import RepositoryOfAllPages.CreateNewCustomerRepo;
import RepositoryOfAllPages.HomePageRepo;
import RepositoryOfAllPages.TasksPageRepo;
import RepositoryOfAllPages.createNewProjectRepo;
import Utils.DataDrivenUtils;
import Utils.JavaUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewProjectTest extends BaseClass{

	
	HomePageRepo hp;
	TasksPageRepo tp;
	CreateNewCustomerRepo cn;
	JavaUtils ju;
	DataDrivenUtils dv;
	
	int randomenumber,randomenumber1;
	
	createNewProjectRepo cp;
	

	
	@When("i click New Project")
	public void i_click_new_project() {
		 tp=new TasksPageRepo(driver);
		 tp.clickCreateNewProject();
	}
	
	@When("i Enter Project name as {string}")
	public void i_enter_Project_page_as(String newCust) throws InterruptedException {
		Thread.sleep(2000);
		ju=new JavaUtils();
		randomenumber=ju.randomNumber();
		cn=new CreateNewCustomerRepo(driver);
		cn.clickCustName();
		cn.enterCustName(newCust+randomenumber);
	
	}
	
	@When("i Select existing customer name in dorpdown as at project box {string}")
	public void i_select_existing_customer_name_in_dorpdown_as_at_project_box(String string) throws InterruptedException {
		 cp=new createNewProjectRepo(driver);
		 cp.selectCustomerFromDropDown(string);
	}
	
	@Then("i give task name {string}")
	public void i_give_task_name(String taskName) {
	   cp=new createNewProjectRepo(driver);
	   ju=new JavaUtils();
		randomenumber1=ju.randomNumber();
	   cp.setTasksName(taskName+randomenumber1);
	}
	
	@Then("i set deadline {string}")
	public void i_set_deadline(String string) throws InterruptedException {
		 cp=new createNewProjectRepo(driver);
		 cp.setDeadLine(string);
	}
	
	@When("i click new project button")
	public void i_click_new_project_button() {
	   cp=new createNewProjectRepo(driver);
	   cp.clickProjectButton();
	}
	
	@Then("i should see that particular project name as {string} in Task list page")
	public void i_should_see_that_particular_project_name_as_in_task_list_page(String newProject) throws InterruptedException {
		Thread.sleep(3000);
		tp=new TasksPageRepo(driver);
		tp.isParticularCustNameShowing(newProject+randomenumber);
		
	}
	
	@Then("i should see particular task name {string} in task list page")
	public void i_should_see_particular_task_name_in_task_list_page(String string) throws InterruptedException {
		Thread.sleep(3000);
		tp=new TasksPageRepo(driver);
		
		tp.isTasknameShowingCorrect(string+randomenumber1);
	}
	
	@Then("i should see correct deadline in tasklist {string}")
	public void i_should_see_correct_deadline_in_tasklist(String string) {
		tp=new TasksPageRepo(driver);
	    boolean res=tp.isDeadLineShowingCorrectly(string);
	    Assert.assertTrue(res);
	}
	

}
