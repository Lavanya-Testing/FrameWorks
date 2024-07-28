package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import keywords.ApplicationKeyWords;
import utils.UtilKit;

public class ValidateLoginKeyWordsDataMap  extends ApplicationKeyWords{
	
	@Test(dataProvider="getData")
	public void validateLoginTest( HashMap<String,String> dataMap)
	{
	
	ApplicationKeyWords app=new ApplicationKeyWords();
	app.openBrowser();
	
	app.launchApp();
	
	
	app.type("username_textbox", dataMap.get("username"));
	app.type("username_password", dataMap.get("password"));
	app.click("login_button");
	
	app.validateTitle(dataMap.get("expected Title"));
	
	System.out.println("progrm ends...");
	app.close();
	
	
	
	
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		 Object [][] data=new Object[1][1];
		 data[0][0]=UtilKit.getTestData("TC-100");
		 
		return data;
		
	}
	
	

	

}
