package test.java;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import utility.Constants;
import utility.ExcelUtils;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ASPScenario extends HIScenario{
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  	System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"RA");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testASPScenario() throws Exception {
	  
	  String email = ExcelUtils.getCellData(9, 0);
	  String pwd = ExcelUtils.getCellData(9, 1);
	  String unit = ExcelUtils.getCellData(9, 2);
	  String capability = ExcelUtils.getCellData(9, 3);
	  String noplate = ExcelUtils.getCellData(9, 4);
	  String fname = ExcelUtils.getCellData(9, 5);
	  String lname = ExcelUtils.getCellData(9, 6);
	  String email1 = ExcelUtils.getCellData(9, 7);
	  String phno = ExcelUtils.getCellData(9, 8);
	  String carrier = ExcelUtils.getCellData(9, 9);
	  String licence = ExcelUtils.getCellData(9, 10);
	  String level = ExcelUtils.getCellData(9, 11);
	  String unit1 = ExcelUtils.getCellData(9, 12);
	  String sdate = ExcelUtils.getCellData(9, 13);
	  String time = ExcelUtils.getCellData(9, 14);
	  String edate = ExcelUtils.getCellData(9, 15);
	  String time1 = ExcelUtils.getCellData(9, 16);
	  //String pending = ExcelUtils.getCellData(9, 17);
	  
    driver.get(Constants.URL);
    driver.manage().window().maximize();
    
    /*driver.findElement(By.name("accessCode")).clear();
    driver.findElement(By.name("accessCode")).sendKeys("ihD6aQ");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Sachin@123");
    driver.findElement(By.id("cfnPassword")).click();
    driver.findElement(By.id("cfnPassword")).clear();
    driver.findElement(By.id("cfnPassword")).sendKeys("Sachin@123");
    driver.findElement(By.id("resetPasswordBut")).click();
    */
    
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(pwd);
    driver.findElement(By.id("loginBtnId")).click();
    
    driver.findElement(By.id("aspManageVeh")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("unitNum")).click();
    driver.findElement(By.id("unitNum")).clear();
    driver.findElement(By.id("unitNum")).sendKeys(unit);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//form[@id='createAmbulanceFormId']/div/div/div[2]/div/button/span")).click();
    driver.findElement(By.xpath("//form[@id='createAmbulanceFormId']/div/div/div[2]/div/div/ul/li[2]/a/span")).click();
    new Select(driver.findElement(By.id("capability"))).selectByVisibleText(capability);
    Thread.sleep(2000);
    driver.findElement(By.id("vehilePlateNumber")).click();
    driver.findElement(By.id("vehilePlateNumber")).clear();
    driver.findElement(By.id("vehilePlateNumber")).sendKeys(noplate);
    Thread.sleep(2000);
    driver.findElement(By.id("createId")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("aspManageCrew")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.id("firstName")).sendKeys(fname);
    driver.findElement(By.id("lastName")).sendKeys(lname);
    Thread.sleep(2000);
    driver.findElement(By.id("email")).sendKeys(email1);
    Thread.sleep(2000);
    driver.findElement(By.id("phoneNumber")).sendKeys(phno);
    driver.findElement(By.id("phoneCarrier")).sendKeys(carrier);
    driver.findElement(By.id("memberLicense")).sendKeys(licence);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//form[@id='addOrUpdateCrewMemebersForm']/div/div/div/div[7]/div/button/span")).click();
    driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Paramedic')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("submitId")).click();
    //new Select(driver.findElement(By.id("certificationLevel"))).selectByVisibleText(level);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//a[@href='#'][contains(text(),'PA64')]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Assign Vehicle')]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Vehicle')]")).click();
    Thread.sleep(5000);
    driver.findElement(By.linkText("WCT")).click();
    //new Select(driver.findElement(By.id("ambulanceValue"))).selectByVisibleText(unit1);
    driver.findElement(By.id("startTimePicker")).click();
   // driver.findElement(By.id("startTimePicker")).clear();
    //driver.findElement(By.id("startTimePicker")).sendKeys(sdate, time);
    Thread.sleep(5000);
    driver.findElement(By.id("endTimePicker")).click();
    driver.findElement(By.id("endTimePicker")).clear();
    driver.findElement(By.id("endTimePicker")).sendKeys(edate, time1);
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 marT10']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[@id='submit']")).click();
    Thread.sleep(5000);
    driver.findElement(By.linkText("Requests")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("aspPendingReq")).click();
    Thread.sleep(2000);
    System.out.println("Text is: "+HIScenario.e);
    driver.findElement(By.linkText(HIScenario.e)).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class = 'btn aq-btn ']")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("Requests")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("aspActiveReq")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText(HIScenario.e)).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Assign Vehicle')]")).click();
    /*driver.findElement(By.id("aspRequest_"+pending)).click();
    /driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();*/
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@class = 'btn aq-btn aq-btn-sm padL10 padR10 txtcenter']")).click();
    //driver.findElement(By.id("//button[@id='75_serAmbuId']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@id='backToActiveAsp']/img")).click();
    
    //Logout
    driver.findElement(By.xpath("//li[@class='dropdown marL20 userLi']//a[@class='dropdown-toggle']")).click(); //driver.findElement(By.linkText("Admin")).click();
    driver.findElement(By.linkText("Logout")).click();
    
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
