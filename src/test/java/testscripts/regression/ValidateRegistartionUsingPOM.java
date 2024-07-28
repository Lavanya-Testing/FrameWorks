package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import utils.UtilKit;

public class ValidateRegistartionUsingPOM  extends BaseTest{
	
	
	@Test(dataProvider="getData")
	public void newUserRegistration(HashMap<String, String> dataMap)
	{
		
		RegistrationPage registrationPage=PageFactory.initElements(driver, RegistrationPage.class);
		
		registrationPage.screenShot();
		registrationPage.newUserRegister();
		registrationPage.register_username_textbox(dataMap.get("Username"));
		registrationPage.register_password_textbox(dataMap.get("Password"));
		registrationPage.register_confirmpassword_textbox(dataMap.get("Confirm Passwod"));
		registrationPage.register_fullname_textbox(dataMap.get("FullName"));
		registrationPage.register_email_textbox(dataMap.get("EmailAddress"));
		registrationPage.register_captha(dataMap.get("CaptchText"));
		registrationPage.screenShot();
		
		
	}
	
	  @DataProvider
	    public Object[][] getData()
	    {
	    	
	    	 Object [][] data=new Object[1][1];
	    	 data[0][0]=UtilKit.getTestData("TC-102");
			return data;
	    	
	    }
	
	

}
