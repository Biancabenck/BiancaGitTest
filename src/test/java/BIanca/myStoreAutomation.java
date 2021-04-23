package BIanca;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myStoreAutomation {
	WebDriver driver;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TestCase1() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		String Title = "My store";
		String expectedTitle = driver.getTitle();
		System.out.println(driver.getTitle());

		if (Title.equals(expectedTitle)) {
			System.out.println("Title is found");
		} else {
			System.out.println("This is the wrong Title");
		}
		// search shirt and click on submmit
		WebElement searchbox = driver.findElement(By.xpath("//input[contains(@name, 'search_query')]"));
		searchbox.sendKeys("shirt");

		WebElement SubmmitButton = driver.findElement(By.xpath("//button[contains(@name, 'submit_search')]"));
		SubmmitButton.click();
		Thread.sleep(5000);

		WebElement resultShirt = driver.findElement(By.xpath("//span[contains(@class, 'lighter')]"));
		resultShirt.getText();
		String text = resultShirt.getText();
		String expectedResult = "\"SHIRT\"";
		// assertTrue(expectedResult);
		assertEquals(text, expectedResult);

	}

}



