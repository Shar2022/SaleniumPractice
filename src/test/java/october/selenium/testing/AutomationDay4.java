package october.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDay4 {
	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		login();
		Thread.sleep(5000);
		MoveToSwitchToTab();
		clickonAlert();
		//clickonWindowAlert();
		clickonPromptAlert();
		
	}

	public static void login() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/home.html");
		//How to maximize the screen.
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.cssSelector("#password_field"));
		password.sendKeys("admin123");
		
	
		WebElement login = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		login.click();
	}
	
	public static void MoveToSwitchToTab() {
		
		
	WebElement switchToTab = driver.findElement(By.xpath("//button[contains(text(), 'Switch To')]"));
	
	//Mouseover
	
	Actions action = new Actions(driver);
	action.moveToElement(switchToTab).build().perform();
		
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
	
		private static void clickonPromptAlert() throws InterruptedException {
	
		WebElement promptAlert = driver.findElement(By.xpath("//button[text()='Promt Alert']"));
		promptAlert.click();
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("Jnanesh");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		//driver.switchTo().alert().dismiss();
		
		String alertinfo = driver.findElement(By.id("Selenium")).getText();
		
		System.out.println(alertinfo);
		
		
	}
	
	

}

