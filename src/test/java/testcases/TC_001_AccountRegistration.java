package testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.Homepage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	
	@Test(groups= {"Regression","Master"})
	public void Registration() throws InterruptedException
	{
		
		
		logger.info("Starting TC_001_AccountRegistration");
		try {
		
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		logger.info("clicked on My Account link");
		Thread.sleep(3000);
		hp.clickregister();
		logger.info("clicked on register link");
		Thread.sleep(3000);
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("providing customer details");
		rp.setfirstname(RandomName());
		rp.setlasttname(RandomName());
		rp.setmail(RandomName()+"@gmail.com");
		rp.settelephone(Randomnum());
		String password=passwdgenerate();
		rp.setpassword(password);
		rp.setconfirmpasswd(password);
		rp.privacy_policy();
		rp.continue_click();
		logger.info("Validating expected message");
		String exp_msg=rp.getconfirmationmsg();
		if(exp_msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
			
		}
		
		
			
	}
	catch(Exception e)
	{
		
		Assert.fail();
	}
		
		logger.info("Finished Starting TC_001_AccountRegistration ");
	}
	
	
	}
	
	
	
	
	


