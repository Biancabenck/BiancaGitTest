package BIanca;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBoxAuto {
	WebDriver driver;

	@Before
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testcase() throws InterruptedException {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//input[@type='checkbox'])[1]")));

		Boolean checkbox1 = driver.findElement(By.xpath("//input[contains(@type, 'checkbox')][1]")).isSelected();
		Boolean checkbox2 = driver.findElement(By.xpath("//input[contains(@type, 'checkbox')][2]")).isSelected();
		System.out.println("Checkbox1 is by default unchecked");
		Assert.assertFalse(checkbox1);
		System.out.println("Checkbox2 is by default checked");
		Thread.sleep(3000);

		// action
		driver.findElement(By.xpath("//input[contains(@type, 'checkbox')][1]")).click();
		driver.findElement(By.xpath("//input[contains(@type, 'checkbox')][2]")).click();
		Thread.sleep(2000);
	}

	@After
	public void close() {
		driver.close();

	}



}
