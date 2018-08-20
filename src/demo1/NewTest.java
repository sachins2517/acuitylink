package demo1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	
  @Test
  public void servicerequest() throws InterruptedException {
	  	/*driver.get("https://www.facebook.com");
		WebElement ele = driver.findElement(By.id("day"));
		Select s = new Select (ele);
		s.selectByIndex(25);*/
	  	WebDriverWait w = new WebDriverWait(driver,15);
	  	
	  	driver.get("https://uat.acuity-link.com/acuityLink");
	  	driver.findElement(By.id("email")).sendKeys("hitest2@grr.la");
	    driver.findElement(By.id("password")).sendKeys("Btc@12345");
	    driver.findElement(By.id("loginBtnId")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.id("createSRId")));
	  	
	    driver.findElement(By.xpath("//div/ul[2]/li[3]")).click();
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul[2]/li[3]/ul/li[3]")));
	    WebElement e = driver.findElement(By.xpath("//div/ul[2]/li[3]/ul/li[4]"));
	    e.click();
	    
	    
	    
	    Thread.sleep(5000);
	    
	    /*
	  	driver.findElement(By.xpath("//div/ul[2]/li[5]/button[@id='createSRId']")).click();
	    //driver.findElement(By.id("createSRId")).click(); //button[@id='createSRId']
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sf1']/fieldset/div[2]/div/div/button/span")));
	    
	    WebElement el = driver.findElement(By.xpath("//div[@id='sf1']/fieldset/div[2]/div/div/button/span"));
	    el.click();
	    
	    WebElement el1 = driver.findElement(By.xpath("//div[@id='sf1']/fieldset/div[2]/div[2]/div/button/span"));
	    el1.click();
	    
	    //Select s = new Select(el);
	    //s.selectByIndex(4);
	    
	    /*driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Wheelchair Transport')]")).click();
	    driver.findElement(By.id("srDivId1")).click();*/
	  
		
  }

  @BeforeTest
  public void beforeTest() {
	  	System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().fullscreen();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  
}



