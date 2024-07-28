package extentreportsconcept;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public static ExtentSparkReporter sparkReporter;
	public static  ExtentReports extent;
	public static ExtentTest test;
	static String reportsFolderPath;
public void onTestStart(ITestContext context)
{
	
	reportsFolderPath=System.getProperty("user.dir")+"\\reports";
	
	 File reportsFolder=new File(reportsFolderPath);
	 reportsFolder.mkdir();
	 
	 String pattern="yyyy-MM-dd HH:mm:ss";
	 SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
	 
	String date= simpleDateFormat.format(new Date());
	date=date.replace(":", "-");
	System.out.println(date);
	
	 String filepath= reportsFolderPath+date+"\\.html";
	 sparkReporter=new  ExtentSparkReporter(filepath);
	 
	 sparkReporter.config().setDocumentTitle("myextentreports");
	 sparkReporter.config().setReportName("Adactin Automation");
	 sparkReporter.config().setTheme(Theme.DARK);
	 
	  extent=new ExtentReports();
	  extent.attachReporter(sparkReporter);
	  extent.setSystemInfo("Computername", "localHost");
	  extent.setSystemInfo("Environment", "QA");
	  extent.setSystemInfo("TesterName", "Lavanya");
	  extent.setSystemInfo("OS", "Windows10");
	  extent.setSystemInfo("Browsername", "chrome");
}

public void onTestSuccess(ITestResult result)
{
	 test=extent.createTest(result.getName());
	 test.log(Status.PASS, "Test case is passed"+result.getName());
}

public void onTestFailure(ITestResult result)
{
	 test=extent.createTest(result.getName());
	 test.log(Status.FAIL, "Test case is failed"+result.getName());
	 test.log(Status.FAIL, "Test case is failed"+result.getThrowable());
	
}
public void onTestSkipped(ITestResult result)
{
	 test=extent.createTest(result.getName());
	 test.log(Status.SKIP, "Test case is skipped"+result.getName());
}
public void onTestFinish(ITestContext context)
{
	extent.flush();
}


	
	
	
	
	
	
	

}
