package testscripts.regression;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;
import utils.UtilsKit;


public class ValidateLoginExcel2 extends BaseTest {
	
	@Test(dataProvider="getData")
	public void validateLogin(HashMap<String,String> dataMap)
	{
		//valid username & validpassword
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(dataMap.get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		//System.out.println(driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), dataMap.get("expectedTitle"));
		//Assert.assertEquals(driver.getTitle(), dataMap.get("expectedTitle"));
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		//Assert.assertEquals(driver.getTitle(),dataMap.get("expected-Title"), "ok done");
	}
	
	@DataProvider
	public Object[][] getData()  
	{
		Object[][] data=new Object[1][1];
		data[0][0]=UtilsKit.getTestData("TC-100");
		return data;
	}
}
