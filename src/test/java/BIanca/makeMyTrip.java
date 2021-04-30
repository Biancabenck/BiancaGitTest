package BIanca;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTrip {
	WebDriver driver;
	@BeforeTest
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/?ccde=us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws InterruptedException {
	WebElement fromcity = driver.findElement(By.id("fromCity"));
	fromcity.click();
	fromcity.sendKeys("BKK");
		Thread.sleep(3000);
		
		 List<WebElement> list = driver.findElements(By.xpath("//*[@id='react-autowhatever-1']/div/ul/li"));
		 
		for (WebElement webElement : list) {
			String elementText = webElement.getText();
			
			if(elementText.contains("BKK")) {	
				webElement.click();
			}
		
		}
		 
		 
	}
	

}
