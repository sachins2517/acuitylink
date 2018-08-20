package demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.Constants;
import utility.ExcelUtils;

public class Renew_request {
	  
	  WebDriver driver;
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  
		  	System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"RA");
	  }

	  @Test
	  public void testRenew() throws Exception {
	    
		  driver.get(Constants.URL);
		  driver.findElement(By.id("email")).clear();
		  driver.findElement(By.id("email")).sendKeys("hitest2@grr.la");
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys("Btc@12345");
		  driver.findElement(By.id("loginBtnId")).click();
	    
		  driver.findElement(By.xpath("//li[@id='serviceRequestsLiId']//a[@class='dropdown-toggle']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Past Requests")).click();
		  
	  }
}
