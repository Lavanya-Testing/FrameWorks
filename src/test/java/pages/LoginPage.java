package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	   @FindBy(xpath="//input[@id='username']")
	   WebElement username_textBox;
	   
	   @FindBy(xpath="//input[@id='password']")
	   WebElement password_textBox;
	   
	   @FindBy(xpath="//input[@id='login']")
	   WebElement login_Button;
	   
	   
	   
	   public void username_textBox(String text)
	   {
		   username_textBox.sendKeys(text);
	   }
	   
	   public void password_textBox(String text)
	   {
		   password_textBox.sendKeys(text);
	   }
	   
	   public void login_Button()
	   {
		   login_Button.click();
	   }
	   
	   
	   
	   
	

}
