package GenericLiabrary;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import RepositoryOfAllPages.HomePageRepo;
import RepositoryOfAllPages.LoginRepo;


public class BaseClass {

	public static WebDriver driver;
	
	
	public static void openApp() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://demo.actitime.com/login.do");
	}
	
	public static void loginActiTIme() throws InterruptedException  
	{
		LoginRepo lr=new LoginRepo(driver);
		lr.setUserName("admin");
		lr.setPassword("manager");
		lr.clickLoginButton();
		Thread.sleep(3000);
	}
	
	public static void logoutActiTime()
	{
		HomePageRepo hp=new HomePageRepo(driver);
		hp.clickLogoutLink();
	}
	
	public static void closeApp()
	{
		driver.close();
	}
}
