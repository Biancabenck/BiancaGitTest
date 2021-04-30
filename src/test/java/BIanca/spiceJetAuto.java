package BIanca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spiceJetAuto {

	WebDriver driver;
	Select select;

	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void test() throws InterruptedException {
		// select currency
		WebElement dropDown = driver
				.findElement(By.xpath("//select[contains(@id, 'ctl00_mainContent_DropDownListCurrency')]"));
		select = new Select(dropDown);

		select.selectByIndex(1);
		Thread.sleep(3000);

		select.selectByValue("AED");
		Thread.sleep(3000);

		select.selectByVisibleText("USD");
		Thread.sleep(3000);

		// select passengers

		driver.findElement(By.xpath("//div[contains(@id, 'divpaxinfo')]")).click();
		WebElement dropDownadult = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Adult\"]"));
		select = new Select(dropDownadult);
		select.selectByValue("2");
		Thread.sleep(4000);

		WebElement dropDownChild = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Child\"]"));
		select = new Select(dropDownChild);
		select.selectByIndex(4);
		Thread.sleep(4000);

		WebElement dropDownInfant = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Infant\"]"));
		select = new Select(dropDownInfant);
		select.selectByVisibleText("2");
		Thread.sleep(4000);

	}

	@Test(priority = 1)
	public void test2() throws InterruptedException {
		WebElement fromDropDown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		WebElement toDropDown = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		fromDropDown.clear();
		fromDropDown.sendKeys("IDR");
		Thread.sleep(2000);
		toDropDown.clear();
		toDropDown.sendKeys("AMD");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[1]/li[3]/a")).click();

		// calendar
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Div1\"]/button")).click();
		// to
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[6]/td[2]/a")).click();

	}

}
