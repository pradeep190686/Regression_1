package testbase;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.WebEventListener;
import utilities.testutil;

public class TestBase {

	//Practice
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log=Logger.getLogger("capturelogger");
	
/*	 public  WebEventListener eventlistener;
	 public  EventFiringWebDriver e_driver;*/
	public TestBase()
	{
		try {
			prop= new Properties();
			FileInputStream fis=new FileInputStream("C:\\SeleniumTrainingByJitendra\\practicals\\EclipseJavaPracticals\\Regression_1\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void Initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Backup_from_email\\SeleniumTrainingByJitendra\\Tools\\chromedriver_new_jmeter\\chromedriver.exe");
			driver=new ChromeDriver();
		}

		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Backup_from_email\\SeleniumTrainingByJitendra\\Tools\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		else
		{
			System.setProperty("webdriver.ie.driver", "C:\\Backup_from_email\\SeleniumTrainingByJitendra\\Tools\\IEDriverServer.exe\"");
			driver=new InternetExplorerDriver();
		}
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		WebEventListener eventlistener= new WebEventListener();
		edriver.register(eventlistener);
		driver=edriver;		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	
	



}
