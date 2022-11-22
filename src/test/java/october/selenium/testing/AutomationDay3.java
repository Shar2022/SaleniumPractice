package october.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDay3 {

public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
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
		
		// Different ways of waiting for element. 
		Thread.sleep(5000);
		
		WebElement femaleRadio = driver.findElement(By.xpath("//input[@value='female']"));
		femaleRadio.click();
		// find element of the dropdown
		WebElement citydropdown = driver.findElement(By.id("city"));
		
		//create an object of Select - dropdown weblement 
		Select City = new Select(citydropdown);
		City.selectByVisibleText("GOA");
		
		WebElement coursedropdown = driver.findElement(By.name("course"));
		
		Select Course = new Select(coursedropdown);
		//Course.selectByValue("mca");
		Course.selectByIndex(4);
}
}
