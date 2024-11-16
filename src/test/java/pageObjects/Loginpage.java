package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {


	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath=("//input[@id='input-email']"))
	WebElement EnterEmail;
	
	@FindBy(xpath=("//input[@id='input-password']"))
	WebElement EnterPass;
	
	@FindBy(xpath=("//input[@value='Login']"))
	WebElement clickonlogin;
	
	public void Enteruser(String email)
	{
		EnterEmail.sendKeys(email);
	}
	
	public void Enterpass(String pass)
	{
		EnterPass.sendKeys(pass);
	}
	
	
	public void Clicklogin()
	{
		clickonlogin.click();
	}
	
	
	
	
	
}
