package pageclassesHI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Requests_HI {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='col-lg-4 col-md-6 col-sm-12 col-xs-12 pad0']//input[@placeholder='Search']")
	WebElement search;
	
	@FindBy()
	WebElement s;
	
	
	public Requests_HI(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void search(String rid) {
		search.sendKeys(rid);
	}
}
