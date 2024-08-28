package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {
	
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']") WebElement username_txt;
	@FindBy(xpath="//input[@id='input-password']") WebElement passwd_txt;
	@FindBy(xpath="//input[@value='Login']") WebElement login_btn;
	
	//Action Methoids
	
	public void setemail(String username)
	{
		username_txt.sendKeys(username);
	}
	
	public void setpassword(String password)
	{
		passwd_txt.sendKeys(password);
	}
	public void clicklogin()
	{
		login_btn.click();
	}
	

}
