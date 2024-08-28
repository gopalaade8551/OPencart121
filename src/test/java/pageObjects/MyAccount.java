package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends Basepage {
	
	WebDriver driver;
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myacc;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout_btn;
	
	
	//Action Methods
	
	public Boolean getmyacc()
	{
		Boolean acc=myacc.isDisplayed();
		return acc;
	}
	public void logout()
	{
		logout_btn.click();
	}

}
