package demo1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
	
	static {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
	}
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("https://www.trivago.in/");
	driver.findElement(By.id("horus-querytext")).sendKeys("b");
	String s = "//mark[contains(text(),'B')]";
	List<WebElement> list = driver.findElements(By.xpath(s));
	System.out.println("Size: "+list.size());
	for(WebElement e: list) {
		System.out.println(e.getText());
		}
	list.get(0).click();
	}
}
