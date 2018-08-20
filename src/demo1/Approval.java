package demo1;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import utility.Constants;
import utility.ExcelUtils;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Approval {
  WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"RA");
  }

  @Test
  public void testApproval() throws Exception {
    driver.get(Constants.URL);
    String HI = ExcelUtils.getCellData(1, 0);
    String ASP = ExcelUtils.getCellData(1, 10);
        
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("sachina@grr.la");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Sachin@123");
    driver.findElement(By.id("loginBtnId")).click();
   
    driver.findElement(By.linkText("Manage HI")).click();
    Thread.sleep(4000);
    driver.findElement(By.linkText("Manage Registrations")).click();
    isAlertPresent();
    Thread.sleep(5000);
    //driver.findElement(By.xpath("//html//tr[@id='1295']//button[1]")).click();
    
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(HI)));

    driver.findElement(By.linkText(HI)).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 modal-body padT0 padB0']//div[1]/button[1]")));
    driver.findElement(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 modal-body padT0 padB0']//div[1]/button[1]")).click();
    
    Thread.sleep(10000);

    driver.findElement(By.linkText("Manage ASP")).click();
    driver.findElement(By.linkText("Manage Registrations")).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ASP)));
    driver.findElement(By.linkText(ASP)).click();
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 modal-body padT0 padB0']//div[1]/button[1]")));
    driver.findElement(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 modal-body padT0 padB0']//div[1]/button[1]")).click();
    
    
    driver.findElement(By.xpath("//img[@src='/acuityLink/images/avatar.png']")).click();
  //li[@class='dropdown marL20 userLi']//a[@class='dropdown-toggle']
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

/*List<WebElement> d = driver.findElements(By.xpath("//div[@class='aq-wrapper']"));
int size = d.size();
String stext = "Achin HI";
System.out.println("Size of the list is: "+size);
for(int i=0; i<size; i++)
{
		System.out.println(d.get(i).getText());    		
	}
Thread.sleep(20000);
for(WebElement result: d)
		if(result.getText().equals(stext)) {
			result.click();
		}*/
