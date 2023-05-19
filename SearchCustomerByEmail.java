package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmail {
	
WebDriver ldriver;
	
	public  SearchCustomerByEmail(WebDriver rDriver)
	{
		ldriver =rDriver;
		PageFactory.initElements(rDriver,this);	
	}

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement ClickOnCustomersMenu;
	
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']/p[contains(text(),'Customers')]")
	WebElement ClickonCustomeritem;
	
	@FindBy(id="SearchEmail")
	WebElement Emailsearch;
	@FindBy(id="search-customers")
	WebElement customerssearch;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchresult;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tablerows;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tablecolumn;
	
	@FindBy(id="SearchFirstName")
	WebElement firstname;
	
	@FindBy(id="SearchLastName")
	WebElement lastname;
	
	public void ClickOnCustomersMenu() throws InterruptedException {
		ClickOnCustomersMenu.click();
		Thread.sleep(2000);
	}
    
	public void ClickonCustomeritem() {
		ClickonCustomeritem.click();
	}
	public void emailsearch(String Email) {
		Emailsearch.sendKeys(Email);
	}
	
	public void clickonSearchbutton() {
		customerssearch.click();
	}
	
	public int getnorows() {
		return (tablerows.size());
	}
	
	public boolean searchcustomerByEmailresult(String email) {
		boolean found =false;
		
		// count total no rows
		//int ttlrows = tablerows.size();
				
				for (int i=1; i<=getnorows(); i++)    //to iterate all rows of grid
				{	
					String  emailid= table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+ i +"]/td[2]")).getText();
					
					System.out.println(emailid);
										
					if(emailid.equals(email))
					{
						found=   true;
					}
				}
				return found;
				
	}

	public void enterfirstname(String name) {
		firstname.sendKeys(name);
		
	}
	public void enterlastname(String Lastname) {
		lastname.sendKeys(Lastname);
	} 
	public boolean searchcustomerByName(String Name) {
		boolean found =false;
		
		// count total no rows
		//int ttlrows = tablerows.size();
				
				for (int i=1; i<=getnorows(); i++)    //to iterate all rows of grid
				{	
					String  SearchName= table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+ i +"]/td[3]")).getText();
					
					System.out.println(SearchName);
										
					if(SearchName.equals(Name))
					{
						found=   true;
					}
				}
				return found;
				
	}
	
}
