package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateLoginUsingPOM  extends BaseTest
{
    @Test
	public void validateLogin()
	{
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.username_textBox("LasyaTest");
		loginpage.password_textBox("P76MNB");
		loginpage.screenShot();
		
		loginpage.login_Button();
		
		SearchHotelPage searchHotel= PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotel.validateTitle("Adactin.com - Search Hotel");
		
		SearchHotelPage.screenShot();
		
		
		
		
	}
}
