package testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.*;
public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		 super();
	}
	
	@BeforeMethod
	public void setup()
	{
	    Initialization();
	     loginpage=new LoginPage();

	}

	@Test
	public void LoginPagetitletest()
	{
	   // LoginPage loginpage=new LoginPage();
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service",title);
	}
	
	@Test
	public void crmlogotest()
	{
		log.info("Verify login image testcase started");
		//LoginPage loginpage=new LoginPage();
		Assert.assertTrue(loginpage.validateCRMImage());
		log.info("Verify login image ended");
	}
	
	@Test
	public void logintest()
	{
	    //LoginPage loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
