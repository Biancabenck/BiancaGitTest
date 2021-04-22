package BIanca;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTesting {
	@Test
	public void openFacebook() {
		System.setProperty("webdriver.chrome.driver" ,  "/Users/biancabenck/eclipse-workspace/github.test/driver/chromedriver 2");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	//	driver.findElement(By.xpath("//button[contains(@name, 'login')]")).click();
		
		boolean message = driver.findElement(By.xpath("//button[contains(@name, 'login')]")).isDisplayed();
		
		assertTrue(message);
		
	}

}
