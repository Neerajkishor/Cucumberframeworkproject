package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public  LoginPage(WebDriver rDriver)
	{
		ldriver =rDriver;
		PageFactory.initElements(rDriver,this);
		
	}
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement lgnbtn;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void enterEmail(String emaiAdd)
	{
		
		email.clear();
		email.sendKeys(emaiAdd);
	}
	
	public void password(String pwd)
	{
		password.clear();

		password.sendKeys(pwd);
	}
	
	public void clickonLoginButton()
	{
		lgnbtn.click();
	}
	
	public void clickonLogOutButton()
	{
		logout.click();
	}
	

}
