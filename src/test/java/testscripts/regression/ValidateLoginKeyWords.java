package testscripts.regression;

import org.testng.annotations.Test;

import keywords.ApplicationKeyWords;

public class ValidateLoginKeyWords  extends ApplicationKeyWords{
	
	@Test
	public void validateLoginTest()
	{
	
	ApplicationKeyWords app=new ApplicationKeyWords();
	app.openBrowser();
	
	app.launchApp();
	
	
	app.type("username_textbox", "LasyaTest");
	app.type("username_password", "P76MNB");
	app.click("login_button");
	
	app.validateTitle("Adactin.com - Search Hotel");
	
	System.out.println("progrm ends...");
	app.close();
	
	
	
	
	
	}
	
	

	

}
