package BIanca;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingJUnit {
	@Ignore
	@Test
	public void openGoogle() {
		System.setProperty("webdriver.chrome.driver" ,  "/Users/biancabenck/eclipse-workspace/github.test/driver/chromedriver 2");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
