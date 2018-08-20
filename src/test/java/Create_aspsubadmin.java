package test.java;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.Constants;
import utility.ExcelUtils;

public class Create_aspsubadmin {
	  private WebDriver driver;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  public static String e;
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  	System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"RA");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testHIScenario() throws Exception {
	    
		  driver.get(Constants.URL);
		  String email = ExcelUtils.getCellData(12, 0);
		  String pwd = ExcelUtils.getCellData(12, 1);
		  String fname = ExcelUtils.getCellData(12, 2);
		  String lname = ExcelUtils.getCellData(12, 3);
		  String email1 = ExcelUtils.getCellData(12, 4);
		  String phno = ExcelUtils.getCellData(12, 5);
		  String division = ExcelUtils.getCellData(12, 6);
	    
		driver.findElement(By.id("email")).sendKeys(email);
	    driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("loginBtnId")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.id("aspUser")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("addAdmin")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("firstName")).sendKeys(fname);
	    
	    driver.findElement(By.id("lastName")).sendKeys(lname);
	    
	    driver.findElement(By.id("userEmail")).sendKeys(email1); 
	    driver.findElement(By.id("phoneNumber")).sendKeys(phno);
	    driver.findElement(By.xpath("//input[@placeholder='please type or select a division']")).sendKeys(division);
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/input[1]")).sendKeys(Keys.DOWN);
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/input[1]")).sendKeys(Keys.ENTER);
	    	Thread.sleep(1000);
	    driver.findElement(By.id("addBtn")).click();
	   
	 }

	 @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
