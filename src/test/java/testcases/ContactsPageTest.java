package testcases;

import java.io.IOException;

import javax.naming.NameNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.testutil;

public class ContactsPageTest extends TestBase {
	testutil tutil;
	LoginPage loginpage;
	ContactsPage contactspage;
	HomePage homepage;
	String sheetName="Sheet1";

	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		Initialization();
		tutil=new testutil();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		tutil.switchtoframe();
		contactspage=homepage.ClickOnContactsLink();

	}

	@Test(priority=1)
	public void VerifyContactLabelDisplayTest()
	{
		log.info("contact label is displayed");
		Assert.assertTrue(contactspage.VerifyContactsLabel(),"contacts label not found");		
	}
     //Testing integration
	@Test(priority=2,enabled = true,expectedExceptions=NoSuchElementException.class)
	public void checkboxtest()
	{
		contactspage.selectContact("chiran amgai");
		log.debug("check box not selected");
	}

	@Test(priority=3,enabled = false)
	public void multicheckboxtest()
	{
		contactspage.selectContact("chiran amgai");
		contactspage.selectContact("Binu Amgai");

	}

	@Test(priority=4)
	public void CreateNewContactTest()
	{
		homepage.ClickOnNewContactLink();
		contactspage.CreateNewContact("Mr.","Tom","Jerry","Elle");
	}

	@DataProvider
	public Object[][] getexcelTestData() throws Exception, IOException
	{
		Object[][] data1=tutil.getTestData(sheetName);	
		return data1;
	}

	@Test(priority=5,dataProvider="getexcelTestData")
	public void CreateNewContactExcelTest(String title,String firstname,String lastname,String company)
	{
		homepage.ClickOnNewContactLink();
		//contactspage.CreateNewContact("Mr.","Tom","Jerry","Elle");
		contactspage.CreateNewContact(title, firstname, lastname,company);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
