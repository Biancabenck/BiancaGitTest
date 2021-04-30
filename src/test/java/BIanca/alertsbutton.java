package BIanca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertsbutton {

	WebDriver driver;

	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {
		WebElement box1 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button"));
		box1.click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		WebElement box2 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));
		box2.click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);

		WebElement box3 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button"));
		box3.click();
		String message = "hi";
		driver.switchTo().alert().sendKeys(message);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		String text = driver.findElement(By.xpath("//*[@id=\"prompt-demo\"]")).getText();

		if (text.contains(message)) {
			System.out.println("PASS");
		}

	}
}
