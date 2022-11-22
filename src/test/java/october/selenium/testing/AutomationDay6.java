package october.selenium.testing;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

/* implicit wait (implicitlyWait) - for all elements of the application.
 * Explicit Wait. - for a specific element 
 *  Fluentwait - Polling time
 * 
 */

public class AutomationDay6 {
	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		login();
		Interactions();
		//doubleclick();
		toolTip();
		
	}
	
	
	public static void login() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email_field"));
		waitforVisibility(10,email);
		email.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.cssSelector("#password_field"));
		password.sendKeys("admin123");
		
	
		WebElement login = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		login.click();
	}
	
	public static void Interactions() {
		
		WebElement interactions = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		
		waitforVisibility(10,interactions);
		
		interactions.click();
		
	}
	
	public static void toolTip() {
		
		
		WebElement tooltip = driver.findElement(By.xpath("//a[contains(text(),'Tool Tip')]"));
		tooltip.click();
		
		WebElement right = driver.findElement(By.className("tooltipr"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(right).build().perform();
		
		WebElement txtright = driver.findElement(By.className("tooltiptextr"));
		String ExpToolTipRight = "RightOne";
		String ActToolTipRight = txtright.getText();
		//Asserstions . testNg 
		compareText(ActToolTipRight, ExpToolTipRight);
		
		
		
	}
	
	public static void compareText(String ActualValue,String ExpectedValue) {
		
		Assert.assertEquals(ActualValue, ExpectedValue);
		//Assert.asserEquals(ActToolTipRight, ExpToolTipRight);
	}
	
	public static void doubleclick() throws InterruptedException {
		
		WebElement doubleclick = driver.findElement(By.xpath("//a[text()='Double Click']"));
		doubleclick.click();
		
		WebElement buttondoubleclick = driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"));
		Thread.sleep(5000);
		//Code to double click on an Element. 
		
		
		Actions actions = new Actions(driver);
		actions.doubleClick(buttondoubleclick).build().perform();
		
	}
	
public static void waitforVisibility(int time, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element)); //400 milisec
	}

}
