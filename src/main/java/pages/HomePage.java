package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

public class HomePage extends TestBase{
	
	ContactsPage contactspage;
	DealsPage dealspage;
	
	//@FindBy(xpath="//td[contains(text(),'Naveen')]")
	//WebElement usernameLabel;
	
	@FindBy(xpath="//td[@align='left']/font[1][@color='#64AB23']")
	WebElement usernameLabel;
	
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=contact']")
	WebElement contactslink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement NewContact;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
		
	}
	
	public ContactsPage ClickOnContactsLink()
	{
		 contactslink.click();
		 return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink()
	{
		 dealsLink.click();
		 return new DealsPage();
	}
	
	public TasksPage ClickonTaskPage()
	{
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public boolean VerifyUserNameHomePage() 
	{
		return usernameLabel.isDisplayed();
	}
	
	public void ClickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		NewContact.click();
	}
	
	

}
