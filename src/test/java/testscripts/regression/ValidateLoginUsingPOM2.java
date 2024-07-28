package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateLoginUsingPOM2  extends BaseTest
{
    @Test(dataProvider="getData")
	public void validateLogin(HashMap<String, String> dataMap)
	{
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.username_textBox(dataMap.get("username"));
		loginpage.password_textBox(dataMap.get("password"));
		loginpage.screenShot();
		
		loginpage.login_Button();
		
		SearchHotelPage searchHotel= PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotel.validateTitle(dataMap.get("expected Title"));
		
		SearchHotelPage.screenShot();
		
		
		
		
	}
    
    @DataProvider
    public Object[][] getData()
    {
    	
    	 Object [][] data=new Object[1][1];
    	 data[0][0]=UtilKit.getTestData("TC-100");
		return data;
    	
    }
}
