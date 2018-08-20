package demo1;

import java.util.regex.Pattern;
import java.awt.Robot;
import java.util.Set;
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

public class Just {
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
   
	driver.get("https://uat.acuity-link.com/acuityLink");  
	driver.findElement(By.xpath("//button[@id='']")).click();
	
	/*
    driver.get("https://FSI-QA:oTkyAWlTfyQhJ9sRRVAP0c@pai-qa.thermoscientific.com/"); //To login with default credentials
    String parent = driver.getWindowHandle();
    Set child = driver.getWindowHandles();
    
    int windowsize = driver.getWindowHandles().size();
    if(windowsize>1)
    {
    		for(String windowhandle : child)
    		{
    			if(!windowhandle.equals(parent))
    			{
    				driver.switchTo().window(windowhandle);
    				driver.get("https://www.google.com");
    			}
    		}
    }*/
	  driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'-- Select Type -- *')]")).click();
	  Select s = new Select(driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'-- Select Type -- *')]")));
	  s.selectByVisibleText("Diagnostic Center");
  }
 
}