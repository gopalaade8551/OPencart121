package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
	
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		
		super(driver);
	}
	//locators
    @FindBy(xpath="//a[@title='My Account']") WebElement myaccountt;
    
    @FindBy(xpath="//a[normalize-space()='Register']") WebElement register;
    
    @FindBy(xpath="//a[normalize-space()='Login']") WebElement linklgin;
    
    //action methods
    
   public void  clickmyaccount()
    {
	   myaccountt.click();
    }
   public void clickregister()
   {
	   register.click();
   }
   public void clicklogin()
   {
	   linklgin.click();
   }


}
