package october.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDay1 {

	public static void main(String[] args) throws InterruptedException  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/home.html");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		String expectedValue = "Selenium";
		String title = driver.getTitle();

		if(expectedValue.equals(title)) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}

		WebElement email = driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password_field"));
		password.sendKeys("admin123");

		WebElement login = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		login.click();

		Thread.sleep(5000);  // Different ways of waiting for element. 

		WebElement Name = driver.findElement(By.id("name"));
		Name.sendKeys("Nidhi");

		WebElement Fathername = driver.findElement(By.cssSelector("#lname"));
		Fathername.sendKeys("Rajkumar");

		WebElement PostalAddress = driver.findElement(By.cssSelector("#postaladdress"));
		PostalAddress.sendKeys("India");

		WebElement MaleRadio = driver.findElement(By.xpath("//input[@value='male']"));
		MaleRadio.click();

		WebElement citydropdown = driver.findElement(By.cssSelector("#city"));
		Select City = new Select(citydropdown);
		City.selectByVisibleText("MUMBAI");

		WebElement coursedropdown = driver.findElement(By.name("course"));

		Select Course = new Select(coursedropdown);
		//Course.selectByValue("mba");
		Course.selectByIndex(2);

	}
}
