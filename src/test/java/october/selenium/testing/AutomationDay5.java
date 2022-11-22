package october.selenium.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*   Action Class - Mousehover -action.moveToElement(element).build().perform(); 
 *   Windows Pop up -   accept or dismiss
 *                    driver.switchTo().alert().accept/discuss.
 *   driver.switchTo().alert().sendKeys("Jnanesh");
 * 
 */

public class AutomationDay5 {
	/*   Thread.sleep(5000) - Non recommanded way.
	 *   3 Types of Waits
	 *   1. Implicit Wait
	 *   2. Explicit wait
	 *   3. Fluent wait. 
	 */
	
	static WebDriver driver;
	public static void main(String[] args) {
		/* implicit wait . 
		Driver will halt for some amount of maximum for all element . If it doesnt find it will throw exception.
		Disadvantage
		   1. It will check each element before it perform action
		   2. 10 sec , 20 sec to load. you dont have flexiblity to change the wait time 
		    
		*/
		
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement email = driver.findElement(By.id("email_field"));
		waitforVisibility(10,email);
		email.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.cssSelector("#password_field"));
		password.sendKeys("admin123");
		
	
		WebElement login = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		login.click();
		
		WebElement switchToTab = driver.findElement(By.xpath("//button[contains(text(), 'Switch To')]"));
		//Explicit Wait. 
		//waitforVisibility(20,switchToTab);
		fluentWaitforElement(switchToTab);
		switchToTab.click();
		
		
	}
	
	public static void waitforVisibility(int time, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element)); //400 milisec
	}
	
	
	public static void fluentWaitforElement(WebElement element) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(10, TimeUnit.SECONDS);
		//wait.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	

}
