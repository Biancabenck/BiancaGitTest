package BIanca;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTesting {
	@Test
	public void openFacebook() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		driver.manage().window().maximize();
		
		
		
		
//		System.setProperty("webdriver.chrome.driver" ,  "/Users/biancabenck/eclipse-workspace/github.test/driver/chromedriver 2");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");
		
	//	driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
		
		boolean message = driver.findElement(By.xpath("//button[contains(@name, 'login')]")).isDisplayed();
		
		assertTrue(message);
		
	}

}
