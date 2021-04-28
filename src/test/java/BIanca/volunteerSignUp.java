package BIanca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class volunteerSignUp {

	WebDriver driver;

	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test

	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-1')]")).sendKeys("Bianca");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-2')]")).sendKeys("Be");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-3')]")).sendKeys("333");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-4')]")).sendKeys("USA");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-5')]")).sendKeys("Arlington");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-6')]")).sendKeys("bb@gmail.com");
		// gender
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_RadioButton-7_1')]")).click();
		// days available
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_CheckBox-8_1')]")).click();
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_CheckBox-8_2')]")).click();
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_CheckBox-8_3')]")).click();

		// time to contact
		driver.findElement(By.xpath("//select[contains(@class, 'drop_down')]")).click();
		driver.findElement(By.xpath("//option[contains(@value, 'Radio-1')]")).click();

		Thread.sleep(10000);

		// submit
		driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).click();

	}
@AfterTest
public void close() {
//	driver.close();
}
}
