package extentreportsconcept;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
@Listeners(extentreportsconcept.ExtentReportManager.class)
public class AdactionLogin {
	
	
	public class ValidateLogin extends BaseTest {
		
		@Test(dataProvider="getData")
		public void validateLogin(String uname,String pwd,String expTitle)
		{
			//valid username & validpassword
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@name='login']")).click();
			Assert.assertEquals(driver.getTitle(),expTitle );
		}
		
		@DataProvider
		public Object[][] getData()
		{
			 Object[][] data=new Object[4][3];//valid username&password
			 data[0][0]="LasyaTest";
			 data[0][1]="P76MNB";
			 data[0][2]="Adactin.com - Search Hotel";
			
			 data[1][0]="LasyaTest";//valid username& invalid
			 data[1][1]="Lavanya";
			 data[1][2]="Adactin.com - Hotel  System";
			 
			 data[2][0]="LavanyaReddy"; // invalid username&valid password
			 data[2][1]="P76MNB";
			 data[2][2]="Adactin.com - search hotel System";
			 
			 data[3][0]="LavanyaReddy"; // invalid username&invalid password
			 data[3][1]="Lavanya";
			 data[3][2]="Adactin.com - Hotel Reservation System";
			 
			 
			
			return data;
		}
	}
  

}
