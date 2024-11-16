package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistationPage extends BasePage
{

WebDriver driver;

public AccountRegistationPage(WebDriver driver)
{
	super(driver);
}
	
@FindBy(xpath=("//input[@id='input-firstname']"))
WebElement txt_FirstName;

@FindBy(xpath=("//input[@id='input-lastname']"))
WebElement txt_Lastname;

@FindBy(xpath=("//input[@id='input-email']"))
WebElement txt_Email;

@FindBy(xpath=("//input[@id='input-telephone']"))
WebElement txt_telephone;

//
//xpath=("//input[@id='input-confirm']")
//xpath=("//input[@id='input-telephone']")
@FindBy(xpath=("//input[@id='input-password']"))
WebElement txt_Pass;

@FindBy(xpath=("//input[@id='input-confirm']"))
WebElement txt_ConfirmPass;

@FindBy(xpath=("//input[@name='agree']"))
WebElement chkdpolicy;

@FindBy(xpath=("//input[@value='Continue']"))
WebElement btn_continue;

@FindBy(xpath=("//h1[normalize-space()='Your Account Has Been Created!']"))
WebElement msg_Confirmation;


public void set_Firstname(String fname)
{
	txt_FirstName.sendKeys(fname);
}

public void set_lastname(String lname)
{
	txt_Lastname.sendKeys(lname);
}

public void set_Email(String Email)
{
	txt_Email.sendKeys(Email);
}

public void set_Telephone(String Telephone)
{
	txt_telephone.sendKeys(Telephone);
}

public void set_Password(String Pass)
{
	txt_Pass.sendKeys(Pass);
}

public void set_confirmPassword(String Pass)
{
	txt_ConfirmPass.sendKeys(Pass);
}
public void checkpolicy()
{
	chkdpolicy.click();
}

public void btn_continue()
{
	btn_continue.click();
}


public String getconfirmationMsg() {
	try {
		return(msg_Confirmation.getText());
	} catch (Exception e) {
		return(e.getMessage());	}
}


}
