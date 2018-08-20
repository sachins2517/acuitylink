package pageclassesHI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AspConfig {
	
	@FindBy(xpath="//button[contains(text(),'Add New ASP')]")
	WebElement addNewASP; 
	
	@FindBy(xpath="//button[contains(text(),'Add Existing ASP')]")
	WebElement addExistingASP;
	
	@FindBy(xpath="//a[@title='ASP Test']")
	WebElement detailASP;
	
	@FindBy(xpath="//div[contains(@class,'col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 topContentHead')]//div[2]//div[1]//div[2]//button[1]")
	WebElement addExclusiveASP;
	
	@FindBy(xpath="////div[contains(@class,'col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 topContentHead')]//div[contains(@class,'col-lg-12 col-md-12 col-sm-12 col-xs-12')]//div[3]//button[1]")
	WebElement addCustomASP;
	
	
	@FindBy(xpath="//button[contains(text(),'Set % of Allotment')]")
	WebElement addCustomPercentageASP;
	

	@FindBy(xpath="//div[contains(@class,'col-lg-12 col-md-12 col-sm-12 col-xs-12 pad0 topContentHead')]//div[4]//div[1]//div[2]//button[1]")
	WebElement addEvenOrder;
	
	@FindBy(xpath="//div[@id='orderRotation_wrapper']//tbody//tr[1]//td[5]//button[1]")
	WebElement removeASP;
	
	
	public void addNewASP() {
		addNewASP.click();
	}
	
	public void addExistingASP() {
		addExistingASP.click();
	}
	
	public void detailASP() {
		detailASP.click();
	}
	
	public void addASP() {
		addExclusiveASP.click();
	}
	
	public void addCustomASP() {
		addCustomASP.click();
	}
	
	public void addCustomPercentageASP() {
		addCustomPercentageASP.click();
	}
	
	public void addEvenOrder()
	{
		addEvenOrder.click();
	}
	
	public void removeASP()
	{
		removeASP.click();
	}
}
