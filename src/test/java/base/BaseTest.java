package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 public  static FileInputStream fis;
	 public  static Properties pr;
	 public  static Properties locatorproperties;

	 public  static WebDriver driver;
	 public static FileInputStream fis2;

	@BeforeTest
	public void filesRead() throws IOException {
		//System.out.println(System.getProperty("user.dir"));
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		pr = new Properties();
		pr.load(fis);
		
		fis2=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\locators.properties");
         locatorproperties=new Properties();
         locatorproperties.load(fis2);
	}
	@BeforeMethod
	public void setUp()
	{
		
		 String b=pr.getProperty("browser");
		 ChromeOptions options= new ChromeOptions();
		 EdgeOptions eoptions= new EdgeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 if(b.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver(options);
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
		 driver.get(pr.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(pr.getProperty("implicitwait"))));

	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(30);
		driver.quit();
	}

}
