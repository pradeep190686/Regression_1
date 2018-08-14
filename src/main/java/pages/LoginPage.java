package pages;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase {

	//Page factory or object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_button;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement Signup;
	
	@FindBy(xpath="//html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login_button.click();
		return new HomePage();
	}
}
