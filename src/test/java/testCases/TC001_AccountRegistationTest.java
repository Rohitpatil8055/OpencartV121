package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		
		
		logger.info("**** Starting TC001_AccountRegistationTest*****");
		
		try
		{
		Homepage hp=new Homepage(driver);
		 
	    hp.ClickonMyAccount();
	    
	    logger.info("**** ClickonMyAccount*****");
	    
	    hp.CLickonRegister();
	    logger.info("**** CLickonRegister*****");
	    
	    AccountRegistationPage ar=new AccountRegistationPage(driver);
	    
	    logger.info("**** Providing customer detail*****");
	    
	    ar.set_Firstname(randomdata().toUpperCase());
	    ar.set_lastname(randomdata().toUpperCase());
	    ar.set_Email(randomdata()+"@gmail.com");
	    ar.set_Telephone(randomnum());
	    
	   String Password= randomalphanumiric();
	    ar.set_Password(Password);
	    ar.set_confirmPassword(Password);
	    ar.checkpolicy();
	    ar.btn_continue();
	    
	    logger.info("**** Validating Expected msg*****");
	   String confirmationmsg= ar.getconfirmationMsg();
	   
	   Assert.assertEquals(confirmationmsg, "Your Account Has Been Created!");
	   
	}
	catch(Exception e)
		{
		logger.error("**** Test Failed..*****");
		logger.debug("**** debug log*****");
		Assert.fail();
		}
	
		logger.info("**** Finished tc*****");
	}
	
}
