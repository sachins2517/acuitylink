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

public class HIScenario {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String e;
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  	System.setProperty("webdriver.chrome.driver", "//Users//sachin//Desktop//selenium//chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().fullscreen();
	    ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"RA");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHIScenario() throws Exception {
    
	  driver.get(Constants.URL);
	  //String password = ExcelUtils.getCellData(5, 0);
	  //String cnfpassword = ExcelUtils.getCellData(5, 1);
	  String email = ExcelUtils.getCellData(5, 2);
	  String pwd = ExcelUtils.getCellData(5, 3);
	  String building = ExcelUtils.getCellData(5, 4);
	  String lobby = ExcelUtils.getCellData(5, 5);
	  String floor = ExcelUtils.getCellData(5, 6);
	  String unit = ExcelUtils.getCellData(5, 7);
	  String phno = ExcelUtils.getCellData(5, 8);
	  String faxno = ExcelUtils.getCellData(5, 9);
	  
	  String level = ExcelUtils.getCellData(5, 10);
	  String fname = ExcelUtils.getCellData(5, 11);
	  String lname = ExcelUtils.getCellData(5, 12);
	  String dob = ExcelUtils.getCellData(5, 13);
	  String gender = ExcelUtils.getCellData(5, 14);
	  String phno1 = ExcelUtils.getCellData(5, 15);
	  String wt = ExcelUtils.getCellData(5, 16);
	  String unit1 = ExcelUtils.getCellData(5, 17);
	  String comments = ExcelUtils.getCellData(5, 18);
	  String room1 = ExcelUtils.getCellData(5, 20);
	  String prefered = ExcelUtils.getCellData(5, 19);
	  String room2 = ExcelUtils.getCellData(5, 21);
	  String clinician = ExcelUtils.getCellData(5, 22);
	  String response = ExcelUtils.getCellData(5, 23);
	  
    /*driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("cfnPassword")).clear();
    driver.findElement(By.id("cfnPassword")).sendKeys(cnfpassword);
    driver.findElement(By.id("resetPasswordBut")).click();*/
    
	driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(pwd);
    driver.findElement(By.id("loginBtnId")).click();
    Thread.sleep(5000);
    
    driver.findElement(By.xpath("//img[@src='/acuityLink/images/avatar.png']")).click(); //driver.findElement(By.linkText("Admin")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("profile")).click(); //a[@id='profile']
    Thread.sleep(5000);
    driver.findElement(By.id("buildingListId")).click(); //button[@id='buildingListId']
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Add Building')]")).click();   //(//button[@type='button'])[3]
    
    driver.findElement(By.id("buildingName")).click(); 
    driver.findElement(By.id("buildingName")).clear();
    driver.findElement(By.id("buildingName")).sendKeys(building); //input[@id='buildingName']
    Thread.sleep(5000);
    driver.findElement(By.id("addUpdateLobbyId")).click();  //button[@id='addUpdateLobbyId']
    Thread.sleep(5000);
    driver.findElement(By.id("lobbyName")).click();
    driver.findElement(By.id("lobbyName")).clear();
    driver.findElement(By.id("lobbyName")).sendKeys(lobby);  //input[@id='lobbyName']
    driver.findElement(By.id("addLobbyBtn")).click(); //button[@id='addLobbyBtn']
    Thread.sleep(6000);
    
    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Add Floor')]")).click();
    Thread.sleep(6000);
    driver.findElement(By.id("floors")).click();
    driver.findElement(By.id("floors")).clear();
    driver.findElement(By.id("floors")).sendKeys(floor); //input[@id='floors']
    
    driver.findElement(By.id("unitName")).click();
    driver.findElement(By.id("unitName")).clear();
    driver.findElement(By.id("unitName")).sendKeys(unit); //input[@id='unitName']
    
    driver.findElement(By.id("phoneNumber")).click();
    driver.findElement(By.id("phoneNumber")).clear();
    driver.findElement(By.id("phoneNumber")).sendKeys(phno); //input[@id='phoneNumber']
    
    driver.findElement(By.id("faxNumber")).click();
    driver.findElement(By.id("faxNumber")).clear();
    driver.findElement(By.id("faxNumber")).sendKeys(faxno);  //input[@id='faxNumber']
    
    
    driver.findElement(By.id("addFloorBtn")).click(); //button[@id='addFloorBtn']
    Thread.sleep(5000);
    
        
    driver.findElement(By.id("saveOrUpdateBtn")).click(); //button[@id='saveOrUpdateBtn']
    Thread.sleep(5000);
  
  // remove after regression driver.findElement(By.xpath("//li[@id='manageASPAndPriority']//a[@class='dropdown-toggle']")).click(); //driver.findElement(By.linkText("ASPs & Configuration")).click(); 
    /*driver.findElement(By.id("hiASPByHI")).click(); //a[@id='hiASPByHI']
    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Add Existing ASP')]")).click(); //driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
    Thread.sleep(5000);
       
    //driver.findElement(By.xpath("//a[contains(@class,'paginate_button')][contains(text(),'1')]")).click(); //driver.findElement(By.linkText("2")).click();
    //driver.findElement(By.xpath("//a[contains(@class,'paginate_button')][contains(text(),'2')]")).click(); //driver.findElement(By.linkText("3")).click();
 
    driver.findElement(By.xpath("//a[contains(@class,'paginate_button')][contains(text(),'3')]")).click();
    Thread.sleep(5000);
 
    driver.findElement(By.xpath("//a[@href='javascript:void(0)'][contains(text(),'Bug ASP 1')]")).click();
    //tr[@id='840']//td[@class='txtright']//button[@type='button']
    Thread.sleep(5000);

    driver.findElement(By.xpath("//button[@id='aspAdd']")).click();
    Thread.sleep(6000);*/ //temp remove after doin your work
    
    driver.findElement(By.id("createSRId")).click(); //button[@id='createSRId']
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[@id='sf1']/fieldset/div[2]/div/div/button/span")).click();
    
    driver.findElement(By.xpath("//span[@class='text'][contains(text(),'Wheelchair Transport')]")).click();
    driver.findElement(By.id("srDivId1")).click();
    
    driver.findElement(By.id("patientFirstName")).clear();
    driver.findElement(By.id("patientFirstName")).sendKeys(fname);
    driver.findElement(By.id("patientLastName")).clear();
    driver.findElement(By.id("patientLastName")).sendKeys(lname);
    Thread.sleep(3000);
    driver.findElement(By.id("patientDob")).sendKeys(dob);
    
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Choose Gender')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText(gender)).click();
    Thread.sleep(5000);
    driver.findElement(By.id("patientPhoneNumber")).sendKeys(phno1);
    driver.findElement(By.id("patientWeight")).sendKeys(wt);
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Pounds')]")).click();
    Thread.sleep(5000);
    driver.findElement(By.linkText(unit1)).click();

    driver.findElement(By.id("clinicalComment")).click();
    driver.findElement(By.id("clinicalComment")).sendKeys(comments);

    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Building')]")).click();     //div[@id='sf2']/fieldset/div[4]/div[3]/div[4]/div/button/span
    Thread.sleep(3000);
    driver.findElement(By.linkText("Building 1")).click(); //div[@class='btn-group bootstrap-select aq-select aq-select-form open']//div[@class='dropdown-menu open']//ul[@class='dropdown-menu inner']//li[@data-original-index='1']//a[@tabindex='0']
    
    driver.findElement(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 boxWhite padB10']/div[5]/div[1]/button[1]/span[1]")).click();   //div[@id='sf2']/fieldset/div[4]/div[3]/div[5]/div/button/span
    Thread.sleep(3000);
    driver.findElement(By.linkText("Lobby 1")).click();
        
    //new Select(driver.findElement(By.id("puLobbyNameTemp0"))).selectByVisibleText("Lobby 1");
    
    driver.findElement(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 boxWhite padB10']/div[7]/div[1]/button[1]/span[1]")).click();    // (//button[@type='button'])[13]
    Thread.sleep(3000);
    driver.findElement(By.linkText("Floor 1")).click();
    
    driver.findElement(By.xpath("//html//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 boxWhite padB10']/div[8]/div[1]/button[1]/span[1]")).click();   //div[@id='sf2']/fieldset/div[4]/div[3]/div[8]/div/button/span
    Thread.sleep(3000);
    driver.findElement(By.linkText("Unit 1")).click();
 
   
    driver.findElement(By.id("puRoomNumber0")).click();
    driver.findElement(By.id("puRoomNumber0")).clear();
    driver.findElement(By.id("puRoomNumber0")).sendKeys(room1);
    
    Thread.sleep(3000);    
    
    driver.findElement(By.id("preferredServiceData0")).click();
    driver.findElement(By.id("preferredServiceData0")).sendKeys(prefered);
    Thread.sleep(4000);
    driver.findElement(By.id("searchId0")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("searchId0")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.id("searchId0")).click();
    driver.findElement(By.id("searchId0")).clear();
    driver.findElement(By.id("searchId0")).sendKeys("pu");
    Thread.sleep(4000);
    driver.findElement(By.id("searchId0")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("searchId0")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[4]/div/button/span")).click();
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[4]/div/div/ul/li[2]/a")).click();
    new Select(driver.findElement(By.id("destBuildingNameTemp0"))).selectByVisibleText("Building A");
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[5]/div/button/span")).click();
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[5]/div/div/ul/li[3]/a")).click();
    new Select(driver.findElement(By.id("destLobbyNameTemp0"))).selectByVisibleText("Entrance");
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[7]/div/button/span")).click();
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[7]/div/div/ul/li[2]/a")).click();
    new Select(driver.findElement(By.id("destFloorNumber0"))).selectByVisibleText("G Floor");
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[8]/div/button/span")).click();
    driver.findElement(By.xpath("//div[@id='acuityHiDivId0']/div[8]/div/div/ul/li[2]/a")).click();
    new Select(driver.findElement(By.id("destUnitNumberTemp0"))).selectByVisibleText("G1");
    Thread.sleep(3000);
    
    driver.findElement(By.id("destRoomNumber0")).click();
    driver.findElement(By.id("destRoomNumber0")).clear();
    driver.findElement(By.id("destRoomNumber0")).sendKeys(room2);
    
    driver.findElement(By.id("destReceivingClinician0")).click();
    driver.findElement(By.id("destReceivingClinician0")).clear();
    driver.findElement(By.id("destReceivingClinician0")).sendKeys(clinician);
    Thread.sleep(3000);
    
    /*driver.findElement(By.xpath("//div[@id='sirenDivId']/label")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[39]")).click();
    driver.findElement(By.xpath("//div[@id='acceptableResponseTimeDivId']/div[2]/div/div/button/span")).click();
    driver.findElement(By.xpath("//div[@id='acceptableResponseTimeDivId']/div[2]/div/div/div/ul/li[3]/a/span")).click();
    new Select(driver.findElement(By.id("acceptableResponseTime0"))).selectByVisibleText(response); */
    
    driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(text(),'Select Response Time')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText(response)).click();
    
    driver.findElement(By.id("srDivId2")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("submitRequestButtonId")).click();
    Thread.sleep(5000);
        
    driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
    Thread.sleep(1000);
    //driver.findElement(By.linkText("Pending Requests")).click();
    driver.findElement(By.xpath("//a[@id='0']")).click();
    Thread.sleep(5000);
    e = driver.findElement(By.xpath("//span[@id='customRequestId']")).getText();
    System.out.println("Text is: "+e);
    
    //driver.findElement(By.xpath("//button[@type='button'][contains(text(),'×')]")).click();
    //Thread.sleep(2000);  
    	//driver.findElement(By.xpath("//img[@src='/acuityLink/images/avatar.png']")).click(); //driver.findElement(By.linkText("Admin")).click();
    //Thread.sleep(2000);
    //driver.findElement(By.linkText("Logout")).click();
 }

 /*@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }*/

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
