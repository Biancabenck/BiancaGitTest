package BIanca;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newWindow {
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

	public void test() {
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[1]/div/a")).click();
System.out.println("before"+driver.getTitle());


Set <String> w = driver.getWindowHandles();
Iterator <String> iterator = w.iterator();

String parentW = iterator.next();
String child1W = iterator.next();
String child2W = iterator.next();
String child3W = iterator.next();

System.out.println("PARENT " +parentW);
System.out.println("CHILD "+child1W);

driver.switchTo().window(child1W);

System.out.println("Title of child1 is " +driver.getTitle());

System.out.println("-------");

driver.switchTo().window(child2W);

System.out.println("Title of child2 is " +driver.getTitle());

System.out.println("-------");
driver.switchTo().window(child3W);

System.out.println("Title of child3 is " +driver.getTitle());

driver.switchTo().window(parentW);

System.out.println("back to parent window" +parentW);




	}

}
