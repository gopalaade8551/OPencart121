package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Basepage{

	WebDriver driver;
	public  RegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname_txt;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement laststname_txt;
	@FindBy(xpath="//input[@id='input-email']") WebElement email_txt;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone_txt;
	@FindBy(xpath="//input[@id='input-password']") WebElement password_txt;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmpasswd_txt;
	@FindBy(xpath="//input[@name='agree']") WebElement privacy_btn;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_btn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	//Actions Methods
	
	public void setfirstname(String firstname)
	{
		firstname_txt.sendKeys(firstname);
	}
	
	public void setlasttname(String lastname)
	{
		laststname_txt.sendKeys(lastname);
	}
	
	public void setmail(String email)
	{
		email_txt.sendKeys(email);
	}
	public void settelephone(String telephone)
	{
		telephone_txt.sendKeys(telephone);
	}
	public void setpassword(String password)
	{
		password_txt.sendKeys(password);
	}
	public void setconfirmpasswd(String confirmpasswd)
	{
		confirmpasswd_txt.sendKeys(confirmpasswd);
	}
	public void privacy_policy()
	{
		privacy_btn.click();
	}
	public void continue_click()
	{
		continue_btn.click();
	}
	public String getconfirmationmsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	

}
