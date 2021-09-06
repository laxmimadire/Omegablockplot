package TestCases_PracticeSession;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassforPS  {
	public static WebDriver driver;
	public static Alert a;
	public static WebElement element;
	public static Logger logger;
	public String BaseUrl="https://omayo.blogspot.com/";
	
	
	@BeforeClass
	@Parameters("Browser")
	public void setUpBrowser( String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	}
	//@AfterClass
public void tearDown()
{
	driver.quit();
}
}
