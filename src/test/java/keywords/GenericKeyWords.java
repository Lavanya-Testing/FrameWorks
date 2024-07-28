package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeyWords extends BaseTest {
	
	public  void openBrowser() {
		

		 String b=pr.getProperty("browser");
		 //ChromeOptions options= new ChromeOptions();
		// EdgeOptions eoptions= new EdgeOptions();
		 //options.addArguments("--remote-allow-origins=*");
		 if(b.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		 }
			 
		 else  if(b.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 
		 }
		 else
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 
		 }
		 
	}
	
	public  void  launchApp()
	{
		driver.get(pr.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(pr.getProperty("implicitwait"))));
		
	}
	//getWebElement Method
	
	public WebElement getElement(String locatorkey)
	{
		WebElement element=null;
		element=driver.findElement(getlocator(locatorkey));
		return element ;
		
	}
	
	//getLocator Method
	
	public By getlocator(String locatorkey)
	{
		
		By by=null;
		
		if(locatorkey.endsWith("_id"))
		{
			by=By.id(locatorproperties.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_name"))
		{
			by=By.name(locatorproperties.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_linktext"))
		{
			by=By.linkText(locatorproperties.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_xpath"))
		{
			by=By.xpath(locatorproperties.getProperty(locatorkey));
		}
		else
		{
			by=By.xpath(locatorproperties.getProperty(locatorkey));
		}
		return by;
		
	}
	
	public void clear(String locatorkey)
	{
		getElement(locatorkey).clear();
	}
	public void click(String locatorkey)
	{
		getElement(locatorkey).click();
	}
	public void type(String locatorkey, String text)
	{
		getElement(locatorkey).sendKeys(text);
	}
	
	public void selectOptionFromDropdown(String locatorkey,String option)
	{
		new Select(getElement(locatorkey)).selectByVisibleText(option);
		
	
	}
	
	public void close()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
