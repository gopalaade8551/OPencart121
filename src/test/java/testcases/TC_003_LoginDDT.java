package testcases;

import org.testng.Assert;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.Dataprovider;


/*data is valid--login success--test pass----logout
                 login unsuccess--test fail
                 
  data is invalid--login success--testfail---logout
                   login unsucess---testpass        
  
*/

public class TC_003_LoginDDT extends BaseClass {
	
		
	@Test( dataProvider="Logindata", dataProviderClass=Dataprovider.class   )
	public void LoginDDT(String email,String password,String exp)
	{
		
		logger.info("**** TC_002_Login   ***********");
		
		
		
		try {
		
	//Home page
		Homepage hp=new Homepage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
	    
	    
	    //Login page
	    Loginpage lp=new Loginpage(driver);
	    lp.setemail(email);
	    lp.setpassword(password);
	    lp.clicklogin();
	    
	    //My Account
	    MyAccount myacc=new MyAccount(driver);
	    boolean targetpage=myacc.getmyacc();
	    if(exp.equalsIgnoreCase("Valid"))
	    {
	    	if(targetpage==true)
	    	{
	    		myacc.logout();
	    		Assert.assertTrue(true);
	    		
	    		
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    		Thread.sleep(3000);
	    	}
	    	
	    }
	  
	    
	    if(exp.equalsIgnoreCase("Invalid"))
	    {
	    	if(targetpage==true)
	    	{
	    		myacc.logout();
	    		Assert.assertTrue(false);
	    		
	    	}
	    	else
	    	{
	    		Assert.assertTrue(true);
	    		Thread.sleep(3000);
	    	}
	    	
	    }
		
		
		
		}
		
		catch(Exception e)
		{
					Assert.fail();
		}
	
	    logger.info("****Finished TC_003 Login_ddt");
	    		
	   


		}
}



		
	
		
	
	
	

