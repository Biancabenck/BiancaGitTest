package BIanca;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class phptravels_Homework {
	WebDriver driver;

	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		String userpassword = driver
				.findElement(By
						.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[2]/div[2]/div"))
				.getText();
		// System.out.println(userpassword);
		// System.out.println(userpassword.length());
		String user = userpassword.substring(6, 29);
		String password = userpassword.substring(39, 51);

//		System.out.println(user);
//		System.out.println(password);

		// second window
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[1]/div/a"))
				.click();
		;
		System.out.println("Title Before: " + driver.getTitle());

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();

		String window1 = iterator.next();
		String window2 = iterator.next();

		driver.switchTo().window(window2);

		// entering login info
		WebElement emailin = driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/label[1]/input"));
		emailin.sendKeys(user);
		Thread.sleep(3000);
		WebElement passwordin = driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/label[2]/input"));
		passwordin.sendKeys(password);
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[2]/form[1]/button")).click();

		// printing list finding widgets
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"social-sidebar-menu\"]")));

		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"social-sidebar-menu\"]"));
		for (int i = 0; i < list.size(); i++) {
			WebElement names = list.get(i);
			String name = names.getText();
			System.out.println(name);
			if (name.contains("WIDGETS")) {
				System.out.println("PASS!!!!");
			} else {
				System.out.println("try againnnnn");
			}
		}

	}
}
