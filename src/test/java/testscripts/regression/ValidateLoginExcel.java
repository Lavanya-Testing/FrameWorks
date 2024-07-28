package testscripts.regression;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;


public class ValidateLoginExcel extends BaseTest {
	
	@Test(dataProvider="getData")
	public void validateLogin(HashMap<String,String> dataMap)
	{
		//valid username & validpassword
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(dataMap.get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Assert.assertEquals(driver.getTitle(), dataMap.get("expected Title"));
		System.out.println("program ends....");
		
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data= new Object[1][1];
		
		 data[0][0]=UtilKit.getTestData("TC-100");
		 
		
		return data;
	}
}
