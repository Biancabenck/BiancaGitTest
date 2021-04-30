package BIanca;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClass_example {
	WebDriver driver;
	Actions action;
	@BeforeTest
	
	public void open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/dragabble");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
	}
	
	@Test
	public void actionclass_droppable() {
		WebElement draggable = driver.findElement(By.id("draggable"));
	//	WebElement droppable = driver.findElement(By.id("droppable"));
		
		
		action = new Actions(driver);
		
		action.dragAndDropBy(draggable,200,400);
		
		
	}
	

}
