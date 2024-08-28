package testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	
	
	@Test(groups= {"Sanity","Master"})
	public void TestLogin()
	{
		
		logger.info("**** TC_002_Login   ***********");
		try
		{
		
	//Home page
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
	    hp.clicklogin();
	    
	    
	    //Login page
	    Loginpage lp=new Loginpage(driver);
	    lp.setemail(p.getProperty("email"));
	    lp.setpassword(p.getProperty("password"));
	    lp.clicklogin();
	    
	    //My Account
	    MyAccount myacc=new MyAccount(driver);
	    boolean targetpage=myacc.getmyacc();
	    Assert.assertTrue(true);
	    
	    myacc.logout();
		}
	
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC_002_Login  *** ");
	    
	  }

}
