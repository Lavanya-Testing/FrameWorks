package testscripts.regression;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.UtilKit;

import keywords.ApplicationKeyWords;

public class ValidateRegistration  extends ApplicationKeyWords{
	
	@Test(dataProvider="getData")
	public void validateLoginTest(HashMap<String,String> dataMap) throws InterruptedException
	{
	
	ApplicationKeyWords app=new ApplicationKeyWords();
	app.openBrowser();
	
	app.launchApp();
	/*newUserRegister_linktext=New User Register Here
	register_username_textbox=//input[@name='username']
	register_password_textbox=//input[@name='password']
	register_confirmpassword_textbox=//input[@name='re_password']
	register_fullname_textbox=//input[@name='full_name']
	register_email_textbox=//input[@name='email_add']
	register_captch_textbox=//input[@name='captcha]
		 * 
		 */
		//app.click("newUserRegister_linktext");
		//app.type(null, null);
	app.click("newUserRegister_linktext");
	app.validateTitle(dataMap.get("expected Title"));
	//Assert.assertTrue(false);
	
	app.type("register_username_textbox", dataMap.get("Username"));
	app.type("register_password_textbox", dataMap.get("Password"));
	app.type("register_confirmpassword_textbox", dataMap.get("Confirm Passwod"));
	app.type("register_fullname_textbox", dataMap.get("FullName"));
	app.type("register_email_textbox", dataMap.get("EmailAddress"));
	app.type("register_captch_textbox", dataMap.get("CaptchText"));
	app.click("register_terms_conditions");
	//app.click("register_submitbutton");;
	
	//
	
	
	
	//app.click("login_button");
	
	
	
	System.out.println("progrm ends...");
	//Thread.sleep(6000);
	app.close();
	
	
	
	
	
	}
	
	@DataProvider
	public Object[][] getData(){
		
		 Object[][] data=new Object[1][1];
		 
		  data[0][0]=UtilKit.getTestData("TC-101");
		  
		return data;
		
	}
	
	

	

}
