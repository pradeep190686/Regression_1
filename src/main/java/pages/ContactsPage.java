package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select.*;


import testbase.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(id="first_name")
	WebElement Firstname;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save'] ")
	WebElement Save;
	
	
	
/*	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;*/
	
	/*@FindBy(xpath="//a[contains(text(),'chiran amgai')]/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@type='checkbox']")
	WebElement 
	"//td[contains(text(),'Contacts')]"
	*/
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean VerifyContactsLabel()
	{
		System.out.println("entered verify contacts label method");
		return ContactsLabel.isDisplayed();
		
	}
	public void selectContact(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@type='checkbox']")).click();
	}
	
	public void CreateNewContact(String titles,String firstname,String lastname,String Comp )
	{
		Select sel= new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(titles);	
		Firstname.sendKeys(firstname);
		LastName.sendKeys(lastname);
		company.sendKeys(Comp);
	    Save.click();    
	}
	
	
		
	}

