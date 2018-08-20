package demo1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import utility.Constants;
import utility.ExcelUtils;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class SignupASP {
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
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
  }

  @Test
  public void testSignupASP() throws Exception {
	
	  driver.get(Constants.URL);
	  String Name = ExcelUtils.getCellData(1, 10);
	  String type = ExcelUtils.getCellData(1, 11);
	  String type1 = ExcelUtils.getCellData(1, 12);
	  String type2 = ExcelUtils.getCellData(1, 13);
	  String type3 = ExcelUtils.getCellData(1, 14);
	 
	  String street = ExcelUtils.getCellData(1, 15);
	  String zip = ExcelUtils.getCellData(1, 16);
	  String licence = ExcelUtils.getCellData(1, 17);
	  String fname = ExcelUtils.getCellData(1, 18);
	  String lname = ExcelUtils.getCellData(1, 19);
	  String email = ExcelUtils.getCellData(1, 20);
	  String phno = ExcelUtils.getCellData(1, 21);
	  //String fax = ExcelUtils.getCellData(1, 22);
	
    driver.findElement(By.xpath("(//button[@id=''])[2]")).click();
    driver.findElement(By.name("aspName")).clear();
    driver.findElement(By.name("aspName")).sendKeys(Name);
    driver.findElement(By.name("aspName")).sendKeys(Keys.TAB);
    Thread.sleep(10000);
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/button/span")).click();
  
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li/a/span")).click();
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li[2]/a/span")).click();
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li[3]/a/span")).click();
    driver.findElement(By.xpath("//form[@id='aspRegistrationForm']/div/div[2]/div/div/ul/li[4]/a/span")).click();
    Thread.sleep(10000);
    driver.findElement(By.id("streetAddress")).click();
    driver.findElement(By.id("streetAddress")).clear();
    driver.findElement(By.id("streetAddress")).sendKeys(street);
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys(zip);
    driver.findElement(By.name("aspLicenseNumber")).click();
    driver.findElement(By.name("aspLicenseNumber")).clear();
    driver.findElement(By.name("aspLicenseNumber")).sendKeys(licence);
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys(fname);
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys(lname);
    Thread.sleep(10000);
    driver.findElement(By.xpath("(//input[@name='userEmail'])[2]")).sendKeys(email);
    driver.findElement(By.name("phoneNumber")).clear();
    driver.findElement(By.name("phoneNumber")).sendKeys(phno);
    Thread.sleep(5000);
    driver.findElement(By.id("aspSubmit")).click();
    
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
