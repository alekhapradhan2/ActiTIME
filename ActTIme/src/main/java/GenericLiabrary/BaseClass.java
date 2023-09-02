package GenericLiabrary;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RepositoryOfAllPages.HomePageRepo;
import RepositoryOfAllPages.LoginRepo;
import Utils.DataDrivenUtils;
import Utils.PropertiesUitils;


public class BaseClass {

	public static WebDriver driver;
	
	
	public static void openApp() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
