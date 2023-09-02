package Utils;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.io.Files;

import junit.framework.Assert;

public class DataDrivenUtils {

	/**
	 * This method is for Delete all cookies of the browser
	 */
	public void deleteAllCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
	
	
	
	/**
	 * This method is for maximizing the browser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	

	/**
	 * This method is for minimizing the browser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/*
	 * This method is for resize the browser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void resizeBrowser(WebDriver driver,int h, int b) {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(h, b));
	}
	
	/**
	 * This method is for refresh the browser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	/**
	 * This method is for perform backword the browser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void backwordBrowser(WebDriver driver) {
		driver.navigate().back();
	}
	
	/**
	 * This method is for forword the browser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void forwordBrowser(WebDriver driver) {
		driver.navigate().forward();
	}
	
	/**
	 * This method is going to perform that move the mouse courser
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void moveTheCourser(WebDriver driver, WebElement ele) {
		Actions act= new Actions(driver);
		
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method is going to perform right click
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void rightclick(WebDriver driver, WebElement ele) {
		Actions act= new Actions(driver);
		
		act.moveToElement(ele).contextClick().build().perform();
	}
	
	/*
	 * This method is going to perform double click
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void doubleclick(WebDriver driver, WebElement ele) {
		Actions act= new Actions(driver);
		
		act.doubleClick(ele).perform();
	}
	
	/**
	 * This method is going to perform drag and drop if you know source and destination
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dragandDrop(WebDriver driver, WebElement ele, WebElement ele1) {
		Actions act= new Actions(driver);
		
		act.dragAndDrop(ele, ele1).perform();
	}
	
	/**
	 * This method is going to perform drag and drop if you know source and destination
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dragandDrop(WebDriver driver, WebElement ele,int x,int y) {
		Actions act= new Actions(driver);
		
		act.dragAndDropBy(ele, x, y);
	}
	
	
	/**
	 * This method is going to perform scrolling on our web page
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void scroll(WebDriver driver,int x, int y) {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * This method is going to perform screenshot
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void screenshot(WebDriver driver,String path) throws Throwable {
		TakesScreenshot sh= (TakesScreenshot)driver;
		File src= sh.getScreenshotAs(OutputType.FILE);
		File dist= new File(path);
		Files.copy(src, dist);
	}
	
	/**
	 * This method is going to perform drop down by index
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dropdownByindex(WebElement ele,int index) {
		Select s= new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is going to perform drop down by value
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dropdownByValue(WebElement ele,int value) {
		Select s= new Select(ele);
		s.selectByIndex(value);
	}
	
	/**
	 * This method is going to perform drop down by visible text
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dropdownByVisibletest(WebElement ele,String visibletext) {
		Select s= new Select(ele);
		s.selectByVisibleText(visibletext);
	}

	/**
	 * This method is going to perform dynamic drop down
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dynamicDropDown(List<WebElement> ele, String expecteddata) {
		for(WebElement i:ele) {
			if(i.getText().contains(expecteddata)) {
				i.click();
				break;
			}
		}
	}
	
	/**
	 * This method is going to perform the dynamic drop down and print it
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void dropdownPrint(List<WebElement> ele) {
		for(WebElement i:ele) {
			System.out.println(i.getText());
		}
	}
	
	
	/**
	 * This method is provide the static wait
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void staticWait(int mtime) throws Throwable {
		
		Thread.sleep(mtime);
	}
	
	/**
	 * This method is provide the implicit wait
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void implicitWait(WebDriver driver,int second) {
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
	}
	
	/**
	 * This method is provide explicit wait by visibility of element
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void explicitWaitByVisibility(WebDriver driver,int second,String address) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(""+address+"")));
		
	}
	
	/**
	 * This method is provide explicit wait by clickable of element
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void explicitWaitByClickable(WebDriver driver,int second,String address) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""+address+"")));
		
	}
	
	/**
	 * This method is going to perform Alert to click on ok
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void alertToAccept(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	/**
	 * This method is going to perform Alert to click on cancel
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void alertToCancel(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	/**
	 * This method is going to perform Alert to print message
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public String alertToPrintMessage(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		String data=alt.getText();
		return data;
	}
	
	/**
	 * This method is going to handle the frame by index
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	
	public void frameByIndex(WebDriver driver, int index) {
		
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method is going to handle the frame by web element
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	
	public void frameByWebelement(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * This method is going to handle the frame by visible text
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void frameByVisibleText(WebDriver driver, String visibletext) {
		
	driver.switchTo().frame(visibletext);
	}
	
	/**
	 * This method is going to switch frame page to main page
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	public void frameByMainpage(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is going to switch the driver ID of window
	 * Here I passed webDriver in method parameter, so that driver ID must pass.
	 */
	
	public void handleWindow(WebDriver driver,String title) {
		Set<String> str= driver.getWindowHandles();
		
		for(String i:str) {
			String data= driver.switchTo().window(i).getTitle();
			if(data.contains(title)) {
				driver.switchTo().window(i);
				break;
			}
		}
	}
	
	/**
	 * This method is hard assert and it will validate the two data
	 * @param actData
	 * @param exptData
	 */
	public void validation(String actData,String exptData) {
		 Assert.assertEquals(actData, exptData);
		 Reporter.log("Varification Successful");
	}
}
