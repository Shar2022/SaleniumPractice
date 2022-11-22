package october.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDay2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		login();
		Thread.sleep(5000);
		switchToTab();
		clickonAlert();
		clickonWindowAlert();
	}

	public static void login() throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/home.html");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password_field"));
		password.sendKeys("admin123");

		WebElement login = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		login.click();
	}

	public static void switchToTab() throws InterruptedException {
		Thread.sleep(5000);
		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions action = new Actions(driver);
		//Thread.sleep(5000);

		action.moveToElement(switchTo).build().perform();
		

	}
	private static void clickonAlert() {
		 WebElement alert = driver.findElement(By.xpath("//a[text()='Alert']"));
		 alert.click();	
		}
	private static void clickonWindowAlert() throws InterruptedException {
		WebElement windowalert = driver.findElement(By.xpath("//button[text()='Window Alert']"));
		windowalert.click();
		Thread.sleep(5000);
		
		String alertText = driver.switchTo().alert().getText();
		
		System.out.println("Alert Text" +alertText);
		
		driver.switchTo().alert().accept();
		
		
	}
}
