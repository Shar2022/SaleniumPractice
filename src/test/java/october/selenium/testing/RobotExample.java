package october.selenium.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.*;
public class RobotExample {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Robot robot = new Robot();
		Thread.sleep(10000);
		robot.mouseMove(400,400);
		robot.mouseWheel(20);
		//Thread.sleep(5000);
		//driver.close();
	}

}
