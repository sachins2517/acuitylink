package pageclassesHI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	WebDriver driver;
	
	@FindBy(id="patientReg")
	WebElement patientreg; 
	
	@FindBy(id="exportReport")
	WebElement report;
	
	@FindBy(id="aspFilterBut")
	WebElement filter;
	
	@FindBy(xpath="//div[@id='aspFilter']//button[@type='button'][contains(text(),'Apply')]")
	WebElement apply;
	
	@FindBy(id="reportrange")
	WebElement calenderRange;
	
	
	@FindBy(xpath="//div[contains(@class,'daterangepicker dropdown-menu ltr opensleft')]//button[contains(@type,'button')][contains(text(),'Apply')]")
	WebElement applytop5;
	
	
	@FindBy(xpath="//div[contains(@class,'daterangepicker dropdown-menu ltr opensleft')]//button[contains(@type,'button')][contains(text(),'Cancel')]")
	WebElement canceltop5;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickpatientreg()
	{
		patientreg.click();
	}
	
	public void clickreport()
	{
		report.click();
	}
	
	public void clickfilter()
	{	
		filter.click();
	}
	
	public void clickapply()
	{
		apply.click();
	}
	
	public void clickCalenderRange()
	{
		calenderRange.click();
	}
	
	public void clickApplyTop5()
	{
		applytop5.click();
	}
	
	public void clickCancelTop5()
	{
		canceltop5.click();
	}
	
	//Example for passing the values through send keys
/*	public void clickCancelTop(String dest)
	{
		applytop5.sendKeys(dest);
	}*/
}