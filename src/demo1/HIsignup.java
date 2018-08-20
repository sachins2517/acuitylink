package demo1;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import utility.Constants;
import utility.ExcelUtils;

import static org.testng.Assert.*;

import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HIsignup {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"RA");

  }

  @Test
  public void testSignupHI() throws Exception {
   
    driver.get(Constants.URL);
    String Name = ExcelUtils.getCellData(1, 0);
	String type = ExcelUtils.getCellData(1, 1);
    String street = ExcelUtils.getCellData(1, 2);
    String zip = ExcelUtils.getCellData(1, 3);
    String licence = ExcelUtils.getCellData(1, 4);
    String fname = ExcelUtils.getCellData(1, 5);
    String lname = ExcelUtils.getCellData(1, 6);
    String email = ExcelUtils.getCellData(1, 7);
    String phno = ExcelUtils.getCellData(1, 8);
       
    driver.findElement(By.xpath("//button[@id='']")).click();
    //driver.findElement(By.id("hiName")).click();
    //driver.findElement(By.id("hiName")).clear();
    driver.findElement(By.id("hiName")).sendKeys(Name);
    driver.findElement(By.id("hiName")).sendKeys(Keys.TAB);
    Thread.sleep(10000);   
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'-- Select Type -- *')]")).click();
       
    driver.manage().timeouts().implicitlyWait(50 ,TimeUnit.SECONDS);
    driver.findElement(By.linkText(type)).click();
   //new Select(driver.findElement(By.id("hitype"))).selectByVisibleText(type);
    driver.findElement(By.name("streetAddress")).click();
    driver.findElement(By.name("streetAddress")).clear();
    driver.findElement(By.name("streetAddress")).sendKeys(street);
    driver.findElement(By.id("hiZip")).click();
    driver.findElement(By.id("hiZip")).sendKeys(zip);
    driver.findElement(By.id("hiLicenseNumber")).clear();
    driver.findElement(By.id("hiLicenseNumber")).sendKeys(licence);
    driver.findElement(By.id("hiAdminFirstName")).clear();
    driver.findElement(By.id("hiAdminFirstName")).sendKeys(fname);
    driver.findElement(By.id("hiAdminLastName")).clear();
    driver.findElement(By.id("hiAdminLastName")).sendKeys(lname);
    //driver.findElement(By.xpath("//form[@id='hiRegistrationForm']/div[3]/div")).click();
    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
    driver.findElement(By.id("hiAdminPhoneNo")).clear();
    driver.findElement(By.id("hiAdminPhoneNo")).sendKeys(phno);
    Thread.sleep(4000);
    driver.findElement(By.id("hiSubmit")).click();
    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
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
