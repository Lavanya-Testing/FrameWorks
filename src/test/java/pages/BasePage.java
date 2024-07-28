package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import base.BaseTest;

public class BasePage  extends BaseTest{

	
	public void validateTitle( String expectedTitle)
	{
		Assert.assertEquals(driver.getTitle(),expectedTitle );
	}
	
	
    public static  String screenShot()
    {
    	
    	 String ScreenShotFolderPath=System.getProperty("user.dir")+"//screenshots";
    	 
    	 File screenshotfolder =new File(ScreenShotFolderPath);
    	 screenshotfolder.mkdir();
    	 
    	 String pattern="yyyy-MM-dd HH:mm:ss";
    	 SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
    	 
    	String date= simpleDateFormat.format(new Date());
    	date=date.replace(":", "-");
		System.out.println(date);
		
		 File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String screenShotFileName=ScreenShotFolderPath+"\\"+date+".png";
		
		
		try {
			FileUtils.copyFile(srcFile, new File(screenShotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	  
		return screenShotFileName;
    	 
    }
}
