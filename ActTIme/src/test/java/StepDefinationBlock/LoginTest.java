package StepDefinationBlock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericLiabrary.BaseClass;
import RepositoryOfAllPages.HomePageRepo;
import RepositoryOfAllPages.LoginRepo;
import Utils.PropertiesUitils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	WebDriver driver;
	PropertiesUitils po;
	LoginRepo lr;
	HomePageRepo hp;
	BaseClass bs;

	@Given("Hera i Open the applicaation")
	public void hera_i_open_the_applicaation() throws Throwable {
		// BaseClass.openApp();

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.actitime.com/login.do");

	}

	@When("i give valid username {string} and valid password {string}")
	public void i_give_valid_username_and_valid_password(String string, String string2) {
		lr = new LoginRepo(driver);
		lr.setUserName(string);
		lr.setPassword(string2);
	}

	@When("i click to Login button")
	public void i_click_to_login_button() throws InterruptedException {
		lr = new LoginRepo(driver);
		lr.clickLoginButton();

	}

	@Then("i should see ActTimeHomePgae")
	public void i_should_see_act_time_home_pgae() {
		lr = new LoginRepo(driver);
		lr.isHomePagedisplayed();
	}

	@When("i click logout")
	public void i_click_logout() throws InterruptedException {
		hp = new HomePageRepo(driver);
		hp.clickLogoutLink();

	}

	@Then("i should see ActiTime LoginPage")
	public void i_should_see_acti_time_login_page() {
		lr = new LoginRepo(driver);
		lr.isLoginPageDisplayed();
	}

	@Then("i close browser")
	public void i_close_browser() {

		driver.close();
	}

	@When("i give invalid username {string} and invalid password {string}")
	public void i_give_invalid_username_and_invalid_password(String string, String string2) {
		lr = new LoginRepo(driver);
		lr.setUserName(string);
		lr.setPassword(string2);
	}

	@Then("i should see approprate Error Message")
	public void i_should_see_approprate_error_message() {
		lr = new LoginRepo(driver);
		lr.isErrMsgShowing();
	}
}
