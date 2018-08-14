package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.testutil;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	testutil tutil;
	ContactsPage contactspage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialization();
		tutil=new testutil();
		loginpage=new LoginPage();
		contactspage= new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	
	public void VerifyHomePageTitleTest()
	{
		String homepagetitle=homepage.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","Home Page Title not found");
	}
	
	@Test(priority=2)
	public void CorrectUserName()  
	{
		tutil.switchtoframe();
		Assert.assertTrue(homepage.VerifyUserNameHomePage(),"UserNameLabelisMissing");
	}
	
	@Test(priority=3)
	
	public void verifycontactslinktest()
	{
		log.info("Verify contacts link test case started");
		tutil.switchtoframe();
		contactspage=homepage.ClickOnContactsLink();
		log.info("Verify contacts link test case ended");
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		
		driver.quit();
	}

}
