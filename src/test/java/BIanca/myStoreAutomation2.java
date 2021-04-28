package BIanca;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myStoreAutomation2 {
	WebDriver driver;
	Actions action;
	WebDriverWait explicitWait;

	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
		// Scroll by 100 pixel vertically
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebElement inStockText = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/span/span"));

		action = new Actions(driver);
		action.moveToElement(inStockText).build().perform();
		Thread.sleep(5000);

		WebElement addToCartButton = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
		addToCartButton.click();

		WebElement greenCheckOutButton = driver
				.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));

		explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOf(greenCheckOutButton));
		greenCheckOutButton.click();

		// proceed to checkout

		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		checkout.click();

		String text1 = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).getText();

		assertEquals(text1, "Authentication");

		Thread.sleep(3000);

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
