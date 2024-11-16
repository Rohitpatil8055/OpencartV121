package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{
@Test(groups = {"Sanity","Master"})
public void verify()
{
	logger.info("******Starting TC002_LoginTest *********");
	
	try
	{
		
	Homepage hp=new Homepage(driver);
	hp.ClickonMyAccount();
	hp.clickonlogin();
	
	Loginpage lp=new Loginpage(driver);
	lp.Enteruser(p.getProperty("email"));
	lp.Enterpass(p.getProperty("password"));
	lp.Clicklogin();
	
	MyAccountPage Ac=new MyAccountPage(driver);
	boolean targetpage= Ac.isMyAccountPageExits();
	
		//Assert.assertEquals(targetpage, true,"Login failed");	
	Assert.assertTrue(targetpage);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("******Starting TC002_LoginTest *********");
}
	
	
	
	

}
