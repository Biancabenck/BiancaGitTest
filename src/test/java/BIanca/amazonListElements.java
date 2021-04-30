package BIanca;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonListElements {
public static void main(String[] args) {
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	List<WebElement> listPhones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal"));
	
	for(int i = 0; i <=listPhones.size(); i ++) {
		WebElement phonesNames = listPhones.get(i);
		String phones = phonesNames.getText();
		if(phones.contains("Samsung")) {
			System.out.println(i + " - " +phones);
		}else {
			System.out.println("FAILED");
		}
	}
	
}
}
