package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.Addcustomers;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginpg;
	
	public Addcustomers Addcust;
	public SearchCustomerByEmail Searchbyemail;
	
	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
		
	}
	
	

}
