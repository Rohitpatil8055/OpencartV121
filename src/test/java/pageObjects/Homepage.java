package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage
{
	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath=("//span[normalize-space()='My Account']"))
	WebElement lnkMyAccount;
	
	@FindBy(xpath=("//a[normalize-space()='Register']"))
	WebElement lnkRegister;
	
	@FindBy(xpath=("//a[normalize-space()='Login']"))
	WebElement lnklogin;

	public void ClickonMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void CLickonRegister()
	{
		lnkRegister.click();
	}
	
	public void clickonlogin() 
	{
		lnklogin.click();
	}
}
