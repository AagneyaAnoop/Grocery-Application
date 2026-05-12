package grocerycore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;

public class GroceryBase {
	
	Properties prop;
	FileInputStream fileis;
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowzer(String browsers) throws IOException
	{
		prop=new Properties();
		fileis=new FileInputStream(Constant.CONFIGFILE);
		prop.load(fileis);
		
		if(browsers.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browsers.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browsers.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException{
		
		if(itestresult.getStatus()==ITestResult.FAILURE) 
		{
			ScreenShotUtility screenshotutility=new ScreenShotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
		
		//ITestResult - It is an interface controlling the overall life cycle of a test case
	}

}
