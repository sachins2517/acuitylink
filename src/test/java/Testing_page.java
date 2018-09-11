package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclassesHI.Dashboard;

public class Testing_page {
	private WebDriver driver;
	private String baseUrl;
	Dashboard d;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://uat.acuity-link.com/acuityLink";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void test() {
		driver.findElement(By.id("email")).sendKeys("hitest2@grr.la");
		driver.findElement(By.id("password")).sendKeys("Abc@1234");
		driver.findElement(By.id("loginBtnId")).click();
		WebElement e = driver.findElement(By.id("createSRId"));
		System.out.println("Element found is: "+e);
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(e));*/
		while(true)
		{
			d.clickreport();
			break;
		}
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
	
}
