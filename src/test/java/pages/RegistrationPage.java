package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage  extends BasePage{
	
	
	@FindBy(linkText="New User Register Here")
	WebElement newUserRegister;
	
	/*newUserRegister_linktext=New User Register Here
	register_username_textbox=//input[@name='username']
	register_password_textbox=//input[@name='password']
	register_confirmpassword_textbox=//input[@name='re_password']
	register_fullname_textbox=//input[@name='full_name']
	register_email_textbox=//input[@name='email_add']
	register_captch_textbox=//input[@name='captcha]
		 * 
		 */
	
	
	@FindBy(xpath="//input[@name='username']")
	WebElement register_username_textbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement register_password_textbox;
	
	@FindBy(xpath="//input[@name='re_password']")
	WebElement register_confirmpassword_textbox;
	
	@FindBy(xpath="//input[@name='full_name']")
	WebElement register_fullname_textbox;
	
	@FindBy(xpath="//input[@name='email_add']")
	WebElement 	register_email_textbox;
	
	@FindBy(xpath="//input[@name='captcha']")
	WebElement 	register_captha;
	
	
	public void newUserRegister()
	{
		newUserRegister.click();
	}
	
	public void register_username_textbox(String username)
	{
		register_username_textbox.sendKeys(username);
	}
	public void register_password_textbox(String password)
	{
		register_password_textbox.sendKeys(password);
	}
	public void register_confirmpassword_textbox(String confirmpassword)
	{
		register_confirmpassword_textbox.sendKeys(confirmpassword);
	}
	public void  register_fullname_textbox(String fullname)
	{
		 register_fullname_textbox.sendKeys(fullname);
	}
	public void register_email_textbox(String email)
	{
		register_password_textbox.sendKeys(email);
	}
	public void register_captha(String captchaText)
	{
		register_captha.sendKeys(captchaText);
	}
	
	
	
	

}
